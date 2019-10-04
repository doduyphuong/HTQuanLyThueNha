/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Loainha;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class LoainhaDAO {
    public List<Loainha> getListLoaiNha() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeLoaiNha";
        Query query = session.createSQLQuery(hql).addEntity(Loainha.class);
        List<Loainha> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Loainha getLoaiNha(int MaLoaiNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Loainha loaiNha = null;
        String hql = "CALL USP_LayThongTinLoaiNha(:MaLoaiNha)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Loainha.class)
                .setParameter("MaLoaiNha", MaLoaiNha);
        List<Loainha> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            loaiNha = (Loainha) listObject.get(0);
        }

        return loaiNha;
    }

    public int updateLoaiNha(Loainha loaiNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatLoaiNha (:MaLoaiNha,:TenLoaiNha)";
        Query query = session.createSQLQuery(hql).addEntity(Loainha.class);
        query.setParameter("MaLoaiNha", loaiNha.getMaLoai());
        query.setParameter("TenLoaiNha", loaiNha.getTenLoai());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int createLoaiNha(Loainha loaiNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemLoaiNha (:TenLoaiNha)";
        Query query = session.createSQLQuery(hql).addEntity(Loainha.class);
        
        query.setParameter("HoTen", loaiNha.getTenLoai());
        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int deleteLoaiNha(int MaLoaiNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaLoaiNha (:MaLoaiNha)";
        Query query = session.createSQLQuery(hql).addEntity(Loainha.class);
        query.setParameter("MaLoaiNha", MaLoaiNha);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
}

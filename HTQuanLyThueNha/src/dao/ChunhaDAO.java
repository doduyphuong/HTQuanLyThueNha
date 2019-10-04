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
import pojos.Chunha;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class ChunhaDAO {
    public List<Chunha> getListChuNha() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeChuNha";
        Query query = session.createSQLQuery(hql).addEntity(Chunha.class);
        List<Chunha> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Chunha getChuNha(int MaChuNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Chunha chuNha = null;
        String hql = "CALL USP_LayThongTinChuNha(:MaChuNha)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Chunha.class)
                .setParameter("MaChuNha", MaChuNha);
        List<Chunha> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            chuNha = (Chunha) listObject.get(0);
        }

        return chuNha;
    }

    public int updateChuNha(Chunha chuNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatChuNha (:MaChuNha,:HoTen,:DiaChi, :SoDT)";
        Query query = session.createSQLQuery(hql).addEntity(Chunha.class);
        query.setParameter("MaChuNha", chuNha.getMaChuNha());
        query.setParameter("HoTen", chuNha.getHoTen());
        query.setParameter("DiaChi", chuNha.getDiaChi());
        query.setParameter("SoDT", chuNha.getSoDienThoai());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int createChuNha(Chunha chuNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemChuNha (:HoTen,:DiaChi, :SoDT)";
        Query query = session.createSQLQuery(hql).addEntity(Chunha.class);
        
        query.setParameter("HoTen", chuNha.getHoTen());
        query.setParameter("DiaChi", chuNha.getDiaChi());
        query.setParameter("SoDT", chuNha.getSoDienThoai());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int deleteChuNha(int MaChuNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaChuNha (:MaChuNha)";
        Query query = session.createSQLQuery(hql).addEntity(Chunha.class);
        query.setParameter("MaChuNha", MaChuNha);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
}

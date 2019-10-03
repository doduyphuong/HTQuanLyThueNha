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
import pojos.Nha;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class NhaDAO {
    
    public List<Nha> getListNha() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeNha";
        Query query = session.createSQLQuery(hql).addEntity(Nha.class);
        List<Nha> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public List<Nha> getNhaChiNhanh(int MaChiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Nha chiNhanh = null;
        String hql = "CALL USP_ThongKeNha_ChiNhanh(:MaChiNhanh)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Nha.class)
                .setParameter("MaChiNhanh", MaChiNhanh);
        
        List<Nha> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public int updateNha(Nha nha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatNha (:MaNha , :DiaChi, :Quan, :ThanhPho, :KhuVuc, :TienThue, :LoaiNha, :ChuNha, :ChiNhanhDK)";
        Query query = session.createSQLQuery(hql).addEntity(Nha.class);
        query.setParameter("MaNha", nha.getMaNha());
        query.setParameter("DiaChi", nha.getDiaChi());
        query.setParameter("Quan", nha.getQuan());
        query.setParameter("ThanhPho", nha.getThanhPho());
        query.setParameter("KhuVuc", nha.getKhuVuc());
        query.setParameter("TienThue", nha.getTienThue1thang());
        query.setParameter("LoaiNha", nha.getLoaiNha());
        query.setParameter("ChuNha", nha.getChuNha());
        query.setParameter("ChiNhanhDK", nha.getChiNhanhDangKy());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
    
    public int createNha(Nha nha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemNha (:MaNha , :DiaChi, :Quan, :ThanhPho, :KhuVuc, :TienThue, :LoaiNha, :ChuNha, :ChiNhanhDK)";
        Query query = session.createSQLQuery(hql).addEntity(Nha.class);
        query.setParameter("MaNha", nha.getMaNha());
        query.setParameter("DiaChi", nha.getDiaChi());
        query.setParameter("Quan", nha.getQuan());
        query.setParameter("ThanhPho", nha.getThanhPho());
        query.setParameter("KhuVuc", nha.getKhuVuc());
        query.setParameter("TienThue", nha.getTienThue1thang());
        query.setParameter("LoaiNha", nha.getLoaiNha());
        query.setParameter("ChuNha", nha.getChuNha());
        query.setParameter("ChiNhanhDK", nha.getChiNhanhDangKy());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
    
    public int deleteNha(int MaNha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaNha (:MaNha)";
        Query query = session.createSQLQuery(hql).addEntity(Nha.class);
        query.setParameter("MaNha", MaNha);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

}

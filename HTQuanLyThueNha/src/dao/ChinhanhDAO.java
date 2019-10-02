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
import pojos.Chinhanh;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class ChinhanhDAO {

    public List<Chinhanh> getListChiNhanh() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeChiNhanh";
        Query query = session.createSQLQuery(hql).addEntity(Chinhanh.class);
        List<Chinhanh> listChiNhanh = query.list();
        transaction.commit();
        return listChiNhanh;
    }

    public Chinhanh getChiNhanh(int MaChiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Chinhanh chiNhanh = null;
        String hql = "CALL USP_LayThongChiNhanh(:MaChiNhanh)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Chinhanh.class)
                .setParameter("MaChiNhanh", MaChiNhanh);
        List<Chinhanh> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            chiNhanh = (Chinhanh) listObject.get(0);
        }

        return chiNhanh;
    }

    public int updateChiNhanh(Chinhanh chiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatChiNhanh (:MaChiNhanh, :TenChiNhanh, :DiaChi, :Quan, :ThanhPho, :KhuVuc, :SoDienThoai, :SoFAX)";
        Query query = session.createSQLQuery(hql).addEntity(Chinhanh.class);
        query.setParameter("MaChiNhanh", chiNhanh.getMaCn());
        query.setParameter("TenChiNhanh", chiNhanh.getTenChiNhanh());
        query.setParameter("DiaChi", chiNhanh.getDiaChi());
        query.setParameter("Quan", chiNhanh.getQuan());
        query.setParameter("ThanhPho", chiNhanh.getThanhPho());
        query.setParameter("KhuVuc", chiNhanh.getKhuVuc());
        query.setParameter("SoDienThoai", chiNhanh.getSoDienThoai());
        query.setParameter("SoFAX", chiNhanh.getSoFax());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
    
    public int createChiNhanh(Chinhanh chiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemChiNhanh (:TenChiNhanh, :DiaChi, :Quan, :ThanhPho, :KhuVuc, :SoDienThoai, :SoFAX)";
        Query query = session.createSQLQuery(hql).addEntity(Chinhanh.class);
        query.setParameter("TenChiNhanh", chiNhanh.getTenChiNhanh());
        query.setParameter("DiaChi", chiNhanh.getDiaChi());
        query.setParameter("Quan", chiNhanh.getQuan());
        query.setParameter("ThanhPho", chiNhanh.getThanhPho());
        query.setParameter("KhuVuc", chiNhanh.getKhuVuc());
        query.setParameter("SoDienThoai", chiNhanh.getSoDienThoai());
        query.setParameter("SoFAX", chiNhanh.getSoFax());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
    
    public int deleteChiNhanh(int MaChiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaChiNhanh (:MaChiNhanh)";
        Query query = session.createSQLQuery(hql).addEntity(Chinhanh.class);
        query.setParameter("MaChiNhanh", MaChiNhanh);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
}

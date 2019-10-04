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
import pojos.Nhanvien;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class NhanvienDAO {
public List<Nhanvien> getListNhanVien() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeNhanVien";
        Query query = session.createSQLQuery(hql).addEntity(Nhanvien.class);
        List<Nhanvien> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Nhanvien getNhanVien(int MaNhanVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Nhanvien nhanVien = null;
        String hql = "CALL USP_LayThongTinNhanVien(:MaNhanVien)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Nhanvien.class)
                .setParameter("MaNhanVien", MaNhanVien);
        List<Nhanvien> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            nhanVien = (Nhanvien) listObject.get(0);
        }

        return nhanVien;
    }

    public int updateNhanVien(Nhanvien nhanVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatNhanVien (:MaNhanVien,:HoTen,:DiaChi, :SoDT,:GioiTinh)";
        Query query = session.createSQLQuery(hql).addEntity(Nhanvien.class);
        query.setParameter("MaNhanVien", nhanVien.getMaNv());
        query.setParameter("HoTen", nhanVien.getHoTen());
        query.setParameter("DiaChi", nhanVien.getDiaChi());
        query.setParameter("SoDT", nhanVien.getSoDienThoai());
        query.setParameter("GioiTinh", nhanVien.getGioiTinh());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int createNhanVien(Nhanvien nhanVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemNhanVien (:HoTen,:DiaChi, :SoDT,:GioiTinh)";
        Query query = session.createSQLQuery(hql).addEntity(Nhanvien.class);
        
        query.setParameter("HoTen", nhanVien.getHoTen());
        query.setParameter("DiaChi", nhanVien.getDiaChi());
        query.setParameter("SoDT", nhanVien.getSoDienThoai());
        query.setParameter("GioiTinh", nhanVien.getGioiTinh());
        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int deleteNhanVien(int MaNhanVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaNhanVien (:MaNhanVien)";
        Query query = session.createSQLQuery(hql).addEntity(Nhanvien.class);
        query.setParameter("MaNhanVien", MaNhanVien);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
}

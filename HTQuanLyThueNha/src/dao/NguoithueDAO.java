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
import pojos.Nguoithue;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class NguoithueDAO {

    public List<Nguoithue> getListNguoiThue() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeNguoiThue";
        Query query = session.createSQLQuery(hql).addEntity(Nguoithue.class);
        List<Nguoithue> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Nguoithue getNguoiThue(int MaNguoiThue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Nguoithue nguoiThue = null;
        String hql = "CALL USP_LayThongTinNguoiThue(:MaNguoiThue)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Nguoithue.class)
                .setParameter("MaNguoiThue", MaNguoiThue);
        List<Nguoithue> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            nguoiThue = (Nguoithue) listObject.get(0);
        }

        return nguoiThue;
    }

    public List<Nguoithue> getNguoiThueChiNhanh(int MaChiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "CALL USP_ThongKeNguoiThue_CoDieuKien(:MaChiNhanh)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Nguoithue.class)
                .setParameter("MaChiNhanh", MaChiNhanh);

        List<Nguoithue> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public int updateNguoiThue(Nguoithue nguoiThue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatNguoiThue(:MaNguoiThue,:HoTen,:DiaChi, :SoDT, :MaChiNhanh)";
        Query query = session.createSQLQuery(hql).addEntity(Nguoithue.class);
        query.setParameter("MaNguoiThue", nguoiThue.getMaNt());
        query.setParameter("HoTen", nguoiThue.getHoTen());
        query.setParameter("DiaChi", nguoiThue.getDiaChi());
        query.setParameter("SoDT", nguoiThue.getDienThoai());
        query.setParameter("MaChiNhanh", nguoiThue.getChiNhanhQuanLy());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int createNguoiThue(Nguoithue nguoiThue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemNguoiThue(:HoTen,:DiaChi, :SoDT, :MaChiNhanh)";
        Query query = session.createSQLQuery(hql).addEntity(Nguoithue.class);
        query.setParameter("HoTen", nguoiThue.getHoTen());
        query.setParameter("DiaChi", nguoiThue.getDiaChi());
        query.setParameter("SoDT", nguoiThue.getDienThoai());
        query.setParameter("MaChiNhanh", nguoiThue.getChiNhanhQuanLy());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int deleteNguoiThue(int MaNguoiThue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaNguoiThue (:MaNguoiThue)";
        Query query = session.createSQLQuery(hql).addEntity(Nguoithue.class);
        query.setParameter("MaNguoiThue", MaNguoiThue);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }
}

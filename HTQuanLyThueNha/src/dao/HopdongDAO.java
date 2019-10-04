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
import pojos.Hopdong;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class HopdongDAO {

    public List<Hopdong> getListHopDong() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeHopDong";
        Query query = session.createSQLQuery(hql).addEntity(Hopdong.class);
        List<Hopdong> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Hopdong getHopDong(int MaHopDong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Hopdong hopDong = null;
        String hql = "CALL USP_LayThongTinHopDong(:MaHopDong)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Hopdong.class)
                .setParameter("MaHopDong", MaHopDong);
        List<Hopdong> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            hopDong = (Hopdong) listObject.get(0);
        }

        return hopDong;
    }

    public List<Hopdong> getHopDongChiNhanh(int MaChiNhanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "CALL USP_ThongKeHopDong_CoDieuKien(:MaChiNhanh)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Hopdong.class)
                .setParameter("MaChiNhanh", MaChiNhanh);

        List<Hopdong> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public int updateHopDong(Hopdong hopDong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_CapNhatHD(:MaHopDong,:MaNha,:MaChuNha, :MaNguoiThue, :NgayKyHD, :NgayBD, :NgayKT, :TienThue1Thang, :TienCoc, :MaNV)";
        Query query = session.createSQLQuery(hql).addEntity(Hopdong.class);
        query.setParameter("MaHopDong", hopDong.getMaHd());
        query.setParameter("MaNha", hopDong.getMaNha());
        query.setParameter("MaChuNha", hopDong.getMaChuNha());
        query.setParameter("MaNguoiThue", hopDong.getMaNt());
        query.setParameter("NgayKyHD", hopDong.getNgayKyHd());
        query.setParameter("NgayBD", hopDong.getNgayBatDauHd());
        query.setParameter("NgayKT", hopDong.getNgayKetThucHd());
        query.setParameter("TienThue1Thang", hopDong.getTienThue1thang());
        query.setParameter("TienCoc", hopDong.getTienCoc());
        query.setParameter("MaNV", hopDong.getMaNv());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int createHopDong(Hopdong hopDong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_ThemHD(:MaNha,:MaChuNha, :MaNguoiThue, :NgayKyHD, :NgayBD, :NgayKT, :TienThue1Thang, :TienCoc, :MaNV)";
        Query query = session.createSQLQuery(hql).addEntity(Hopdong.class);
        query.setParameter("MaNha", hopDong.getMaNha());
        query.setParameter("MaChuNha", hopDong.getMaChuNha());
        query.setParameter("MaNguoiThue", hopDong.getMaNt());
        query.setParameter("NgayKyHD", hopDong.getNgayKyHd());
        query.setParameter("NgayBD", hopDong.getNgayBatDauHd());
        query.setParameter("NgayKT", hopDong.getNgayKetThucHd());
        query.setParameter("TienThue1Thang", hopDong.getTienThue1thang());
        query.setParameter("TienCoc", hopDong.getTienCoc());
        query.setParameter("MaNV", hopDong.getMaNv());

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

    public int deleteHopDong(int MaHopDong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int result = 0;
        String hql = "CALL USP_XoaHĐ (:MaHopDong)";
        Query query = session.createSQLQuery(hql).addEntity(Hopdong.class);
        query.setParameter("MaHopDong", MaHopDong);

        result = query.executeUpdate();
        transaction.commit();
        return result;
    }

}

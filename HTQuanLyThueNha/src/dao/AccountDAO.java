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
import pojos.Account;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class AccountDAO {

    public List<Account> loadUSP_ThongKeAccount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "call USP_ThongKeAccount";
        Query query = session.createSQLQuery(hql).addEntity(Account.class);
        List<Account> listObject = query.list();
        transaction.commit();
        return listObject;
    }

    public Account getUSP_LayThongTinTaiKhoan(String userName, String passwd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Account account = null;
        String hql = "CALL USP_LayThongTinTaiKhoan(:userName,:passwd)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Account.class)
                .setParameter("userName", userName)
                .setParameter("passwd", passwd);
        List<Account> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            account = (Account) listObject.get(0);
        }
        return account;
    }
    
    public Account updatePassAccount(String userName, String passwd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Account account = null;
        String hql = "CALL USP_DoiMatKhauTaiKhoan(:userName,:passwd)";
        Query query = session.createSQLQuery(hql)
                .addEntity(Account.class)
                .setParameter("userName", userName)
                .setParameter("passwd", passwd);
        List<Account> listObject = query.list();
        transaction.commit();
        if (listObject.size() > 0) {
            account = (Account) listObject.get(0);
        }
        return account;
    }
}

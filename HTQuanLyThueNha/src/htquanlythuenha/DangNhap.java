/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htquanlythuenha;

import dao.AccountDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pojos.Account;

/**
 *
 * @author CPU12407-local
 */
public class DangNhap extends javax.swing.JFrame {
    static Account account = null;
    /**
     * Creates new form Login
     */
    public DangNhap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtLogin = new javax.swing.JButton();
        jtfPasswd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtLogin.setText("Login");
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPasswd)
                            .addComponent(jtfUsername)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(93, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jbtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfPasswd, jtfUsername});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed
        boolean validate = validateForm();
        if (!validate) {

//            if (account.getRole() == 1) {
//                manageClassRoom mClassRoom = new manageClassRoom(this);
//                mClassRoom.setVisible(true);
//            }
//
//            if (account.getRole() == 0) {
//                studentLayout sLayout = new studentLayout(this, account);
//                sLayout.setVisible(true);
//            }
            QuanLyChucNang qlcn = new QuanLyChucNang(this);
            qlcn.setVisible(true);

            jtfUsername.setText("");
            jtfPasswd.setText("");
        }

    }//GEN-LAST:event_jbtLoginActionPerformed

    private boolean validateForm() {
        boolean validate = false;
        String username = jtfUsername.getText();
        String passwd = jtfPasswd.getText();
        StringBuilder msgErr = new StringBuilder();

        if (username.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập tên đăng nhập.");
            msgErr.append("\n");
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
            return validate;
        }

        if (passwd.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập mật khẩu.");
            msgErr.append("\n");
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
            return validate;
        }

        if (validate == false) {
            AccountDAO accountDAO = new AccountDAO();
            Account a = accountDAO.getUSP_LayThongTinTaiKhoan(username, passwd);
            if (a != null) {
                account = a;
                validate = false;
            } else {
                validate = true;
            }

        }

        if (validate == true) {
            msgErr.append("Tên đăng nhập hoặc mật khẩu chưa đúng.");
            msgErr.append("\n");
            jtfPasswd.setText("");
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return validate;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtLogin;
    private javax.swing.JPasswordField jtfPasswd;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}

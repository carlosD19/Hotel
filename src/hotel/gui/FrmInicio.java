/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.dao.Controlador;
import hotel.entities.Correo;
import hotel.entities.MiError;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class FrmInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        setLocationRelativeTo(null);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        //sdsdsdsdsds
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        lblSignIn = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 50, 40));

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setOpaque(false);
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 200, 30));

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setOpaque(false);
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("GO");
        jButton2.setFocusable(false);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 80, -1));

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 255, 255));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPass.setText("Forgot Password?");
        lblPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPassMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPassMousePressed(evt);
            }
        });
        getContentPane().add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 100, 20));

        lblSignIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(255, 102, 0));
        lblSignIn.setText("Sign In");
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignInMouseExited(evt);
            }
        });
        getContentPane().add(lblSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 340, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 340, 320));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoI.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void lblPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassMouseEntered
        lblPass.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblPassMouseEntered

    private void lblPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassMouseExited
        lblPass.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblPassMouseExited

    private void lblSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseEntered
        lblSignIn.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblSignInMouseEntered

    private void lblSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseExited
        lblSignIn.setForeground(Color.ORANGE);
    }//GEN-LAST:event_lblSignInMouseExited

    private void lblPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassMousePressed
        enviarCorreo();
    }//GEN-LAST:event_lblPassMousePressed

    private void txtUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMousePressed
        lblMensaje.setText("");
    }//GEN-LAST:event_txtUserMousePressed

    public void enviarCorreo() {
        try {
            Correo c = new Correo();
            c.setNombreArchivo("tarjeta.jpg");
            c.setRutaArchivo("tarjeta.jpg");
            c.setContraseña("hqexpdqyexxcslnn");
            c.setUsuarioCorreo("greatfallshotel@gmail.com");
            c.setAsunto("Recuperar contraseña");
            c.setMensaje("Hola, Carlos:\n\n"
                    + "Recibimos una solicitud para recordar tu contraseña de Great Falls Hotel.\n\n"
                    + "Contraseña: GreatFalls\n\n");
            c.setDestino("carlos.d.m.s@hotmail.com");
            Controlador co = new Controlador();
            if (co.enviarCorreo(c)) {
                lblMensaje.setText("Correo enviado.");
            } else {
                lblMensaje.setText("Error al enviar correo.");
            }
        } catch (MiError ex) {
            lblMensaje.setText(ex.getMessage());
        }
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

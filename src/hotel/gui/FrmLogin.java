/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.bo.UsuarioBo;
import hotel.dao.Controlador;
import hotel.entities.MiError;
import hotel.entities.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import hotel.entities.Correo;
/**
 *
 * @author pc
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    private boolean bus;

    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setButtons();
        bus = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblPassForgot = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setOpaque(false);
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("GO");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 80, -1));

        lblPassForgot.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPassForgot.setForeground(new java.awt.Color(255, 255, 255));
        lblPassForgot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassForgot.setText("Forgot Password?");
        lblPassForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPassForgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPassForgotMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPassForgotMousePressed(evt);
            }
        });
        getContentPane().add(lblPassForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 100, 20));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 340, 20));

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo.setText("Correo Electronico:");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 120, 20));

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPass.setOpaque(false);
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPassMousePressed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 340, 320));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoI.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPassForgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassForgotMouseEntered
        lblPassForgot.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblPassForgotMouseEntered

    private void lblPassForgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassForgotMouseExited
        lblPassForgot.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblPassForgotMouseExited

    private void lblPassForgotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassForgotMousePressed
        lblInfo.setVisible(true);
        txtPass.setEnabled(false);
        bus = false;
    }//GEN-LAST:event_lblPassForgotMousePressed

    private void txtUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMousePressed
        lblMensaje.setText("");
    }//GEN-LAST:event_txtUserMousePressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        enter();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMousePressed
        lblMensaje.setText("");
    }//GEN-LAST:event_txtPassMousePressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == 10) {
            enter();
        }
    }//GEN-LAST:event_txtPassKeyPressed
    /**
     * Verifica que el login sea correcto
     */
    public void enter() {
        if (bus) {
            try {
                Usuario u;
                UsuarioBo ubo = new UsuarioBo();
                u = ubo.verificarLogin(txtUser.getText().trim(), String.valueOf(txtPass.getPassword()).trim());
                if (u != null) {
                    FrmPrincipal frm = new FrmPrincipal(u);
                    frm.setVisible(true);
                    frm.setLocationRelativeTo(null);
                    dispose();
                } else {
                    lblMensaje.setText("Nombre de usuario o contraseña incorrectas.");
                }
            } catch (MiError e) {
                lblMensaje.setText(e.getMessage());
            }
        } else {
            try {
                UsuarioBo ubo = new UsuarioBo();
                Usuario u = ubo.verificarCorreo(txtUser.getText().trim());
                if (!(u == null)) {
                    enviarCorreo(u);//Envia la Contraseña
                } else {
                    lblMensaje.setText("El Usuario no Existe.");
                }

            } catch (MiError e) {
                lblMensaje.setText(e.getMessage());
            }
        }
    }

    /**
     * Envia un correo si se lo olvido la contraseña
     *
     * @param u usuario al que se le envia el correo
     */
    public void enviarCorreo(Usuario u) {
        try {
            Correo c = new Correo();
            c.setNombreArchivo("tarjeta.jpg");
            c.setRutaArchivo("tarjeta.jpg");
            c.setContraseña("contraseña del correo que lo envia");
            c.setUsuarioCorreo("greatfallshotel@gmail.com");
            c.setAsunto("Recuperar contraseña");
            c.setMensaje("Hola, " + u.getNombre() + " " + u.getApellido() + ":\n\n"
                    + "Recibimos una solicitud para recordar tu contraseña de Great Falls Hotel.\n\n"
                    + "Contraseña: " + u.getContrasena() + "\n\n");
            c.setDestino(txtUser.getText().trim());
            Controlador co = new Controlador();
            if (co.enviarCorreo(c)) {
                lblMensaje.setText("Correo enviado.");
                lblInfo.setVisible(false);
                txtPass.setEnabled(true);
                bus = true;
            } else {
                lblMensaje.setText("Error al enviar correo.");
            }
        } catch (MiError ex) {
            lblMensaje.setText(ex.getMessage());
        }
    }

    /**
     * Elimina el fondo de los botones
     */
    public void setButtons() {
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        lblInfo.setVisible(false);
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPassForgot;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

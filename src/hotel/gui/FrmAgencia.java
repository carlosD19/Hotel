/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.bo.AgenciaBo;
import hotel.entities.Agencia;
import hotel.entities.MiError;
import hotel.entities.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pc
 */
public class FrmAgencia extends javax.swing.JFrame {

    private Usuario activoU;
    private Image img2;
    private ImageIcon img;
    private int funcion;
    private ArrayList<Agencia> agencias;
    private int index;
    private AgenciaBo bo;
    private boolean bus;

    /**
     * Creates new form FrmAgencia
     */
    public FrmAgencia() {
        initComponents();
        setLocationRelativeTo(null);
        setButtons();
        bo = new AgenciaBo();
        agencias = bo.cargarTodo();
        activoU = new Usuario();
        img = new ImageIcon();
        funcion = 1;
        cargarFoto();
    }

    public FrmAgencia(Usuario u, int num) {
        initComponents();
        setLocationRelativeTo(null);
        bo = new AgenciaBo();
        agencias = bo.cargarTodo();
        img = new ImageIcon();
        funcion = num;
        activoU = u;
        bus = true;
        setIcon();
        setButtons();
        cargarFoto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcFoto = new javax.swing.JFileChooser();
        panelAgencia = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPaginaWeb = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnPrincipal = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelAgencia.setBackground(new java.awt.Color(255, 255, 255));
        panelAgencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelAgencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Agencia de Viaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre de Agencia:");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 183, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        jPanel8.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 206, 235, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Email:");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 238, -1, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        jPanel8.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 261, 235, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 293, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        jPanel8.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 316, 235, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Página Web:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 348, -1, -1));

        txtPaginaWeb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPaginaWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPaginaWebMousePressed(evt);
            }
        });
        jPanel8.add(txtPaginaWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 371, 235, -1));

        lblLogo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Logo");
        lblLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLogoMousePressed(evt);
            }
        });
        jPanel8.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 35, 235, 142));

        panelAgencia.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 420));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Agencias Registradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras_1.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel9.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 288, -1, -1));

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siguiente.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel9.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 288, -1, -1));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jPanel9.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 35, 312, 227));

        panelAgencia.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 400, 420));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelAgencia.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        panelAgencia.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 0, 50, 50));

        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });
        panelAgencia.add(btnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelAgencia.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 554, 450, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMousePressed
        lblError.setText("");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image", "jpg");
        fcFoto.setFileFilter(filtro);
        int option = fcFoto.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                img = new ImageIcon(fcFoto.getSelectedFile().getAbsolutePath());
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
                File pathToFile = new File(fcFoto.getSelectedFile().getAbsolutePath());
                Image image = ImageIO.read(pathToFile.getAbsoluteFile());
                img2 = image;
                lblLogo.setText("");
                lblLogo.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblLogoMousePressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        switch (funcion) {
            case 1:
                registrar();
                break;
            case 2:
                modificar();
                break;
            case 3:
                eliminar();
                break;
        }
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        anterior();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        lblError.setText("");
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        lblError.setText("");
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        lblError.setText("");
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtPaginaWebMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaginaWebMousePressed
        lblError.setText("");
    }//GEN-LAST:event_txtPaginaWebMousePressed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frm = new FrmPrincipal(activoU);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Registra la agencia
     */
    public void registrar() {
        try {
            Agencia a = new Agencia();
            a.setImagen(img2);
            a.setNombre(txtNombre.getText().trim());
            a.setEmail(txtEmail.getText().trim());
            a.setTelefono(Integer.valueOf(txtTelefono.getText()));
            a.setPaginaWeb(txtPaginaWeb.getText().trim());
            AgenciaBo abo = new AgenciaBo();
            if (abo.registrarAgencia(a, funcion, 0)) {
                setText();
                lblError.setText("Agencia registrada con éxito.");
                cargarDatos();
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Formato de teléfono incorrecto.");
        } catch (MiError ex) {
            lblError.setText(ex.getMessage());
        } catch (Exception ex) {
            lblError.setText("Problemas al guardar, favor intente nuevamente.");
        }
    }

    /**
     * Modifica la agencia
     */
    public void modificar() {
        try {
            Agencia a = new Agencia();
            a.setImagen(img2);
            a.setNombre(txtNombre.getText().trim());
            a.setEmail(txtEmail.getText().trim());
            a.setTelefono(Integer.valueOf(txtTelefono.getText()));
            a.setPaginaWeb(txtPaginaWeb.getText().trim());
            AgenciaBo abo = new AgenciaBo();
            if (abo.registrarAgencia(a, funcion, agencias.get(index).getId())) {
                setText();
                lblError.setText("Agencia modificada con éxito.");
                cargarDatos();
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Formato de teléfono incorrecto.");
        } catch (MiError ex) {
            lblError.setText(ex.getMessage());
        } catch (Exception ex) {
            lblError.setText("Problemas al modificar, favor intente nuevamente.");
        }
    }

    /**
     * Elimina la agencia
     */
    public void eliminar() {
        try {
            AgenciaBo abo = new AgenciaBo();
            if (abo.eliminarAgencia(agencias.get(index).getId())) {
                setText();
                cargarDatos();
                lblError.setText("Agencia Eliminada.");
            } else {
                lblError.setText("Intente Nuevamente.");
            }
        } catch (MiError ex) {
            lblError.setText(ex.getMessage());
        } catch (Exception ex) {
            lblError.setText("Problema al cargar agencias");
        }
    }

    /**
     * Cambia los iconos dependiendo de la funcion
     */
    public void setIcon() {
        switch (funcion) {
            case 2:
                btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificarREA.png")));
                break;
            case 3:
                btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminarREA.png")));
                break;
        }
    }
    /**
     * Elimina el fondo de los botones
     */
    public void setButtons() {
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBorder(null);
        btnPrincipal.setContentAreaFilled(false);
        btnPrincipal.setBorder(null);
    }
    /**
     * Carga la lista de agancias
     */
    public void cargarDatos() {
        agencias.clear();
        index = 0;
        agencias = bo.cargarTodo();
        cargarFoto();
    }
    /**
     * Carga la foto en el label
     */
    private void cargarFoto() {
        if (funcion != 1) {
            lblFoto.setIcon(null);
            if (agencias.size() > 0) {
                lblFoto.setText("");
                ImageIcon icon = new ImageIcon(agencias.get(index).getImagen());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
                if (bus) {
                    Icon icono2 = new ImageIcon(icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
                    lblLogo.setText("");
                    lblLogo.setIcon(icono2);
                    txtEmail.setText(agencias.get(index).getEmail());
                    txtNombre.setText(agencias.get(index).getNombre());
                    txtPaginaWeb.setText(agencias.get(index).getPaginaWeb());
                    txtTelefono.setText(String.valueOf(agencias.get(index).getTelefono()));
                }
            }
        }
    }
    /**
     * Pasa a la siguiente agencia
     */
    private void siguiente() {
        index++;
        if (index >= agencias.size()) {
            index = 0;
        }
        cargarFoto();
    }
    /**
     * Pasa a la agencia anterior
     */
    private void anterior() {
        index--;
        if (index < 0) {
            index = agencias.size() - 1;
        }
        cargarFoto();
    }
    /**
     * Limpia los campos de texto
     */
    public void setText() {
        txtEmail.setText("");
        txtNombre.setText("");
        txtPaginaWeb.setText("");
        txtTelefono.setText("");
        lblLogo.setIcon(null);
        lblLogo.setText("LOGO");
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
            java.util.logging.Logger.getLogger(FrmAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelAgencia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}

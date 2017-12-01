/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.bo.HabitacionBo;
import hotel.bo.TipoHabitacionBo;
import hotel.dao.TipoHabitacionDAO;
import hotel.entities.Habitacion;
import hotel.entities.MiError;
import hotel.entities.TipoHabitacion;
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
public class FrmHabitacion extends javax.swing.JFrame {

    private Usuario activoU;
    private Image img2;
    private ImageIcon img;
    private int funcion;
    private int idHabitacion;
    ArrayList<TipoHabitacion> tipo;

    /**
     * Creates new form FrmHabitacion
     */
    public FrmHabitacion() {
        initComponents();
        setLocationRelativeTo(null);
        setButtons();
        activoU = new Usuario();
        funcion = 1;
        img = new ImageIcon();
        tipo = new ArrayList<>();
        cargarTipos();
    }

    public FrmHabitacion(Usuario u, int num) {
        initComponents();
        setLocationRelativeTo(null);
        setButtons();
        activoU = u;
        funcion = num;
        tipo = new ArrayList<>();
        cargarTipos();
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
        jPanel3 = new javax.swing.JPanel();
        panelHabitacion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxNombre = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        chcBano = new javax.swing.JCheckBox();
        chcVista = new javax.swing.JCheckBox();
        chcReloj = new javax.swing.JCheckBox();
        chcTV = new javax.swing.JCheckBox();
        chcRefri = new javax.swing.JCheckBox();
        chcTelefono = new javax.swing.JCheckBox();
        chcCaja = new javax.swing.JCheckBox();
        chcAire = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTamano = new javax.swing.JTextField();
        lblFotoHab = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnAnadir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        panelHabitacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre:");

        cbxNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitación Simple", "Habitación Doble", "Habitación Triple", "Habitación Cuádruple" }));
        cbxNombre.setFocusable(false);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipo de Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        chcBano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcBano.setText("Baño");
        chcBano.setFocusable(false);

        chcVista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcVista.setText("Vista al mar");
        chcVista.setFocusable(false);

        chcReloj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcReloj.setText("Reloj");
        chcReloj.setFocusable(false);

        chcTV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcTV.setText("TV");
        chcTV.setFocusable(false);

        chcRefri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcRefri.setText("Refrigerador");
        chcRefri.setFocusable(false);

        chcTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcTelefono.setText("Teléfono");
        chcTelefono.setFocusable(false);

        chcCaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcCaja.setText("Caja Fuerte");
        chcCaja.setFocusable(false);

        chcAire.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chcAire.setText("Aire Acondicionado");
        chcAire.setFocusable(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chcTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chcReloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chcBano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chcTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chcRefri, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chcVista, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chcAire)
                    .addComponent(chcCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chcVista)
                    .addComponent(chcBano))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chcRefri)
                    .addComponent(chcReloj))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chcTelefono)
                    .addComponent(chcAire))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chcTV)
                    .addComponent(chcCaja))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Precio por noche:");

        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tipo:");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(0, 104, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Estado:");

        cbxEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Fuera de Servicio" }));
        cbxEstado.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tamaño:");

        lblFotoHab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFotoHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoHab.setText("Foto");
        lblFotoHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFotoHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFotoHabMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("N° Habitación:");

        txtNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelHabitacionLayout = new javax.swing.GroupLayout(panelHabitacion);
        panelHabitacion.setLayout(panelHabitacionLayout);
        panelHabitacionLayout.setHorizontalGroup(
            panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHabitacionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHabitacionLayout.createSequentialGroup()
                        .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFotoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelHabitacionLayout.setVerticalGroup(
            panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHabitacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTamano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(panelHabitacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFotoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(panelHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 390));

        btnAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 0, 50, 50));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFotoHabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoHabMousePressed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image", "jpg","png");
        fcFoto.setFileFilter(filtro);
        int option = fcFoto.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                img = new ImageIcon(fcFoto.getSelectedFile().getAbsolutePath());
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(lblFotoHab.getWidth(), lblFotoHab.getHeight(), Image.SCALE_DEFAULT));
                File pathToFile = new File(fcFoto.getSelectedFile().getAbsolutePath());
                Image image = ImageIO.read(pathToFile.getAbsoluteFile());
                img2 = image;
                lblFotoHab.setText("");
                lblFotoHab.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(FrmHabitacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblFotoHabMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frm = new FrmPrincipal(activoU);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        setCbx();
        for (TipoHabitacion th : tipo) {
            if (cbxTipo.getSelectedItem().toString().equals(th.getNombre())) {
                idHabitacion = th.getId();
                lblPrecio.setText("₡ " + String.valueOf(th.getPrecio()));
                if (!th.isAireAcondicionado()) {
                    chcAire.setSelected(false);
                }
                if (!th.isBaño()) {
                    chcBano.setSelected(false);
                }
                if (!th.isCajaFuerte()) {
                    chcCaja.setSelected(false);
                }
                if (!th.isRefri()) {
                    chcRefri.setSelected(false);
                }
                if (!th.isReloj()) {
                    chcReloj.setSelected(false);
                }
                if (!th.isTelefono()) {
                    chcTelefono.setSelected(false);
                }
                if (!th.isTv()) {
                    chcTV.setSelected(false);
                }
                if (!th.isVistaMar()) {
                    chcVista.setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        try{
            Habitacion h = new Habitacion();
            h.setFoto(img2);
            h.setNumero(Integer.valueOf(txtNumero.getText()));
            h.setTamaño(Float.valueOf(txtTamano.getText()));
            h.setTipoHabitacion(idHabitacion);
            h.setEstado(cbxEstado.getSelectedItem().toString());
            h.setNombre(cbxNombre.getSelectedItem().toString());
            HabitacionBo hbo = new HabitacionBo();
            if(hbo.registrarHabitacion(h)){
                System.out.println("Exitooo");
            }
        }catch(MiError ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    public void setButtons() {
        btnAnadir.setContentAreaFilled(false);
        btnAnadir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBorder(null);
    }

    

    public void setCbx() {
        chcAire.setSelected(true);
        chcBano.setSelected(true);
        chcCaja.setSelected(true);
        chcRefri.setSelected(true);
        chcReloj.setSelected(true);
        chcTV.setSelected(true);
        chcTelefono.setSelected(true);
        chcVista.setSelected(true);
    }

    public void cargarTipos() {
        TipoHabitacionBo thbo = new TipoHabitacionBo();
        tipo = thbo.cargarTodo();
        for (TipoHabitacion th : tipo) {
            cbxTipo.addItem(th.getNombre());
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
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxNombre;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JCheckBox chcAire;
    private javax.swing.JCheckBox chcBano;
    private javax.swing.JCheckBox chcCaja;
    private javax.swing.JCheckBox chcRefri;
    private javax.swing.JCheckBox chcReloj;
    private javax.swing.JCheckBox chcTV;
    private javax.swing.JCheckBox chcTelefono;
    private javax.swing.JCheckBox chcVista;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFotoHab;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JPanel panelHabitacion;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTamano;
    // End of variables declaration//GEN-END:variables
}
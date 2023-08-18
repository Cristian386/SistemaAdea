package com.mycompany.systemusuario;

import static com.mycompany.systemusuario.FormUsuario.PASSWORD;
import static com.mycompany.systemusuario.FormUsuario.URL;
import static com.mycompany.systemusuario.FormUsuario.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableroUsuario extends javax.swing.JFrame {

    public static Connection getConection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            JOptionPane.showMessageDialog(null, "conexion existosa");
        } catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
    
    String[] Titulos = {"NOMBRE", "LOGIN", "FECHA ALTA", "ESTATUS"};
    DefaultTableModel dtm_datos = new DefaultTableModel();
    TableRowSorter<TableModel> trs;
    ResultSet rs;
    String[][] M_datos;
    Conectar cc = new Conectar();
    Connection cn = cc.conectar();
    
    
    public TableroUsuario() {
        initComponents();
        datos_tabla();
    }
    
    private void datos_tabla(){
        int contador = 0;
        try {
            Statement st_cont = cn.createStatement();
            ResultSet rs_cont = st_cont.executeQuery("SELECT COUNT(*) FROM usuario");
            if (rs_cont.next()){
                contador = rs_cont.getInt(1);
            }
            
            Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre, login, fechaAlta, status FROM usuario");
            
            int cont = 0;
            M_datos = new String[contador][4];
            while (rs.next()){
                M_datos[cont][0] = rs.getString("nombre");
                M_datos[cont][1] = rs.getString("login");
                M_datos[cont][2] = rs.getString("fechaAlta");
                M_datos[cont][3] = rs.getString("status");
                cont = cont + 1;
            }
        } catch (SQLException ex){
            Logger.getLogger(TableroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dtm_datos = new DefaultTableModel(M_datos, Titulos){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        jtable_datos.setModel(dtm_datos);
        trs = new TableRowSorter<>(dtm_datos);
        jtable_datos.setRowSorter(trs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarAlta = new javax.swing.JTextField();
        txtBuscarNombre = new javax.swing.JTextField();
        txtBuscarFinal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarInactivos = new javax.swing.JButton();
        btnBuscarRevocados = new javax.swing.JButton();
        btnBuscarActivos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("FECHA ALTA INICIAL:");

        jLabel4.setText("FECHA ALTA FINAL:");

        txtBuscarAlta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAltaKeyPressed(evt);
            }
        });

        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyPressed(evt);
            }
        });

        txtBuscarFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarFinalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBuscarInactivos.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarInactivos.setText("INACTIVOS");
        btnBuscarInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInactivosActionPerformed(evt);
            }
        });

        btnBuscarRevocados.setBackground(new java.awt.Color(255, 204, 51));
        btnBuscarRevocados.setText("REVOCADOS");
        btnBuscarRevocados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRevocadosActionPerformed(evt);
            }
        });

        btnBuscarActivos.setBackground(new java.awt.Color(51, 255, 0));
        btnBuscarActivos.setText("ACTIVOS");
        btnBuscarActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnBuscarActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarRevocados, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRevocados, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setText("TABLERO Y BUSCADOR DE USUARIOS");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtable_datos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel1))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyPressed
        int valor = 0;
        int cont = 0;
        String aux = "" + txtBuscarNombre.getText();
        try {
            Statement st_cont = cn.createStatement();
            rs = st_cont.executeQuery("SELECT COUNT(*) FROM usuario WHERE nombre LIKE'"+txtBuscarNombre.getText()+"%'");
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            
            M_datos = new String[valor][4];
            rs = st_cont.executeQuery("SELECT nombre, login, fechaAlta, status FROM usuario WHERE nombre LIKE'"+txtBuscarNombre.getText()+"%'");
            while (rs.next()){
                M_datos[cont][0] = rs.getString("nombre");
                M_datos[cont][1] = rs.getString("login");
                M_datos[cont][2] = rs.getString("fechaAlta");
                M_datos[cont][3] = rs.getString("status");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos){
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        
        jtable_datos.setModel(dtm_datos);
        trs = new TableRowSorter<>(dtm_datos);
        jtable_datos.setRowSorter(trs);
            
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_txtBuscarNombreKeyPressed

    private void txtBuscarAltaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAltaKeyPressed
        int valor = 0;
        int cont = 0;
        String aux = "" + txtBuscarAlta.getText();
        try {
            Statement st_cont = cn.createStatement();
            rs = st_cont.executeQuery("SELECT COUNT(*) FROM usuario WHERE fechaAlta LIKE'"+txtBuscarAlta.getText()+"%'");
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            
            M_datos = new String[valor][4];
            rs = st_cont.executeQuery("SELECT nombre, login, fechaAlta, status FROM usuario WHERE fechaAlta LIKE'"+txtBuscarAlta.getText()+"%'");
            while (rs.next()){
                M_datos[cont][0] = rs.getString("nombre");
                M_datos[cont][1] = rs.getString("login");
                M_datos[cont][2] = rs.getString("fechaAlta");
                M_datos[cont][3] = rs.getString("status");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos){
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        
        jtable_datos.setModel(dtm_datos);
        trs = new TableRowSorter<>(dtm_datos);
        jtable_datos.setRowSorter(trs);
            
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_txtBuscarAltaKeyPressed

    private void txtBuscarFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarFinalKeyPressed
        int valor = 0;
        int cont = 0;
        String aux = "" + txtBuscarFinal.getText();
        try {
            Statement st_cont = cn.createStatement();
            rs = st_cont.executeQuery("SELECT COUNT(*) FROM usuario WHERE fechaBaja LIKE'"+txtBuscarFinal.getText()+"%'");
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            
            M_datos = new String[valor][4];
            rs = st_cont.executeQuery("SELECT nombre, login, fechaAlta, status FROM usuario WHERE fechaBaja LIKE'"+txtBuscarFinal.getText()+"%'");
            while (rs.next()){
                M_datos[cont][0] = rs.getString("nombre");
                M_datos[cont][1] = rs.getString("login");
                M_datos[cont][2] = rs.getString("fechaAlta");
                M_datos[cont][3] = rs.getString("status");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos){
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        
        jtable_datos.setModel(dtm_datos);
        trs = new TableRowSorter<>(dtm_datos);
        jtable_datos.setRowSorter(trs);
            
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_txtBuscarFinalKeyPressed

    private void btnBuscarActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActivosActionPerformed
        mostrar("A");
    }//GEN-LAST:event_btnBuscarActivosActionPerformed

    private void btnBuscarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarInactivosActionPerformed
        mostrar("B");
    }//GEN-LAST:event_btnBuscarInactivosActionPerformed

    private void btnBuscarRevocadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRevocadosActionPerformed
        mostrar("R");
    }//GEN-LAST:event_btnBuscarRevocadosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    public void mostrar(String status){
        int valor = 0;
        int cont = 0;
        try {
            Statement st_cont = cn.createStatement();
            rs = st_cont.executeQuery("SELECT COUNT(*) FROM usuario WHERE status = '"+status+"'");
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            
            M_datos = new String[valor][4];
            rs = st_cont.executeQuery("SELECT nombre, login, fechaAlta, status FROM usuario WHERE status = '"+status+"'");
            while (rs.next()){
                M_datos[cont][0] = rs.getString("nombre");
                M_datos[cont][1] = rs.getString("login");
                M_datos[cont][2] = rs.getString("fechaAlta");
                M_datos[cont][3] = rs.getString("status");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos){
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        
        jtable_datos.setModel(dtm_datos);
        trs = new TableRowSorter<>(dtm_datos);
        jtable_datos.setRowSorter(trs);
            
        } catch (Exception e){
            
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
            java.util.logging.Logger.getLogger(TableroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarActivos;
    private javax.swing.JButton btnBuscarInactivos;
    private javax.swing.JButton btnBuscarRevocados;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JTextField txtBuscarAlta;
    private javax.swing.JTextField txtBuscarFinal;
    private javax.swing.JTextField txtBuscarNombre;
    // End of variables declaration//GEN-END:variables
}

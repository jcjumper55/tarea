/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.sun.media.sound.ModelSource;
import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelos.Boletos;
import modelos.Disponibilidad;
import objects.Boleto;

/**
 *
 * @author ciroa
 */
public class VentaBoleto extends javax.swing.JFrame {
    Double costo=140.0;
    modelos.Rutas rutas;
    String action="ADD";
    javax.swing.JFrame main;
    ArrayList<String[]> asientos=new ArrayList<>();
    objects.Disponibilidad disponible;
    String [] labelsTtbl =new String [] { "ASIENTO", "TIPO", "VALOR" };
    /**
     * Creates new form VentaBoleto
     */
    public VentaBoleto() {
        initComponents();
        setConfigs();
    }
    public VentaBoleto(Principal main,objects.Boleto bol) {
        initComponents();
        this.action="EDIT";
        this.rutas=main.rutas;
        this.main=main;
        setConfigs();
        lblAsientos.setText("");
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        tblAsientos.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},labelsTtbl));
        tblAsientos.setDefaultEditor(Object.class, null);
        this.setBoleto(bol);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                main.setVisible(true);
                main.toFront();
            }
        });        
    }
    public VentaBoleto(Principal main) {
        initComponents();
        this.action="ADD";
        this.rutas=main.rutas;
        this.main=main;
        setConfigs();
        lblAsientos.setText("");
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        tblAsientos.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},labelsTtbl));
        tblAsientos.setDefaultEditor(Object.class, null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                main.setVisible(true);
            }
        });
    }
    public void setBoleto(objects.Boleto bol){
//        System.out.println("probar1 "+(bol.getParadaInicial()+" - "+bol.getParadaFinal()));
//        System.out.println("probar "+(bol.getParadaInicial()+" - "+bol.getParadaFinal()));
        cmbRuta.setSelectedItem((Object)(bol.getParadaInicial()+" - "+bol.getParadaFinal()));
        this.setHorarios();
        ((JTextField)dtpFecha.getDateEditor().getUiComponent()).setText(bol.getFecha());
        cmbHora.setSelectedItem((Object)bol.getHora());
        
        txtIdentificacion.setText(bol.getIdentificacion());
        txtNombres.setText(bol.getNombres());
        txtApellidos.setText(bol.getApellidos());
        txtEdad.setText(String.valueOf(bol.getEdad()));
        cmbTipo.setSelectedItem((Object)bol.getTipo());
        txtTotal.setText(bol.getTotal().toString());
        
        this.setDisponibilidad();        
        System.out.println(bol.getAsientosStr());
        String[] asientosStr=bol.getAsientosStr().split(";");                         
        for(int i=0;i<asientosStr.length;i++){
            System.out.println(asientosStr[i]);
            String[] asientoNum=asientosStr[i].split(":");
            this.asientos.add(new String[]{asientoNum[0],asientoNum[1]});
       }
        
        this.setAsientos();
        this.setLabelAsiento();
    }
    public void setHorarios(){
        String valRuta=(String)cmbRuta.getSelectedItem();
        ArrayList<objects.Abstract> list=this.rutas.getList();
        ArrayList<String> labels=new ArrayList<>();
        for(objects.Abstract ruta: list) {
            objects.Ruta aux=((objects.Ruta)ruta);
            String rutaFinal=/*aux.getCodigo()+": "+*/aux.getParadaInicial()+" - "+aux.getParadaFinal();
            Boolean add=true;
            if(valRuta.equals(rutaFinal)){
                for(String label: labels) {
                    if(label.equals(aux.getHora()))
                        add=false;
                }
                if(add) labels.add(aux.getHora());
            }
        }
        String[] modelArr = new String[labels.size()];
        modelArr = labels.toArray(modelArr);
        DefaultComboBoxModel model = new DefaultComboBoxModel(modelArr);
        cmbHora.setModel(model);
    }
    public void setConfigs(){
        ArrayList<objects.Abstract> list=this.rutas.getList();
        ArrayList<String> labels=new ArrayList<>();
        for(objects.Abstract ruta: list) {
            objects.Ruta aux=((objects.Ruta)ruta);
            String rutaFinal=/*aux.getCodigo()+": "+*/aux.getParadaInicial()+" - "+aux.getParadaFinal();
            System.out.println(rutaFinal);
            Boolean add=true;
            for(String label: labels) {
                if(label.equals(rutaFinal))
                    add=false;
            }
            if(add) labels.add(rutaFinal);
        }
        String[] modelArr = new String[labels.size()];
        modelArr = labels.toArray(modelArr);
        DefaultComboBoxModel model = new DefaultComboBoxModel(modelArr);
        cmbRuta.setModel(model);
        this.setHorarios();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        popupMenu1 = new java.awt.PopupMenu();
        jToolBar1 = new javax.swing.JToolBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        cmbHora = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dtpFecha = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbAsiento = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbUbica = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblAsientos = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAsientos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblNombresTitulo = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        lblApellidosTitulo = new javax.swing.JLabel();
        lblTipoClienteTitulo = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        lblApellidosTitulo1 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        popupMenu1.setLabel("popupMenu1");

        jToolBar1.setRollover(true);

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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(0, 112, 92));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Interface de Venta de Boletos");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1148, 251));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Seleccione la ruta");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/avion.png"))); // NOI18N
        jLabel3.setText("Ruta");

        jLabel7.setText("Fecha");

        cmbRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item 1", "item2" }));
        cmbRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRutaActionPerformed(evt);
            }
        });

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "05h45 y 15h00", "07h00 y 16h30" }));

        jLabel2.setText("Hora");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero de Asiento");

        cmbAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cmbAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsientoActionPerformed(evt);
            }
        });

        jLabel12.setText("Ubicación");

        cmbUbica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pasillo", "Ventana" }));
        cmbUbica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUbicaActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ASIENTOS RESERVADOS:");

        lblAsientos.setText("jLabel8");

        jButton4.setText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tblAsientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null},
                {"2", null, null},
                {"3", null, null},
                {"4", null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(tblAsientos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbUbica, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbUbica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblAsientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        lblNombresTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombresTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombresTitulo.setText("Nombres");

        lblIdentificacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIdentificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdentificacion.setText("Identificacion");

        txtIdentificacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });

        lblApellidosTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblApellidosTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellidosTitulo.setText("Apellidos");

        lblTipoClienteTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTipoClienteTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoClienteTitulo.setText("Tipo Cliente");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "VIP" }));
        cmbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        lblApellidosTitulo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblApellidosTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellidosTitulo1.setText("Edad");

        txtEdad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VentaBoleto.this.keyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KeyTyped(evt);
            }
        });

        jButton5.setText("Buscar ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtIdentificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombres)
                    .addComponent(lblNombresTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblApellidosTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdad)
                    .addComponent(lblApellidosTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoClienteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombresTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoClienteTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidosTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidosTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Asientos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("TOTAL:");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(82, 82, 82))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutaActionPerformed
        this.setHorarios();
    }//GEN-LAST:event_cmbRutaActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        for(String[] asi:this.asientos){                
            this.disponible.setOcupado(Integer.parseInt(asi[0]),false);
        }
        this.asientos=new ArrayList<>();
        this.setAsientos();
        this.setLabelAsiento();
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void cmbAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAsientoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] ruta=  cmbRuta.getSelectedItem().toString().trim().split(" - ");
        objects.Boleto bol=new Boleto();
        bol.setParadaInicial(ruta[0]);
        bol.setParadaFinal(ruta[1]);
        bol.setHora(cmbHora.getSelectedItem().toString().trim());
        bol.setFecha(((JTextField)dtpFecha.getDateEditor().getUiComponent()).getText().trim());
        bol.setIdentificacion(txtIdentificacion.getText().trim());
        bol.setNombres(txtNombres.getText().trim());
        bol.setApellidos(txtApellidos.getText().trim());
        bol.setEdad(Integer.parseInt(txtEdad.getText().trim()));
        bol.setTipo(cmbTipo.getSelectedItem().toString().trim());
        
        
        String asientosStr="";
        Double total=0.00;
        for(String[] asi:this.asientos){
            Double val=this.calculaCosto();
            total+=val;
            asientosStr+=(("".equals(asientosStr)?"":";")+(asi[0]+":"+asi[1]+":"+val));
        }
        bol.setAsientosStr(asientosStr);
        bol.setTotal(this.round(total, 2));
        
        modelos.Boletos bolManager=new modelos.Boletos();
        if(this.action.equals("EDIT"))            
            bolManager.updateData(bol);
        else    
            bolManager.addData(bol);
        Disponibilidad dis=new Disponibilidad();
        dis.updateData(this.disponible);
        this.main.setVisible(true);        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setDisponibilidad(){
        if(!((JTextField)dtpFecha.getDateEditor().getUiComponent()).getText().trim().equals("")){
            this.asientos=new ArrayList<>();
            Disponibilidad dis=new Disponibilidad();
            dis.readData();  
            String fecha=((JTextField)dtpFecha.getDateEditor().getUiComponent()).getText().trim();
            if(!"".equals(fecha.trim())){
                //System.out.println("Fecha: "+String.format("%1$ty-%1$tm-%1$td",dtpFecha.getD));
                objects.Disponibilidad asienAux=dis.Search(cmbRuta.getSelectedItem().toString(),cmbHora.getSelectedItem().toString(), ((JTextField)dtpFecha.getDateEditor().getUiComponent()).getText());
                if(asienAux==null){
                    String[] ruta=  cmbRuta.getSelectedItem().toString().trim().split(" - ");
                    asienAux=new objects.Disponibilidad();
                    asienAux.setParadaInicial(ruta[0]);
                    asienAux.setParadaFinal(ruta[1]);
                    asienAux.setFecha(fecha);
                    asienAux.setHora(cmbHora.getSelectedItem().toString().trim());
                    dis.addData(asienAux);
                } 
                this.disponible=asienAux;                
            }
        }else
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha valida!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE); 
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setDisponibilidad();
        this.setAsientos();
    }//GEN-LAST:event_jButton3ActionPerformed
    private void setAsientos(){
        if(this.disponible!=null){
            ArrayList<Integer> asientosTipo=this.disponible.getAsientosDisponibles(cmbUbica.getSelectedItem().toString().trim());
            ArrayList<String> asientosLibres=new ArrayList<>();
            String tipo=cmbTipo.getSelectedItem().toString().trim();
            for(Integer num: asientosTipo){
                if(!this.isOcupado(num) && ( (tipo.equals("VIP")&& num<=20)||(tipo.equals("Normal")&& num>20) ))
                    asientosLibres.add(String.valueOf(num));
            }
            String[] a = new String[asientosLibres.size()];
            cmbAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(asientosLibres.toArray(a)));
        }
    }
    private Boolean isOcupado(Integer num){
        for(String[] asien : this.asientos){
            if(num==Integer.parseInt(asien[0]))
                return true;
        }
        return false;
    }
    private void cmbUbicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUbicaActionPerformed
        this.setAsientos();
    }//GEN-LAST:event_cmbUbicaActionPerformed
    public boolean isNumeric(String cadena) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    public boolean validaCliente() {
        return (!txtIdentificacion.getText().trim().equals("") &&
               !txtNombres.getText().trim().equals("") &&
               !txtApellidos.getText().trim().equals("") &&
               !txtEdad.getText().trim().equals("") &&
               this.isNumeric(txtEdad.getText().trim()));
    }
    public Double calculaCosto(){
        Double val=this.costo;
        if(this.isNumeric(txtEdad.getText().trim())){
            int edad=Integer.parseInt(txtEdad.getText().trim());
            if(edad>=70) val-=(this.costo*0.10);
            if( edad<=5 && cmbTipo.getSelectedItem().toString().trim().equals("Normal")){
                val-=(this.costo*0.05);
            }
        }
        if(cmbTipo.getSelectedItem().toString().trim().equals("VIP")){
            val-=(this.costo*0.04);
        }else{
            val-=(this.costo*0.02);
        }
        return val;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.disponible!=null){
            if(this.validaCliente()){
                if(this.asientos.size()<5){
                    String num=cmbAsiento.getSelectedItem().toString().trim();
                    this.asientos.add(new String[]{num,cmbUbica.getSelectedItem().toString().trim()});
                    this.disponible.setOcupado(Integer.parseInt(num),true);
                    this.setAsientos();
                    this.setLabelAsiento();
                }else
                    JOptionPane.showMessageDialog(null, "No puede reservar mas de 5 asientos!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null, "Debe Llenar los datos del cliente correctamente!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "Seleccione Ruta Fecha y Hora!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row=tblAsientos.getSelectedRow();
        if (row != -1){
            System.out.println(row);
            String num=tblAsientos.getModel().getValueAt(row, 0).toString();
            int i=0;
            for(String[] asi:this.asientos){
                if(asi[0].equals(num)){
                    this.asientos.remove(i);
                    this.disponible.setOcupado(Integer.parseInt(num),false);
                    this.setAsientos();
                    this.setLabelAsiento();
                    break;
                }
                i++;
            }
        }else
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una el asiento a eliminar!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        this.setLabelAsiento();
    }//GEN-LAST:event_txtEdadActionPerformed

    private void KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeyTyped
        //this.setLabelAsiento();
    }//GEN-LAST:event_KeyTyped

    private void keyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyReleased
        this.setLabelAsiento();
    }//GEN-LAST:event_keyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Boletos dis=new Boletos();
        dis.readData();
        objects.Boleto bol=dis.SearchOne(cmbRuta.getSelectedItem().toString(),cmbHora.getSelectedItem().toString(), ((JTextField)dtpFecha.getDateEditor().getUiComponent()).getText(), txtIdentificacion.getText().trim());
        if(bol!=null){
            this.setBoleto(bol);
        }else
            JOptionPane.showMessageDialog(null, "No se encontro el boleto a Editar!", "InfoBox: " + "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed
    public Double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public void setLabelAsiento(){
        Double total=0.00;
        String asientosStr="";
        Object[][] tabla=new Object [this.asientos.size()][3];
        int i=0;
        for(String[] asi:this.asientos){
            Double valorAsi=this.calculaCosto();
            asientosStr+=(("".equals(asientosStr)?"":", ")+asi[0]);
            tabla[i]=new Object[]{asi[0],asi[1],valorAsi};
            total+=valorAsi;
            i++;
        }
        lblAsientos.setText(asientosStr);
        txtTotal.setText(this.round(total, 2).toString());
        tblAsientos.setModel(new javax.swing.table.DefaultTableModel(tabla,labelsTtbl));
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
            java.util.logging.Logger.getLogger(VentaBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaBoleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbAsiento;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbUbica;
    private com.toedter.calendar.JDateChooser dtpFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblApellidosTitulo;
    private javax.swing.JLabel lblApellidosTitulo1;
    private javax.swing.JLabel lblAsientos;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNombresTitulo;
    private javax.swing.JLabel lblTipoClienteTitulo;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tblAsientos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

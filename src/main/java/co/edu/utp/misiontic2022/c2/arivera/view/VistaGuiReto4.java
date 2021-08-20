package co.edu.utp.misiontic2022.c2.arivera.view;

import javax.swing.JPanel;
//import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.arivera.view.TablaNombre;
import co.edu.utp.misiontic2022.c2.arivera.view.TablaSalario;
import co.edu.utp.misiontic2022.c2.arivera.view.TablaTipoProyecto;
import co.edu.utp.misiontic2022.c2.arivera.view.VistaRequerimientosReto4;
import co.edu.utp.misiontic2022.c2.arivera.controller.ControladorRequerimientosReto4;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento1;
import co.edu.utp.misiontic2022.c2.arivera.model.dao.Requerimiento_1Dao;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento2;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento3;

public class VistaGuiReto4 extends JFrame {
    /************ Declaración de Variables ************/

    private javax.swing.JMenuBar mbArchivo;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmAcerca;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem miAcercaDe;
    private javax.swing.JMenuItem miLiderNombre;
    private javax.swing.JMenuItem miLiderSalario;
    private javax.swing.JMenuItem miLimpiarConsulta;
    private javax.swing.JMenuItem miTipoProyecto;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpConsultas;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btnLiderNombre;
    private javax.swing.JButton btnLiderSalario;
    private javax.swing.JLabel jlTitleConsultas;
    private javax.swing.JButton btnProyectoTipo;
    private javax.swing.JPanel jpContenedorTabla;
    private javax.swing.JScrollPane jsOcultar;
    private javax.swing.JTable tblPrincipal;

    public static final ControladorRequerimientosReto4 controller = new ControladorRequerimientosReto4();
    public TablaSalario modelTabla;
    public TablaTipoProyecto modelTabla1;
    public TablaNombre modelTabla2;

    public VistaGuiReto4(){
        elementos();
        pantalla();
        setLocationRelativeTo(null);
        jsOcultar.setVisible(false); 
    }

    private void elementos() {

        /*********************** Configuración Barra Menús ***********************/
        mbArchivo = new javax.swing.JMenuBar();
        // mbArchivo.setBackground(new java.awt.Color(0, 204, 204));
        setJMenuBar(mbArchivo);
        jmArchivo = new javax.swing.JMenu();
        jmArchivo.setText("Archivo");
        mbArchivo.add(jmArchivo);

        jmAcerca = new javax.swing.JMenu();
        miAcercaDe = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();
        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jmArchivo.add(miSalir);

        jmConsultas = new javax.swing.JMenu();
        jmConsultas.setText("Consultas");
        mbArchivo.add(jmConsultas);
        miLiderSalario = new javax.swing.JMenuItem();
        miLiderSalario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miLiderSalario.setText("Lideres por Salario");
        miLiderSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLiderSalarioActionPerformed(evt);
            }
        });
        jmConsultas.add(miLiderSalario);
        miTipoProyecto = new javax.swing.JMenuItem();
        miTipoProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miTipoProyecto.setText("Proyectos por Tipo");

        
        miTipoProyecto.addActionListener(new java.awt.event.ActionListener() { public
        void actionPerformed(java.awt.event.ActionEvent evt) {
        miTipoProyectoActionPerformed(evt); } });
        
        jmConsultas.add(miTipoProyecto);

        miLiderNombre = new javax.swing.JMenuItem();
        miLiderNombre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miLiderNombre.setText("Lideres por Nombre");
        miLiderNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLiderNombreActionPerformed(evt);
            }
        });
        jmConsultas.add(miLiderNombre);

        miLimpiarConsulta = new javax.swing.JMenuItem();
        miLimpiarConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miLimpiarConsulta.setText("Limpiar Consulta");
        miLimpiarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLimpiarConsultaActionPerformed(evt);
            }
        });
        jmConsultas.add(miLimpiarConsulta);

        jmAcerca = new javax.swing.JMenu();
        jmAcerca.setText("Acerca de");
        mbArchivo.add(jmAcerca);
        miAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miAcercaDe.setText("Acerca de Nosotros");
        miAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAcercaDeActionPerformed(evt);
            }
        });
        jmAcerca.add(miAcercaDe);

        mbArchivo.add(jmAcerca);

        setJMenuBar(mbArchivo);

        /* Titulo */
        jlTitulo = new javax.swing.JLabel();
        jlTitulo.setBackground(new java.awt.Color(0, 204, 204));
        jlTitulo.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Constructora Construyendo Sueños S.A");
        getContentPane().add(jlTitulo, java.awt.BorderLayout.PAGE_START);

        /* Panel de Consultas */

        jpConsultas = new javax.swing.JPanel();
        jpConsultas.setBackground(new java.awt.Color(0, 204, 204));
        jpConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLiderSalario = new javax.swing.JButton();
        btnProyectoTipo = new javax.swing.JButton();
        btnLiderNombre = new javax.swing.JButton();
        jlTitleConsultas = new javax.swing.JLabel();
        btLimpiar = new javax.swing.JButton();

        btnLiderSalario.setText("Lideres por Salario");
        btnLiderSalario.setFocusable(false);
        btnLiderSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiderSalarioActionPerformed(evt);
            }
        });

        btnProyectoTipo.setText("Proyecto por Tipo");
        btnProyectoTipo.setFocusable(false);
        btnProyectoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectoTipoActionPerformed(evt);
            }
        });

        btnLiderNombre.setText("Lideres por Nombre");
        btnLiderNombre.setFocusable(false);
        btnLiderNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiderNombreActionPerformed(evt);
            }
        });

        jlTitleConsultas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlTitleConsultas.setText("CONSULTAS");
        jlTitleConsultas.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        btLimpiar.setText("Limpiar");
        btLimpiar.setFocusable(false);
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConsultasLayout = new javax.swing.GroupLayout(jpConsultas);
        jpConsultas.setLayout(jpConsultasLayout);
        jpConsultasLayout.setHorizontalGroup(jpConsultasLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpConsultasLayout.createSequentialGroup().addContainerGap()
                        .addGroup(jpConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLiderSalario, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProyectoTipo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLiderNombre, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                .addGroup(jpConsultasLayout.createSequentialGroup().addGap(36, 36, 36)
                        .addComponent(jlTitleConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btLimpiar,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)));
        jpConsultasLayout.setVerticalGroup(jpConsultasLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpConsultasLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(jlTitleConsultas)
                        .addGap(64, 64, 64).addComponent(btnLiderSalario).addGap(56, 56, 56)
                        .addComponent(btnProyectoTipo).addGap(56, 56, 56).addComponent(btnLiderNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btLimpiar).addGap(22, 22, 22)));

        getContentPane().add(jpConsultas, java.awt.BorderLayout.LINE_START);

        /* Panel Contenedor de Tabla */

        jpContenedorTabla = new javax.swing.JPanel();
        jpContenedorTabla.setBackground(new java.awt.Color(0, 153, 153));
        jpContenedorTabla.setLayout(new java.awt.BorderLayout());

        jsOcultar = new javax.swing.JScrollPane();
        jsOcultar.setBackground(new java.awt.Color(0, 153, 153));
        jpContenedorTabla.add(jsOcultar, java.awt.BorderLayout.CENTER);

        /* Tabla Chicharron carnudo :/ */

        tblPrincipal = new javax.swing.JTable();
        tblPrincipal.setAutoCreateRowSorter(true);
        tblPrincipal.setForeground(new java.awt.Color(0, 51, 51));
        /* Object[][] control = { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                { null, null, null, null } };
        String[] column = { "prueba", "APELLIDO ", "ID LIDER", "SALARIO" };

        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(control, column));
 */
        tblPrincipal.setGridColor(new java.awt.Color(51, 204, 255));
        tblPrincipal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPrincipal.setGridColor(new java.awt.Color(51, 204, 255));
        tblPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jpContenedorTabla.add(tblPrincipal, java.awt.BorderLayout.CENTER);
        jsOcultar.setViewportView(tblPrincipal);

        jpContenedorTabla.add(jsOcultar, java.awt.BorderLayout.CENTER);
        getContentPane().add(jpContenedorTabla, java.awt.BorderLayout.CENTER);       
    }

    /* Metodos Funcionales */

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {
        salirApp();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        salirApp();
    }

    private void miLiderSalarioActionPerformed(java.awt.event.ActionEvent evt) {
        consultaLiderSalario();
    }

    private void consultaLiderSalario() throws HeadlessException {
        try {
            tblPrincipal.setVisible(true);
            var liderS = controller.requerimiento_1();
            modelTabla = new TablaSalario(liderS);
            tblPrincipal.setModel(modelTabla);
            jsOcultar.setVisible(true);            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        //tblPrincipal.clearSelection();
        // tblPrincipal.setVisible(false);
        jsOcultar.setVisible(false);
    }

    private void btnLiderSalarioActionPerformed(java.awt.event.ActionEvent evt) {
        consultaLiderSalario();

    }

    private void btnProyectoTipoActionPerformed(java.awt.event.ActionEvent evt) {
        consultaTipoProyecto();
    }

    private void btnLiderNombreActionPerformed(java.awt.event.ActionEvent evt) {
        consultaLiderNombre();
    }

    private void miAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Este Programa fue diseñado para realizar consultas,\nelaborado por Andres Rivera", getTitle(),
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void miTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {
        consultaTipoProyecto();
    }

    private void miLiderNombreActionPerformed(java.awt.event.ActionEvent evt) {
        consultaLiderNombre();
    }

    private void miLimpiarConsultaActionPerformed(java.awt.event.ActionEvent evt) {
        tblPrincipal.clearSelection();
        // tblPrincipal.setVisible(false);
        jsOcultar.setVisible(false);
    }

    private void consultaLiderNombre() throws HeadlessException {
        try {
            var liderN = controller.requerimiento_3();
            //tblPrincipal.clearSelection();
            jsOcultar.setVisible(true);
            modelTabla2 = new TablaNombre(liderN);
            tblPrincipal.setModel(modelTabla2);
            
            // tblPrincipal.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultaTipoProyecto() throws HeadlessException {
        try {
            jsOcultar.setVisible(true);
            var tipoP = controller.requerimiento_2();
            tblPrincipal.clearSelection();
            modelTabla1 = new TablaTipoProyecto(tipoP);
            tblPrincipal.setModel(modelTabla1);            
            // tblPrincipal.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salirApp() throws HeadlessException {
        if (JOptionPane.showConfirmDialog(this, "¿Desea salir del Programa?", getTitle(),
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public void pantalla() {
        setTitle("App Consultas");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

    }
    
}

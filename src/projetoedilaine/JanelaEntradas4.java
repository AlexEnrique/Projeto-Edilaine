package projetoedilaine;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex Enrique Crispim
 */
public class JanelaEntradas4 extends javax.swing.JFrame {

    private int x, y;
    private Timer fadeInJL3;
    private JSONObject json;

    private static final long serialVersionUID = 8607734981506765935L;
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final int SB_SIZE = 10;
    private static final Color THUMB_COLOR = Color.BLACK;

    public JanelaEntradas4() throws FileNotFoundException {
        this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json")
                          )
                      )
                  );
        initComponents();
    }

    private void initComponents() throws FileNotFoundException {

        /* jLabel1 == Figura da empresa
         * jLabel2 == Campo para arrastar a tela
         * jPanel1 == painel principal; tela toda
         * jPanel2 == painel onde ficam os jLable 1 e 2 e os botões de minimizar e maximizar
         */
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        // Botões sim ou não para abrir o panel de necessidades especiais
        jPanel3 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane(jPanel3);

        jLabelQuestion = new javax.swing.JLabel() ;
        jRadioButtonSim = new javax.swing.JRadioButton("Sim");
        jRadioButtonNao = new javax.swing.JRadioButton("Não");
        buttonGroup = new javax.swing.ButtonGroup();

        // Botoes de minimizar e maximizar
        jButtonExit = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();

        // Separador
        jSeparator = new javax.swing.JSeparator(SwingConstants.VERTICAL);

        // Next and previous buttons
        jButtonNext = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criador de currículo CONTRETEC");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 900, 550));
        setMaximumSize(new java.awt.Dimension(900, 550));
        setMinimumSize(new java.awt.Dimension(900, 550));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButtonExit.setBackground(new java.awt.Color(62, 62, 62));
        jButtonExit.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("x");
        jButtonExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonExit.setFocusPainted(false);
        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jButtonExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonExitMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonExitMouseExited(evt);
            }
        });


        jButtonMinimize.setBackground(new java.awt.Color(62, 62, 62));
        jButtonMinimize.setFont(new Font("DejaVu Sans", 1, 14)); // NOI18N
        jButtonMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMinimize.setText("-");
        jButtonMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonMinimize.setFocusPainted(false);
        jButtonMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonMinimizeActionPerformed(evt);
            }
        });
        jButtonMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonMinimizeMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonMinimizeMouseExited(evt);
            }
        });

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });


        // Deficiencias
        if (json.getString("deficiencia?").equals("sim"))
          jRadioButtonSim.setSelected(true);
        else
          jRadioButtonNao.setSelected(true);
          
        // ================================================================================================================
        // *jScrollPane principal******************************************************************************************
        if (json.getString("deficiencia?").equals("sim"))
          jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(215, 215, 215), 1));
        else
          jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
        jScrollPane.setPreferredSize(new Dimension(840, 300));
        jScrollPane.setBackground(new Color(255, 255, 255));

        jPanel3.setBackground(new Color(255, 255, 255));
        jPanel3.setBorder(BorderFactory.createEmptyBorder());

        jScrollBar = jScrollPane.getVerticalScrollBar();
        jScrollBar.setPreferredSize(new Dimension(9, 1));
        jScrollBar.setUI(new ProjectScrollBarUI(jScrollPane));
        // *jScrollPane principal******************************************************************************************

        // *Check Box gerais ******************************************************************************************
        JCheckBox jCheckBoxAuditiva = new JCheckBox();
        JCheckBox jCheckBoxFala = new JCheckBox();
        JCheckBox jCheckBoxFisica = new JCheckBox();
        JCheckBox jCheckBoxIntelectualMental = new JCheckBox();
        JCheckBox jCheckBoxVisual = new JCheckBox();

        jCheckBoxAuditiva.setFocusPainted(false);
        jCheckBoxFala.setFocusPainted(false);
        jCheckBoxFisica.setFocusPainted(false);
        jCheckBoxIntelectualMental.setFocusPainted(false);
        jCheckBoxVisual.setFocusPainted(false);

        jCheckBoxAuditiva.setSelected(json.getString("defAuditiva?").toLowerCase().equals("sim"));
        jCheckBoxFala.setSelected(json.getString("defFala?").equals("sim"));
        jCheckBoxFisica.setSelected(json.getString("defFisica?").equals("sim"));
        jCheckBoxIntelectualMental.setSelected(json.getString("defIntelectualMental?").equals("sim"));
        jCheckBoxVisual.setSelected(json.getString("defVisual?").equals("sim"));


        // *Check Box gerais ******************************************************************************************

        // *Auditiva***************************************************************************************************
        jCheckBoxAuditiva.setBackground(new Color(230, 230, 230));
        jCheckBoxAuditiva.setForeground(new Color(62, 62, 62));
        jCheckBoxAuditiva.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
        jCheckBoxAuditiva.setFont(new Font("DejaVu Sans", 1, 15));
        jCheckBoxAuditiva.setText("Auditiva");

        JLabel jLabelAud1 = new JLabel("Nível de deficiência auditiva");

        JComboBox jComboBoxAud1 = new JComboBox<>();
        JComboBox jComboBoxAud2 = new JComboBox<>();

        JLabel jLabelAud2 = new JLabel("Tipo de deficiência auditiva");

        JCheckBox jCheckBoxAud1 = new JCheckBox("Oralizado");
        JCheckBox jCheckBoxAud2 = new JCheckBox("Usuário de Libras");
        JCheckBox jCheckBoxAud3 = new JCheckBox("Precisa de Intérprete");

        jCheckBoxAud1.setSelected(json.getString("defAuditivaOralizado?").equals("sim"));
        jCheckBoxAud2.setSelected(json.getString("defAuditivaLibras?").equals("sim"));
        jCheckBoxAud3.setSelected(json.getString("defAuditivaInterprete?").equals("sim"));

        jLabelAud1.setBackground(new Color(230, 230, 230));
        jLabelAud1.setForeground(new Color(62, 62, 62));
        jLabelAud1.setFont(new Font("DejaVu Sans", 0, 12));

        jLabelAud2.setBackground(new Color(255, 255, 255));
        jLabelAud2.setForeground(new Color(62, 62, 62));
        jLabelAud2.setFont(new Font("DejaVu Sans", 0, 12));

        jComboBoxAud1.setModel(new DefaultComboBoxModel<>(new String[] {"", "de 41 a 55 dB - Surdez Moderada", "de 56 a 70 dB - Surdez Acentuada", "de 71 a 90 dB - Surdez Severa", "acima de 91 dB - Surdez Profunda", "Anacusia"}));
        jComboBoxAud2.setModel(new DefaultComboBoxModel<>(new String[] {"", "unilateral", "bilateral"}));
        jComboBoxAud1.setSelectedItem(json.getString("defAuditivaNivel"));
        jComboBoxAud2.setSelectedItem(json.getString("defAuditivaTipo"));

        jCheckBoxAud1.setBackground(new Color(230, 230, 230));
        jCheckBoxAud1.setForeground(new Color(62, 62, 62));
        jCheckBoxAud1.setFont(new Font("DejaVu Sans", 0, 12));

        jCheckBoxAud2.setBackground(new Color(230, 230, 230));
        jCheckBoxAud2.setForeground(new Color(62, 62, 62));
        jCheckBoxAud2.setFont(new Font("DejaVu Sans", 0, 12));

        jCheckBoxAud3.setBackground(new Color(230, 230, 230));
        jCheckBoxAud3.setForeground(new Color(62, 62, 62));
        jCheckBoxAud3.setFont(new Font("DejaVu Sans", 0, 12));

        // addActionListener's
        jComboBoxAud1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defAuditivaNivel", jComboBoxAud1.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jComboBoxAud2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defAuditivaTipo", jComboBoxAud2.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jCheckBoxAuditiva.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxAuditiva.isSelected()) {
              json.put("defAuditiva?", "sim");
            } else {
              json.put("defAuditiva?", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jCheckBoxAud1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxAud1.isSelected()) {
              json.put("defAuditivaOralizado?", "sim");
            } else {
              json.put("defAuditivaOralizado?", "");
            }

            try {
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxAud2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxAud2.isSelected()) {
              json.put("defAuditivaLibras?", "sim");
            } else {
              json.put("defAuditivaLibras?", "");
            }

            try {
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxAud3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxAud3.isSelected()) {
              json.put("defAuditivaInterprete?", "sim");
            } else {
              json.put("defAuditivaInterprete?", "");
            }

            try {
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        // *Auditiva***************************************************************************************************


        // *Fala***************************************************************************************************
        jCheckBoxFala.setBackground(new Color(230, 230, 230));
        jCheckBoxFala.setForeground(new Color(62, 62, 62));
        jCheckBoxFala.setFont(new Font("DejaVu Sans", 1, 15));
        jCheckBoxFala.setText("Fala");

        JLabel jLabelFala1 = new JLabel("Tipo de deficiência de fala");
        JComboBox jComboBoxFala1 = new JComboBox<>();

        jLabelFala1.setBackground(new Color(255, 255, 255));
        jLabelFala1.setForeground(new Color(62, 62, 62));
        jLabelFala1.setFont(new Font("DejaVu Sans", 0, 12));

        jComboBoxFala1.setModel(new DefaultComboBoxModel<>(new String[] {"", "Pequenas alterações na fala", "Grandes alterações na fala", "Mudez"}));
        jComboBoxFala1.setSelectedItem(json.getString("defFalaTipo"));
        // addActionListener's
        jCheckBoxFala.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxFala.isSelected()) {
              json.put("defFala?", "sim");
            } else {
              json.put("defFala?", "");
            }

            try {
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jComboBoxFala1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defFalaTipo", jComboBoxFala1.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        // *Fala***************************************************************************************************


        // *Física***************************************************************************************************
        jCheckBoxFisica.setBackground(new Color(230, 230, 230));
        jCheckBoxFisica.setForeground(new Color(62, 62, 62));
        jCheckBoxFisica.setFont(new Font("DejaVu Sans", 1, 15));
        jCheckBoxFisica.setText("Fisica");

        JLabel jLabelFis1 = new JLabel("Tipo de deficiência física");
        JComboBox jComboBoxFisica1 = new JComboBox<>();

        jLabelFis1.setBackground(new Color(255, 255, 255));
        jLabelFis1.setForeground(new Color(62, 62, 62));
        jLabelFis1.setFont(new Font("DejaVu Sans", 0, 12));

        jComboBoxFisica1.setModel(new DefaultComboBoxModel<>(new String[] {"", "Monoparesia", "Monoplegia", "Hemiparesia", "Hemiplegia", "Paraparesia", "Paraplegia", "Triparesia", "Triplegia", "Tetraparesia", "Tetraplegia", "Amputação ou ausência de membro", "Membos com deformidade congênida ou adquirida", "Nanismo", "Ostomia", "Paralisia cerebral", "Deficiência Crônica Renal"}));
        jComboBoxFisica1.setSelectedItem(json.getString("defFisicaTipo"));

        // addActionListener's
        jCheckBoxFisica.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxFisica.isSelected()) {
              json.put("defFisica?", "sim");
            } else {
              json.put("defFisica?", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jComboBoxFisica1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defFisicaTipo", jComboBoxFisica1.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        // *Física***************************************************************************************************


        // *Intelectual/Mental***************************************************************************************************
        jCheckBoxIntelectualMental.setBackground(new Color(230, 230, 230));
        jCheckBoxIntelectualMental.setForeground(new Color(62, 62, 62));
        jCheckBoxIntelectualMental.setFont(new Font("DejaVu Sans", 1, 15));
        jCheckBoxIntelectualMental.setText("Intelectual/Mental");

        JLabel jLabelIntMent1 = new JLabel("Limitações associadas a duas ou mais áreas de habilidades adaptativas, tais como:");

        jLabelIntMent1.setBackground(new Color(255, 255, 255));
        jLabelIntMent1.setForeground(new Color(62, 62, 62));
        jLabelIntMent1.setFont(new Font("DejaVu Sans", 0, 12));

        JCheckBox jCheckBoxIntMent1 = new JCheckBox("Comunicação");
        jCheckBoxIntMent1.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent1.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent1.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent1.setSelected(json.getString("defIntelectualMentalItem1").equals("sim"));

        JCheckBox jCheckBoxIntMent2 = new JCheckBox("Cuidado pessoal");
        jCheckBoxIntMent2.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent2.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent2.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent2.setSelected(json.getString("defIntelectualMentalItem2").equals("sim"));

        JCheckBox jCheckBoxIntMent3 = new JCheckBox("Habilidade social");
        jCheckBoxIntMent3.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent3.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent3.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent3.setSelected(json.getString("defIntelectualMentalItem3").equals("sim"));

        JCheckBox jCheckBoxIntMent4 = new JCheckBox("Utilização de recursos da comunidade");
        jCheckBoxIntMent4.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent4.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent4.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent4.setSelected(json.getString("defIntelectualMentalItem4").equals("sim"));

        JCheckBox jCheckBoxIntMent5 = new JCheckBox("Saúde e segurança");
        jCheckBoxIntMent5.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent5.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent5.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent5.setSelected(json.getString("defIntelectualMentalItem5").equals("sim"));

        JCheckBox jCheckBoxIntMent6 = new JCheckBox("Habilidade acadêmica");
        jCheckBoxIntMent6.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent6.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent6.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent6.setSelected(json.getString("defIntelectualMentalItem6").equals("sim"));

        JCheckBox jCheckBoxIntMent7 = new JCheckBox("Lazer");
        jCheckBoxIntMent7.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent7.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent7.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent7.setSelected(json.getString("defIntelectualMentalItem7").equals("sim"));

        JCheckBox jCheckBoxIntMent8 = new JCheckBox("Trabalho");
        jCheckBoxIntMent8.setBackground(new Color(230, 230, 230));
        jCheckBoxIntMent8.setForeground(new Color(62, 62, 62));
        jCheckBoxIntMent8.setFont(new Font("DejaVu Sans", 0, 12));
        jCheckBoxIntMent8.setSelected(json.getString("defIntelectualMentalItem8").equals("sim"));

        // addActionListener's
        jCheckBoxIntelectualMental.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntelectualMental.isSelected()) {
              json.put("defIntelectualMental?", "sim");
            } else {
              json.put("defIntelectualMental?", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent1.isSelected()) {
              json.put("defIntelectualMentalItem1", "sim");
            } else {
              json.put("defIntelectualMentalItem1", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent2.isSelected()) {
              json.put("defIntelectualMentalItem2", "sim");
            } else {
              json.put("defIntelectualMentalItem2", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent3.isSelected()) {
              json.put("defIntelectualMentalItem3", "sim");
            } else {
              json.put("defIntelectualMentalItem3", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent4.isSelected()) {
              json.put("defIntelectualMentalItem4", "sim");
            } else {
              json.put("defIntelectualMentalItem4", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent5.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent5.isSelected()) {
              json.put("defIntelectualMentalItem5", "sim");
            } else {
              json.put("defIntelectualMentalItem5", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent6.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent6.isSelected()) {
              json.put("defIntelectualMentalItem6", "sim");
            } else {
              json.put("defIntelectualMentalItem6", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent7.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent7.isSelected()) {
              json.put("defIntelectualMentalItem7", "sim");
            } else {
              json.put("defIntelectualMentalItem7", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        jCheckBoxIntMent8.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxIntMent8.isSelected()) {
              json.put("defIntelectualMentalItem8", "sim");
            } else {
              json.put("defIntelectualMentalItem8", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        // *Intelectual/Mental***************************************************************************************************


        // *Visual***************************************************************************************************
        jCheckBoxVisual.setBackground(new Color(230, 230, 230));
        jCheckBoxVisual.setForeground(new Color(62, 62, 62));
        jCheckBoxVisual.setFont(new Font("DejaVu Sans", 1, 15));
        jCheckBoxVisual.setText("Visual");

        JLabel jLabelVisual1 = new JLabel("Tipo de deficiência visual");
        JLabel jLabelVisual2 = new JLabel("Detalhamento da deficiência visual");

        jLabelVisual1.setBackground(new Color(230, 230, 230));
        jLabelVisual1.setForeground(new Color(62, 62, 62));
        jLabelVisual1.setFont(new Font("DejaVu Sans", 0, 12));

        jLabelVisual2.setBackground(new Color(255, 255, 255));
        jLabelVisual2.setForeground(new Color(62, 62, 62));
        jLabelVisual2.setFont(new Font("DejaVu Sans", 0, 12));

        JComboBox jComboBoxVisual1 = new JComboBox<>();
        JComboBox jComboBoxVisual2 = new JComboBox<>();

        jComboBoxVisual1.setModel(new DefaultComboBoxModel<>(new String[] {"", "Visão Subnormal ou Baixa Visão", "Cegueira", "Visão monocular", "Somatória da média do campo de visão em ambos os olhos menor do que 60º"}));
        jComboBoxVisual2.setModel(new DefaultComboBoxModel<>(new String[] {"", "unilateral", "bilateral"}));

        jComboBoxVisual1.setSelectedItem(json.getString("defVisualTipo"));
        jComboBoxVisual2.setSelectedItem(json.getString("defVisualDetalhamento"));

        // addActionListener's
        jCheckBoxVisual.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            if (jCheckBoxVisual.isSelected()) {
              json.put("defVisual?", "sim");
            } else {
              json.put("defVisual?", "");
            }

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jComboBoxVisual1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defVisualTipo", jComboBoxVisual1.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        jComboBoxVisual2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            json.put("defVisualDetalhamento", jComboBoxVisual2.getSelectedItem());

            try {
                WriteJSON();
            } catch (IOException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        // *Visual***************************************************************************************************


        // *Observações***************************************************************************************************
        JTextArea jTextAreaObservacoes = new JTextArea();
        JScrollPane jScrollPaneObservacoes = new JScrollPane(jTextAreaObservacoes);
        JScrollBar jScrollBarObservacoes = new JScrollBar();
        JLabel jLabelObservacoes = new JLabel("Observações");
        jLabelObservacoes.setBackground(new Color(255, 255, 255));
        jLabelObservacoes.setForeground(new Color(62, 62, 62));
        jLabelObservacoes.setFont(new Font("DejaVu Sans", 1, 15));

        jScrollPaneObservacoes.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));
        jScrollPaneObservacoes.setPreferredSize(new Dimension(840, 300));

        jScrollBarObservacoes = jScrollPaneObservacoes.getVerticalScrollBar();
        jScrollBarObservacoes.setPreferredSize(new Dimension(9, 1));
        jScrollBarObservacoes.setUI(new ProjectScrollBarUI(jScrollPaneObservacoes));

        jTextAreaObservacoes.setColumns(1);
        jTextAreaObservacoes.setRows(2);
        jTextAreaObservacoes.setBorder(BorderFactory.createEmptyBorder());
        jTextAreaObservacoes.setLineWrap(true);
        jTextAreaObservacoes.setWrapStyleWord(true);
        jTextAreaObservacoes.setText(json.getString("obsDeficiencias"));
        jTextAreaObservacoes.getDocument().addDocumentListener(new DocumentListener() {
                  @Override
                  public void changedUpdate(DocumentEvent evt) {
                      ChangeJSON();
                  }

                  @Override
                  public void removeUpdate(DocumentEvent evt) {
                      ChangeJSON();
                  }

                  @Override
                  public void insertUpdate(DocumentEvent evt) {
                      ChangeJSON();
                  }

                  public void ChangeJSON() {
                      json.put("obsDeficiencias", jTextAreaObservacoes.getText());

                      try {
                          WriteJSON();
                      } catch (IOException ex) {
                          Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              });

        // *Observações***************************************************************************************************
        //=======================================================================================================

        // Botões principais ====================================================================================
        jLabelQuestion.setBackground(new Color(255, 255, 255));
        jLabelQuestion.setForeground(new Color(62, 62, 62));
        jLabelQuestion.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelQuestion.setText("Possui alguma deficiência?");

        jRadioButtonSim.setBackground(new Color(255, 255, 255));
        jRadioButtonSim.setForeground(new Color(62, 62, 62));
        jRadioButtonSim.setFont(new Font("DejaVu Sans", 1, 14));
        jRadioButtonSim.setFocusPainted(false);
        jRadioButtonSim.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            jScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(215, 215, 215), 1));

            GroupLayout jPanel3LayoutSIM = new GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3LayoutSIM);
            jPanel3LayoutSIM.setHorizontalGroup(
              jPanel3LayoutSIM.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jCheckBoxAuditiva, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createParallelGroup()
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jLabelAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jComboBoxAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jLabelAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jComboBoxAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jCheckBoxAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jCheckBoxAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                            .addGap(20)
                            .addComponent(jCheckBoxAud3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        )
                    )
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jCheckBoxFala, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                    .addComponent(jLabelFala1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                    .addComponent(jComboBoxFala1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    )
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jCheckBoxFisica, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabelFis1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jComboBoxFisica1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    )
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jCheckBoxIntelectualMental, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabelIntMent1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent6, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent7, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jCheckBoxIntMent8, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    )
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jCheckBoxVisual, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabelVisual1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabelVisual2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jComboBoxVisual1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jComboBoxVisual2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3LayoutSIM.createParallelGroup()
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                        .addGap(5)
                        .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                    )
                )
            );
            jPanel3LayoutSIM.setVerticalGroup(
              jPanel3LayoutSIM.createSequentialGroup()
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(5)
                    .addComponent(jCheckBoxAuditiva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAud1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(2)
                        .addComponent(jComboBoxAud1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(2)
                        .addComponent(jLabelAud2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(2)
                        .addComponent(jComboBoxAud2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(5)
                        .addComponent(jCheckBoxAud1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(2)
                        .addComponent(jCheckBoxAud2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(2)
                        .addComponent(jCheckBoxAud3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    )
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jCheckBoxFala, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFala1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jComboBoxFala1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    )
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jCheckBoxFisica, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFis1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jComboBoxFisica1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    )
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jCheckBoxIntelectualMental, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIntMent1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(jCheckBoxIntMent1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jCheckBoxIntMent8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    )
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jCheckBoxVisual, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVisual1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(3)
                    .addComponent(jComboBoxVisual1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jLabelVisual2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(3)
                    .addComponent(jComboBoxVisual2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    )
                .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                )
            );

            jPanel3.revalidate();
            jScrollPane.revalidate();
            json.put("deficiencia?", "sim");

            try{
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
        if (json.getString("deficiencia?").equals("sim")) {
          jRadioButtonSim.setSelected(true);
          // jScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

          GroupLayout jPanel3LayoutSIM = new GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3LayoutSIM);
          jPanel3LayoutSIM.setHorizontalGroup(
            jPanel3LayoutSIM.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jCheckBoxAuditiva, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createParallelGroup()
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jLabelAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jComboBoxAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jLabelAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jComboBoxAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jCheckBoxAud1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jCheckBoxAud2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                          .addGap(20)
                          .addComponent(jCheckBoxAud3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                      )
                  )
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jCheckBoxFala, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                  .addComponent(jLabelFala1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                  .addComponent(jComboBoxFala1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  )
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jCheckBoxFisica, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jLabelFis1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jComboBoxFisica1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  )
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jCheckBoxIntelectualMental, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jLabelIntMent1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent6, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent7, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jCheckBoxIntMent8, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  )
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jCheckBoxVisual, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jLabelVisual1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jLabelVisual2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jComboBoxVisual1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(20)
                      .addComponent(jComboBoxVisual2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel3LayoutSIM.createParallelGroup()
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                      .addGap(5)
                      .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                  )
              )
          );
          jPanel3LayoutSIM.setVerticalGroup(
            jPanel3LayoutSIM.createSequentialGroup()
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(5)
                  .addComponent(jCheckBoxAuditiva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabelAud1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                      .addGap(2)
                      .addComponent(jComboBoxAud1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                      .addGap(2)
                      .addComponent(jLabelAud2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                      .addGap(2)
                      .addComponent(jComboBoxAud2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                      .addGap(5)
                      .addComponent(jCheckBoxAud1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                      .addGap(2)
                      .addComponent(jCheckBoxAud2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                      .addGap(2)
                      .addComponent(jCheckBoxAud3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  )
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(10)
                  .addComponent(jCheckBoxFala, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabelFala1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jComboBoxFala1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  )
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(10)
                  .addComponent(jCheckBoxFisica, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabelFis1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jComboBoxFisica1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  )
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(10)
                  .addComponent(jCheckBoxIntelectualMental, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabelIntMent1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(5)
                  .addComponent(jCheckBoxIntMent1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jCheckBoxIntMent8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  )
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(10)
                  .addComponent(jCheckBoxVisual, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabelVisual1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jComboBoxVisual1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jLabelVisual2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jComboBoxVisual2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  )
              .addGroup(jPanel3LayoutSIM.createSequentialGroup()
                  .addGap(10)
                  .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(2)
                  .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                  .addGap(5)
              )
          );

          jPanel3.revalidate();
          jScrollPane.revalidate();
        }


        jRadioButtonNao.setBackground(new Color(255, 255, 255));
        jRadioButtonNao.setForeground(new Color(62, 62, 62));
        jRadioButtonNao.setFont(new Font("DejaVu Sans", 1, 14));
        jRadioButtonNao.setFocusPainted(false);
        if (json.getString("deficiencia?").equals("não"))
          jRadioButtonNao.setSelected(true);
        jRadioButtonNao.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            jPanel3.remove(jCheckBoxAuditiva);
            jPanel3.remove(jLabelAud1);
            jPanel3.remove(jComboBoxAud1);
            jPanel3.remove(jLabelAud2);
            jPanel3.remove(jComboBoxAud2);
            jPanel3.remove(jCheckBoxAud1);
            jPanel3.remove(jCheckBoxAud2);
            jPanel3.remove(jCheckBoxAud3);
            jPanel3.remove(jCheckBoxFala);
            jPanel3.remove(jLabelFala1);
            jPanel3.remove(jComboBoxFala1);
            jPanel3.remove(jCheckBoxFisica);
            jPanel3.remove(jLabelFis1);
            jPanel3.remove(jComboBoxFisica1);
            jPanel3.remove(jCheckBoxIntelectualMental);
            jPanel3.remove(jLabelIntMent1);
            jPanel3.remove(jCheckBoxIntMent1);
            jPanel3.remove(jCheckBoxIntMent2);
            jPanel3.remove(jCheckBoxIntMent3);
            jPanel3.remove(jCheckBoxIntMent4);
            jPanel3.remove(jCheckBoxIntMent5);
            jPanel3.remove(jCheckBoxIntMent6);
            jPanel3.remove(jCheckBoxIntMent7);
            jPanel3.remove(jCheckBoxIntMent8);
            jPanel3.remove(jCheckBoxVisual);
            jPanel3.remove(jLabelVisual1);
            jPanel3.remove(jComboBoxVisual1);
            jPanel3.remove(jLabelVisual2);
            jPanel3.remove(jComboBoxVisual2);
            jPanel3.remove(jLabelObservacoes);
            jPanel3.remove(jScrollPaneObservacoes);

            jScrollPane.setBorder(BorderFactory.createEmptyBorder());

            jPanel3.revalidate();
            jScrollPane.revalidate();
            json.put("deficiencia?", "nao");

            try{
              WriteJSON();
            } catch (IOException ex) {
              Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });

        buttonGroup.add(jRadioButtonSim);
        buttonGroup.add(jRadioButtonNao);
        // ================================================================================================================


        // Next and Previous Buttons conf. ======================================================================
        jButtonNext.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonNext.setBackground(new Color(62, 62, 62));
        jButtonNext.setForeground(new Color(255, 255, 255));
        jButtonNext.setText("Próximo");
        jButtonNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNext.setFocusPainted(false);
        jButtonNext.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              try {
                  jButtonNextActionPerformed(evt);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonNext.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonNextMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonNextMouseExited(evt);
          }
        });

        jButtonPrevious.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonPrevious.setBackground(new Color(62, 62, 62));
        jButtonPrevious.setForeground(new Color(255, 255, 255));
        jButtonPrevious.setText("Voltar");
        jButtonPrevious.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonPrevious.setFocusPainted(false);
        jButtonPrevious.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              try {
                  jButtonPreviousActionPerformed(evt);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonPreviousMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonPreviousMouseExited(evt);
          }
        });
        // end Next and Previous ================================================================================

        // Layouts dos jPanel's

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\CONTRETEC\\CurriculumSoftware\\LogoEmpresa.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        //jPanel1
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup()
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30)
                    .addComponent(jLabelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup()
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(50)
                 .addComponent(jRadioButtonSim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(10)
                 .addComponent(jRadioButtonNao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(456)
                 .addGap(30)
                 .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(45)
                 .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        ));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10)
                    .addComponent(jLabelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createParallelGroup()
                  .addComponent(jRadioButtonSim, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jRadioButtonNao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(10)
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(15)
               .addGroup(jPanel1Layout.createParallelGroup()
                  .addComponent(jButtonPrevious, 60, 60, 60)
                  .addComponent(jButtonNext, 60, 60, 60))
        ));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    // Arrastar tela (jLabel2)
    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }

    // Sair
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").waitFor();
        } catch (IOException ex) {
            Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.exit(0);
    }

    private void jButtonExitMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonExit.setBackground(new java.awt.Color(240, 240, 240));
      jButtonExit.setForeground(new java.awt.Color(62, 62, 62));
    }

    private void jButtonExitMouseExited(java.awt.event.MouseEvent evt) {
      jButtonExit.setBackground(new java.awt.Color(62, 62, 62));
      jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
    }

    // Minimizar
    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {
      this.setExtendedState(ICONIFIED);
    }

    private void jButtonMinimizeMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonMinimize.setBackground(new java.awt.Color(240, 240, 240));
      jButtonMinimize.setForeground(new java.awt.Color(62, 62, 62));
    }

    private void jButtonMinimizeMouseExited(java.awt.event.MouseEvent evt) {
      jButtonMinimize.setBackground(new java.awt.Color(62, 62, 62));
      jButtonMinimize.setForeground(new java.awt.Color(255, 255, 255));
    }

    // Next Button
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        WriteJSON();

        new JanelaEntradas5().setVisible(true);
        this.dispose();
    }

    private void jButtonNextMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonNext.setBackground(new java.awt.Color(240, 240, 240));
      jButtonNext.setForeground(new java.awt.Color(62, 62, 62));
    }

    private void jButtonNextMouseExited(java.awt.event.MouseEvent evt) {
      jButtonNext.setBackground(new java.awt.Color(62, 62, 62));
      jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
    }

    // Previous button
    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, IOException {
      WriteJSON();

      new JanelaEntradas3().setVisible(true);
      this.dispose();
    }

    private void jButtonPreviousMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonPrevious.setBackground(new java.awt.Color(240, 240, 240));
      jButtonPrevious.setForeground(new java.awt.Color(62, 62, 62));
    }

    private void jButtonPreviousMouseExited(java.awt.event.MouseEvent evt) {
      jButtonPrevious.setBackground(new java.awt.Color(62, 62, 62));
      jButtonPrevious.setForeground(new java.awt.Color(255, 255, 255));
    }

    // jButtonAddTelefone functions =================================
    private void jButtonAddTelefoneActionPerformed(ActionEvent evt) {
        try {
            new JanelajButtonAdicionarTelefone().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void WriteJSON() throws IOException {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json"))) {
        writer.write(json.toString());
        writer.close();
      } catch (IOException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaEntradas4().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaEntradas4.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JSeparator jSeparator;

    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JRadioButton jRadioButtonSim;
    private javax.swing.JRadioButton jRadioButtonNao;
    private javax.swing.ButtonGroup buttonGroup;

    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar;
    private javax.swing.JScrollPane jScrollPane;

    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMinimize;

    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    // End of variables declaration

    private static class ProjectScrollBarUI extends BasicScrollBarUI {
        private JScrollPane jScrollPane;

        private ProjectScrollBarUI(JScrollPane jScrollPane) {
            this.jScrollPane = jScrollPane;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new InvisibleScrollBarButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new InvisibleScrollBarButton();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Nothing
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
            int orientation = scrollbar.getOrientation();
            int x = thumbBounds.x;
            int y = thumbBounds.y;

            int width = thumbBounds.width;
            int height = thumbBounds.height;

            Graphics2D graphics2D = (Graphics2D) g.create();
            graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
            graphics2D.fillRect(x, y, width, height);
            graphics2D.dispose();
        }

        @Override
        protected void setThumbBounds(int x, int y, int width, int height) {
            super.setThumbBounds(x, y, width, height);
            jScrollPane.repaint();
        }

        private static class InvisibleScrollBarButton extends JButton {
            private static final long serialVersionUID = 1552427919226628689L;

            private InvisibleScrollBarButton() {
                setOpaque(false);
                setFocusable(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setBorder(BorderFactory.createEmptyBorder());
            }
        }
    }
}

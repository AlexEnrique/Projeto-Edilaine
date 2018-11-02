package projetoedilaine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @author Alex Enrique Crispim
 */
public class JanelaConfirmarAlterarDados2 extends javax.swing.JFrame {

    private int x, y;
    private Timer fadeInJL3;
    private JSONObject json;

    private static final long serialVersionUID = 8607734981506765935L;
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final int SB_SIZE = 10;
    private static final Color THUMB_COLOR = Color.BLACK;

    private int imgX, imgY;

    public JanelaConfirmarAlterarDados2() throws FileNotFoundException {
      this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("tmp\\tmp.json")
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

        // Botoes de minimizar e maximizar
        jButtonExit = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();


        //
        jLabelTitulo = new JLabel("Confirme seus dados para gerar o currículo");

        jLabelDeficienciaP = new LabelH1("Portador de deficiência:");
        jLabelDeficienciaSN = new LabelH2(); // Sim ou não
        jButtonDeficienciaR = new MyButton("Editar dados sobre deficiências");

        jLabelAuditivaP = new LabelH1("Portador de deficiência auditiva:");
        jLabelAuditivaSN = new LabelH2();
        jLabelAuditivaNivelP = new LabelH1("Nível:");
        jLabelAuditivaNivelSN = new LabelH2();
        jLabelAuditivaTipoP = new LabelH1("Tipo:");
        jLabelAuditivaTipoSN = new LabelH2();
        jLabelAuditivaOralizadoP = new LabelH1("Oralizado:");
        jLabelAuditivaOralizadoSN = new LabelH2();
        jLabelAuditivaLibrasP = new LabelH1("Usuário de Libras:");
        jLabelAuditivaLibrasSN = new LabelH2();
        jLabelAuditivaInterpreteP = new LabelH1("Necessita de intérprete");
        jLabelAuditivaInterpreteSN = new LabelH2();

        jLabelFalaP = new LabelH1("Portador de deficiência na fala:");
        jLabelFalaSN = new LabelH2();
        jLabelFalaTipoP = new LabelH1("Tipo:");
        jLabelFalaTipoPSN = new LabelH2();

        jLabelFisicaP = new LabelH1("Portador de deficiência física:");
        jLabelFisicaSN = new LabelH2();
        jLabelFisicaTipoP = new LabelH1("Tipo:");
        jLabelFisicaTipoSN = new LabelH2();

        jLabelIntMentP = new LabelH1("Portador de deficiência intelectual/mental:");
        jLabelIntMentSN = new LabelH2();
        jLabelIntMentLimitacoesP = new LabelH1("Limitações:");
        jLabelIntMentLimitacoesSN = new LabelH2();
        jLabelIntMentComunicacaoP = new LabelH1("Comunicação:");
        jLabelIntMentComunicacaoSN = new LabelH2();
        jLabelIntMentCuidadosPessoaisP = new LabelH1("Cuidados Pessoais:");
        jLabelIntMentCuidadosPessoaisSN = new LabelH2();
        jLabelIntMentHabilidadesSociaisP = new LabelH1("Habilidades Sociais:");
        jLabelIntMentHabilidadesSociaisSN = new LabelH2();
        jLabelIntMentRecursosComunidadeP = new LabelH1("Utilização de recursos da cuminidade:");
        jLabelIntMentRecursosComunidadeSN = new LabelH2();
        jLabelIntMentSaudeSegurancaP = new LabelH1("Saúde e Segurança:");
        jLabelIntMentSaudeSegurancaSN = new LabelH2();
        jLabelIntMentHabilidadesAcademicasP = new LabelH1("Habilidades acadêmicas:");
        jLabelIntMentHabilidadesAcademicasSN = new LabelH2();
        jLabelIntMentLazerP = new LabelH1("Lazer:");
        jLabelIntMentLazerSN = new LabelH2();
        jLabelIntMentTrabalhoP = new LabelH1("Trabalho:");
        jLabelIntMentTrabalhoSN = new LabelH2();

        jLabelVisualP = new LabelH1("Portador de deficiência visual:");
        jLabelVisualSN = new LabelH2();
        jLabelVisualTipoP = new LabelH1("Tipo:");
        jLabelVisualTipoSN = new LabelH2();
        jLabelVisualDetalhamentoP = new LabelH1("Detalhamento:");
        jLabelVisualDetalhamentoSN = new LabelH2();

        jLabelObservacoes = new LabelH1("Observações:");
        jTextAreaObservacoes = new JTextArea();
        jScrollPaneObservacoes = new JScrollPane(jTextAreaObservacoes);
        jScrollBarObservacoes = jScrollPaneObservacoes.getVerticalScrollBar();
        jScrollBarObservacoes.setPreferredSize(new Dimension(1, 7));
        jScrollBarObservacoes.setUI(new ProjectScrollBarUI(jScrollPaneObservacoes));
        jButtonObservacoes = new MyButton("Alterar/Salvar observações");

        jPanelMain = new JPanel();
        jScrollPaneMain = new JScrollPane(jPanelMain);
        jScrollBarMain = jScrollPaneMain.getVerticalScrollBar();
        jScrollBarMain.setPreferredSize(new Dimension(7, 1));
        jScrollBarMain.setUI(new ProjectScrollBarUI(jScrollPaneMain));

        // Separador
        // jSeparator = new javax.swing.JSeparator(SwingConstants.VERTICAL);

        // Next and previous buttons
        jButtonNext = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();

        // ---------------------------------------------------------------------
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
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExitMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExitMouseExited(evt);
            }
        });


        jButtonMinimize.setBackground(new java.awt.Color(62, 62, 62));
        jButtonMinimize.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jButtonMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMinimize.setText("-");
        jButtonMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonMinimize.setFocusPainted(false);
        jButtonMinimize.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizeActionPerformed(evt);
            }
        });
        jButtonMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMinimizeMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMinimizeMouseExited(evt);
            }
        });

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        // Botões principais ====================================================================================
        jLabelTitulo.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelTitulo.setBackground(new Color(255, 255, 255));
        jLabelTitulo.setForeground(new Color(62, 62, 62));

        jLabelDeficienciaSN.setText(json.getString("deficiencia?").equals("sim") ? "Sim" : "Não");

        jLabelAuditivaSN.setText(json.getString("defAuditiva?").equals("") ? "Não" : "Sim");
        jLabelAuditivaNivelSN.setText(json.getString("defAuditivaNivel"));
        jLabelAuditivaTipoSN.setText(json.getString("defAuditivaTipo"));
        jLabelAuditivaOralizadoSN.setText(json.getString("defAuditivaOralizado?").equals("") ? "Não" : "Sim");
        jLabelAuditivaLibrasSN.setText(json.getString("defAuditivaLibras?").equals("") ? "Não" : "Sim");
        jLabelAuditivaInterpreteSN.setText(json.getString("defAuditivaInterprete?").equals("") ? "Não" : "Sim");

        jLabelFalaSN.setText(json.getString("defFala?").equals("") ? "Não" : "Sim");
        jLabelFalaTipoPSN.setText(json.getString("defFalaTipo"));

        jLabelFisicaSN.setText(json.getString("defFisica?").equals("") ? "Não" : "Sim");
        jLabelFisicaTipoSN.setText(json.getString("defFisicaTipo"));

        jLabelIntMentSN.setText(json.getString("defIntelectualMental?").equals("") ? "Não" : "Sim");
        jLabelIntMentComunicacaoSN.setText(json.getString("defIntelectualMentalItem1").equals("sim") ? "Sim" : "Não");
        jLabelIntMentCuidadosPessoaisSN.setText(json.getString("defIntelectualMentalItem2").equals("sim") ? "Sim" : "Não");
        jLabelIntMentHabilidadesSociaisSN.setText(json.getString("defIntelectualMentalItem3").equals("sim") ? "Sim" : "Não");
        jLabelIntMentRecursosComunidadeSN.setText(json.getString("defIntelectualMentalItem4").equals("sim") ? "Sim" : "Não");
        jLabelIntMentSaudeSegurancaSN.setText(json.getString("defIntelectualMentalItem5").equals("sim") ? "Sim" : "Não");
        jLabelIntMentHabilidadesAcademicasSN.setText(json.getString("defIntelectualMentalItem6").equals("sim") ? "Sim" : "Não");
        jLabelIntMentLazerSN.setText(json.getString("defIntelectualMentalItem7").equals("sim") ? "Sim" : "Não");
        jLabelIntMentTrabalhoSN.setText(json.getString("defIntelectualMentalItem8").equals("sim") ? "Sim" : "Não");

        jLabelVisualSN.setText(json.getString("defVisual?").equals("") ? "Não" : "Sim");
        jLabelVisualTipoSN.setText(json.getString("defVisualTipo"));
        if (json.getString("defVisualDetalhamento").length() > 0)
          jLabelVisualDetalhamentoSN.setText(json.getString("defVisualDetalhamento").substring(0,1).toUpperCase().concat(json.getString("defVisualDetalhamento").substring(1)));

        jTextAreaObservacoes.setText(json.getString("obsDeficiencias"));

        jTextAreaObservacoes.setEditable(false);
        jTextAreaObservacoes.setBackground(new Color(238, 238, 238));

        jScrollPaneObservacoes.setBorder(BorderFactory.createLineBorder(new Color(184, 207, 229), 1));


        // -------BOTÕES ------------------------------------------------------------------------------
        jButtonDeficienciaR.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            jButtonDeficienciaRActionPerformed();
          }
        });

        jButtonObservacoes.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {

            if (jTextAreaObservacoes.isEditable()) {
              jTextAreaObservacoes.setEditable(false);
              jTextAreaObservacoes.setBackground(new Color(238, 238, 238));
              jScrollPaneObservacoes.setBorder(BorderFactory.createLineBorder(new Color(184, 207, 229), 1));

              json.put("obsDeficiencias", jTextAreaObservacoes.getText());

              try {
                WriteJSON();
              } catch (FileNotFoundException e) {
              } catch (IOException e) {
              }

            } else {
              jTextAreaObservacoes.setEditable(true);
              jTextAreaObservacoes.setBackground(new Color(255, 255, 255));
              jScrollPaneObservacoes.setBorder(BorderFactory.createLineBorder(new Color(122, 138, 153), 1));
            }

          }
        });


        //-----------------------------------------------------------------------------------------------
        // .setFont(new Font("DejaVu Sans", 0, 18));
        // .setBackground(new Color(255, 255, 255));
        // .setForeground(new Color(62, 62, 62));
        // .setText("");


        //=======================================================================================================
        // jPanelMain config. ---
        jScrollPaneMain.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));

        jPanelMain.setBackground(new Color(255, 255, 255));

        GroupLayout jPanelMainLayout = new GroupLayout(jPanelMain);
        GroupLayout.Group hGroup = jPanelMainLayout.createParallelGroup();
        GroupLayout.Group vGroup = jPanelMainLayout.createSequentialGroup();

        jPanelMainLayout.setHorizontalGroup(hGroup);
        jPanelMainLayout.setVerticalGroup(vGroup);
        jPanelMain.setLayout(jPanelMainLayout);

        // Título
        hGroup.addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE);
        vGroup.addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);

        // Campo de Deficiencia
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelDeficienciaP, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
          .addGap(3)
          .addComponent(jLabelDeficienciaSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
          .addGap(15)
          .addComponent(jButtonDeficienciaR, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelDeficienciaP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelDeficienciaSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonDeficienciaR, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

          if (jLabelDeficienciaSN.getText().equals("Sim")) {

            vGroup.addGap(15);
            // Auditiva
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelAuditivaP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
            .addGap(3)
            .addComponent(jLabelAuditivaSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelAuditivaP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelAuditivaSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            if (jLabelAuditivaSN.getText().equals("Sim")) {
                // Auditiva - Nível
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelAuditivaNivelP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelAuditivaNivelSN, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelAuditivaNivelP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAuditivaNivelSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Auditiva - Tipo
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelAuditivaTipoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelAuditivaTipoSN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelAuditivaTipoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAuditivaTipoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Auditiva - Oralizado
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelAuditivaOralizadoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelAuditivaOralizadoSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelAuditivaOralizadoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAuditivaOralizadoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Auditiva - Libras
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelAuditivaLibrasP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelAuditivaLibrasSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelAuditivaLibrasP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAuditivaLibrasSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Auditiva - Intérprete
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelAuditivaInterpreteP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelAuditivaInterpreteSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelAuditivaInterpreteP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAuditivaInterpreteSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );
            }

            vGroup.addGap(15);
            // Fala
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelFalaP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
            .addGap(3)
            .addComponent(jLabelFalaSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelFalaP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelFalaSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            if (jLabelFalaSN.getText().equals("Sim")) {
                // Fala - Tipo
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelFalaTipoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelFalaTipoPSN, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelFalaTipoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelFalaTipoPSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );
            }

            vGroup.addGap(15);
            // Fisica
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelFisicaP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
            .addGap(3)
            .addComponent(jLabelFisicaSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelFisicaP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelFisicaSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            if (jLabelFisicaSN.getText().equals("Sim")) {
                // Fisica - Tipo
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelFisicaTipoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelFisicaTipoSN, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelFisicaTipoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelFisicaTipoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );
            }

            vGroup.addGap(15);
            // Mental/Intelectual
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelIntMentP, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
            .addGap(3)
            .addComponent(jLabelIntMentSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelIntMentP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelIntMentSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            if (jLabelIntMentSN.getText().equals("Sim")) {
                // Mental/Intelectual - Limitações
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelIntMentLimitacoesP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentLimitacoesP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Comunicação
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentComunicacaoP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentComunicacaoSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentComunicacaoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentComunicacaoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Cuidados Pessoais
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentCuidadosPessoaisP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentCuidadosPessoaisSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentCuidadosPessoaisP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentCuidadosPessoaisSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Habilidades Sociais
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentHabilidadesSociaisP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentHabilidadesSociaisSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentHabilidadesSociaisP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentHabilidadesSociaisSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Recursos da comunidade
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentRecursosComunidadeP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentRecursosComunidadeSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentRecursosComunidadeP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentRecursosComunidadeSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Segurança
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentSaudeSegurancaP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentSaudeSegurancaSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentSaudeSegurancaP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentSaudeSegurancaSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Habilidades acadêmicas
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentHabilidadesAcademicasP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentHabilidadesAcademicasSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentHabilidadesAcademicasP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentHabilidadesAcademicasSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Lazer
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentLazerP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentLazerSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentLazerP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentLazerSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Mental/Intelectual - Trabalho
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addGap(10)
                .addComponent(jLabelIntMentTrabalhoP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelIntMentTrabalhoSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelIntMentTrabalhoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelIntMentTrabalhoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );
            }


            vGroup.addGap(15);
            // Visual
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelVisualP, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
            .addGap(3)
            .addComponent(jLabelVisualSN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelVisualP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelVisualSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            if (jLabelVisualSN.getText().equals("Sim")) {
                // Visual - Tipo
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelVisualTipoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelVisualTipoSN, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelVisualTipoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelVisualTipoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );

                // Visual - Detalhamento
                hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(20)
                .addGap(10)
                .addComponent(jLabelVisualDetalhamentoP, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(jLabelVisualDetalhamentoSN, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                );
                vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addComponent(jLabelVisualDetalhamentoP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelVisualDetalhamentoSN, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                );
            }


            vGroup.addGap(15);
            // Observações
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(jButtonObservacoes, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jLabelObservacoes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            .addComponent(jButtonObservacoes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            );

            // textArea
            hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(20)
            .addGap(10)
            .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
            );
            vGroup.addGap(5);
            vGroup.addGroup(jPanelMainLayout.createParallelGroup()
            .addComponent(jScrollPaneObservacoes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            );

        }



        // ======================================================================================================



        // Next and Previous Buttons conf. ======================================================================
        jButtonNext.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonNext.setBackground(new Color(62, 62, 62));
        jButtonNext.setForeground(new Color(255, 255, 255));
        jButtonNext.setText("Próximo");
        jButtonNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNext.setFocusPainted(false);
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  jButtonNextActionPerformed(evt);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonNext.addMouseListener(new java.awt.event.MouseAdapter() {
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
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  jButtonPreviousActionPerformed(evt);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
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


        jLabel1.setIcon(new javax.swing.ImageIcon("LogoEmpresa.png")); // NOI18N

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
                  .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 900-60, javax.swing.GroupLayout.PREFERRED_SIZE)
              )
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(45, 45, 45)
                  .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jScrollPaneMain, GroupLayout.PREFERRED_SIZE, 550-100-15-30-60, GroupLayout.PREFERRED_SIZE)
                 )
                .addGap(15)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonPrevious, 60, 60, 60)
                    .addComponent(jButtonNext, 60, 60, 60)))
        );

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

    private void jButtonDeficienciaRActionPerformed() {
      try {
        WriteJSON();
      } catch (FileNotFoundException e) {
      } catch (IOException e) {
      }

        try {
            new JanelaAlterarDeficiencias().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
        }
      this.dispose();
    }


    // Sair
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del tmp\\tmp.json").waitFor();
        } catch (IOException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButtonEstiloRActionPerformed(ActionEvent evt) {
      try {
          // Throw (isEverythingOK?)
          WriteJSON();
      } catch (IOException ex) {
          Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
      }

        try {
            new JanelaTrocarTemplate().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
        }

      this.dispose();
    }

    // Next Button
    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        WriteJSON();

        new JanelaConfirmarAlterarDados3().setVisible(true);
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

      new JanelaConfirmarAlterarDados1().setVisible(true);
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

    private void WriteJSON() throws IOException {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("tmp\\tmp.json"))) {
        writer.write(json.toString());
        writer.close();
      } catch (IOException ex) {
          Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    private Image templateImg() {
      BufferedImage img = null;

      switch (json.getInt("template")) {
        case 1: {
          try {
              img = ImageIO.read(new File("AdjustedTemplates\\template1.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
                break;

        case 2: {
          try {
              img = ImageIO.read(new File("AdjustedTemplates\\template2.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
                break;

        case 3: {
          try {
              img = ImageIO.read(new File("AdjustedTemplates\\template3.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
                break;
      }

      Image dimg = img.getScaledInstance(220, 260, Image.SCALE_SMOOTH);

      return dimg;
    }

    private Image fotoImg() {
      BufferedImage img = null;
      Image dimg;

        try {
            img = ImageIO.read(new File(json.getString("caminhoFoto")));
        } catch (IOException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
        }

      dimg = img.getScaledInstance(imgX, imgY, Image.SCALE_SMOOTH);

      return dimg;
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
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaConfirmarAlterarDados2().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaConfirmarAlterarDados2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMinimize;

    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;

    private JLabel jLabelTitulo;

    private LabelH1 jLabelDeficienciaP;
    private LabelH2 jLabelDeficienciaSN; // Sim ou não
    private MyButton jButtonDeficienciaR;

    private LabelH1 jLabelAuditivaP;
    private LabelH2 jLabelAuditivaSN;
    private LabelH1 jLabelAuditivaNivelP;
    private LabelH2 jLabelAuditivaNivelSN;
    private LabelH1 jLabelAuditivaTipoP;
    private LabelH2 jLabelAuditivaTipoSN;
    private LabelH1 jLabelAuditivaOralizadoP;
    private LabelH2 jLabelAuditivaOralizadoSN;
    private LabelH1 jLabelAuditivaLibrasP;
    private LabelH2 jLabelAuditivaLibrasSN;
    private LabelH1 jLabelAuditivaInterpreteP;
    private LabelH2 jLabelAuditivaInterpreteSN;

    private LabelH1 jLabelFalaP;
    private LabelH2 jLabelFalaSN;
    private LabelH1 jLabelFalaTipoP;
    private LabelH2 jLabelFalaTipoPSN;

    private LabelH1 jLabelFisicaP;
    private LabelH2 jLabelFisicaSN;
    private LabelH1 jLabelFisicaTipoP;
    private LabelH2 jLabelFisicaTipoSN;

    private LabelH1 jLabelIntMentP;
    private LabelH2 jLabelIntMentSN;
    private LabelH1 jLabelIntMentLimitacoesP;
    private LabelH2 jLabelIntMentLimitacoesSN;
    private LabelH1 jLabelIntMentComunicacaoP;
    private LabelH2 jLabelIntMentComunicacaoSN;
    private LabelH1 jLabelIntMentCuidadosPessoaisP;
    private LabelH2 jLabelIntMentCuidadosPessoaisSN;
    private LabelH1 jLabelIntMentHabilidadesSociaisP;
    private LabelH2 jLabelIntMentHabilidadesSociaisSN;
    private LabelH1 jLabelIntMentRecursosComunidadeP;
    private LabelH2 jLabelIntMentRecursosComunidadeSN;
    private LabelH1 jLabelIntMentSaudeSegurancaP;
    private LabelH2 jLabelIntMentSaudeSegurancaSN;
    private LabelH1 jLabelIntMentHabilidadesAcademicasP;
    private LabelH2 jLabelIntMentHabilidadesAcademicasSN;
    private LabelH1 jLabelIntMentLazerP;
    private LabelH2 jLabelIntMentLazerSN;
    private LabelH1 jLabelIntMentTrabalhoP;
    private LabelH2 jLabelIntMentTrabalhoSN;

    private LabelH1 jLabelVisualP;
    private LabelH2 jLabelVisualSN;
    private LabelH1 jLabelVisualTipoP;
    private LabelH2 jLabelVisualTipoSN;
    private LabelH1 jLabelVisualDetalhamentoP;
    private LabelH2 jLabelVisualDetalhamentoSN;

    private LabelH1 jLabelObservacoes;
    private JTextArea jTextAreaObservacoes;
    private JScrollPane jScrollPaneObservacoes;
    private JScrollBar jScrollBarObservacoes;
    private MyButton jButtonObservacoes;

    private JPanel jPanelMain;
    private JScrollPane jScrollPaneMain;
    private JScrollBar jScrollBarMain;


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

    private static class LabelH1 extends JLabel {
      private LabelH1() {
        this.setBackground(new Color(255, 255, 255));
        this.setForeground(new Color(62, 62, 62));
        this.setFont(new Font("DejaVu Sans", 0, 16));
      }

      private LabelH1(String text) {
        this.setBackground(new Color(255, 255, 255));
        this.setForeground(new Color(62, 62, 62));
        this.setFont(new Font("DejaVu Sans", 0, 16));
        this.setText(text);
      }
      // end LabelH1 class
    }

    private static class LabelH2 extends JLabel {
      private LabelH2() {
        this.setBackground(new Color(255, 255, 255));
        this.setForeground(new Color(62, 62, 62));
        this.setFont(new Font("DejaVu Sans", 1, 14));
      }

      private LabelH2(String text) {
        this.setBackground(new Color(255, 255, 255));
        this.setForeground(new Color(62, 62, 62));
        this.setFont(new Font("DejaVu Sans", 1, 14));
        this.setText(text);
      }
      // end LabelH2 class
    }

    private static class MyButton extends JButton {
      MyButton myButton = this;

      private MyButton() {
        standardConfig();
      }

      private MyButton(String text) {
        standardConfig();
        myButton.setText(text);
      }

      private void standardConfig() {
        myButton.setBackground(new Color(62, 62, 62));
        myButton.setForeground(new Color(255, 255, 255));
        myButton.setFont(new Font("DejaVu Sans", 1, 11));
        myButton.setFocusable(false);
        myButton.setFocusPainted(false);
        myButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        myButton.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent evt) {
            myButton.setBackground(new Color(240, 240, 240));
            myButton.setForeground(new Color(62, 62, 62));
          }

          @Override
          public void mouseExited(MouseEvent evt) {
            myButton.setBackground(new Color(62, 62, 62));
            myButton.setForeground(new Color(255, 255, 255));
          }
        });

      }
      // End MyButton class
    }

}

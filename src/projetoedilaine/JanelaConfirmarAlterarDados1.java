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
public class JanelaConfirmarAlterarDados1 extends javax.swing.JFrame {

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

    public JanelaConfirmarAlterarDados1() throws FileNotFoundException {
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

        // Botoes de minimizar e maximizar
        jButtonExit = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();


        //
        jLabelTitulo = new JLabel("Confirme seus dados para gerar o currículo");

        jLabelNome = new JLabel("Nome:");
        jTextFieldNome = new JTextField();

        jLabelProfissao = new JLabel("Profissão:");
        jTextFieldProfissao = new JTextField();

        jLabelEstilo = new JLabel("Estilo do currículo:");
        jLabelEstiloImagem = new JLabel();

        jLabelEmail = new JLabel("E-mail:"); // Transformar em um array ao final
        jTextFieldEmail = new JTextField();

        jLabelDDD = new JLabel("DDD:");
        jTextFieldDDD = new JTextField();
        jLabelTelefone = new JLabel("Telefone:");
        jTextFieldTelefone = new JTextField();

        jLabelCidade = new JLabel("Cidade:");
        jTextFieldCidade = new JTextField();

        jLabelEstado = new JLabel("Estado:");
        jTextFieldEstado = new JTextField();

        jLabelWebsite = new JLabel("Website:");
        jTextFieldWebsite = new JTextField();

        jLabelLinkedin = new JLabel("LinkedIn:");
        jTextFieldLinkedin = new JTextField();

        jLabelFoto = new JLabel("Foto:");
        jLabelFotoUsar = new JLabel( (json.getInt("usarFoto?") == 0) ? "Não" : "Sim" );
        jLabelFotoImagem = new JLabel();

        jLabelObsEndereco = new JLabel("Observações sobre endereço:");
        jTextAreaObsEndereco = new JTextArea();
        jScrollPaneObsEndereco = new JScrollPane(jTextAreaObsEndereco);
        jScrollBarObsEndereco = new JScrollBar();

        jLabelObsVirtuais = new JLabel("Observações sobre endereços virtuais:");
        jTextAreaObsVirtuais = new JTextArea();
        jScrollPaneObsVirtuais = new JScrollPane(jTextAreaObsVirtuais);
        jScrollBarObsVirtuais = new JScrollBar();


        jPanelMain = new JPanel();
        jScrollPaneMain = new JScrollPane(jPanelMain);
        jScrollBarMain = new JScrollBar();

        // Separador
        // jSeparator = new javax.swing.JSeparator(SwingConstants.VERTICAL);

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
        imgY = 120;
        imgX = imgY;

        jLabelTitulo.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelTitulo.setBackground(new Color(255, 255, 255));
        jLabelTitulo.setForeground(new Color(62, 62, 62));

        jLabelNome.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelNome.setBackground(new Color(255, 255, 255));
        jLabelNome.setForeground(new Color(62, 62, 62));

        jTextFieldNome.setText(json.getString("nome"));
        jTextFieldNome.setEditable(false);

        jLabelProfissao.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelProfissao.setBackground(new Color(255, 255, 255));
        jLabelProfissao.setForeground(new Color(62, 62, 62));

        jTextFieldProfissao.setText(json.getString("profissao"));
        jTextFieldProfissao.setEditable(false);

        jLabelEstilo.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelEstilo.setBackground(new Color(255, 255, 255));
        jLabelEstilo.setForeground(new Color(62, 62, 62));

        jLabelEstiloImagem.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));
        jLabelEstiloImagem.setIcon(new ImageIcon(templateImg()));

        jLabelEmail.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelEmail.setBackground(new Color(255, 255, 255));
        jLabelEmail.setForeground(new Color(62, 62, 62));

        jTextFieldEmail.setText(json.getString("email"));
        jTextFieldEmail.setEditable(false);

        jLabelDDD.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelDDD.setBackground(new Color(255, 255, 255));
        jLabelDDD.setForeground(new Color(62, 62, 62));

        jTextFieldDDD.setText(json.getString("DDD1"));
        jTextFieldDDD.setEditable(false);

        jLabelTelefone.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelTelefone.setBackground(new Color(255, 255, 255));
        jLabelTelefone.setForeground(new Color(62, 62, 62));

        jTextFieldTelefone.setText(json.getString("telefone1"));
        jTextFieldTelefone.setEditable(false);

        jLabelCidade.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelCidade.setBackground(new Color(255, 255, 255));
        jLabelCidade.setForeground(new Color(62, 62, 62));

        jTextFieldCidade.setText(json.getString("cidade"));
        jTextFieldCidade.setEditable(false);

        jLabelEstado.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelEstado.setBackground(new Color(255, 255, 255));
        jLabelEstado.setForeground(new Color(62, 62, 62));

        jTextFieldEstado.setText(json.getString("estado"));
        jTextFieldEstado.setEditable(false);

        jLabelWebsite.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelWebsite.setBackground(new Color(255, 255, 255));
        jLabelWebsite.setForeground(new Color(62, 62, 62));

        jTextFieldWebsite.setText(json.getString("website"));
        jTextFieldWebsite.setEditable(false);

        jLabelLinkedin.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelLinkedin.setBackground(new Color(255, 255, 255));
        jLabelLinkedin.setForeground(new Color(62, 62, 62));

        jTextFieldLinkedin.setText(json.getString("linkedin"));
        jTextFieldLinkedin.setEditable(false);

        jLabelFoto.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelFoto.setBackground(new Color(255, 255, 255));
        jLabelFoto.setForeground(new Color(62, 62, 62));

        jLabelFotoUsar.setFont(new Font("DejaVu Sans", 0, 15));
        jLabelFotoUsar.setBackground(new Color(255, 255, 255));
        jLabelFotoUsar.setForeground(new Color(62, 62, 62));

        jLabelFotoImagem.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));
        jLabelFotoImagem.setIcon(new ImageIcon(fotoImg()));


        jLabelObsEndereco.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelObsEndereco.setBackground(new Color(255, 255, 255));
        jLabelObsEndereco.setForeground(new Color(62, 62, 62));

        jScrollPaneObsEndereco.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

        jScrollBarObsEndereco = jScrollPaneObsEndereco.getVerticalScrollBar();
        jScrollBarObsEndereco.setPreferredSize(new Dimension(9, 1));
        jScrollBarObsEndereco.setUI(new ProjectScrollBarUI(jScrollPaneObsEndereco));

        jTextAreaObsEndereco.setBackground(new Color(255, 255, 255));
        jTextAreaObsEndereco.setColumns(1);
        jTextAreaObsEndereco.setRows(2);
        jTextAreaObsEndereco.setBorder(BorderFactory.createEmptyBorder());
        jTextAreaObsEndereco.setLineWrap(true);
        jTextAreaObsEndereco.setWrapStyleWord(true);
        jTextAreaObsEndereco.setText(json.getString("obsEndereco"));
        jTextAreaObsEndereco.setEditable(false);


        jLabelObsVirtuais.setFont(new Font("DejaVu Sans", 0, 16));
        jLabelObsVirtuais.setBackground(new Color(255, 255, 255));
        jLabelObsVirtuais.setForeground(new Color(62, 62, 62));

        jScrollPaneObsVirtuais.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

        jScrollBarObsVirtuais = jScrollPaneObsVirtuais.getVerticalScrollBar();
        jScrollBarObsVirtuais.setPreferredSize(new Dimension(9, 1));
        jScrollBarObsVirtuais.setUI(new ProjectScrollBarUI(jScrollPaneObsVirtuais));

        jTextAreaObsVirtuais.setBackground(new Color(255, 255, 255));
        jTextAreaObsVirtuais.setColumns(2);
        jTextAreaObsVirtuais.setRows(3);
        jTextAreaObsVirtuais.setBorder(BorderFactory.createEmptyBorder());
        jTextAreaObsVirtuais.setLineWrap(true);
        jTextAreaObsVirtuais.setWrapStyleWord(true);
        jTextAreaObsVirtuais.setText(json.getString("obsVirtuais"));
        jTextAreaObsVirtuais.setEditable(false);



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

        // Campo de nome
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelNome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo de profissao
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelProfissao, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldProfissao, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelProfissao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldProfissao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo de templates
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelEstilo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelEstilo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addGap(50)
          .addComponent(jLabelEstiloImagem, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(5);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelEstiloImagem, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
        );

        // E-mail
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelEmail, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Telefones
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelDDD, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldDDD, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
          .addGap(12)
          .addComponent(jLabelTelefone, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldTelefone, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelDDD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldDDD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo Cidade
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelCidade, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldCidade, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelCidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldCidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo Estado
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelEstado, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldEstado, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelEstado, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldEstado, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo Website
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelWebsite, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldWebsite, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelWebsite, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldWebsite, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo LinkedIn
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelLinkedin, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jTextFieldLinkedin, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelLinkedin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldLinkedin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        // Campo foto
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelFoto, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
          .addGap(7)
          .addComponent(jLabelFotoUsar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelFoto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelFotoUsar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        if (json.getInt("usarFoto?") == 1) {
          BufferedImage img = null;

          try {
              img = ImageIO.read(new File(json.getString("caminhoFoto")));
          } catch (IOException ex) {
              ex.printStackTrace();
          }

          Image dimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

          jLabelFotoImagem.setIcon(new ImageIcon(dimg));

          hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
              .addGap(50)
              .addComponent(jLabelFotoImagem, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
          );
          vGroup.addGap(5);
          vGroup.addGroup(jPanelMainLayout.createParallelGroup()
              .addComponent(jLabelFotoImagem, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
          );
        }

        // Campo observações endereço
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelObsEndereco, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelObsEndereco, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addGap(30)
          .addComponent(jScrollPaneObsEndereco, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jScrollPaneObsEndereco, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );

        // Campo observações endereços virtuais
        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addComponent(jLabelObsVirtuais, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jLabelObsVirtuais, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

        hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
          .addGap(30)
          .addComponent(jScrollPaneObsVirtuais, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGap(10);
        vGroup.addGroup(jPanelMainLayout.createParallelGroup()
          .addComponent(jScrollPaneObsVirtuais, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );

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
                  Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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
                  Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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

    // Sair
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").waitFor();
        } catch (IOException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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

        // new JanelaEntradas2().setVisible(true);
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

      new JanelaFoto().setVisible(true);
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
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json"))) {
        writer.write(json.toString());
        writer.close();
      } catch (IOException ex) {
          Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    private Image templateImg() {
      BufferedImage img = null;

      switch (json.getInt("template")) {
        case 1: {
          try {
              img = ImageIO.read(new File("C:\\CONTRETEC\\CurriculumSoftware\\AdjustedTemplates\\template1.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
                break;

        case 2: {
          try {
              img = ImageIO.read(new File("C:\\CONTRETEC\\CurriculumSoftware\\AdjustedTemplates\\template2.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
                break;

        case 3: {
          try {
              img = ImageIO.read(new File("C:\\CONTRETEC\\CurriculumSoftware\\AdjustedTemplates\\template3.png"));
          } catch (IOException ex) {
              Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaConfirmarAlterarDados1().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaConfirmarAlterarDados1.class.getName()).log(Level.SEVERE, null, ex);
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

    private JLabel jLabelNome;
    private JTextField jTextFieldNome;

    private JLabel jLabelProfissao;
    private JTextField jTextFieldProfissao;

    private JLabel jLabelEstilo;
    private JLabel jLabelEstiloImagem;

    private JLabel jLabelEmail; // Transformar em um array ao final
    private JTextField jTextFieldEmail;

    private JLabel jLabelDDD;
    private JTextField jTextFieldDDD;
    private JLabel jLabelTelefone;
    private JTextField jTextFieldTelefone;

    private JLabel jLabelCidade;
    private JTextField jTextFieldCidade;

    private JLabel jLabelEstado;
    private JTextField jTextFieldEstado;

    private JLabel jLabelWebsite;
    private JTextField jTextFieldWebsite;

    private JLabel jLabelLinkedin;
    private JTextField jTextFieldLinkedin;

    private JLabel jLabelFoto;
    private JLabel jLabelFotoUsar;
    private JLabel jLabelFotoImagem;

    private JLabel jLabelObsEndereco;
    private JTextArea jTextAreaObsEndereco;
    private JScrollPane jScrollPaneObsEndereco;
    private JScrollBar jScrollBarObsEndereco;

    private JLabel jLabelObsVirtuais;
    private JTextArea jTextAreaObsVirtuais;
    private JScrollPane jScrollPaneObsVirtuais;
    private JScrollBar jScrollBarObsVirtuais;

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

}

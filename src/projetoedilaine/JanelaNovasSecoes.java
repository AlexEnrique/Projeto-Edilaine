package projetoedilaine;

import projetoedilaine.WriteTemplate3;

// import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
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

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex Enrique Crispim
 */
public class JanelaNovasSecoes extends javax.swing.JFrame {

    private int k = 0;
    private int x, y;
    private JSONObject json;

    private static final long serialVersionUID = 8607734981506765935L;
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final int SB_SIZE = 10;
    private static final Color THUMB_COLOR = Color.BLACK;

    public JanelaNovasSecoes() throws FileNotFoundException {
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

        jLabel3 = new javax.swing.JLabel(); // Texto da janela
        jLabel4 = new ArrayList<JLabel>();  // Nome seção (*)
        jLabel5 = new ArrayList<JLabel>();  // Texto da subseção ()
        jLabel6 = new ArrayList<JLabel>();  // Data ()
        jLabel7Inicio = new ArrayList<JLabel>();  // Data início e fim ()
        jLabel7Fim = new ArrayList<JLabel>();  // Data início e fim ()
        jLabel8 = new ArrayList<JLabel>();  // Local ()
        jLabel9 = new ArrayList<JLabel>();  // Descrição
        jLabel10 = new ArrayList<JLabel>(); // Tópicos ()

        jCheckBoxJL5 = new ArrayList<JCheckBox>();
        jCheckBoxJL6 = new ArrayList<JCheckBox>();
        jCheckBoxJL7InicioFim = new ArrayList<JCheckBox>();
        jCheckBoxJL8 = new ArrayList<JCheckBox>();
        jCheckBoxJL9 = new ArrayList<JCheckBox>();
        jCheckBoxJL10 = new ArrayList<JCheckBox>();

        jTextFieldJL4 = new ArrayList<MyTextField>();
        jTextFieldJL5 = new ArrayList<MyTextField>();
        jTextFieldJL6 = new ArrayList<MyTextField>();
        jTextFieldJL7Inicio = new ArrayList<MyTextField>();
        jTextFieldJL7Fim = new ArrayList<MyTextField>();
        jTextFieldJL8 = new ArrayList<MyTextField>();
        jTextAreaJL9 = new ArrayList<MyTextArea>();
        jTextAreaJL10 = new ArrayList<MyTextArea>();

        jScrollPaneTextJL9 = new ArrayList<JScrollPane>();
        jScrollPaneTextJL10 = new ArrayList<JScrollPane>();
        jScrollBarJL9 = new ArrayList<JScrollBar>();
        jScrollBarJL10 = new ArrayList<JScrollBar>();

        // jScrollPaneText = new ArrayList<JScrollPane>();
        // jScrollBar = new ArrayList<JScrollBar>();

        jPanelMain = new JPanel();
        jScrollPaneMain = new JScrollPane(jPanelMain);
        jButtonAdicionarHabilidade = new JButton("Adicionar nova seção");

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

        // jLabel3  config. ==========================================================================
        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setForeground(new Color(62, 62, 62));
        jLabel3.setFont(new Font("DejaVu Sans", 0, 18));
        jLabel3.setText("Nesta janela, você pode criar novas seções além das anteriores para seu currículo (opcional)");

        // jPanelMain ====================================================================================
        jScrollPaneMain.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

        jScrollBarMain = jScrollPaneMain.getVerticalScrollBar();
        jScrollBarMain.setPreferredSize(new Dimension(9, 1));
        jScrollBarMain.setUI(new ProjectScrollBarUI(jScrollPaneMain));

        jPanelMain.setBackground(new Color(255, 255, 255));

        // Entradas ===================================================================================
        int length = 0;
        for (String name : JSONObject.getNames(json)) {
          if (name.substring(0, name.length() - 1).equals("novaSecaoNome")) {
            length++;
          }
        }

        GroupLayout jPanelMainLayout = new GroupLayout(jPanelMain);
        GroupLayout.Group hGroup = jPanelMainLayout.createParallelGroup();
        GroupLayout.Group vGroup = jPanelMainLayout.createSequentialGroup();
        jPanelMainLayout.setHorizontalGroup(hGroup);
        jPanelMainLayout.setVerticalGroup(vGroup);
        jPanelMain.setLayout(jPanelMainLayout);

        // k precisou ser definido fora do initComponents() por que deve ser final, se for de dentro da classe
        for (k = 0; k < length; k++) {
          // Criando novos elementos ===============================================================
          // Labels
          jLabel4.add(new JLabel("Nome da seção"));
          jLabel5.add(new JLabel("Nome de subseção"));
          jLabel6.add(new JLabel("Data"));
          jLabel7Inicio.add(new JLabel("Data de início"));
          jLabel7Fim.add(new JLabel("Data de termino"));
          jLabel8.add(new JLabel("Local"));
          jLabel9.add(new JLabel("Descrição"));
          jLabel10.add(new JLabel("Tópicos"));

          jCheckBoxJL5.add(new JCheckBox("Nome de subseção"));
          jCheckBoxJL5.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 6 funcionando");
            }
          });

          jCheckBoxJL6.add(new JCheckBox("Data"));
          jCheckBoxJL6.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 6 funcionando");
            }
          });

          jCheckBoxJL7InicioFim.add(new JCheckBox("Data de início e término"));
          jCheckBoxJL7InicioFim.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 7 funcionando");
            }
          });

          jCheckBoxJL8.add(new JCheckBox("Local"));
          jCheckBoxJL8.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 8 funcionando");
            }
          });

          jCheckBoxJL9.add(new JCheckBox("Descrição"));
          jCheckBoxJL9.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 9 funcionando");
            }
          });

          jCheckBoxJL10.add(new JCheckBox("Tópicos"));
          jCheckBoxJL10.get(k).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              System.out.println("Botão 10 funcionando");
            }
          });

          // Text areas and fields
          jTextFieldJL4.add(new MyTextField());
          jTextFieldJL5.add(new MyTextField());
          jTextFieldJL6.add(new MyTextField());
          jTextFieldJL7Inicio.add(new MyTextField());
          jTextFieldJL7Fim.add(new MyTextField());
          jTextFieldJL8.add(new MyTextField());
          jTextAreaJL9.add(new MyTextArea());
          jTextAreaJL10.add(new MyTextArea());

          // ScrollBar for the text areas
          jScrollPaneTextJL9.add(new JScrollPane(jTextAreaJL9.get(jTextAreaJL9.size() - 1)));
          jScrollPaneTextJL10.add(new JScrollPane(jTextAreaJL10.get(jTextAreaJL10.size() - 1)));

          int aux = k;
          // jTextFieldJL6.get(k).setText(json.getString("habilidadeTipo" + String.valueOf(k)));
          // jTextFieldJL6.get(k).index = k;
          // jTextFieldJL6.get(k).getDocument().addDocumentListener(new DocumentListener() {
          //   @Override
          //   public void changedUpdate(DocumentEvent evt) {
          //     ChangeJSON();
          //   }
          //
          //   @Override
          //   public void removeUpdate(DocumentEvent evt) {
          //     ChangeJSON();
          //   }
          //
          //   @Override
          //   public void insertUpdate(DocumentEvent evt) {
          //     ChangeJSON();
          //   }
          //
          //   public void ChangeJSON() {
          //     int index = jTextFieldJL6.get(aux).index;
          //     json.put("habilidadeTipo" + String.valueOf(index), jTextFieldJL6.get(index).getText());
          //
          //     try {
          //       WriteJSON();
          //     } catch (IOException ex) {
          //       Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
          //     }
          //   }
          // });
          //
          jTextAreaJL9.get(k).setColumns(1);
          jTextAreaJL9.get(k).setRows(2);
          jTextAreaJL9.get(k).setBorder(BorderFactory.createEmptyBorder());
          jTextAreaJL9.get(k).setLineWrap(true);
          jTextAreaJL9.get(k).setWrapStyleWord(true);
          // jTextAreaJL7.get(k).setText(json.getString("habilidadeDescricao" + String.valueOf(k)));
          // jTextAreaJL7.get(k).index = k;
          // jTextAreaJL7.get(k).getDocument().addDocumentListener(new DocumentListener() {
          //           @Override
          //           public void changedUpdate(DocumentEvent evt) {
          //               ChangeJSON();
          //           }
          //
          //           @Override
          //           public void removeUpdate(DocumentEvent evt) {
          //               ChangeJSON();
          //           }
          //
          //           @Override
          //           public void insertUpdate(DocumentEvent evt) {
          //               ChangeJSON();
          //           }
          //
          //           public void ChangeJSON() {
          //               int index = jTextAreaJL7.get(aux).index;
          //               json.put("habilidadeDescricao" + String.valueOf(index), jTextAreaJL7.get(index).getText());
          //
          //               try {
          //                   WriteJSON();
          //               } catch (IOException ex) {
          //                   Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
          //               }
          //           }
          //       });

          // The jTextAreaJL7 is inside the jScrollPaneText
          jScrollPaneTextJL9.get(k).setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

          jScrollPaneTextJL10.get(k).setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

          jScrollBarJL9.add(jScrollPaneTextJL9.get(k).getVerticalScrollBar());
          jScrollBarJL9.get(k).setPreferredSize(new Dimension(9, 1));
          jScrollBarJL9.get(k).setUI(new ProjectScrollBarUI(jScrollPaneTextJL9.get(k)));

          jScrollBarJL10.add(jScrollPaneTextJL10.get(k).getVerticalScrollBar());
          jScrollBarJL10.get(k).setPreferredSize(new Dimension(9, 1));
          jScrollBarJL10.get(k).setUI(new ProjectScrollBarUI(jScrollPaneTextJL10.get(k)));

          jLabel4.get(k).setBackground(new Color(255, 255, 255));
          jLabel4.get(k).setForeground(new Color(62, 62, 62));
          jLabel4.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel5.get(k).setBackground(new Color(255, 255, 255));
          jLabel5.get(k).setForeground(new Color(62, 62, 62));
          jLabel5.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel6.get(k).setBackground(new Color(255, 255, 255));
          jLabel6.get(k).setForeground(new Color(62, 62, 62));
          jLabel6.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel7Inicio.get(k).setBackground(new Color(255, 255, 255));
          jLabel7Inicio.get(k).setForeground(new Color(62, 62, 62));
          jLabel7Inicio.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel7Fim.get(k).setBackground(new Color(255, 255, 255));
          jLabel7Fim.get(k).setForeground(new Color(62, 62, 62));
          jLabel7Fim.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel8.get(k).setBackground(new Color(255, 255, 255));
          jLabel8.get(k).setForeground(new Color(62, 62, 62));
          jLabel8.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel9.get(k).setBackground(new Color(255, 255, 255));
          jLabel9.get(k).setForeground(new Color(62, 62, 62));
          jLabel9.get(k).setFont(new Font("DejaVu Sans", 0, 18));

          jLabel10.get(k).setBackground(new Color(255, 255, 255));
          jLabel10.get(k).setForeground(new Color(62, 62, 62));
          jLabel10.get(k).setFont(new Font("DejaVu Sans", 0, 18));
          // =================================================================================================================
          // jCheckBoxJL5 = new ArrayList<JCheckBox>();
          // jCheckBoxJL6 = new ArrayList<JCheckBox>();
          // jCheckBoxJL7InicioFim = new ArrayList<JCheckBox>();
          // jCheckBoxJL8 = new ArrayList<JCheckBox>();
          // jCheckBoxJL9 = new ArrayList<JCheckBox>();
          // jCheckBoxJL10 = new ArrayList<JCheckBox>();

          // Adicionado-os ao painel ===============================================================
              hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                );
              hGroup.addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addGroup(jPanelMainLayout.createParallelGroup()
                  .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)

                  .addComponent(jCheckBoxJL5.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                  .addComponent(jCheckBoxJL6.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                  .addComponent(jCheckBoxJL7InicioFim.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                    .addComponent(jLabel7Inicio.get(k), GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldJL7Inicio.get(k), GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                      .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(145)
                        .addGroup(jPanelMainLayout.createParallelGroup()
                          .addComponent(jLabel7Fim.get(k), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                          .addComponent(jTextFieldJL7Fim.get(k), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        )
                      )
                    )
                  )

                  .addComponent(jCheckBoxJL8.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel8.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextFieldJL8.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                  .addComponent(jCheckBoxJL9.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel9.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextAreaJL9.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                  .addComponent(jCheckBoxJL10.get(k), GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(jPanelMainLayout.createParallelGroup()
                      .addComponent(jLabel10.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jTextAreaJL10.get(k), GroupLayout.PREFERRED_SIZE, 670-50, GroupLayout.PREFERRED_SIZE)
                    )
                  )

                )
                );

              // Vertical
              vGroup.addGroup(jPanelMainLayout.createParallelGroup()
                .addGroup(jPanelMainLayout.createSequentialGroup()
                  .addGap(3)
                  .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jCheckBoxJL5.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jCheckBoxJL6.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jCheckBoxJL7InicioFim.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)

                  .addGroup(jPanelMainLayout.createParallelGroup()
                    .addComponent(jLabel7Inicio.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(jLabel7Fim.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  )

                  .addGroup(jPanelMainLayout.createParallelGroup()
                    .addComponent(jTextFieldJL7Inicio.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(3)
                    .addComponent(jTextFieldJL7Fim.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  )

                  .addGap(3)
                  .addComponent(jCheckBoxJL8.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jLabel8.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL8.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jCheckBoxJL9.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jLabel9.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextAreaJL9.get(k), GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jCheckBoxJL10.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jLabel10.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextAreaJL10.get(k), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                  )
              );
        }
        // =================================================================================================================

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
                  Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
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
                  Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
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


        // jButtonAdicionarHabilidade =================================================================================
        jButtonAdicionarHabilidade.setBackground(new Color(62, 62, 62));
        jButtonAdicionarHabilidade.setForeground(new Color(255, 255, 255));
        jButtonAdicionarHabilidade.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAdicionarHabilidade.setBorder(BorderFactory.createEmptyBorder());
        jButtonAdicionarHabilidade.setFocusPainted(false);
        jButtonAdicionarHabilidade.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            jButtonAdicionarHabilidadeActionPerformed(evt);
          }
        });
        jButtonAdicionarHabilidade.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonAdicionarHabilidadeMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonAdicionarHabilidadeMouseExited(evt);
          }
        });

        // end jButtonAdicionarHabilidade =============================================================================


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
                .addGap(30)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addGap(30)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup()
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(170+6)
                  .addGap(45, 45, 45)
                  .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jButtonAdicionarHabilidade, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
              )
            )));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonPrevious, 60, 60, 60)
                    .addComponent(jButtonNext, 60, 60, 60)
                    .addComponent(jButtonAdicionarHabilidade, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
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
        new JanelaFoto().setVisible(true);

        // Remover isso na versão final!
        try {
            Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").waitFor();
        } catch (IOException ex) {
            Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        }


        // new JanelaNovasSecoes().setVisible(true);
        // SaveJSONFile();

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

      new JanelaEntradas8().setVisible(true);
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

    // jButtonAdicionarHabilidade
    private void jButtonAdicionarHabilidadeActionPerformed(ActionEvent evt) {
      int length = jLabel4.size();

      // Criando novos elementos ===============================================================

      // *Criando dados para o arquivo JSON****************************************************

      // =================================================================================================================
    }

    private void jButtonAdicionarHabilidadeMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonAdicionarHabilidade.setBackground(new Color(240, 240, 240));
      jButtonAdicionarHabilidade.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAdicionarHabilidadeMouseExited(java.awt.event.MouseEvent evt) {
      jButtonAdicionarHabilidade.setBackground(new Color(62, 62, 62));
      jButtonAdicionarHabilidade.setForeground(new Color(255, 255, 255));
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
            java.util.logging.Logger.getLogger(JanelaNovasSecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaNovasSecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaNovasSecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaNovasSecoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaNovasSecoes().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaNovasSecoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;

    private JButton jButtonExit;
    private JButton jButtonMinimize;

    private JLabel jLabel3; // Texto da janela
    private List<JLabel> jLabel4;  // Nome seção (*)
    private List<JLabel> jLabel5;  // Texto da subseção ()
    private List<JLabel> jLabel6;  // Data ()
    private List<JLabel> jLabel7Inicio;  // Data início e fim ()
    private List<JLabel> jLabel7Fim;  // Data início e fim ()
    private List<JLabel> jLabel8;  // Local ()
    private List<JLabel> jLabel9;  // Descrição
    private List<JLabel> jLabel10; // Tópicos ()

    private List<JCheckBox> jCheckBoxJL5;
    private List<JCheckBox> jCheckBoxJL6;
    private List<JCheckBox> jCheckBoxJL7InicioFim;
    private List<JCheckBox> jCheckBoxJL8;
    private List<JCheckBox> jCheckBoxJL9;
    private List<JCheckBox> jCheckBoxJL10;

    private List<MyTextField> jTextFieldJL4;
    private List<MyTextField> jTextFieldJL5;
    private List<MyTextField> jTextFieldJL6;
    private List<MyTextField> jTextFieldJL7Inicio;
    private List<MyTextField> jTextFieldJL7Fim;
    private List<MyTextField> jTextFieldJL8;
    private List<MyTextArea> jTextAreaJL9;
    private List<MyTextArea> jTextAreaJL10;

    private List<JScrollPane> jScrollPaneTextJL9;
    private List<JScrollPane> jScrollPaneTextJL10;
    private List<JScrollBar> jScrollBarJL9;
    private List<JScrollBar> jScrollBarJL10;

    private JPanel jPanelMain;
    private JScrollPane jScrollPaneMain;
    private JButton jButtonAdicionarHabilidade;
    private JScrollBar jScrollBarMain;

    private JButton jButtonNext;
    private JButton jButtonPrevious;
    // End of variables declaration

    private static class MyTextArea extends JTextArea {
      public int index;

      private MyTextArea() {}
    }

    private static class MyTextField extends JTextField {
      public int index;

      private MyTextField() {}
    }

    private static class ProjectScrollBarUI extends BasicScrollBarUI {
        private JScrollPane jScrollPaneText;

        private ProjectScrollBarUI(JScrollPane jScrollPaneText) {
            this.jScrollPaneText = jScrollPaneText;
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
            jScrollPaneText.repaint();
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

package projetoedilaine;

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
public class JanelaEntradas7 extends javax.swing.JFrame {

    private int k;
    private int x, y;
    private JSONObject json;

    private static final long serialVersionUID = 8607734981506765935L;
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final int SB_SIZE = 10;
    private static final Color THUMB_COLOR = Color.BLACK;

    public JanelaEntradas7() throws FileNotFoundException {
      this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("tmp.json")
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new ArrayList<JLabel>();
        jLabel5 = new ArrayList<JLabel>();
        jLabel6 = new ArrayList<JLabel>();
        jLabel7 = new ArrayList<JLabel>();

        jTextFieldJL4 = new ArrayList<JTextField>();
        jTextFieldJL5 = new ArrayList<JTextField>();
        jTextFieldJL6 = new ArrayList<JTextField>();
        jTextAreaJL7 = new ArrayList<JTextArea>();
        jScrollPaneText = new ArrayList<JScrollPane>();
        jScrollBar = new ArrayList<JScrollBar>();

        jPanelMain = new JPanel();
        // jScrollPaneMain = new JScrollPane(jPanelMain);
        jScrollPaneMain = new JScrollPane();
        jButtonAdicionarFormacao = new JButton("Adicionar nova formação");

        // jTextFieldJL4 = new JTextField(json.getString("formacaoAnoInicio"));
        // jTextFieldJL5 = new JTextField(json.getString("formacaoAnoFim"));
        // jTextFieldJL6 = new JTextField(json.getString("formacaoLocal"));
        // jTextAreaJL7 = new javax.swing.jTextAreaJL7(json.getString("formacaoDescricao")); // text area of jLabel7 (descrição)
        // jScrollPaneText = new javax.swing.jScrollPaneText(jTextAreaJL7);

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

        // jLabel3 e jTextAreaJL7 config. ==========================================================================
        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setForeground(new Color(62, 62, 62));
        jLabel3.setFont(new Font("DejaVu Sans", 0, 18));
        jLabel3.setText("Está janela corresponde à seção \"Experiências Profissionais\" do currículo. A mesma é opcional");

        // Entradas ===================================================================================
        int length = 0;
        for (String name : JSONObject.getNames(json)) {
          if (name.substring(0, name.length() - 1).equals("formacaoDescricao")) {
            length++;
          }
        }
        System.out.println("O length é " + String.valueOf(length));
        // k precisou ser definido fora do initComponents() por que deve ser final, se for de dentro da classe
        for (k = 0; k < length; k++) {
        // Criando novos elementos ===============================================================
        jLabel4.add(new JLabel("Ano de início"));
        jLabel5.add(new JLabel("Ano de conclusão"));
        jLabel6.add(new JLabel("Local de formação"));
        jLabel7.add(new JLabel("Descrição"));
        jTextFieldJL4.add(new JTextField(json.getString("formacaoAnoInicio" + String.valueOf(k + 1))));
        jTextFieldJL5.add(new JTextField(json.getString("formacaoAnoFim" + String.valueOf(k + 1))));
        jTextFieldJL6.add(new JTextField(json.getString("formacaoLocal" + String.valueOf(k + 1))));
        jTextAreaJL7.add(new JTextArea(json.getString("formacaoDescricao" + String.valueOf(k + 1))));
        jScrollPaneText.add(new JScrollPane(jTextAreaJL7.get(jTextAreaJL7.size() - 1)));

        jTextAreaJL7.get(k).setColumns(1);
        jTextAreaJL7.get(k).setRows(2);
        jTextAreaJL7.get(k).setBorder(BorderFactory.createEmptyBorder());
        jTextAreaJL7.get(k).setLineWrap(true);
        jTextAreaJL7.get(k).setWrapStyleWord(true);
        jTextAreaJL7.get(k).setText(json.getString("formacaoDescricao" + String.valueOf(k + 1)));
        jTextAreaJL7.get(k).getDocument().addDocumentListener(new DocumentListener() {
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
                      json.put("formacaoDescricao" + String.valueOf(k + 1), jTextAreaJL7.get(k).getText());

                      try {
                          WriteJSON();
                      } catch (IOException ex) {
                          Logger.getLogger(JanelaEntradas5.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              });

        // The jTextAreaJL7 is inside the jScrollPaneText
        jScrollPaneText.get(k).setBorder(javax.swing.BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

        jScrollBar.add(jScrollPaneText.get(k).getVerticalScrollBar());
        jScrollBar.get(k).setPreferredSize(new Dimension(9, 1));
        jScrollBar.get(k).setUI(new ProjectScrollBarUI(jScrollPaneText.get(k)));

        jLabel4.get(k).setBackground(new Color(255, 255, 255));
        jLabel4.get(k).setForeground(new Color(62, 62, 62));
        jLabel4.get(k).setFont(new Font("DejaVu Sans", 0, 18));

        jLabel5.get(k).setBackground(new Color(255, 255, 255));
        jLabel5.get(k).setForeground(new Color(62, 62, 62));
        jLabel5.get(k).setFont(new Font("DejaVu Sans", 0, 18));

        jLabel6.get(k).setBackground(new Color(255, 255, 255));
        jLabel6.get(k).setForeground(new Color(62, 62, 62));
        jLabel6.get(k).setFont(new Font("DejaVu Sans", 0, 18));

        jLabel7.get(k).setBackground(new Color(255, 255, 255));
        jLabel7.get(k).setForeground(new Color(62, 62, 62));
        jLabel7.get(k).setFont(new Font("DejaVu Sans", 0, 18));
        // =================================================================================================================

        // Adicionado-os ao painel ===============================================================
          GroupLayout jPanelMainLayout = new GroupLayout(jPanelMain);
          jPanelMain.setLayout(jPanelMainLayout);
          jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup()
              .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                )
              .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
                )
              .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel7.get(k), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
              )
              .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(30)
                .addComponent(jScrollPaneText.get(k), GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
              )
            );
          jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createSequentialGroup()
              .addGroup(jPanelMainLayout.createParallelGroup()
                .addGroup(jPanelMainLayout.createSequentialGroup()
                  .addGap(k*330)
                  .addGap(3)
                  .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  )
                .addGroup(jPanelMainLayout.createSequentialGroup()
                  .addGap(k*330)
                  .addGap(3)
                  .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  )
                .addGroup(jPanelMainLayout.createSequentialGroup()
                  .addGap(k*330)
                  .addGap(3)
                  .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  )
                .addGroup(jPanelMainLayout.createSequentialGroup()
                  .addGap(k*330)
                  .addGap(3)
                  .addGap(55)
                  .addComponent(jLabel7.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                  .addGap(3)
                  .addComponent(jScrollPaneText.get(k), GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  )
              )
            );
        }
        // =================================================================================================================

        // jPanelMain ====================================================================================
        jScrollPaneMain.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

        jScrollBarMain = jScrollPaneMain.getVerticalScrollBar();
        jScrollBarMain.setPreferredSize(new Dimension(9, 1));
        jScrollBarMain.setUI(new ProjectScrollBarUI(jScrollPaneMain));

        jPanelMain.setBackground(new Color(255, 255, 255));
        //=======================================================================================================

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
                  Logger.getLogger(JanelaEntradas7.class.getName()).log(Level.SEVERE, null, ex);
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
                  Logger.getLogger(JanelaEntradas7.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaEntradas7.class.getName()).log(Level.SEVERE, null, ex);
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


        // jButtonAdicionarFormacao =================================================================================
        jButtonAdicionarFormacao.setBackground(new Color(62, 62, 62));
        jButtonAdicionarFormacao.setForeground(new Color(255, 255, 255));
        jButtonAdicionarFormacao.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAdicionarFormacao.setBorder(BorderFactory.createEmptyBorder());
        jButtonAdicionarFormacao.setFocusPainted(false);
        jButtonAdicionarFormacao.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            jButtonAdicionarFormacaoActionPerformed(evt);
          }
        });
        jButtonAdicionarFormacao.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonAdicionarFormacaoMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonAdicionarFormacaoMouseExited(evt);
          }
        });

        // end jButtonAdicionarFormacao =============================================================================


        jLabel1.setIcon(new javax.swing.ImageIcon("/home/alex/NetBeansProjects/projetoEdilaine/LogoEmpresa.png")); // NOI18N

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
              // .addGroup(jPanel1Layout.createSequentialGroup()
              //     .addComponent(jButtonAdicionarFormacao, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jButtonNext, 60, 60, 60)))
                    // .addComponent(jButtonAdicionarFormacao, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
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
            Runtime.getRuntime().exec("rm tmp.json").waitFor();
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

        new JanelaEntradas8().setVisible(true);
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

      new JanelaEntradas7().setVisible(true);
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

    // jButtonAdicionarFormacao
    private void jButtonAdicionarFormacaoActionPerformed(ActionEvent evt) {
      int length = jLabel4.size();

      // Criando novos elementos ===============================================================

      // *Criando dados para o arquivo JSON****************************************************
      json.put("formacaoAnoInicio" + String.valueOf(length + 1), "");
      json.put("formacaoAnoFim" + String.valueOf(length + 1), "");
      json.put("formacaoLocal" + String.valueOf(length + 1), "");
      json.put("formacaoDescricao" + String.valueOf(length + 1), "");

      try {
          WriteJSON();
      } catch (IOException ex) {
          Logger.getLogger(JanelaEntradas7.class.getName()).log(Level.SEVERE, null, ex);
      }
      // ****************************************************************************************

      jLabel4.add(new JLabel("Ano de início"));
      jLabel5.add(new JLabel("Ano de conclusão"));
      jLabel6.add(new JLabel("Local de formação"));
      jLabel7.add(new JLabel("Descrição"));
      jTextFieldJL4.add(new JTextField(""));
      jTextFieldJL5.add(new JTextField(""));
      jTextFieldJL6.add(new JTextField(""));
      jTextAreaJL7.add(new JTextArea(""));
      jScrollPaneText.add(new JScrollPane(jTextAreaJL7.get(length - 1)));

      jTextAreaJL7.get(length - 1).setColumns(1);
      jTextAreaJL7.get(length - 1).setRows(2);
      jTextAreaJL7.get(length - 1).setBorder(BorderFactory.createEmptyBorder());
      jTextAreaJL7.get(length - 1).setLineWrap(true);
      jTextAreaJL7.get(length - 1).setWrapStyleWord(true);
      jTextAreaJL7.get(length - 1).setText(json.getString("formacaoDescricao" + String.valueOf(length + 1)));
      jTextAreaJL7.get(length - 1).getDocument().addDocumentListener(new DocumentListener() {
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
                    json.put("formacaoDescricao" + String.valueOf(length + 1), jTextAreaJL7.get(length - 1).getText());

                    try {
                        WriteJSON();
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaEntradas5.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

      // The jTextAreaJL7 is inside the jScrollPaneText
      jScrollPaneText.get(length - 1).setBorder(javax.swing.BorderFactory.createLineBorder(new Color(62, 62, 62), 1));

      jScrollBar.add(jScrollPaneText.get(length - 1).getVerticalScrollBar());
      jScrollBar.get(length - 1).setPreferredSize(new Dimension(9, 1));
      jScrollBar.get(length - 1).setUI(new ProjectScrollBarUI(jScrollPaneText.get(length - 1)));

      jLabel4.get(length - 1).setBackground(new Color(255, 255, 255));
      jLabel4.get(length - 1).setForeground(new Color(62, 62, 62));
      jLabel4.get(length - 1).setFont(new Font("DejaVu Sans", 0, 18));

      jLabel5.get(length - 1).setBackground(new Color(255, 255, 255));
      jLabel5.get(length - 1).setForeground(new Color(62, 62, 62));
      jLabel5.get(length - 1).setFont(new Font("DejaVu Sans", 0, 18));

      jLabel6.get(length - 1).setBackground(new Color(255, 255, 255));
      jLabel6.get(length - 1).setForeground(new Color(62, 62, 62));
      jLabel6.get(length - 1).setFont(new Font("DejaVu Sans", 0, 18));

      jLabel7.get(length - 1).setBackground(new Color(255, 255, 255));
      jLabel7.get(length - 1).setForeground(new Color(62, 62, 62));
      jLabel7.get(length - 1).setFont(new Font("DejaVu Sans", 0, 18));
      // =================================================================================================================

      // Adicionado-os ao painel ===============================================================
      int k = length - 1;
      GroupLayout jPanelMainLayout = new GroupLayout(jPanelMain);
      jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
        jPanelMainLayout.createParallelGroup()
          .addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(30)
            .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
            .addGap(15)
            .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
            )
          .addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(30)
            .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
            .addGap(15)
            .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
            )
          .addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(30)
            .addComponent(jLabel7.get(k), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
          )
          .addGroup(jPanelMainLayout.createSequentialGroup()
            .addGap(30)
            .addComponent(jScrollPaneText.get(k), GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
          )
        );
      jPanelMainLayout.setVerticalGroup(
        jPanelMainLayout.createSequentialGroup()
          .addGroup(jPanelMainLayout.createParallelGroup()
            .addGroup(jPanelMainLayout.createSequentialGroup()
              .addGap(k*330)
              .addGap(3)
              .addComponent(jLabel4.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
              .addGap(3)
              .addComponent(jTextFieldJL4.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
              )
            .addGroup(jPanelMainLayout.createSequentialGroup()
              .addGap(k*330)
              .addGap(3)
              .addComponent(jLabel5.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
              .addGap(3)
              .addComponent(jTextFieldJL5.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
              )
            .addGroup(jPanelMainLayout.createSequentialGroup()
              .addGap(k*330)
              .addGap(3)
              .addComponent(jLabel6.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
              .addGap(3)
              .addComponent(jTextFieldJL6.get(k), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
              )
            .addGroup(jPanelMainLayout.createSequentialGroup()
              .addGap(k*330)
              .addGap(3)
              .addGap(55)
              .addComponent(jLabel7.get(k), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
              .addGap(3)
              .addComponent(jScrollPaneText.get(k), GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
              .addGap(10)
              )
          )
        );
      // =================================================================================================================
    }

    private void jButtonAdicionarFormacaoMouseEntered(java.awt.event.MouseEvent evt) {
      jButtonAdicionarFormacao.setBackground(new Color(240, 240, 240));
      jButtonAdicionarFormacao.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAdicionarFormacaoMouseExited(java.awt.event.MouseEvent evt) {
      jButtonAdicionarFormacao.setBackground(new Color(62, 62, 62));
      jButtonAdicionarFormacao.setForeground(new Color(255, 255, 255));
    }


    private void WriteJSON() throws IOException {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("tmp.json"))) {
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
            java.util.logging.Logger.getLogger(JanelaEntradas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaEntradas7().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaEntradas7.class.getName()).log(Level.SEVERE, null, ex);
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

    private JLabel jLabel3;
    private List<JLabel> jLabel4;
    private List<JLabel> jLabel5;
    private List<JLabel> jLabel6;
    private List<JLabel> jLabel7;
    private List<JScrollPane> jScrollPaneText;
    private List<JScrollBar> jScrollBar;
    private List<JTextField> jTextFieldJL4;
    private List<JTextField> jTextFieldJL5;
    private List<JTextField> jTextFieldJL6;
    private List<JTextArea> jTextAreaJL7;

    private JPanel jPanelMain;
    private JScrollPane jScrollPaneMain;
    private JButton jButtonAdicionarFormacao;
    private JScrollBar jScrollBarMain;

    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    // End of variables declaration

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

package projetoedilaine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

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
public class JanelaEntradas2 extends javax.swing.JFrame {

    private int x, y;
    private Timer fadeInJL3;
    private JSONObject json;

    public JanelaEntradas2() throws FileNotFoundException {
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

        // Labels para observações
        jLabelObs1 = new javax.swing.JLabel();
        jLabelObs2 = new javax.swing.JLabel();
        jLabelObs3 = new javax.swing.JLabel();
        jLabelObs4 = new javax.swing.JLabel();

        // Botões para adicionar novos dados ou observações
        jButtonAdicionarTelefone = new javax.swing.JButton();
        jButtonAdicionarEmail = new javax.swing.JButton();
        jButtonAlterarTelefone = new javax.swing.JButton();
        jButtonAlterarEmail = new javax.swing.JButton();
        jButtonObsEndereco = new javax.swing.JButton();
        jButtonObsVirtuais = new javax.swing.JButton(); // Endereços virtuais

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

        // Botões principais ====================================================================================
        jButtonAdicionarTelefone.setBackground(new Color(62, 62, 62));
        jButtonAdicionarTelefone.setForeground(new Color(255, 255, 255));
        jButtonAdicionarTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAdicionarTelefone.setFocusPainted(false);
        jButtonAdicionarTelefone.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAdicionarTelefone.setText("Adicionar Telefone");
        jButtonAdicionarTelefone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonAdicionarTelefoneActionPerformed(evt);
            }
        });
        jButtonAdicionarTelefone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonAdicionarTelefoneMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonAdicionarTelefoneMouseExited(evt);
            }
        });

        jButtonAdicionarEmail.setBackground(new Color(62, 62, 62));
        jButtonAdicionarEmail.setForeground(new Color(255, 255, 255));
        jButtonAdicionarEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAdicionarEmail.setFocusPainted(false);
        jButtonAdicionarEmail.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAdicionarEmail.setText("Adicionar E-mail");
        jButtonAdicionarEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonAdicionarEmailActionPerformed(evt);
            }
        });
        jButtonAdicionarEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonAdicionarEmailMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonAdicionarEmailMouseExited(evt);
            }
        });

        jButtonAlterarTelefone.setBackground(new Color(62, 62, 62));
        jButtonAlterarTelefone.setForeground(new Color(255, 255, 255));
        jButtonAlterarTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAlterarTelefone.setFocusPainted(false);
        jButtonAlterarTelefone.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAlterarTelefone.setText("Alterar Telefone");
        jButtonAlterarTelefone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonAlterarTelefoneActionPerformed(evt);
            }
        });
        jButtonAlterarTelefone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonAlterarTelefoneMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonAlterarTelefoneMouseExited(evt);
            }
        });

        jButtonAlterarEmail.setBackground(new Color(62, 62, 62));
        jButtonAlterarEmail.setForeground(new Color(255, 255, 255));
        jButtonAlterarEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAlterarEmail.setFocusPainted(false);
        jButtonAlterarEmail.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAlterarEmail.setText("Alterar E-mail");
        jButtonAlterarEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonAlterarEmailActionPerformed(evt);
            }
        });
        jButtonAlterarEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonAlterarEmailMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonAlterarEmailMouseExited(evt);
            }
        });

        jButtonObsEndereco.setBackground(new Color(62, 62, 62));
        jButtonObsEndereco.setForeground(new Color(255, 255, 255));
        jButtonObsEndereco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonObsEndereco.setFocusPainted(false);
        jButtonObsEndereco.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonObsEndereco.setText("Observações - endereço");
        jButtonObsEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonObsEnderecoActionPerformed(evt);
            }
        });
        jButtonObsEndereco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonObsEnderecoMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonObsEnderecoMouseExited(evt);
            }
        });

        jButtonObsVirtuais.setBackground(new Color(62, 62, 62));
        jButtonObsVirtuais.setForeground(new Color(255, 255, 255));
        jButtonObsVirtuais.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonObsVirtuais.setFocusPainted(false);
        jButtonObsVirtuais.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonObsVirtuais.setText("Observações - endereços virtuais");
        jButtonObsVirtuais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonObsVirtuaisActionPerformed(evt);
            }
        });
        jButtonObsVirtuais.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jButtonObsVirtuaisMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jButtonObsVirtuaisMouseExited(evt);
            }
        });
        //=======================================================================================================

        // Observações ==========================================================================================
        jLabelObs1.setBackground(new Color(255, 255, 255));
        jLabelObs1.setForeground(new Color(62, 62, 62));
        jLabelObs1.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelObs1.setText("Os botões abaixo permitem a adição de novos telefones e e-mails, além de observações");

        jLabelObs2.setBackground(new Color(255, 255, 255));
        jLabelObs2.setForeground(new Color(62, 62, 62));
        jLabelObs2.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelObs2.setText("sobre os dados de endereço ou endereços virtuais da janela anterior. ");

        jLabelObs3.setBackground(new Color(255, 255, 255));
        jLabelObs3.setForeground(new Color(62, 62, 62));
        jLabelObs3.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelObs3.setText("A alteração das observações de endereços (físicos ou virtuais) é feita pelo próprio botão");

        jLabelObs4.setBackground(new Color(255, 255, 255));
        jLabelObs4.setForeground(new Color(62, 62, 62));
        jLabelObs4.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelObs4.setText("de adicionar informações sobre os mesmos");
        //=======================================================================================================

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
                  Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
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
                  Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
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
            // Group - Observações
            .addGroup(jPanel1Layout.createParallelGroup()
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabelObs1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabelObs2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabelObs3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabelObs4, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
            // Separador e botões (lado esquerdo)
            .addGroup(jPanel1Layout.createParallelGroup()
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30)
                  .addGap(71)
                  .addComponent(jButtonAdicionarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30)
                  .addGap(71)
                  .addComponent(jButtonAdicionarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30)
                  .addGap(71)
                  .addComponent(jButtonAlterarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30)
                  .addGap(71)
                  .addComponent(jButtonAlterarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            // Lado direito
            .addGroup(jPanel1Layout.createParallelGroup()
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addGap(32)
                  .addComponent(jButtonObsEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addGap(32)
                  .addComponent(jButtonObsVirtuais, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel1)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100)
                .addGap(12)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelObs1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelObs2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelObs3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelObs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100)
                .addGap(125)
                .addGap(12)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonAdicionarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonAdicionarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonAlterarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonAlterarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
            // Lado direito
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100)
                .addGap(125)
                .addGap(12)
                .addGap(35)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonObsEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonObsVirtuais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonPrevious, 60, 60, 60)
                    .addComponent(jButtonNext, 60, 60, 60)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100)
                .addGap(125)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 320 - 6, javax.swing.GroupLayout.PREFERRED_SIZE))
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
      this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json")
                          )
                      )
                  );

      WriteJSON();

      new JanelaEntradas3().setVisible(true);
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
      this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json")
                          )
                      )
                  );

      WriteJSON();

      new JanelaEntradas1().setVisible(true);
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

    // jButtonAdicionarTelefone functions =================================
    private void jButtonAdicionarTelefoneActionPerformed(ActionEvent evt) {
        try {
            new JanelajButtonAdicionarTelefone().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonAdicionarTelefoneMouseEntered(MouseEvent evt) {
        jButtonAdicionarTelefone.setBackground(new Color(240, 240, 240));
        jButtonAdicionarTelefone.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAdicionarTelefoneMouseExited(MouseEvent evt) {
        jButtonAdicionarTelefone.setBackground(new Color(62, 62, 62));
        jButtonAdicionarTelefone.setForeground(new Color(255, 255, 255));
    }
    // end jButtonAdicionarTelefone functions ==============================

    // jButtonAdicionarEmail functions =================================
    private void jButtonAdicionarEmailActionPerformed(ActionEvent evt) {
        try {
            new JanelajButtonAdicionarEmail().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonAdicionarEmailMouseEntered(MouseEvent evt) {
        jButtonAdicionarEmail.setBackground(new Color(240, 240, 240));
        jButtonAdicionarEmail.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAdicionarEmailMouseExited(MouseEvent evt) {
        jButtonAdicionarEmail.setBackground(new Color(62, 62, 62));
        jButtonAdicionarEmail.setForeground(new Color(255, 255, 255));
    }
    // end jButtonAdicionarEmail functions ==============================

    // jButtonObsEndereco functions =================================
    private void jButtonObsEnderecoActionPerformed(ActionEvent evt) {
        try {
            new JanelajButtonObsEndereco().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonObsEnderecoMouseEntered(MouseEvent evt) {
        jButtonObsEndereco.setBackground(new Color(240, 240, 240));
        jButtonObsEndereco.setForeground(new Color(62, 62, 62));
    }

    private void jButtonObsEnderecoMouseExited(MouseEvent evt) {
        jButtonObsEndereco.setBackground(new Color(62, 62, 62));
        jButtonObsEndereco.setForeground(new Color(255, 255, 255));
    }
    // end jButtonObsEndereco functions ==============================

    // jButtonObsVirtuais functions =================================
    private void jButtonObsVirtuaisActionPerformed(ActionEvent evt) {
        try {
            new JanelajButtonObsVirtuais().setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonObsVirtuaisMouseEntered(MouseEvent evt) {
        jButtonObsVirtuais.setBackground(new Color(240, 240, 240));
        jButtonObsVirtuais.setForeground(new Color(62, 62, 62));
    }

    private void jButtonObsVirtuaisMouseExited(MouseEvent evt) {
        jButtonObsVirtuais.setBackground(new Color(62, 62, 62));
        jButtonObsVirtuais.setForeground(new Color(255, 255, 255));
    }
    // end jButtonObsVirtuais functions ==============================

    // jButtonAlterarTelefone functions =================================
    private void jButtonAlterarTelefoneActionPerformed(ActionEvent evt) {
        // new JanelajButtonAlterarTelefone().setVisible(true);
    }

    private void jButtonAlterarTelefoneMouseEntered(MouseEvent evt) {
        jButtonAlterarTelefone.setBackground(new Color(240, 240, 240));
        jButtonAlterarTelefone.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAlterarTelefoneMouseExited(MouseEvent evt) {
        jButtonAlterarTelefone.setBackground(new Color(62, 62, 62));
        jButtonAlterarTelefone.setForeground(new Color(255, 255, 255));
    }
    // end jButtonAlterarTelefone functions ==============================

    // jButtonAlterarEmail functions =================================
    private void jButtonAlterarEmailActionPerformed(ActionEvent evt) {
        // new JanelajButtonAlterarEmail().setVisible(true);
    }

    private void jButtonAlterarEmailMouseEntered(MouseEvent evt) {
        jButtonAlterarEmail.setBackground(new Color(240, 240, 240));
        jButtonAlterarEmail.setForeground(new Color(62, 62, 62));
    }

    private void jButtonAlterarEmailMouseExited(MouseEvent evt) {
        jButtonAlterarEmail.setBackground(new Color(62, 62, 62));
        jButtonAlterarEmail.setForeground(new Color(255, 255, 255));
    }
    // end jButtonAlterarEmail functions ==============================

    /* Criar janelas
        JanelajButtonAdicionarTelefone
        JanelajButtonAdicionarEmail
        JanelajButtonObsEndereco
        JanelajButtonObsVirtuais
    */


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
            java.util.logging.Logger.getLogger(JanelaEntradas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaEntradas2().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaEntradas2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    // Labels para observações
    private javax.swing.JLabel jLabelObs1;
    private javax.swing.JLabel jLabelObs2;
    private javax.swing.JLabel jLabelObs3;
    private javax.swing.JLabel jLabelObs4;

    private javax.swing.JSeparator jSeparator;

    private javax.swing.JButton jButtonAdicionarTelefone;
    private javax.swing.JButton jButtonAdicionarEmail;
    private javax.swing.JButton jButtonAlterarTelefone;
    private javax.swing.JButton jButtonAlterarEmail;
    private javax.swing.JButton jButtonObsEndereco;
    private javax.swing.JButton jButtonObsVirtuais; // Endereços virtuais

    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMinimize;

    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    // End of variables declaration
}

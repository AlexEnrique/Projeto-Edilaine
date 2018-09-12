package projetoedilaine;

import java.awt.Color;
import java.awt.Font;
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
 *
 * @author Alex Enrique Crispim
 */
public class JanelaEntradas1 extends javax.swing.JFrame {

    int x, y;
    int alpha = 0;
    Timer fadeInJL3;
    JSONObject json;

    public JanelaEntradas1() throws FileNotFoundException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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

        // Separador
        jSeparator = new javax.swing.JSeparator(SwingConstants.VERTICAL);

        // Labels das entradas
        jLabelNome = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelTelefone_1 = new javax.swing.JLabel();
        jLabelTelefone_2 = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelWebSite = new javax.swing.JLabel();
        jLabelLinkedIn = new javax.swing.JLabel();
        /* Mover para outra janela
         jLabelInteresses = new javax.swing.JLabel();
         jLabelIdiomas = new javax.swing.JLabel();
         */

        // Text field das entradas
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefone_1 = new javax.swing.JTextField();
        jTextFieldTelefone_2 = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldWebSite = new javax.swing.JTextField();
        jTextFieldLinkedIn = new javax.swing.JTextField();

        json = new JSONObject(
            new JSONTokener(
                new BufferedReader(
                    new FileReader("tmp.json")
                )
            )
        );

        // Next and previous buttons
        jButtonNext = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criador de currículo CONTRETEC");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 900, 550));
        // setLocation(new java.awt.Point(100, 100));
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

        // Entradas
        //=======================================================================================================
        // .put("nome", jTextFieldNome.getText())
        // .put("template", json.getInt("template"))
        // .put("email", jTextFieldEmail.getText())
        // .put("telefone1", jTextFieldTelefone_1.getText())
        // .put("telefone2", jTextFieldTelefone_2.getText())
        // .put("endereco", jTextFieldCidade.getText())
        // .put("website", jTextFieldWebSite.getText())
        // .put("linkedin", jTextFieldLinkedIn.getText())

        jLabelNome.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelNome.setBackground(new Color(255, 255, 255));
        jLabelNome.setForeground(new Color(62, 62, 62));
        jLabelNome.setText("Nome completo");

        jTextFieldNome.setText(json.getString("nome"));
        jTextFieldNome.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("nome", jTextFieldNome.getText());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelEmail.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelEmail.setBackground(new Color(255, 255, 255));
        jLabelEmail.setForeground(new Color(62, 62, 62));
        jLabelEmail.setText("E-mail");

        jTextFieldEmail.setText(json.getString("email"));
        jTextFieldEmail.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("email", jTextFieldEmail.getText().toLowerCase());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelTelefone_1.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelTelefone_1.setBackground(new Color(255, 255, 255));
        jLabelTelefone_1.setForeground(new Color(62, 62, 62));
        jLabelTelefone_1.setText("Telefone 1");

        jTextFieldTelefone_1.setText(json.getString("telefone1"));
        jTextFieldTelefone_1.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("telefone1", jTextFieldTelefone_1.getText());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelTelefone_2.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelTelefone_2.setBackground(new Color(255, 255, 255));
        jLabelTelefone_2.setForeground(new Color(62, 62, 62));
        jLabelTelefone_2.setText("Telefone 2");

        jTextFieldTelefone_2.setText(json.getString("telefone2"));
        jTextFieldTelefone_2.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("telefone2", jTextFieldTelefone_2.getText());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelCidade.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelCidade.setBackground(new Color(255, 255, 255));
        jLabelCidade.setForeground(new Color(62, 62, 62));
        jLabelCidade.setText("Cidade de residência");

        jTextFieldCidade.setText(json.getString("cidade"));
        jTextFieldCidade.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("cidade", jTextFieldCidade.getText());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelEstado.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelEstado.setBackground(new Color(255, 255, 255));
        jLabelEstado.setForeground(new Color(62, 62, 62));
        jLabelEstado.setText("Estado");

        jTextFieldEstado.setText(json.getString("estado"));
        jTextFieldEstado.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("estado", jTextFieldEstado.getText().toUpperCase());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabelWebSite.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelWebSite.setBackground(new Color(255, 255, 255));
        jLabelWebSite.setForeground(new Color(62, 62, 62));
        jLabelWebSite.setText("Web Site");

        jTextFieldWebSite.setText(json.getString("website"));
        jTextFieldWebSite.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("website", jTextFieldWebSite.getText().toLowerCase());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Deixar isso opcional
        jLabelLinkedIn.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelLinkedIn.setBackground(new Color(255, 255, 255));
        jLabelLinkedIn.setForeground(new Color(62, 62, 62));
        jLabelLinkedIn.setText("LinkedIn");

        jTextFieldLinkedIn.setText(json.getString("linkedin"));
        jTextFieldLinkedIn.getDocument().addDocumentListener(new DocumentListener() {
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
                json.put("linkedin", jTextFieldLinkedIn.getText());
                try {
                    WriteJSON();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // .setFont(new Font("DejaVu Sans", 0, 18));
        // .setBackground(new Color(255, 255, 255));
        // .setForeground(new Color(62, 62, 62));
        // .setText("");
        //=======================================================================================================

        // Next and Previous Buttons conf.
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
                  Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
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
                  Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
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
        // ======================================================================================================

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

        // Retornar daqui...
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
                  .addGap(450, 450, 450)
                  .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldNome, 390, 390, 390))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldEmail, 390, 390, 390))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jLabelTelefone_1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldTelefone_1, 390, 390, 390))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jLabelTelefone_2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldTelefone_2, 390, 390, 390)))
            // Segundo grupo
            .addGroup(jPanel1Layout.createParallelGroup()
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addGap(328, 328, 328)
                  .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldCidade, 308, 308, 308))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addGap(328, 328, 328)
                  .addComponent(jTextFieldEstado, 62, 62, 62))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jLabelWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldWebSite, 390, 390, 390))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jLabelLinkedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jTextFieldLinkedIn, 390, 390, 390))
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(450, 450, 450)
                  .addGap(30, 30, 30)
                  .addComponent(jButtonPrevious, 170, 170, 170)
                  .addGap(45, 45, 45)
                  .addComponent(jButtonNext, 170, 170, 170)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldNome, 30, 30, 30))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldEmail, 30, 30, 30))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelTelefone_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldTelefone_1, 30, 30, 30))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelTelefone_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldTelefone_2, 30, 30, 30)))
          // Segundo grupo
          .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldCidade, 30, 30, 30)
                    .addComponent(jTextFieldEstado, 30, 30, 30))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                .addComponent(jTextFieldWebSite, 30, 30, 30))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelLinkedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldLinkedIn, 30, 30, 30))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonPrevious, 60, 60, 60)
                    .addComponent(jButtonNext, 60, 60, 60)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 550 - 135 - javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        new JanelaEntradas2().setVisible(true);
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

      new JanelaTemplates().setVisible(true);
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
            java.util.logging.Logger.getLogger(JanelaEntradas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEntradas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JanelaEntradas1().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JanelaEntradas1.class.getName()).log(Level.SEVERE, null, ex);
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

    private javax.swing.JSeparator jSeparator;

    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelTelefone_1;
    private javax.swing.JLabel jLabelTelefone_2;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelWebSite;
    private javax.swing.JLabel jLabelLinkedIn;

    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldTelefone_1;
    private javax.swing.JTextField jTextFieldTelefone_2;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldWebSite;
    private javax.swing.JTextField jTextFieldLinkedIn;

    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    // End of variables declaration
}

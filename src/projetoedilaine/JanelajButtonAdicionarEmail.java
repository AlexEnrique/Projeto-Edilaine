package projetoedilaine;

import java.awt.BorderLayout;
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
 *
 * @author Alex Enrique Crispim
 */
public class JanelajButtonAdicionarEmail extends javax.swing.JFrame {
    private int x, y;
    private Timer fadeInJL3;
    private JSONObject json;

    public JanelajButtonAdicionarEmail() throws FileNotFoundException {
      this.json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("tmp\\tmp.json")
                          )
                      )
                  );
      initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        // jButtonExit = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();

        jLabelEmail = new javax.swing.JLabel();

        jTextFieldEmail = new javax.swing.JTextField();

        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criador de currículo CONTRETEC - Novo currículo");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 600, 350));
        setMaximumSize(new java.awt.Dimension(600, 350));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 350));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 350));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        // jButtonExit.setBackground(new java.awt.Color(62, 62, 62));
        // jButtonExit.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        // jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        // jButtonExit.setText("x");
        // jButtonExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        // jButtonExit.setFocusPainted(false);
        // jButtonExit.addActionListener(new java.awt.event.ActionListener() {
        //     @Override
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jButtonExitActionPerformed(evt);
        //     }
        // });
        // jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
        //     @Override
        //     public void mouseEntered(java.awt.event.MouseEvent evt) {
        //         jButtonExitMouseEntered(evt);
        //     }
        //
        //     @Override
        //     public void mouseExited(java.awt.event.MouseEvent evt) {
        //         jButtonExitMouseExited(evt);
        //     }
        // });


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

        // Labels and TextFields ===================================================================================
        jLabelEmail.setFont(new Font("DejaVu Sans", 0, 18));
        jLabelEmail.setBackground(new Color(255, 255, 255));
        jLabelEmail.setForeground(new Color(62, 62, 62));
        jLabelEmail.setText("Novo E-mail");
        // end Labels and TextFields ===============================================================================

        // Botões de adicionar e cancelar
        jButtonAdicionar.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonAdicionar.setBackground(new Color(62, 62, 62));
        jButtonAdicionar.setForeground(new Color(255, 255, 255));
        jButtonAdicionar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAdicionar.setFocusPainted(false);
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  jButtonAdicionarActionPerformed(evt);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(JanelajButtonAdicionarEmail.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonAdicionarMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonAdicionarMouseExited(evt);
          }
        });

        jButtonCancelar.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonCancelar.setBackground(new Color(62, 62, 62));
        jButtonCancelar.setForeground(new Color(255, 255, 255));
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCancelar.setFocusPainted(false);
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  jButtonCancelarActionPerformed(evt);
              } catch (IOException ex) {
                  Logger.getLogger(JanelajButtonAdicionarEmail.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonCancelarMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonCancelarMouseExited(evt);
          }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                // .addGap(1, 1, 1)
                // .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        // .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("LogoEmpresa.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                // .addGroup(jPanel1Layout.createSequentialGroup()
                //     .addGap(30, 30, 30)
                //     .addGap(91)
                //     .addComponent(jLabelDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                // .addGroup(jPanel1Layout.createSequentialGroup()
                //     .addGap(30, 30, 30)
                //     .addGap(91)
                //     .addComponent(jTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGap(15, 15, 15)
                    .addGap(91)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250 - 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGap(15, 15, 15)
                    .addGap(91)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 390 - 62 - 28 + 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGap(78, 78, 78)
                .addComponent(jButtonCancelar, 170, 170, 170)
                .addGap(45, 45, 45)
                .addComponent(jButtonAdicionar, 170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jTextFieldEmail, 30, 30, 30)
                    .addGap(39, 39, 39))
                .addGap(30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonCancelar, 60, 60, 60)
                    .addComponent(jButtonAdicionar, 60, 60, 60))
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

      // private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
      //   System.exit(0);
      // }

      private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {
        this.setExtendedState(ICONIFIED);
      }

      private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
      }

      private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
      }

      // private void jButtonExitMouseEntered(java.awt.event.MouseEvent evt) {
      //   jButtonExit.setBackground(new java.awt.Color(240, 240, 240));
      //   jButtonExit.setForeground(new java.awt.Color(62, 62, 62));
      // }
      //
      // private void jButtonExitMouseExited(java.awt.event.MouseEvent evt) {
      //   jButtonExit.setBackground(new java.awt.Color(62, 62, 62));
      //   jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
      // }

      private void jButtonMinimizeMouseEntered(java.awt.event.MouseEvent evt) {
        jButtonMinimize.setBackground(new java.awt.Color(240, 240, 240));
        jButtonMinimize.setForeground(new java.awt.Color(62, 62, 62));
      }

      private void jButtonMinimizeMouseExited(java.awt.event.MouseEvent evt) {
        jButtonMinimize.setBackground(new java.awt.Color(62, 62, 62));
        jButtonMinimize.setForeground(new java.awt.Color(255, 255, 255));
      }

       private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
         int n = 0;

         // Pegar o número de telefones registrados
         for (String name: JSONObject.getNames(json)) {
           if ("email".equals( name.substring(0, name.length() - 1) )) {
             if ( Integer.parseInt( name.substring(name.length() - 1, name.length()) ) > n ) {
               n = Integer.parseInt( name.substring(name.length() - 1, name.length()) );
             }
           }
         }

         if ("".equals(json.getString("email"))) {
           json.put("email", jTextFieldEmail.getText());

         } else {
           json.put("email" + String.valueOf(n + 1), jTextFieldEmail.getText());
         }

         try {
           WriteJSON();
         } catch (IOException ex) {
           Logger.getLogger(JanelajButtonObsVirtuais.class.getName()).log(Level.SEVERE, null, ex);
         }

         this.dispose();
       }

       private void jButtonAdicionarMouseEntered(java.awt.event.MouseEvent evt) {
         jButtonAdicionar.setBackground(new java.awt.Color(240, 240, 240));
         jButtonAdicionar.setForeground(new java.awt.Color(62, 62, 62));
       }

       private void jButtonAdicionarMouseExited(java.awt.event.MouseEvent evt) {
         jButtonAdicionar.setBackground(new java.awt.Color(62, 62, 62));
         jButtonAdicionar.setForeground(new java.awt.Color(255, 255, 255));
       }

       // Previous button
       private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
         this.dispose();
       }

       private void jButtonCancelarMouseEntered(java.awt.event.MouseEvent evt) {
         jButtonCancelar.setBackground(new java.awt.Color(240, 240, 240));
         jButtonCancelar.setForeground(new java.awt.Color(62, 62, 62));
       }

       private void jButtonCancelarMouseExited(java.awt.event.MouseEvent evt) {
         jButtonCancelar.setBackground(new java.awt.Color(62, 62, 62));
         jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
       }

       private void WriteJSON() throws IOException {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("tmp\\tmp.json"))) {
           writer.write(json.toString());
           writer.close();
         } catch (IOException ex) {
             Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
         }
       }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException{
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
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JanelajButtonAdicionarEmail().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JanelajButtonAdicionarEmail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    // private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMinimize;

    private javax.swing.JLabel jLabelEmail;

    private javax.swing.JTextField jTextFieldEmail;

    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    // End of variables declaration
}

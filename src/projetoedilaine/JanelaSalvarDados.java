package projetoedilaine;

// import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Alex Enrique Crispim
 */
public class JanelaSalvarDados extends javax.swing.JFrame {
    private int x, y;
    private JSONObject json;
    private JFrame frameToDispose;
    private JFrame thisFrame;

    public JanelaSalvarDados(JFrame _frameToDispose) {
        frameToDispose = _frameToDispose;
        thisFrame = this;

        try {
            this.json = new JSONObject(
                    new JSONTokener(
                            new BufferedReader(
                                    new FileReader("tmp\\tmp.json")
                            )
                    )
            );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaSalvarDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
    }


    public JanelaSalvarDados() {
        thisFrame = this;

        try {
            this.json = new JSONObject(
                    new JSONTokener(
                            new BufferedReader(
                                    new FileReader("tmp\\tmp.json")
                            )
                    )
            );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JanelaSalvarDados.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        jPanel1 = new javax.swing.JPanel();

        jLabelIcon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        // jLabel4 = new javax.swing.JLabel();
        // jLabel5 = new javax.swing.JLabel();
        // jLabel6 = new javax.swing.JLabel();

        jButtonSalvar = new javax.swing.JButton();
        jButtonNao = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aviso - Criador de currículo CONTRETEC");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 600, 350));
        setMaximumSize(new java.awt.Dimension(600, 350));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 350));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 350));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setForeground(new Color(62, 62, 62));
        jLabel3.setFont(new Font("DejaVu Sans", 0, 18));
        jLabel3.setText("Deseja salvar os dados deste currículo?");

        jButtonSalvar.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonSalvar.setBackground(new Color(62, 62, 62));
        jButtonSalvar.setForeground(new Color(255, 255, 255));
        jButtonSalvar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSalvar.setFocusPainted(false);
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            String filePath = null;
            JFileChooser chooser = new JFileChooser();

            chooser.setCurrentDirectory(new File("Curriculos Salvos"));

            if (chooser.showOpenDialog(thisFrame) == JFileChooser.APPROVE_OPTION) {

              File file = chooser.getSelectedFile();
              if (file == null) {
                return;
              }

              filePath = chooser.getSelectedFile().getAbsolutePath(); // String imgPath
              String saveFile;

              if (chooser.getSelectedFile().getName().contains(".json"))
                saveFile = chooser.getSelectedFile().getName();
              else
                saveFile = chooser.getSelectedFile() + ".json";

              BufferedWriter bw;
              try {
                  System.out.println(json.toString());
                  bw = new BufferedWriter(new FileWriter("Curriculos Salvos\\" + saveFile));
                  bw.write(json.toString());
                  bw.close();
              } catch (IOException ex) {
                  Logger.getLogger(JanelaSalvarDados.class.getName()).log(Level.SEVERE, null, ex);
              }


            }

              if (frameToDispose != null) {
                frameToDispose.dispose();
              }

              if (filePath != null)  {
                thisFrame.dispose();
              }

              new RenderCurriculum();

          }
        });
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonSalvarMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonSalvarMouseExited(evt);
          }
        });

        jButtonNao.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonNao.setBackground(new Color(62, 62, 62));
        jButtonNao.setForeground(new Color(255, 255, 255));
        jButtonNao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNao.setFocusPainted(false);
        jButtonNao.setText("Descartar");
        jButtonNao.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              if (frameToDispose != null)
                  frameToDispose.dispose();
              thisFrame.dispose();

              new RenderCurriculum();

          }
        });
        jButtonNao.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonNao.setBackground(new java.awt.Color(240, 240, 240));
            jButtonNao.setForeground(new java.awt.Color(62, 62, 62));
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonNao.setBackground(new java.awt.Color(62, 62, 62));
            jButtonNao.setForeground(new java.awt.Color(255, 255, 255));
          }
        });


        jButtonCancelar.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonCancelar.setBackground(new Color(62, 62, 62));
        jButtonCancelar.setForeground(new Color(255, 255, 255));
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCancelar.setFocusPainted(false);
        jButtonCancelar.setText("Canelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              thisFrame.dispose();
          }
        });
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonCancelar.setBackground(new java.awt.Color(240, 240, 240));
            jButtonCancelar.setForeground(new java.awt.Color(62, 62, 62));
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonCancelar.setBackground(new java.awt.Color(62, 62, 62));
            jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
          }
        });


        // Redimensionar imagem (icon)
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("imgs\\question.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        jLabelIcon.setIcon(new javax.swing.ImageIcon(dimg));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270)
                .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, 540, 540, 540))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap( (300-170/2) / 2 + 10)
                .addComponent(jButtonSalvar, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(jButtonNao, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
            )
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300-170/2)
                .addComponent(jButtonCancelar, 170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3, 15, 15, 15))
                .addGap(45)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addComponent(jButtonSalvar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNao, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(15)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addGap(200)
                    .addComponent(jButtonCancelar, 60, 60, 60))
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
    }

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }

       private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
         // this.dispose();
       }

       private void jButtonSalvarMouseEntered(java.awt.event.MouseEvent evt) {
         jButtonSalvar.setBackground(new java.awt.Color(240, 240, 240));
         jButtonSalvar.setForeground(new java.awt.Color(62, 62, 62));
       }

       private void jButtonSalvarMouseExited(java.awt.event.MouseEvent evt) {
         jButtonSalvar.setBackground(new java.awt.Color(62, 62, 62));
         jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
       }

       private void jButtonNaoActionPerformed(java.awt.event.MouseEvent evt) {
         if (frameToDispose != null)
            frameToDispose.dispose();
         this.dispose();
       }

       private void jButtonCancelarActionPerformed(java.awt.event.MouseEvent evt) {
         this.dispose();
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
                new JanelaSalvarDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;

    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonNao;
    private javax.swing.JButton jButtonCancelar;
    // End of variables declaration
}

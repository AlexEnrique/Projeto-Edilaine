package projetoedilaine;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Enrique Crispim
 */
public class JanelaAviso1 extends javax.swing.JFrame {
    int x, y;

    public JanelaAviso1() {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButtonOk = new javax.swing.JButton();

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
        jLabel3.setFont(new Font("DejaVu Sans", 1, 15));

        jLabel4.setBackground(new Color(255, 255, 255));
        jLabel4.setForeground(new Color(62, 62, 62));
        jLabel4.setFont(new Font("DejaVu Sans", 1, 15));

        jLabel5.setBackground(new Color(255, 255, 255));
        jLabel5.setForeground(new Color(62, 62, 62));
        jLabel5.setFont(new Font("DejaVu Sans", 1, 15));

        jLabel6.setBackground(new Color(255, 255, 255));
        jLabel6.setForeground(new Color(62, 62, 62));
        jLabel6.setFont(new Font("DejaVu Sans", 1, 15));

        jLabel3.setText(" Algumas informações são opcionais. Basta deixar os campos");
        jLabel4.setText("em brancos, caso não queira informar.");
        jLabel5.setText(" Se alguma informação não opcional não for preenchida, um");
        jLabel6.setText("aviso aparecerá informando, ao se tentar avançar de janela.");

        jButtonOk.setFont(new Font("DejaVu Sans", 0, 18));
        jButtonOk.setBackground(new Color(62, 62, 62));
        jButtonOk.setForeground(new Color(255, 255, 255));
        jButtonOk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonOk.setFocusPainted(false);
        jButtonOk.setText("Entendido");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  jButtonOkActionPerformed(evt);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(JanelaAviso1.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        });
        jButtonOk.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButtonOkMouseEntered(evt);
          }

          @Override
          public void mouseExited(java.awt.event.MouseEvent evt) {
            jButtonOkMouseExited(evt);
          }
        });

        jLabelIcon.setIcon(new javax.swing.ImageIcon("C:\\CONTRETEC\\CurriculumSoftware\\warning.png"));

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
                .addGap(30, 30, 30)
                .addComponent(jLabel4, 540, 540, 540))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, 540, 540, 540))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6, 540, 540, 540))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300-170/2)
                .addComponent(jButtonOk, 170, 170, 170))
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
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel4, 15, 15, 15))
                .addGap(20)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel5, 15, 15, 15))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel6, 15, 15, 15))
                .addGap(50)
                .addGroup(jPanel1Layout.createParallelGroup()
                    .addGap(200)
                    .addComponent(jButtonOk, 60, 60, 60))
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

       private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
         this.dispose();
       }

       private void jButtonOkMouseEntered(java.awt.event.MouseEvent evt) {
         jButtonOk.setBackground(new java.awt.Color(240, 240, 240));
         jButtonOk.setForeground(new java.awt.Color(62, 62, 62));
       }

       private void jButtonOkMouseExited(java.awt.event.MouseEvent evt) {
         jButtonOk.setBackground(new java.awt.Color(62, 62, 62));
         jButtonOk.setForeground(new java.awt.Color(255, 255, 255));
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
                new JanelaAviso1().setVisible(true);
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

    private javax.swing.JButton jButtonOk;
    // End of variables declaration
}

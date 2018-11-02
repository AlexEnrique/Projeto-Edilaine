package projetoedilaine;

// import java.awt.*;
import java.awt.BorderLayout;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex Enrique Crispim
 */
public final class WriteTemplateB {
  private JSONObject json;

  public WriteTemplateB() {
      try {
          this.json = new JSONObject(
                  new JSONTokener(
                          new BufferedReader(
                                  new FileReader("tmp\\tmp.json")
                          )
                  )
          );
      } catch (FileNotFoundException ex) {
          Logger.getLogger(WriteTemplateB.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          makeTexCode();
      } catch (IOException ex) {
          Logger.getLogger(WriteTemplateB.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public  void makeTexCode() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("CurriculumPDFs\\template3\\curriculum2.tex"))) {
          String latexCode = "";
          // Code here







          // writer.write(latexCode);
          Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CurriculumPDFs\\template3\\curriculum.tex"), "UTF-8"));
      try {
          out.write(latexCode);
      } finally {
          out.close();
      }
          writer.close();
      } catch (FileNotFoundException ex) {
        Logger.getLogger(WriteTemplateB.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(WriteTemplateB.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del tmp\\tmp.json").waitFor();
      } catch (IOException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          String[] commands = {"cmd.exe",
                              "/C",
                              "cd C:\\CONTRETEC\\CurriculumSoftware & del tmp\\tmp.json",
                              "& cd CurriculumPDFs\\template3",
                              "& Start",
                              "CurriculumPDFs\\template3\\teste.bat"
                            };

                            // Ainda não está deletando o .json
          Process p =  Runtime.getRuntime().exec(commands);

      } catch (IOException ex) {
      }

  }

  public String abreviateName(String name) {
    // Fazer essa função para a versão final

    return name;
  }

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new WriteTemplateB();
        }
    });
  }

}

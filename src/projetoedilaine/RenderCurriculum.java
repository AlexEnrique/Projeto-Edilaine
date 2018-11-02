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

public final class RenderCurriculum {
  private JSONObject json;

  public RenderCurriculum() {
      try {
          this.json = new JSONObject(
                  new JSONTokener(
                          new BufferedReader(
                                  new FileReader("tmp\\tmp.json")
                          )
                  )
          );
      } catch (FileNotFoundException ex) {
          Logger.getLogger(RenderCurriculum.class.getName()).log(Level.SEVERE, null, ex);
      }

      switch (json.getInt("template")) {
        case 1:
          new WriteTemplate1();
          break;
        case 2:
          new WriteTemplate2();
          break;
        case 3:
          new WriteTemplate3();
          break;
        // case 4:
        //   // new WriteTemplate4();
        //   break;
        // case 5:
        //   // new WriteTemplate5();
        //   break;
        // case 6:
        //   // new WriteTemplate6();
        //   break;
        // default:
        //   new WriteTemplate1();
        //   break;
      }

      // new WriteTemplate1(); // Remover ao final
  }

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new RenderCurriculum();
        }
    });
  }

}

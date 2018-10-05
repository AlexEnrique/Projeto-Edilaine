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
public final class WriteTemplate3 {
  private JSONObject json;

  public WriteTemplate3() {
      try {
          this.json = new JSONObject(
                  new JSONTokener(
                          new BufferedReader(
                                  new FileReader("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json")
                          )
                  )
          );
      } catch (FileNotFoundException ex) {
          Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          initComponents();
      } catch (IOException ex) {
          Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public  void initComponents() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\CONTRETEC\\CurriculumSoftware\\CurriculumPDFs\\template3\\curriculum2.tex"))) {
          String latexCode = "";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% LaTeX Template: Designer's CV\n";
          latexCode += "%\n";
          latexCode += "% Source: http://www.howtotex.com\n";
          latexCode += "%\n";
          latexCode += "% Feel free to distribute this example, but please keep the referral\n";
          latexCode += "% to HowToTeX.com\n";
          latexCode += "%\n";
          latexCode += "% Date: March 2012\n";
          latexCode += "%\n";
          latexCode += "% Modified by Lim Lian Tze to support multiple pages using fix provided at\n";
          latexCode += "% http://www.howtotex.com/templates/creating-a-designers-cv-in-latex/\n";
          latexCode += "% Date: November 2014\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% How to use writeLaTeX:\n";
          latexCode += "%\n";
          latexCode += "% You edit the source code here on the left, and the preview on the\n";
          latexCode += "% right shows you the result within a few seconds.\n";
          latexCode += "%\n";
          latexCode += "% Bookmark this page and share the URL with your co-authors. They can\n";
          latexCode += "% edit at the same time!\n";
          latexCode += "%\n";
          latexCode += "% You can upload figures, bibliographies, custom classes and\n";
          latexCode += "% styles using the files menu.\n";
          latexCode += "%\n";
          latexCode += "% If you're new to LaTeX, the wikibook is a great place to start:\n";
          latexCode += "% http://en.wikibooks.org/wiki/LaTeX\n";
          latexCode += "%\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% Document properties and packages\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\n";
          latexCode += "\\documentclass[a4paper,12pt,final]{memoir}\n";
          latexCode += "\n";
          latexCode += "% misc\n";
          latexCode += "\\renewcommand{\\familydefault}{bch}	% font\n";
          latexCode += "\\pagestyle{empty}					% no pagenumbering\n";
          latexCode += "\\setlength{\\parindent}{0pt}			% no paragraph indentation\n";
          latexCode += "\n";
          latexCode += "% required packages (add your own)\n";
          latexCode += "\\usepackage[utf8]{inputenc}\n";
          latexCode += "\\usepackage{amsmath}\n";
          latexCode += "\\usepackage{amsfonts}\n";
          latexCode += "\\usepackage{amssymb}\n";
          latexCode += "\\usepackage{mathtools}\n";
          latexCode += "\\usepackage[brazil]{babel}\n";
          latexCode += "\\inputencoding{latin1}\n";
          latexCode += "\\inputencoding{utf8}\n";
          latexCode += "\\usepackage{flowfram}										% column layout\n";
          latexCode += "\\usepackage[top=1cm,left=1cm,right=1cm,bottom=1cm]{geometry}% margins\n";
          latexCode += "\\usepackage{graphicx}										% figures\n";
          latexCode += "\\usepackage{url}											% URLs\n";
          latexCode += "\\usepackage[usenames,dvipsnames]{xcolor}					% color\n";
          latexCode += "\\usepackage{multicol}										% columns env.\n";
          latexCode += "	\\setlength{\\multicolsep}{0pt}\n";
          latexCode += "\\usepackage{paralist}										% compact lists\n";
          latexCode += "\\usepackage{tikz}\n";
          latexCode += "\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% Create column layout\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% define length commands\n";
          latexCode += "\\setlength{\\vcolumnsep}{\\baselineskip}\n";
          latexCode += "\\setlength{\\columnsep}{\\vcolumnsep}\n";
          latexCode += "\n";
          latexCode += "% left frame\n";
          latexCode += "\\newflowframe{0.2\\textwidth}{\\textheight}{0pt}{0pt}[left]\n";
          latexCode += "	 \\newlength{\\LeftMainSep}\n";
          latexCode +=	"  \\setlength{\\LeftMainSep}{0.2\\textwidth}\n";
          latexCode +=	"  \\addtolength{\\LeftMainSep}{1\\columnsep}\n";
          latexCode += "\n";
          latexCode += "% small static frame for the vertical line\n";
          latexCode += "\\newstaticframe{1.5pt}{\\textheight}{\\LeftMainSep}{0pt}\n";
          latexCode += "\n";
          latexCode += "% content of the static frame\n";
          latexCode += "\\begin{staticcontents}{1}\n";
          latexCode += "\\hfill\n";
          latexCode += "\\tikz{%\n";
          latexCode += " 	\\draw[loosely dotted,color=RoyalBlue,line width=1.5pt,yshift=0]\n";
          latexCode +=	"   (0,0) -- (0,\\textheight);}%\n";
          latexCode += "\\hfill\\mbox{}\n";
          latexCode += "\\end{staticcontents}\n";
          latexCode += "\n";
          latexCode += "% right frame\n";
          latexCode += "\\addtolength{\\LeftMainSep}{1.5pt}\n";
          latexCode += "\\addtolength{\\LeftMainSep}{1\\columnsep}\n";
          latexCode += "\\newflowframe{0.7\\textwidth}{\\textheight}{\\LeftMainSep}{0pt}[main01]\n";
          latexCode += "\n";
          latexCode += "\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% define macros (for convience)\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\\newcommand{\\Sep}{\\vspace{1.5em}}\n";
          latexCode += "\\newcommand{\\SmallSep}{\\vspace{0.5em}}\n";
          latexCode += "\n";
          latexCode += "\\newenvironment{AboutMe}\n";
          latexCode += "	{\\ignorespaces\\textbf{\\color{RoyalBlue} Sobre mim}}\n";
          latexCode += "	{\\Sep\\ignorespacesafterend}\n";
          latexCode += "\n";
          latexCode += "\\newcommand{\\CVSection}[1]\n";
          latexCode += "	{\\Large\\textbf{#1}\\par\n";
          latexCode += "	\\SmallSep\\normalsize\\normalfont}\n";
          latexCode += "\n";
          latexCode += "\\newcommand{\\CVItem}[1]\n";
          latexCode += "	{\\textbf{\\color{RoyalBlue} #1}}\n";
          latexCode += "\n";
          latexCode += "\n";
          latexCode += "\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% Begin document\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\\begin{document}\n";
          latexCode += "\n";
          latexCode += "% Left frame\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "%";
          latexCode += "% Upload your own photo using the files menu\n";
          latexCode += "\\begin{figure}\n";
          latexCode += "	\\hfill\n";
          latexCode += "	\\includegraphics[width=0.6\\columnwidth]{cv-photo.png}\n";
          latexCode += "	\\vspace{-7cm}\n";
          latexCode += "\\end{figure}\n";
          latexCode += "\n";
          latexCode += "\\begin{flushright}\\small\n";
          latexCode += "	" + abreviateName(json.getString("nome")) + "\\\\ \n";
          latexCode += "	\\url{" + json.getString("email") + "}  \\\\ \n";

          if ( !("").equals(json.getString("website")) )
            latexCode += "	\\url{" + json.getString("website") + "} \\\\ \n";

          if ( !("").equals(json.getString("linkedin")) )
            latexCode += "	\\url{" + json.getString("linkedin") + "} \\\\ \n";

          int numTelefones = 0;
          for (String name : JSONObject.getNames(json)) {
            if (name.substring(0, name.length() - 1).equals("DDD")) {
              numTelefones++;
            }
          }

          for (int n = 0; n < numTelefones; n++) {
            latexCode += "(" + json.getString("DDD" + String.valueOf(n + 1)) +") " + json.getString("telefone" + String.valueOf(n + 1)) + "\\\\ \n";
          }

          latexCode += "\\SmallSep\n";
          latexCode += json.getString("cidade") + ", " + json.getString("estado");

          latexCode += "\\end{flushright}\\normalsize\n";
          latexCode += "\\framebreak\n";
          latexCode += "\n";
          latexCode += "\n";
          latexCode += "\n";
          latexCode += "% Right frame\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\\Huge\\bfseries {\\color{RoyalBlue} " + json.getString("nome") + "} \\\\ \n";

          if ( !("").equals(json.getString("profissao")) ) {
            latexCode += "\\Large\\bfseries  ";
            latexCode += json.getString("profissao");
            latexCode += " \\\\ \n";
          }

          latexCode += "\n";
          latexCode += "\\normalsize\\normalfont\n";
          latexCode += "\n";
          latexCode += "% About me\n";

          if ( !("").equals(json.getString("sobreMim")) ) {
            latexCode += "\\begin{AboutMe}\n";
            latexCode += "" + json.getString("sobreMim") + "\n";
            latexCode += "\\end{AboutMe}\n";
          }

          latexCode += "\n";
          latexCode += "% Experience\n";

          int numExperiencias = 0;
          for (String name : JSONObject.getNames(json)) {
            if ( name.substring(0, name.length() - 1).equals("experienciaAnoInicio") ) {
              numExperiencias++;
            }
          }

          if (numExperiencias > 0) {
            latexCode += "\\CVSection{Experiências}\n";

            for (int n = 0; n < numExperiencias; n++) {
              latexCode += "\\CVItem{";
                  latexCode += json.getString("experienciaAnoInicio" + String.valueOf(n));
                  latexCode += " - ";
                  if ( ("").equals(json.getString("experienciaAnoFim" + String.valueOf(n))) ) {
                    latexCode += "presente";
                  } else {
                    latexCode += json.getString("experienciaAnoFim" + String.valueOf(n));
                  }
                  latexCode += ", ";
                  latexCode += json.getString("experienciaLocal" + String.valueOf(n));
              latexCode += "} \\\\ \n";

              latexCode += json.getString("experienciaDescricao" + String.valueOf(n)) + "\n";

              if (n != numExperiencias - 1) {
                latexCode += "\\SmallSep\n";
              } else {
                latexCode += "\\Sep\n";
              }

              latexCode += "\n";
            }
          }

          latexCode += "% Education\n";

          int numFormacao = 0;
          for (String name : JSONObject.getNames(json)) {
            if ( name.substring(0, name.length() - 1).equals("formacaoAnoInicio") ) {
              numFormacao++;
            }
          }

          if (numFormacao > 0) {
            latexCode += "\\CVSection{Formação Acadêmica}\n";
            for (int n = 0; n < numFormacao; n++) {
              latexCode += "\\CVItem{";
                  latexCode += json.getString("formacaoAnoInicio" + String.valueOf(n));
                  latexCode += " - ";
                  if ( ("").equals(json.getString("formacaoAnoFim" + String.valueOf(n))) ) {
                    latexCode += "presente";
                  } else {
                    latexCode += json.getString("formacaoAnoFim" + String.valueOf(n));
                  }
                  latexCode += ", ";
                  latexCode += json.getString("formacaoLocal" + String.valueOf(n));
                  latexCode += "} \\\\ \n";

              latexCode += json.getString("formacaoDescricao" + String.valueOf(n)) + "\n";

              if (n != numFormacao - 1) {
                latexCode += "\\SmallSep\n";
              } else {
                latexCode += "\\Sep\n";
              }

              latexCode += "\n";
            }
          }

          // Verificar o final da página
          // latexCode += "% You'll need these 3 lines at the end of each page!\n";
          // latexCode += "\\clearpage\n";
          // latexCode += "\\framebreak\n";
          // latexCode += "\\framebreak\n";
          latexCode += "\n";

          latexCode += "% Skills\n";

          int numHabilidades = 0;
          for (String name : JSONObject.getNames(json)) {
            if ( name.substring(0, name.length() - 1).equals("habilidadeTipo") ) {

              if (name.equals("")) {
                break;
              } else {
                numHabilidades++;
              }

            }
          }

          if (numHabilidades > 0) {
            latexCode += "\\CVSection{Habilidades}\n";

            for (int n = 0; n < numHabilidades; n++) {
              latexCode += "\\CVItem{";
                  latexCode += json.getString("habilidadeTipo" + String.valueOf(n));
                  latexCode += "}\n";
              latexCode += "\\begin{compactitem}[\\color{RoyalBlue}$\\circ$]\n";
              latexCode += 	"\\item ";
                  latexCode += json.getString("habilidadeDescricao" + String.valueOf(n));
                  latexCode += "\n";
              latexCode += "\\end{compactitem}\n";

              if (n != numHabilidades - 1) {
                latexCode += "\\SmallSep\n";
              } else {
                latexCode += "\\Sep\n";
              }

              latexCode += "\n";
            }
          }
          latexCode += "\n";
          // latexCode += "\\begin{multicols}{3}\n";
          // latexCode += "\\end{multicols}\n";

          // latexCode += "% References\n";
          // latexCode += "\\CVSection{Referências}\n";
          // latexCode += "References upon request.\n";
          // latexCode += "\n";

          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% End document\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\\end{document}\n";

          // writer.write(latexCode);
          Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\CONTRETEC\\CurriculumSoftware\\CurriculumPDFs\\template3\\curriculum.tex"), "UTF-8"));
          try {
            out.write(latexCode);
          } finally {
            out.close();
          }

          // String username = System.getProperty("user.name");
          // System.out.println(username);

          // System.out.println("__Debbug__:");
          // System.out.println("  numTelefones: " + String.valueOf(numTelefones));
          // System.out.println("  numFormacao: " + String.valueOf(numFormacao));
          // System.out.println("  numExperiencias: " + String.valueOf(numExperiencias));
          // System.out.println("  numHabilidades: " + String.valueOf(numHabilidades));

          // System.out.println("Debbug: Arquivo fonte para o currículo criado com sucesso!");
          writer.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
    }

      // String commands = "";
      // commands += "cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & ";
      // commands += "del C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json & ";
      // commands += "cmd /c cd C:\\CONTRETEC\\CurriculumSoftware\\CurriculumPDFs\\template3 & ";
      // commands += "pdflatex curriculum.tex & ";
      // commands += "del curriculum.aux curriculum.log curriculum.tex & ";
      // commands += "move curriculum.pdf C:\\Users\\Alex\\Desktop";
      // String[] shellScript = { "/bin/sh",
      //     "-c",
      //     commands
      // };

      // SaveJSONFile();
      try {
          Runtime.getRuntime().exec("cmd /c cd C:\\CONTRETEC\\CurriculumSoftware & del C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").waitFor();
      } catch (IOException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          String[] commands = {"cmd.exe",
                              "/C",
                              "cd C:\\CONTRETEC\\CurriculumSoftware & del C:\\CONTRETEC\\CurriculumSoftware\\C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json",
                              "& cd C:\\CONTRETEC\\CurriculumSoftware\\CurriculumPDFs\\template3",
                              "& Start",
                              "C:\\CONTRETEC\\CurriculumSoftware\\CurriculumPDFs\\template3\\teste.bat"
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
            new WriteTemplate3();
        }
    });
  }

}

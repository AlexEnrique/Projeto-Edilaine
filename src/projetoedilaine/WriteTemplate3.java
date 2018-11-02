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
                                  new FileReader("tmp\\tmp.json")
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
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("CurriculumPDFs\\template3\\curriculum2.tex"))) {
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

          if (json.getInt("usarFoto?")  != 0)
            latexCode += "	\\includegraphics[width=0.6\\columnwidth]{" + json.getString("caminhoFoto") + "}\n";

          latexCode += "	\\vspace{-7cm}\n";
          latexCode += "\\end{figure}\n";
          latexCode += "\n";
          latexCode += "\\begin{flushright}\\small\n";
          latexCode += "	" + abreviateName(json.getString("nome")) + "\\\\ \n";

          if (!json.getString("nascimento").isEmpty())
            latexCode += "  " + json.getString("nascimento") + "\\\\ \n";

            // Contar telefones e e-mails --> Criar função para os outros templates
            int numTelefones = 0;
            int numEmails = 0;
            for (String name : JSONObject.getNames(json)) {
              if (name.equals("email") || name.substring(0, name.length() - 1).equals("email")) {
                numEmails++;
              } else if (name.substring(0, name.length() - 1).equals("DDD") && json.getString(name).length() > 0) {
                numTelefones++;
              }
            }

          /* E-mails */
          latexCode += "\\vspace*{1.5mm} \n";
          for (int k = 0; k < numEmails; k++) {
            latexCode += "	\\url{" + json.getString("email") + "}  \\\\ \n";
          }
          // End Emails

          if ( !("").equals(json.getString("website")) )
            latexCode += "	\\url{" + json.getString("website") + "} \\\\ \n";

          latexCode += "\\vspace*{1.5mm} \n";
          if ( !("").equals(json.getString("linkedin")) )
            latexCode += "LinkedIn:	\\url{" + json.getString("linkedin") + "} \\\\ \n";
          latexCode += "\\vspace*{1.5mm} \n";

          // Telefones
          for (int k = 0; k < numTelefones; k++) {
            String strDDD = json.getString( "DDD" + String.valueOf(k + 1) );
            String strTelefone = json.getString( "telefone" + String.valueOf(k + 1) );

            if (strDDD.length() == 3) { // remove o 0
              strDDD = strDDD.substring(1);
            }

            // Ajusta traços, "-"
            if (strTelefone.length() >= 9) {
              while (strTelefone.contains("-")) {
                int index = strTelefone.indexOf("-");
                strTelefone = strTelefone.substring(0, index) + strTelefone.substring(index + 1);
              }

              while (strTelefone.contains(" ")) {
                int index = strTelefone.indexOf(" ");
                strTelefone = strTelefone.substring(0, index) + strTelefone.substring(index + 1);
              }

              if (strTelefone.length() == 9) { // começa com 9
                strTelefone = strTelefone.substring(0, 1) + "-" + strTelefone.substring(1, 5) + "-" + strTelefone.substring(5);
              } else { // não começa com 9
                strTelefone = strTelefone.substring(0, 4) + "-" + strTelefone.substring(4);
              }

            } else { // length == 8
              strTelefone = strTelefone.substring(0, 4) + "-" + strTelefone.substring(4);
            }

            // escrever...
            latexCode += "(" + strDDD + ") " + strTelefone + "\\\\ \n";
          }
          // end Telefones

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

          // Objetivos
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	OBJETIVOS PROFISSIONAIS \n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          if ( !json.getString("objetivosProfissionais").isEmpty() ) {
            latexCode += "\\CVSection{Objetivos Profissionais}\n";
            latexCode += "\n";
            latexCode += json.getString("objetivosProfissionais") + "\n";
            latexCode += "\n";
          }


          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	DEFICIÊNCIAS \n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          if (json.getString("deficiencia?").equalsIgnoreCase("sim")) {
            String questionDef[] = {"defAuditiva?", "defFala?", "defFisica?", "defIntelectualMental?", "defVisual?"};
            boolean necessidades[] = {false, false, false, false, false};
            boolean oneMatched = false;
            boolean moreThanOne = false;

            latexCode += "\\CVSection{Necessidades Especiais}\n";
            latexCode += "Sou portador de necessidades especiais";

            latexCode += "\n";
            // Contar as necessidades especiais...
            for (int k = 0; k < questionDef.length; k++) {
              if (json.getString(questionDef[k]).equalsIgnoreCase("sim")) {
                necessidades[k] = true;

                if (oneMatched) {
                  moreThanOne = true;
                }
                oneMatched = true;
              }
            }

            // frases para cada necessidade
            String frases[] = { "dificuldades auditivas",
                              "dificuldades na fala",
                              "dificuldades fisicas",
                              "dificuldades intelectuais",
                              "dificuldades visuais"
                            };

            // se Tem mais de uma necessidade
            if (moreThanOne) {
              latexCode += ", dentre as quais possuo ";

              String have[] = {"", "", "", "", ""};
              for (int k = 0; k < necessidades.length; k++) {
                if (necessidades[k]) {
                  have[k] = frases[k];
                }
              }

              Arrays.sort(have);
              for (int k = 0; k < have.length; k++) {
                if (!have[k].isEmpty() && k != necessidades.length - 1) {
                  latexCode += frases[k] + ", ";
                }

                if (k == necessidades.length - 1) {
                  latexCode += " e " + have[k] + ". ";
                }
              }

            } else { // Quando não tem mais do que uma
              latexCode += ". Possuo ";

              for (int k = 0; k < necessidades.length; k++) {
                if (necessidades[k]) {
                  latexCode += frases[k] + ". ";
                  break;
                }
              }

            }

            // se tem  auditiva
            if (necessidades[0]) {
              // Nível
              if (json.getString("defAuditivaNivel").equals("Anacusia")) {
                latexCode += "Possuo anacusia, ";
              } else {
                latexCode += "Possuo nível de deficiência auditiva ";
                latexCode += json.getString("defAuditivaNivel") + ", ";
              }

              // Tipo
              latexCode += json.getString("defAuditivaTipo") + ". ";

              // necessidades específicas
              if (json.getString("defAuditivaOralizado?").equalsIgnoreCase("sim")) {
                latexCode += "Sou oralizado. ";
              }

              if (json.getString("defAuditivaLibras?").equalsIgnoreCase("sim")) {
                latexCode += "Sou usuário de libras. ";
              }

              if (json.getString("defAuditivaInterprete?").equalsIgnoreCase("sim")) {
                latexCode += "Necessito de intérprete para comunicação. ";
              }

            }

            // Fala
            if (necessidades[1]) {
              latexCode += "Possuo ";
              latexCode += json.getString("defFalaTipo").toLowerCase();
              latexCode += ". ";
            }

            // Física
            if (necessidades[2]) {
              latexCode += "Sou portador de " + json.getString("defFisicaTipo").toLowerCase() + ". ";
            }

            // Intelectual / mental
            if (necessidades[3]) {
              boolean notYet = true;
              boolean bolLimit[] = {false, false, false, false, false, false, false, false};
              String limitacoes[] = { "comunicação",
                                      "cuidados pessoais",
                                      "habilidades sociais",
                                      "utilização de recursos da comunidade",
                                      "saúde e segurança",
                                      "habilidades acadêmicas",
                                      "lazer",
                                      "trabalho"
                                    };

              for (int k = 1; k <= 8; k++) {
                if ( json.getString("defIntelectualMentalItem" + String.valueOf(k)).equalsIgnoreCase("sim") ) {
                  if (notYet) {
                    latexCode += "Tenho certas dificuldades com ";
                    notYet = false;
                  }

                  bolLimit[k] = true;
                }
              }

              oneMatched = false;
              moreThanOne = false;
              String lim2[] = {"", "", "", "", "", "", "", ""};
              for (int k = 0; k < bolLimit.length; k++) {
                if (bolLimit[k]) {
                  lim2[k] = limitacoes[k];
                  oneMatched = true;
                }

                if (oneMatched) {
                  moreThanOne = true;
                }
              }

              Arrays.sort(lim2);

              if (oneMatched && !moreThanOne) {
                latexCode += lim2[lim2.length - 1] + ". ";
              } else {
                oneMatched = false;
                for (int k = 0; k < lim2.length; k++) {
                  if (!lim2[k].isEmpty()) {
                    if (oneMatched && k != lim2.length - 1) {
                      latexCode += ", " + lim2[k];
                    }

                    if (!oneMatched) {
                      latexCode += lim2[k] + " ";
                      oneMatched = true;
                    }
                  }

                  if (k == lim2.length - 1) {
                    latexCode += "e " + lim2[k] + ".";
                  }
                }
              }

            }
            // end intelectual/mental

            // Visual
            if (necessidades[4]) {
              if (!json.getString("defVisualTipo").isEmpty())
                latexCode += "Com relação à visão, possuo " + json.getString("defVisualTipo").toLowerCase();
              if (!json.getString("defVisualDetalhamento").isEmpty())
                latexCode += ", " + json.getString("defVisualDetalhamento") + ". ";
            }
            // end visual

            // Observações - def
            if (!json.getString("obsDeficiencias").isEmpty()) {
              latexCode += json.getString("obsDeficiencias");
            }

            latexCode += "\n";
            latexCode += "\n";
          }


          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	FORMAÇÃO ACADÊMICA \n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";

          // Contar
          int numIterFormacao = 0;
          for (String name : JSONObject.getNames(json)) {
            if (name.substring(0, name.length() - 1).equals("formacaoDescricao")) {
              numIterFormacao++;
            }
          } // Quantas foram salvas

          int numFormacoes = 0;
          for (int k = 0; k < numIterFormacao; k++) {
            if (!json.getString("formacaoDescricao" + String.valueOf(k)).isEmpty()) {
              numFormacoes++;
            }
          } // Quantas efetivamente valem

          if (numFormacoes > 0) {
            latexCode += "\\CVSection{Formação}\n";
            latexCode += "\n";

            for (int n = 0; n < numIterFormacao; n++) {
              if (!json.getString("formacaoDescricao" + String.valueOf(n)).isEmpty()) {
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

                if (n != numIterFormacao - 1) {
                  latexCode += "\\SmallSep\n";
                } else {
                  latexCode += "\\Sep\n";
                }

                latexCode += "\n";
                latexCode += "%------------------------------------------------\n";
              }
            }
          }



          latexCode += "%----------------------------------------------------------------------------------------  \n";
          latexCode += "%	HABILIDADES PROFISSIONAIS  \n";
          latexCode += "%----------------------------------------------------------------------------------------  \n";
          latexCode += "  \n";

          // Contar
          int numIterHabilidades = 0;
          for (String name : JSONObject.getNames(json)) {
            if (name.substring(0, name.length() - 1).equals("habilidadeTipo")) {
              numIterHabilidades++;
            }
          } // Quantas foram salvas

          int numHabilidades = 0;
          for (int k = 0; k < numIterHabilidades; k++) {
            if (!json.getString("habilidadeTipo" + String.valueOf(k)).isEmpty()) {
              numHabilidades++;
            }
          } // Quantas efetivamente valem

          if (numHabilidades > 0) {
            latexCode += "\\CVSection{Habilidades Profissionais}  \n";
            latexCode += "  \n";

            for (int n = 0; n < numIterHabilidades; n++) {
              if (!json.getString("habilidadeTipo" + String.valueOf(n)).isEmpty()) {
                latexCode += "\\CVItem{";
                latexCode += json.getString("habilidadeTipo" + String.valueOf(n));
                latexCode += "}\n";
                latexCode += "\\begin{compactitem}[\\color{RoyalBlue}$\\circ$]\n";
                latexCode += 	"\\item ";
                latexCode += json.getString("habilidadeDescricao" + String.valueOf(n));
                latexCode += "\n";
                latexCode += "\\end{compactitem}\n";

                if (n != numIterHabilidades - 1) {
                  latexCode += "\\SmallSep\n";
                } else {
                  latexCode += "\\Sep\n";
                }

                latexCode += "\n";
              }
            }
          }
          latexCode += "\n";


          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	EXPERIÊNCIAS PROFISSIONAIS \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          // Contar
          int numIterExperiencias = 0;
          for (String name : JSONObject.getNames(json)) {
            if (name.substring(0, name.length() - 1).equals("experienciaDescricao")) {
              numIterExperiencias++;
            }
          } // Quantas foram salvas

          int numExperiencias = 0;
          for (int k = 0; k < numIterExperiencias; k++) {
            if (!json.getString("experienciaDescricao" + String.valueOf(k)).isEmpty()) {
              numExperiencias++;
            }
          } // Quantas efetivamente valem

          if (numExperiencias > 0) {
            latexCode += "\\CVSection{Experiências}\n";
            latexCode += "\n";

            for (int n = 0; n < numIterExperiencias; n++) {
              if (!json.getString("experienciaLocal" + String.valueOf(n)).isEmpty()) {
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

                if (n != numIterExperiencias - 1) {
                  latexCode += "\\SmallSep\n";
                } else {
                  latexCode += "\\Sep\n";
                }

                latexCode += "\n";
              }
            }
          }
          latexCode += "\n";

          // Verificar o final da página
          // latexCode += "% You'll need these 3 lines at the end of each page!\n";
          // latexCode += "\\clearpage\n";
          // latexCode += "\\framebreak\n";
          // latexCode += "\\framebreak\n";


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
          Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CurriculumPDFs\\template3\\curriculum.tex"), "UTF-8"));
          try {
            out.write(latexCode);
          } finally {
            out.close();
          }


          try {
              Runtime.getRuntime().exec("cmd /c cd " + System.getProperty("user.dir") + " & del tmp\\tmp.json").waitFor();
          } catch (IOException ex) {
              Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
          }

          String[] commands = {"cmd.exe",
                               "/C",
                               "cd " + System.getProperty("user.dir") + " & del tmp\\tmp.json",
                               "& cd " + System.getProperty("user.dir") + "\\CurriculumPDFs\\template3",
                               "& Start",
                               System.getProperty("user.dir") + "\\CurriculumPDFs\\template3\\run.vbs"
                               };

          Process p =  Runtime.getRuntime().exec(commands);
          new AvisoCompilando().setVisible(true);
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

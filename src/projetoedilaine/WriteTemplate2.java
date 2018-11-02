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
public final class WriteTemplate2 {
  private JSONObject json;

  public WriteTemplate2() {
      try {
          this.json = new JSONObject(
                  new JSONTokener(
                          new BufferedReader(
                                  new FileReader("tmp\\tmp.json")
                          )
                  )
          );
      } catch (FileNotFoundException ex) {
          Logger.getLogger(WriteTemplate2.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          makeTexCode();
      } catch (IOException ex) {
          Logger.getLogger(WriteTemplate2.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public  void makeTexCode() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("CurriculumPDFs\\template2\\curriculum2.tex"))) {
          String latexCode = "";
          // Code here

          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n";
          latexCode += "% Awesome Resume/CV \n";
          latexCode += "% XeLaTeX Template \n";
          latexCode += "% Version 1.2 (27/3/2017) \n";
          latexCode += "% \n";
          latexCode += "% This template has been downloaded from: \n";
          latexCode += "% http://www.LaTeXTemplates.com \n";
          latexCode += "% \n";
          latexCode += "% Original author: \n";
          latexCode += "% Claud D. Park (posquit0.bj@gmail.com) with modifications by  \n";
          latexCode += "% Vel (vel@latextemplates.com) \n";
          latexCode += "% \n";
          latexCode += "% License: \n";
          latexCode += "% CC BY-NC-SA 3.0 (http://creativecommons.org/licenses/by-nc-sa/3.0/) \n";
          latexCode += "% \n";
          latexCode += "% Important note: \n";
          latexCode += "% This template must be compiled with XeLaTeX, the below lines will ensure this \n";
          latexCode += "%!TEX TS-program = xelatex \n";
          latexCode += "%!TEX encoding = UTF-8 Unicode \n";
          latexCode += "% \n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n";
          latexCode += " \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	PACKAGES AND OTHER DOCUMENT CONFIGURATIONS \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";
          latexCode += "\\documentclass[11pt, a4paper]{awesome-cv} % A4 paper size by default, use 'letterpaper' for US letter \n";
          latexCode += " \n";
          latexCode += "\\usepackage[utf8]{inputenc} \n";
          latexCode += "\\usepackage{amsmath} \n";
          latexCode += "\\usepackage{amsfonts} \n";
          latexCode += "\\usepackage{amssymb} \n";
          latexCode += "\\usepackage{mathtools} \n";
          latexCode += "\\usepackage[brazil]{babel} \n";
          latexCode += "\\inputencoding{latin1} \n";
          latexCode += "\\inputencoding{utf8} \n";
          latexCode += " \n";
          latexCode += "\\geometry{left=2cm, top=1.5cm, right=2cm, bottom=2cm, footskip=.5cm} % Configure page margins with geometry \n";
          latexCode += " \n";
          latexCode += "\\fontdir[fonts/] % Specify the location of the included fonts \n";
          latexCode += " \n";
          latexCode += "% Color for highlights \n";
          latexCode += "\\colorlet{awesome}{awesome-red} % Default colors include: awesome-emerald, awesome-skyblue, awesome-red, awesome-pink, awesome-orange, awesome-nephritis, awesome-concrete, awesome-darknight \n";
          latexCode += "%\\definecolor{awesome}{HTML}{CA63A8} % Uncomment if you would like to specify your own color \n";
          latexCode += " \n";
          latexCode += "% Colors for text - uncomment and modify \n";
          latexCode += "%\\definecolor{darktext}{HTML}{414141} \n";
          latexCode += "%\\definecolor{text}{HTML}{414141} \n";
          latexCode += "%\\definecolor{graytext}{HTML}{414141} \n";
          latexCode += "%\\definecolor{lighttext}{HTML}{414141} \n";
          latexCode += " \n";
          latexCode += "\\renewcommand{\\acvHeaderSocialSep}{\\quad\\textbar\\quad} % If you would like to change the social information separator from a pipe (|) to something else \n";
          latexCode += " \n";

          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	PERSONAL INFORMATION \n";
          latexCode += "%	Comment any of the lines below if they are not required \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";
          latexCode += "\\name{}{" + json.getString("nome") + "} \n";

          if (!json.getString("cidade").isEmpty()) {
            latexCode += "\\address{" + json.getString("cidade");

            if (!json.getString("estado").isEmpty())
              latexCode += ", " + json.getString("estado") + "} \n";
            else
              latexCode += "} \n";
          }

          if (!json.getString("profissao").isEmpty())
            latexCode += "\\position{" + json.getString("profissao") + "} % Your expertise/fields \n";

          // Nascimento
          if (!json.getString("nascimento").isEmpty()) {
            latexCode += "\\extrainfo{" + json.getString("nascimento") + "} % Your birthday \n";
          }

          // Telefone e e-mails - contar
          int numTelefones = 0;
          int numEmails = 0;

          for (String name : JSONObject.getNames(json)) {
            if (name.substring(0, name.length() - 1).equals("telefone")) {
              numTelefones++;
            } else if (name.equals("email") || name.substring(0, name.length() - 1).equals("email")) {
              numEmails++;
            }
          }

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
            latexCode += "\\mobile{(" + strDDD + ") " + strTelefone + "} \n";
          }
          // end Telefones
          latexCode += " \n";

          // Emails
          for (int k = 0; k < numEmails; k++) {
            if (k > 0) {
              latexCode += "\\email{" + json.getString("email" + String.valueOf(k)) + "} \n";
            } else {
              latexCode += "\\email{" + json.getString("email") + "} \n";
            }
          }
          // End Emails

          if (!json.getString("website").isEmpty())
            latexCode += "\\homepage{" + json.getString("website") + "} \n";
          if (!json.getString("linkedin").isEmpty())
            latexCode += "\\linkedin{" + json.getString("linkedin") + "} \n";

          // %\github{posquit0}
          // %\skype{skypeid}
          // %\stackoverflow{SOid}{SOname}
          // %\twitter{@twit}
          // %\linkedin{linkedin name}
          // %\reddit{reddit account}
          //
          // \quote{``Make the change that you want to see in the world."} % A quote or statement
          //

          latexCode += "\\makecvfooter{}{" + json.getString("nome") + "}{} % Specify the letter footer with 3 arguments: (<left>, <center>, <right>), leave any of these blank if they are not needed \n";
          latexCode += "\n";

          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";
          latexCode += "\\begin{document} \n";
          latexCode += " \n";
          latexCode += "\\makecvheader % Print the header \n";
          latexCode += " \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	CV/RESUME CONTENT \n";
          latexCode += "%	Each section is imported separately, open each file in turn to modify content \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";

          if (!json.getString("sobreMim").isEmpty()) {
              latexCode += " \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += "%	SOBRE MIM  \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += " \n";
              latexCode += "\\cvsection{Sobre Mim} \n";
              latexCode += " \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += "%	SECTION CONTENT \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += " \n";
              latexCode += "\\begin{cventries} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\cventry \n";
              latexCode += "{} % Degree \n";
              latexCode += "{Sobre mim} % Institution \n";
              latexCode += "{} % Location \n";
              latexCode += "{} % Date(s) \n";
              latexCode += "{ % Description(s) bullet points \n";
              latexCode += "\\begin{cvitems} \n";
              latexCode += "\\item {" + json.getString("sobreMim") + "} \n";
              latexCode += "\\end{cvitems} \n";
              latexCode += "} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\end{cventries}           \n";
              latexCode += " \n";
          }


          if (!json.getString("objetivosProfissionais").isEmpty()) {
              latexCode += " \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += "%	OBJETIVOS PROFISSIONAIS  \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += " \n";
              latexCode += "\\cvsection{Objetivos Profissionais} \n";
              latexCode += " \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += "%	SECTION CONTENT \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += " \n";
              latexCode += "\\begin{cventries} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\cventry \n";
              latexCode += "{} % Degree \n";
              latexCode += "{Objetivos} % Institution \n";
              latexCode += "{} % Location \n";
              latexCode += "{} % Date(s) \n";
              latexCode += "{ % Description(s) bullet points \n";
              latexCode += "\\begin{cvitems} \n";
              latexCode += "\\item {" + json.getString("objetivosProfissionais") + "} \n";
              latexCode += "\\end{cvitems} \n";
              latexCode += "} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\end{cventries}           \n";
              latexCode += " \n";
          }

          if (json.getString("deficiencia?").equalsIgnoreCase("sim")) {
              String questionDef[] = {"defAuditiva?", "defFala?", "defFisica?", "defIntelectualMental?", "defVisual?"};
              boolean necessidades[] = {false, false, false, false, false};
              boolean oneMatched = false;
              boolean moreThanOne = false;
              String text = "";

              latexCode += " \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += "%	DEFICIÊNCIAS  \n";
              latexCode += "%---------------------------------------------------------------------------------------- \n";
              latexCode += " \n";
              latexCode += "\\cvsection{Necessidades Especiais} \n";
              latexCode += " \n";

              // Making the def. text
              text += "Sou portador de necessidades especiais";

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
                text += ", dentre as quais possuo ";

                String have[] = {"", "", "", "", ""};
                for (int k = 0; k < necessidades.length; k++) {
                  if (necessidades[k]) {
                    have[k] = frases[k];
                  }
                }

                Arrays.sort(have);
                for (int k = 0; k < have.length; k++) {
                  if (!have[k].isEmpty() && k != necessidades.length - 1) {
                    text += frases[k] + ", ";
                  }

                  if (k == necessidades.length - 1) {
                    text += " e " + have[k] + ". ";
                  }
                }

              } else { // Quando não tem mais do que uma
                text += ". Possuo ";

                for (int k = 0; k < necessidades.length; k++) {
                  if (necessidades[k]) {
                    text += frases[k] + ". ";
                    break;
                  }
                }

              }

              // se tem  auditiva
              if (necessidades[0]) {
                // Nível
                if (json.getString("defAuditivaNivel").equals("Anacusia")) {
                  text += "Possuo anacusia, ";
                } else {
                  text += "Possuo nível de deficiência auditiva ";
                  text += json.getString("defAuditivaNivel") + ", ";
                }

                // Tipo
                text += json.getString("defAuditivaTipo") + ". ";

                // necessidades específicas
                if (json.getString("defAuditivaOralizado?").equalsIgnoreCase("sim")) {
                  text += "Sou oralizado. ";
                }

                if (json.getString("defAuditivaLibras?").equalsIgnoreCase("sim")) {
                  text += "Sou usuário de libras. ";
                }

                if (json.getString("defAuditivaInterprete?").equalsIgnoreCase("sim")) {
                  text += "Necessito de intérprete para comunicação. ";
                }

              }

              // Fala
              if (necessidades[1]) {
                text += "Possuo ";
                text += json.getString("defFalaTipo").toLowerCase();
                text += ". ";
              }

              // Física
              if (necessidades[2]) {
                text += "Sou portador de " + json.getString("defFisicaTipo").toLowerCase() + ". ";
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
                      text += "Tenho certas dificuldades com ";
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
                  text += lim2[lim2.length - 1] + ". ";
                } else {
                  oneMatched = false;
                  for (int k = 0; k < lim2.length; k++) {
                    if (!lim2[k].isEmpty()) {
                      if (oneMatched && k != lim2.length - 1) {
                        text += ", " + lim2[k];
                      }

                      if (!oneMatched) {
                        text += lim2[k] + " ";
                        oneMatched = true;
                      }
                    }

                    if (k == lim2.length - 1) {
                      text += "e " + lim2[k] + ".";
                    }
                  }
                }

              }
              // end intelectual/mental

              // Visual
              if (necessidades[4]) {
                if (!json.getString("defVisualTipo").isEmpty())
                  text += "Com relação à visão, possuo " + json.getString("defVisualTipo").toLowerCase();
                if (!json.getString("defVisualDetalhamento").isEmpty())
                  text += ", " + json.getString("defVisualDetalhamento") + ". ";
              }
              // end visual

              // Observações - def
              if (!json.getString("obsDeficiencias").isEmpty()) {
                text += json.getString("obsDeficiencias");
              }
              // end formatting text...

              // putting the text
              latexCode += " \n";
              latexCode += "\\begin{cventries} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\cventry \n";
              latexCode += "{} % Degree \n";
              latexCode += "{Necessidades especiais} % Institution \n";
              latexCode += "{} % Location \n";
              latexCode += "{} % Date(s) \n";
              latexCode += "{ % Description(s) bullet points \n";
              latexCode += "\\begin{cvitems} \n";
              latexCode += "\\item {" + text + "} \n";
              latexCode += "\\end{cvitems} \n";
              latexCode += "} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\end{cventries}           \n";
              latexCode += " \n";
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
            latexCode += "\\cvsection{Formação Acadêmica} \n";
            latexCode += "\n";

            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += "%	SECTION CONTENT \n";
            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += " \n";
            latexCode += "\\begin{cventries} \n";
            latexCode += " \n";

            for (int k = 0; k < numIterFormacao; k++) {
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
              latexCode += "\\cventry \n";
              latexCode += "{} % Degree \n";
              latexCode += "{" + json.getString("formacaoLocal" + String.valueOf(k)) + "} % Location \n";
              // latexCode += "{" + json.getString("formacaoLocal" + String.valueOf(k)) + "} % Location \n";

              latexCode += "{" + json.getString("formacaoAnoInicio" + String.valueOf(k));
              if (json.getString("formacaoAnoFim" + String.valueOf(k)).isEmpty())
                latexCode += " - presente} % Date(s) \n";
              else
                latexCode += " - " + json.getString("formacaoAnoFim" + String.valueOf(k)) + "} % Date(s) \n";

              latexCode += "{} % Degree \n";
              latexCode += "{ % Description(s) bullet points \n";
              latexCode += "\\begin{cvitems} \n";
              latexCode += "\\item {" + json.getString("formacaoDescricao" + String.valueOf(k)) + "} \n";
              latexCode += "\\end{cvitems} \n";
              latexCode += "} \n";
              latexCode += " \n";
              latexCode += "%------------------------------------------------ \n";
              latexCode += " \n";
            }

            latexCode += " \n";
            latexCode += "\\end{cventries} \n";

          }

          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	HABILIDADES PROFISSIONAIS \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";

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
            latexCode += "\\cvsection{Habilidades Profissionais} \n";
            latexCode += " \n";
            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += "%	SECTION CONTENT \n";
            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += " \n";
            latexCode += "\\begin{cventries} \n";
            latexCode += " \n";

            for (int k = 0; k < numIterHabilidades; k++) {
              if (!json.getString("habilidadeTipo" + String.valueOf(k)).isEmpty()) {
                latexCode += "%------------------------------------------------ \n";
                latexCode += " \n";
                latexCode += "\\cventry \n";
                latexCode += "{} % Degree \n";
                latexCode += "{Habilidades} % Institution \n";
                latexCode += "{} % Location \n";
                latexCode += "{} % Degree \n";
                latexCode += "{" + json.getString("habilidadeTipo" + String.valueOf(k)) + "} % Institution \n";
                latexCode += "{} % Location \n";
                latexCode += "{} % Date(s) \n";
                latexCode += "{ % Description(s) bullet points \n";
                latexCode += "\\begin{cvitems} \n";
                latexCode += "\\item {" + json.getString("habilidadeDescricao" + String.valueOf(k)) + "} \n";
                latexCode += "\\end{cvitems} \n";
                latexCode += "} \n";
                latexCode += " \n";
                latexCode += "%------------------------------------------------ \n";
                latexCode += " \n";
              }
            }

            latexCode += "\\end{cventries} \n";
          }


          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "%	EXPERIÊNCIAS PROFISSIONAIS \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += "\n";

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
            latexCode += "\\cvsection{Experiências Profissionais} \n";
            latexCode += "\n";

            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += "%	SECTION CONTENT \n";
            latexCode += "%---------------------------------------------------------------------------------------- \n";
            latexCode += " \n";
            latexCode += "\\begin{cventries} \n";
            latexCode += " \n";

            for (int k = 0; k < numExperiencias; k++) {
              if (!json.getString("experienciaLocal" + String.valueOf(k)).isEmpty()) {
                latexCode += "%------------------------------------------------ \n";
                latexCode += " \n";
                latexCode += "\\cventry \n";
                latexCode += "{} % Degree \n";
                latexCode += "{" + json.getString("experienciaLocal" + String.valueOf(k)) + "} % Institution \n";
                latexCode += "{} % Location \n";

                latexCode += "{" + json.getString("experienciaAnoInicio" + String.valueOf(k));
                if (json.getString("experienciaAnoFim" + String.valueOf(k)).isEmpty())
                  latexCode += " - presente} % Date(s) \n";
                else
                  latexCode += " - " + json.getString("experienciaAnoFim" + String.valueOf(k)) + "} % Date(s) \n";

                latexCode += "{ % Description(s) bullet points \n";
                latexCode += "\\begin{cvitems} \n";
                latexCode += "\\item {" + json.getString("experienciaDescricao" + String.valueOf(k)) + "} \n";
                latexCode += "\\end{cvitems} \n";
                latexCode += "} \n";
                latexCode += " \n";
                latexCode += "%------------------------------------------------ \n";
                latexCode += " \n";
              }
            }

            latexCode += " \n";
            latexCode += "\\end{cventries} \n";
          }

          // End document...
          latexCode += " \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";
          latexCode += "\\end{document} \n";

          // writer.write(latexCode);
          Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CurriculumPDFs\\template2\\curriculum.tex"), "UTF-8"));
          try {
              out.write(latexCode);
          } finally {
              out.close();
          }
              writer.close();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(WriteTemplate2.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(WriteTemplate2.class.getName()).log(Level.SEVERE, null, ex);
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
                              "& cd " + System.getProperty("user.dir") + "\\CurriculumPDFs\\template2",
                              "& Start",
                              System.getProperty("user.dir") + "\\CurriculumPDFs\\template2\\run.vbs"
                            };

          Process p =  Runtime.getRuntime().exec(commands);
          new AvisoCompilando().setVisible(true);

  }

  public String abreviateName(String name) {
    // Fazer essa função para a versão final

    return name;
  }

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new WriteTemplate2();
        }
    });
  }

}

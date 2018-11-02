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
public final class WriteTemplate1 {
  private JSONObject json;

  public WriteTemplate1() {
      try {
          this.json = new JSONObject(
                  new JSONTokener(
                          new BufferedReader(
                                  new FileReader("tmp\\tmp.json")
                          )
                  )
          );
      } catch (FileNotFoundException ex) {
          Logger.getLogger(WriteTemplate1.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
          makeTexCode();
      } catch (IOException ex) {
          Logger.getLogger(WriteTemplate1.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public  void makeTexCode() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("CurriculumPDFs\\template1\\curriculum2.tex"))) {
          String latexCode = "";

          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "% XeLaTeX Template\n";
          latexCode += "%\n";
          latexCode += "% This template has been downloaded from:\n";
          latexCode += "% http://www.LaTeXTemplates.com\n";
          latexCode += "%\n";
          latexCode += "% Original author:\n";
          latexCode += "% Howard Wilson (https://github.com/watsonbox/cv_template_2004) with\n";
          latexCode += "% extensive modifications by Vel (vel@latextemplates.com)\n";
          latexCode += "%\n";
          latexCode += "% License:\n";
          latexCode += "% CC BY-NC-SA 3.0 (http://creativecommons.org/licenses/by-nc-sa/3.0/)\n";
          latexCode += "%\n";
          latexCode += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
          latexCode += "\n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	PACKAGES AND OTHER DOCUMENT CONFIGURATIONS\n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          latexCode += "\\documentclass[10pt]{article} % Default font size\n";
          latexCode += "\n";
          latexCode += "\\input{structure.tex} % Include the file specifying document layout\n";
          latexCode += "\n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          latexCode += "\\begin{document}\n";
          latexCode += "\n";

          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	NAME AND CONTACT INFORMATION\n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          latexCode += "\\title{" + json.getString("nome") + ((json.getString("profissao").length() > 0) ? " -- "+json.getString("profissao") : "") + "} % Print the main header\n";
          latexCode += "\n";
          latexCode += "%------------------------------------------------\n";
          latexCode += "\n";
          latexCode += "\\parbox{0.5\\textwidth}{ % First block\n";
          latexCode += "\\begin{tabbing} % Enables tabbing\n";
          latexCode += "\\hspace{3cm} \\= \\hspace{4cm} \\= \\kill % Spacing within the block\n";

          if (!json.getString("nascimento").isEmpty()) {
            latexCode += "{\\bf Nascimento} \\> " + json.getString("nascimento");
            latexCode += "\\\\";
          }

          if (json.getString("cidade").length() > 0) {
            latexCode += "{\\bf Endereço} \\> " + json.getString("cidade");

            if (json.getString("estado").length() > 0) {
              latexCode += ", " + json.getString("estado");
            }

            latexCode += "\\\\ % Address line 1\n";
          }

          if (json.getString("website").length() > 0) {
            latexCode += "{\\bf Website} \\> " + json.getString("website") + " \\\\ % Website \n";
          }

          if (json.getString("linkedin").length() > 0) {
            latexCode += "{\\bf LinkedIn} \\> " + json.getString("linkedin") + " \\\\ % LinkedIn \n";
          }

          latexCode += "\\end{tabbing}}\n";
          latexCode += "\\hfill % Horizontal space between the two blocks\n";
          latexCode += "\\parbox{0.5\\textwidth}{ % Second block\n";
          latexCode += "\\begin{tabbing} % Enables tabbing\n";
          latexCode += "\\hspace{3cm} \\= \\hspace{4cm} \\= \\kill % Spacing within the block\n";

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

          // Telefones
          for (int k = 0; k < numTelefones; k++) {
            String strDDD = json.getString( "DDD" + String.valueOf(k + 1) );
            String strTelefone = json.getString( "telefone" + String.valueOf(k + 1) );

            if (strDDD.length() == 3) { // remove o 0
              strDDD = strDDD.substring(1);
            }

            // Ajusta traços, "-"
            if (strTelefone.length() >= 9) { // Remover traços
              while (strTelefone.contains("-")) {
                int index = strTelefone.indexOf("-");
                strTelefone = strTelefone.substring(0, index) + strTelefone.substring(index + 1);
              }

              while (strTelefone.contains(" ")) { // remover possíveis espaços
                int index = strTelefone.indexOf(" ");
                strTelefone = strTelefone.substring(0, index) + strTelefone.substring(index + 1);
              }

              if (strTelefone.length() == 9) { // começa com 9
                strTelefone = strTelefone.substring(0, 1) + "-" + strTelefone.substring(1, 5) + "-" + strTelefone.substring(5);
              } else { // não começa com 9
                strTelefone = strTelefone.substring(0, 4) + "-" + strTelefone.substring(4);
              }

            } else { // length == 8 => digitado sem traços ou espaços
              strTelefone = strTelefone.substring(0, 4) + "-" + strTelefone.substring(4);
            }

            // escrever...
            latexCode += "{\\bf Telefone " + String.valueOf(k + 1) + " } \\> (" + strDDD + ") " + strTelefone + " \\\\ % phone\n";
          }
          // end Telefones

          // Emails
          for (int k = 0; k < numEmails; k++) {
            if (k > 0) {
              latexCode += "{\\bf E-mail " + String.valueOf(k + 1) + "} \\> " + json.getString("email" + String.valueOf(k)) + " \\\\ % E-mails \n";
            } else if (numEmails > 1) {
              latexCode += "{\\bf E-mail 1} \\> " + json.getString("email") + " \\\\ % E-mails \n";
            } else {
              latexCode += "{\\bf E-mail} \\> " + json.getString("email") + " \\\\ % E-mail \n";
            }
          }
          // End Emails

          latexCode += "\\end{tabbing}}\n";
          latexCode += "\n";

          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	SOBRE MIM \n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          if ( !json.getString("sobreMim").isEmpty() ) {
            latexCode += "\\section{Sobre Mim}\n";
            latexCode += "\n";
            latexCode += json.getString("sobreMim") + "\n";
            latexCode += "\n";
          }

          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "%	OBJETIVOS PROFISSIONAIS \n";
          latexCode += "%----------------------------------------------------------------------------------------\n";
          latexCode += "\n";
          if ( !json.getString("objetivosProfissionais").isEmpty() ) {
            latexCode += "\\section{Objetivos Profissionais}\n";
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

            latexCode += "\\section{Necessidades Especiais}\n";
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
            latexCode += "\\section{Formação}\n";
            latexCode += "\n";

            for (int k = 0; k < numIterFormacao; k++) {
              if (!json.getString("formacaoDescricao" + String.valueOf(k)).isEmpty()) {
                latexCode += "\\tabbedblock{\n";

                latexCode += "\\bf{" + json.getString("formacaoAnoInicio" + String.valueOf(k));
                if (!json.getString("formacaoAnoInicio" + String.valueOf(k)).isEmpty()) {
                  latexCode += "-}";
                  if (!json.getString("formacaoAnoFim" + String.valueOf(k)).isEmpty())
                    latexCode += "{" + json.getString("formacaoAnoFim" + String.valueOf(k)) + "}";
                  else
                    latexCode += "\\\\ \\bf{presente}";
                  latexCode += " \\> \\bf{" + json.getString("formacaoLocal" + String.valueOf(k)) + "}  \\\\[5pt]\n";
                }

                latexCode += "\\> \\+ \n";
                latexCode += "\\ \\ \\ " + json.getString("formacaoDescricao" + String.valueOf(k)) + " \\\\  \n";
                latexCode += "\\>\\+ \n";
                latexCode += "}\n";
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
            latexCode += "\\section{Habilidades Profissionais}  \n";
            latexCode += "  \n";

            for (int k = 0; k < numIterHabilidades; k++) {
              if (!json.getString("habilidadeTipo" + String.valueOf(k)).isEmpty()) {
                latexCode += "\\tabbedblock{  \n";
                latexCode += "\\> $\\bullet$ \\textbf{" + json.getString("habilidadeTipo" + String.valueOf(k)) + "}  \\\\[5pt]  \n";
                latexCode += "\\>\\+  \n";
                latexCode += "\\ \\ \\ \\ " + json.getString("habilidadeDescricao" + String.valueOf(k)) + " \\\\ \n";
                latexCode += "}  \n";
                latexCode += "  \n";
                latexCode += "%------------------------------------------------  \n";
                latexCode += "  \n";
              }
            }
          }

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
            latexCode += "\\section{Experiências Profissionais}  \n";
            latexCode += "\n";
            for (int k = 0; k < numIterExperiencias; k++) {
              if (!json.getString("experienciaLocal" + String.valueOf(k)).isEmpty()) {
                  latexCode += "\\tabbedblock{ \n"; // bloco

                  latexCode += "\\bf{" + json.getString("experienciaAnoInicio" + String.valueOf(k));
                  if (!json.getString("experienciaAnoInicio" + String.valueOf(k)).isEmpty()) {
                    latexCode += "-";
                    latexCode += "}";
                    if (json.getString("experienciaAnoFim" + String.valueOf(k)).isEmpty())
                      latexCode += "\\\\ \\bf{presente} ";
                    else
                      latexCode += "{" + json.getString("experienciaAnoFim" + String.valueOf(k)) + "} ";
                  } else {
                      latexCode += "{} ";
                  }

                  latexCode += "\\> \\bf{" + json.getString("experienciaLocal" + String.valueOf(k)) + "}  \\\\[5pt] \n";

                  latexCode += "\\>\\+ \n";
                  latexCode += "\\ \\ \\ " + json.getString("experienciaDescricao" + String.valueOf(k)) + " \n";
                  latexCode += "} \n";
                  latexCode += " \n";
                  latexCode += "%------------------------------------------------ \n";
                  latexCode += " \n";
              }
            }
          }

          latexCode += " \n";
          latexCode += "%---------------------------------------------------------------------------------------- \n";
          latexCode += " \n";
          latexCode += "\\end{document} \n";

          // TeX code finished

          // writer.write(latexCode);
          Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CurriculumPDFs\\template1\\curriculum.tex"), "UTF-8"));
          try {
              out.write(latexCode);
          } finally {
              out.close();
          }
              writer.close();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(WriteTemplate1.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(WriteTemplate1.class.getName()).log(Level.SEVERE, null, ex);
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
                              "& cd " + System.getProperty("user.dir") + "\\CurriculumPDFs\\template1",
                              "& Start",
                              System.getProperty("user.dir") + "\\CurriculumPDFs\\template1\\run.vbs"
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
            new WriteTemplate1();
        }
    });
  }

}

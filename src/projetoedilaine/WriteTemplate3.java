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
import java.io.FileNotFoundException;
import java.io.IOException;

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
                                  new FileReader("tmp.json")
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
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mainCV.tex"))) {
      writer.write(""
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% LaTeX Template: Designer's CV\n"
          + "%\n"
          + "% Source: http://www.howtotex.com\n"
          + "%\n"
          + "% Feel free to distribute this example, but please keep the referral\n"
          + "% to HowToTeX.com\n"
          + "%\n"
          + "% Date: March 2012\n"
          + "%\n"
          + "% Modified by Lim Lian Tze to support multiple pages using fix provided at\n"
          + "% http://www.howtotex.com/templates/creating-a-designers-cv-in-latex/\n"
          + "% Date: November 2014\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% How to use writeLaTeX:\n"
          + "%\n"
          + "% You edit the source code here on the left, and the preview on the\n"
          + "% right shows you the result within a few seconds.\n"
          + "%\n"
          + "% Bookmark this page and share the URL with your co-authors. They can\n"
          + "% edit at the same time!\n"
          + "%\n"
          + "% You can upload figures, bibliographies, custom classes and\n"
          + "% styles using the files menu.\n"
          + "%\n"
          + "% If you're new to LaTeX, the wikibook is a great place to start:\n"
          + "% http://en.wikibooks.org/wiki/LaTeX\n"
          + "%\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% Document properties and packages\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "\n"
          + "\\documentclass[a4paper,12pt,final]{memoir}\n"
          + "\n"
          + "% misc\n"
          + "\\renewcommand{\\familydefault}{bch}	% font\n"
          + "\\pagestyle{empty}					% no pagenumbering\n"
          + "\\setlength{\\parindent}{0pt}			% no paragraph indentation\n"
          + "\n"
          + "% required packages (add your own)\n"
          + "\\usepackage{flowfram}										% column layout\n"
          + "\\usepackage[top=1cm,left=1cm,right=1cm,bottom=1cm]{geometry}% margins\n"
          + "\\usepackage{graphicx}										% figures\n"
          + "\\usepackage{url}											% URLs\n"
          + "\\usepackage[usenames,dvipsnames]{xcolor}					% color\n"
          + "\\usepackage{multicol}										% columns env.\n"
          + "	\\setlength{\\multicolsep}{0pt}\n"
          + "\\usepackage{paralist}										% compact lists\n"
          + "\\usepackage{tikz}\n"
          + "\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% Create column layout\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% define length commands\n"
          + "\\setlength{\\vcolumnsep}{\\baselineskip}\n"
          + "\\setlength{\\columnsep}{\\vcolumnsep}\n"
          + "\n"
          + "% left frame\n"
          + "\\newflowframe{0.2\\textwidth}{\\textheight}{0pt}{0pt}[left]\n"
          + "	 \\newlength{\\LeftMainSep}\n"
          +	"  \\setlength{\\LeftMainSep}{0.2\\textwidth}\n"
          +	"  \\addtolength{\\LeftMainSep}{1\\columnsep}\n"
          + "\n"
          + "% small static frame for the vertical line\n"
          + "\\newstaticframe{1.5pt}{\\textheight}{\\LeftMainSep}{0pt}\n"
          + "\n"
          + "% content of the static frame\n"
          + "\\begin{staticcontents}{1}\n"
          + "\\hfill\n"
          + "\\tikz{%\n"
          + " 	\\draw[loosely dotted,color=RoyalBlue,line width=1.5pt,yshift=0]\n"
          +	"   (0,0) -- (0,\\textheight);}%\n"
          + "\\hfill\\mbox{}\n"
          + "\\end{staticcontents}\n"
          + "\n"
          + "% right frame\n"
          + "\\addtolength{\\LeftMainSep}{1.5pt}\n"
          + "\\addtolength{\\LeftMainSep}{1\\columnsep}\n"
          + "\\newflowframe{0.7\\textwidth}{\\textheight}{\\LeftMainSep}{0pt}[main01]\n"
          + "\n"
          + "\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% define macros (for convience)\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "\\newcommand{\\Sep}{\\vspace{1.5em}}\n"
          + "\\newcommand{\\SmallSep}{\\vspace{0.5em}}\n"
          + "\n"
          + "\\newenvironment{AboutMe}\n"
          + "	{\\ignorespaces\\textbf{\\color{RoyalBlue} About me}}\n"
          + "	{\\Sep\\ignorespacesafterend}\n"
          + "\n"
          + "\\newcommand{\\CVSection}[1]\n"
          + "	{\\Large\\textbf{#1}\\par\n"
          + "	\\SmallSep\\normalsize\\normalfont}\n"
          + "\n"
          + "\\newcommand{\\CVItem}[1]\n"
          + "	{\\textbf{\\color{RoyalBlue} #1}}\n"
          + "\n"
          + "\n"
          + "\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% Begin document\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "\\begin{document}\n"
          + "\n"
          + "% Left frame\n"
          + "%%%%%%%%%%%%%%%%%%%%\n"
          + "%"
          + "% Upload your own photo using the files menu\n"
          + "\\begin{figure}\n"
          + "	\\hfill\n"
          + "	\\includegraphics[width=0.6\\columnwidth]{cv-photo.png}\n"
          + "	\\vspace{-7cm}\n"
          + "\\end{figure}\n"
          + "\n"
          + "\\begin{flushright}\\small\n"
          + "	" + json.getString("nome") + "\\\\ \n"
          + "	\\url{" + json.getString("email") + "}  \\\\ \n"
          + "	\\url{" + json.getString("website") + "} \\\\ \n"
          + "	(" + json.getString("DDD1") +") " + json.getString("telefone1") + "\n"
          + "\\end{flushright}\\normalsize\n"
          + "\\framebreak\n"
          + "\n"
          + "\n"
          + "\n"
          + "% Right frame\n"
          + "%%%%%%%%%%%%%%%%%%%%\n"
          + "\\Huge\\bfseries {\\color{RoyalBlue} " + json.getString("nome") + "} \\\\ \n"
          + "\\Large\\bfseries  " + json.getString("profissao") + " \\\\ \n"
          + "\n"
          + "\\normalsize\\normalfont\n"
          + "\n"
          + "% About me\n"
          + "\\begin{AboutMe}\n"
          + "" + json.getString("sobreMim") + "\n"
          + "\\end{AboutMe}\n"
          + "\n"
          + "% Experience\n"
          + "\\CVSection{Experience}\n"
          + "\\CVItem{May 2010 - present, Lorem ipsum} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus. Proin rutrum pharetra molestie. Cras sollicitudin nulla nec leo lobortis in tristique purus pretium. Ut eu felis nulla.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Aug 2007 - Feb 2010, Vivamus vel} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Apr 2005 - Jul 2007, Lorem ipsum} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus. Proin rutrum pharetra molestie. Cras sollicitudin nulla nec leo lobortis in tristique purus pretium. Ut eu felis nulla.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Jan 2005 - Mar 2005, Vivamus vel} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Jan 2004 - Dec 2004, Lorem ipsum} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus. Proin rutrum pharetra molestie. Cras sollicitudin nulla nec leo lobortis in tristique purus pretium. Ut eu felis nulla.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Jan 2002 - Nov 2003, Vivamus vel} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{May 1998 - Nov 2001, Lorem ipsum} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus. Proin rutrum pharetra molestie. Cras sollicitudin nulla nec leo lobortis in tristique purus pretium. Ut eu felis nulla.\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Jun 1995 - Apr 1998, Vivamus vel} \\\\ \n"
          + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel bibendum metus.\n"
          + "\n"
          + "\\Sep\n"
          + "\n"
          + "% Education\n"
          + "\\CVSection{Education}\n"
          + "\\CVItem{2010 - present, Lorem ipsum dolor} \\\\ \n"
          + "MSc. Lorem ipsum, Cras sollicitudin\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{2007 - 2010, Lorem ipsum dolor} \\\\ \n"
          + "MSc. Lorem ipsum, Cras sollicitudin\n"
          + "\\SmallSep\n"
          + "\n"
          + "% You'll need these 3 lines at the end of each page!\n"
          + "\\clearpage\n"
          + "\\framebreak\n"
          + "\\framebreak\n"
          + "\n"
          + "\\CVItem{2005 - 2007, Vivamus vel bibendum} \\\\ \n"
          + "Proin rutrum pharetra molestie. Cras sollicitudin nulla nec leo lobortis in tristique purus pretium. Ut eu felis nulla.\n"
          + "\\Sep\n"
          + "\n"
          + "\n"
          + "% Skills\n"
          + "\\CVSection{Skills}\n"
          + "\\CVItem{Platforms}\n"
          + "\\begin{multicols}{3}\n"
          + "\\begin{compactitem}[\\color{RoyalBlue}$\\circ$]\n"
          + 	"\\item Lorem\n"
          + 	"\\item Ipsum\n"
          + "\\end{compactitem}\n"
          + "\\end{multicols}\n"
          + "\\SmallSep\n"
          + "\n"
          + "\\CVItem{Computer software}\n"
          + "\\begin{multicols}{3}\n"
          + "\\begin{compactitem}[\\color{RoyalBlue}$\\circ$]\n"
          + 	"\\item Lorem\n"
          + 	"\\item Ipsum\n"
          + 	"\\item Dolor\n"
          + 	"\\item Sit\n"
          + 	"\\item Amet\n"
          + 	"\\item Consectetur\n"
          + 	"\\item Adipiscing\n"
          + 	"\\item Elit\n"
          + 	"\\item \\ldots\n"
          + "\\end{compactitem}\n"
          + "\\end{multicols}\n"
          + "\\Sep\n"
          + "\n"
          + "% References\n"
          + "\\CVSection{References}\n"
          + "References upon request.\n"
          + "\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "% End document\n"
          + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
          + "\\end{document}\n"
      );

      // System.out.println("Debbug: Arquivo fonte para o currículo criado com sucesso!");
      writer.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(WriteTemplate3.class.getName()).log(Level.SEVERE, null, ex);
    }
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

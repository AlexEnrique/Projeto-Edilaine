package projetoedilaine;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.json.JSONTokener;

public class ProjetoEdilaine {
    /**
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JSONObject json;

        if (new File("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").exists()) {
          json = new JSONObject(
                      new JSONTokener(
                          new BufferedReader(
                              new FileReader("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json")
                          )
                      )
                  );

        } else {
          json = new JSONObject()
                .put("janela", 0)
                .put("nome", "")
                .put("template", 0)
                .put("email", "")
                .put("profissao", "")
                .put("DDD1", "")
                .put("DDD2", "")
                .put("telefone1", "")
                .put("telefone2", "")
                .put("cidade", "")
                .put("estado", "")
                .put("obsEndereco", "") // Observações sobre o endereço         // NÃO UTILIZADO ATÉ O MOMENTO
                .put("obsVirtuais", "") // Observações sobre endereços virtuais // NÃO UTILIZADO ATÉ O MOMENTO
                .put("website", "")
                .put("linkedin", "")
                .put("sobreMim", "")
                .put("deficiencia?", "não") // AINDA NÃO UTILIZADO
                .put("defAuditiva?", "")
                .put("defAuditivaNivel", "")
                .put("defAuditivaTipo", "")
                .put("defAuditivaOralizado?", "")
                .put("defAuditivaLibras?", "")
                .put("defAuditivaInterprete?", "")
                .put("defFala?", "")
                .put("defFalaTipo", "")
                .put("defFisica?", "")
                .put("defFisicaTipo", "")
                .put("defIntelectualMental?", "")
                .put("defIntelectualMentalItem1", "")
                .put("defIntelectualMentalItem2", "")
                .put("defIntelectualMentalItem3", "")
                .put("defIntelectualMentalItem4", "")
                .put("defIntelectualMentalItem5", "")
                .put("defIntelectualMentalItem6", "")
                .put("defIntelectualMentalItem7", "")
                .put("defIntelectualMentalItem8", "")
                .put("defVisual?", "")
                .put("defVisualTipo", "")
                .put("defVisualDetalhamento", "")
                .put("obsDeficiencias", "")
                .put("formacaoAnoInicio0", "")
                .put("formacaoAnoFim0", "")
                .put("formacaoLocal0", "")
                .put("formacaoDescricao0", "")
                .put("experienciaAnoInicio0", "")
                .put("experienciaAnoFim0", "")
                .put("experienciaLocal0", "")
                .put("experienciaDescricao0", "")
                .put("habilidadeTipo0", "")
                .put("habilidadeDescricao0", "")
                .put("novaSecaoNome0", "")
                .put("novaSecaoNomeSubsecao?0", 0)
                .put("novaSecaoNomeSubsecao0", "")
                .put("novaSecaoData?0", 0)
                .put("novaSecaoData0", "")
                .put("novaSecaoDataInicioFim?0", 0)
                .put("novaSecaoDataInicio0", "")
                .put("novaSecaoDataFim0", "")
                .put("novaSecaoLocal?0", 0)
                .put("novaSecaoLocal0", "")
                .put("novaSecaoDescricao?0", 0)
                .put("novaSecaoDescricao0", "")
                .put("novaSecaoTopicos?0", 0)
                .put("novaSecaoTopicos0", "")
                .put("objetivosProfissionais", "")
                .put("usarFoto?", 0) // 0 para não e 1 para sim
                .put("caminhoFoto", "C:\\CONTRETEC\\CurriculumSoftware\\imgs\\no-photo.jpg");

          new FileWriter("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json").close(); // Criar novo arquivo
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\CONTRETEC\\CurriculumSoftware\\tmp\\tmp.json"))) {
          writer.write(json.toString());
          writer.close();
        } catch (IOException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (json.getInt("janela")) {
          case 1: new JanelaEntradas1().setVisible(true);
                  break;

          case 6: new JanelaEntradas6().setVisible(true);
                  break;

          case 7: new JanelaEntradas7().setVisible(true);
                  break;

          case 8: new JanelaEntradas8().setVisible(true);
                  break;

          case 9: new JanelaNovasSecoes().setVisible(true);
                  break;

          case 10: new JanelaFoto().setVisible(true);
                   break;

          case 11: new JanelaConfirmarAlterarDados1().setVisible(true);
                   break;

          default: new Janela0().setVisible(true);
                   break;
        }

        // new Janela0().setVisible(true);
        // new JanelaEntradas1().setVisible(true);
        // new JanelaEntradas2().setVisible(true);
        // new JanelaEntradas3().setVisible(true);
        // new JanelaEntradas4().setVisible(true);
        // new JanelaEntradas5().setVisible(true);
        // new JanelaEntradas6().setVisible(true);
        // new JanelaEntradas7().setVisible(true);
        // new JanelaTemplates().setVisible(true);
        // new JanelaCriarJSON().setVisible(true);
    }
}

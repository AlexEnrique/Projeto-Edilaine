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

        json = new JSONObject()
                          .put("nome", "")
                          .put("template", 0)
                          .put("email", "")
                          .put("DDD1", "")
                          .put("DDD2", "")
                          .put("telefone1", "")
                          .put("telefone2", "")
                          .put("cidade", "")
                          .put("estado", "")
                          .put("obsEndereco", "") // Observações sobre o endereço
                          .put("obsVirtuais", "") // Observações sobre endereços virtuais
                          .put("website", "")
                          .put("linkedin", "")
                          .put("sobreMim", "")
                          .put("deficiencia?", "nao")
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
                          .put("formacaoAnoInicio1", "")
                          .put("formacaoAnoFim1", "")
                          .put("formacaoLocal1", "")
                          .put("formacaoDescricao1", "")
                          .put("objetivosProfissionais", "");

        new FileWriter("tmp.json").close(); // Criar novo arquivo

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tmp.json"))) {
          writer.write(json.toString());
          writer.close();
        } catch (IOException ex) {
          Logger.getLogger(Janela0.class.getName()).log(Level.SEVERE, null, ex);
        }

        // new Janela0().setVisible(true);
        // new JanelaEntradas1().setVisible(true);
        // new JanelaEntradas2().setVisible(true);
        // new JanelaEntradas3().setVisible(true);
        // new JanelaEntradas4().setVisible(true);
        // new JanelaEntradas5().setVisible(true);
        new JanelaEntradas6().setVisible(true);
        // new JanelaEntradas7().setVisible(true);
        // new JanelaTemplates().setVisible(true);
        // new JanelaCriarJSON().setVisible(true);
    }
}

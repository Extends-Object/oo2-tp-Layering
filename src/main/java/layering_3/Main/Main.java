package layering_3.Main;

import layering_3.MODEL.*;
import layering_3.UI.RadioCompetition;

import javax.swing.SwingUtilities;

public class Main {
        public static void main(String[] args) {

            String rutaArchivoConcurso = "src/main/java/layering_3/Concursos";
            String rutaArchivoInscriptos = "src/main/java/layering_3/Inscriptos";

            IApi api = new DefaultApi(rutaArchivoConcurso, rutaArchivoInscriptos);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new Main().start(api);
                    } catch (Exception e) {
                            // log exception...
                        System.out.println(e);
                    }
                }
            });
        }


        private void start(IApi api) {
            RadioCompetition radioCompetition = new RadioCompetition(api);
        }

}
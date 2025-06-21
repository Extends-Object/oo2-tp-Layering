//package layering_3.Main;
//
//import layering_2.MODEL.formateador.Formateador;
//import layering_3.DATABASE.PersistenciaConcurso;
//import layering_3.DATABASE.PersistenciaConcursoApi;
//import layering_3.DATABASE.PersistenciaInscriptos;
//import layering_3.DATABASE.PersistenciaInscriptosApi;
//import layering_3.MODEL.*;
//import layering_3.UI.RadioCompetition;
//
//import javax.swing.SwingUtilities;
//
//public class Main {
//        public static void main(String[] args) {
//
//            String rutaArchivoConcurso = "src/main/java/layering_3/Concursos";
//            String rutaArchivoInscriptos = "src/main/java/layering_3/Inscriptos";
//            Formateador formateadorConcurso = new FormateadorConcurso();
//            Formateador<Inscripcion> formateadorInscripcion = new FormateadorInscripto();
//
//            PersistenciaConcursoApi gestionConcursos = new PersistenciaConcurso(rutaArchivoConcurso, formateadorConcurso);
//            PersistenciaInscriptosApi gestionInscriptos = new PersistenciaInscriptos(rutaArchivoInscriptos, formateadorInscripcion);
//
//            IApi api = new DefaultApi(gestionConcursos, gestionInscriptos);
//
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        new Main().start(api);
//                    } catch (Exception e) {
//                            // log exception...
//                        System.out.println(e);
//                    }
//                }
//            });
//        }
//
//
//        private void start(IApi api) {
//            RadioCompetition radioCompetition = new RadioCompetition(api);
//        }
//
//}
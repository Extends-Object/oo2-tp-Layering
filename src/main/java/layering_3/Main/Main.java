package layering_3.Main;

import layering_3.UI.RadioCompetition;

import javax.swing.SwingUtilities;

public class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new Main().start();
                    } catch (Exception e) {
                            // log exception...
                        System.out.println(e);
                    }
                }
            });
        }


        private void start() {
            RadioCompetition radioCompetition = new RadioCompetition();
        }

}
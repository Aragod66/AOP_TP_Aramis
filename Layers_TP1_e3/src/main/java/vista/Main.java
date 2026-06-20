package vista;

import persistencia.ConcursoRepoTxt;
import persistencia.ParticipanteRepoTxt;

import javax.swing.SwingUtilities;
import java.io.IOException;
import java.time.LocalDate;

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

    private void start() throws Exception {
        new RadioCompetition(new ParticipanteRepoTxt(), new ConcursoRepoTxt(), LocalDate.now());
    }
}

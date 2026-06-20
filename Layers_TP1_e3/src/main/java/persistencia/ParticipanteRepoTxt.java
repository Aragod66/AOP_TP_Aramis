package persistencia;

import modelo.Participante;
import modelo.ParticipanteRepo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ParticipanteRepoTxt implements ParticipanteRepo {

    public ParticipanteRepoTxt() throws IOException {
    }

    @Override
    public void guardar(Participante participante) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("data/participantes.txt", true))) {

            writer.write(
                    participante.getApellido() + ", " +
                            participante.getNombre() + ", " +
                            participante.getPhone() + ", " +
                            participante.getEmail() + ", " +
                            participante.getConcursoId()
            );

            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ParticipanteRepoTxt";
    }
}

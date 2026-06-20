package persistencia;

import modelo.Participante;
import modelo.ParticipanteRepo;

import java.io.IOException;
import java.util.ArrayList;

public class ParticipanteRepoFake implements ParticipanteRepo {
    ArrayList<Participante> participantes = new ArrayList<>();

    @Override
    public void guardar(Participante participante) {
        participantes.add(participante);
    }

    public int cantidadParticipantes(){
        return participantes.size();
    }
}

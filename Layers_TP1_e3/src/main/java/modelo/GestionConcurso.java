package modelo;

import aop.Log;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GestionConcurso {

    @Log
    public List<Concurso> todosLosConcursos(
            ConcursoRepo concursoRepo,
            LocalDate hoy) {

        List<Concurso> concursos = concursoRepo.obtenerTodos();

        return concursos.stream()
                .filter(concurso ->
                        todayBetween(
                                concurso.getIncioInscripcion(),
                                concurso.getFinalInscripcion(),
                                hoy))
                .toList();
    }

    @Log
    public void saveInscription(
            Participante participante,
            ParticipanteRepo participanteRepo)
            throws IOException {

        participanteRepo.guardar(participante);
    }

    public boolean todayBetween(
            LocalDate inicio,
            LocalDate fin,
            LocalDate hoy) {

        return !hoy.isBefore(inicio)
                && !hoy.isAfter(fin);
    }
}
package persistencia;

import modelo.Concurso;
import modelo.ConcursoRepo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoRepoFake implements ConcursoRepo {
    ArrayList<Concurso> concursos = new ArrayList<>();

    public void generar(){
        Concurso c1 = new Concurso(0, "concursoX", LocalDate.now().minusDays(3), LocalDate.now().plusDays(3));
        concursos.add(c1);
        Concurso c2 = new Concurso(0, "concursoY", LocalDate.now().minusDays(5), LocalDate.now().plusDays(1));
        concursos.add(c2);
        Concurso c3 = new Concurso(0, "concursoZ", LocalDate.now().plusDays(3), LocalDate.now().plusDays(3));
        concursos.add(c3);
        Concurso c4 = new Concurso(0, "concursoZA", LocalDate.now().minusDays(3), LocalDate.now().minusDays(3));
        concursos.add(c4);
        Concurso c5 = new Concurso(0, "concursoZB", LocalDate.now().minusDays(10), LocalDate.now().plusDays(10));
        concursos.add(c5);
    }

    @Override
    public List<Concurso> obtenerTodos() {
        return concursos;
    }
}

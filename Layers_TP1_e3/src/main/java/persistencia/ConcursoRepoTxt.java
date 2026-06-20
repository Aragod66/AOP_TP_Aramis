package persistencia;

import modelo.Concurso;
import modelo.ConcursoRepo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ConcursoRepoTxt implements ConcursoRepo {

    private String path = "data/concursos.txt";

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public List<Concurso> obtenerTodos() {
        try {
            return Files.lines(Paths.get(path))
                    .map(linea -> this.mapearConcurso(linea))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Concurso mapearConcurso(String linea) {

        String[] partes = linea.split(",");

        int id = Integer.parseInt(partes[0].trim());
        String nombre = partes[1].trim();
        LocalDate inicio = LocalDate.parse(partes[2].trim(), formatter);
        LocalDate fin = LocalDate.parse(partes[3].trim(), formatter);

        return new Concurso(id, nombre, inicio, fin);
    }

    @Override
    public String toString() {
        return "ConcursoRepoTxt";
    }
}


package modelo;

import org.junit.jupiter.api.Test;
import persistencia.ConcursoRepoFake;
import persistencia.ParticipanteRepoFake;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GestionConcursoTest {

    @Test
    public void leerConcursosInscribibles() throws IOException {
        GestionConcurso gestionConcurso = new GestionConcurso();
        ConcursoRepoFake concursoRepo = new ConcursoRepoFake();
        concursoRepo.generar();
        List<Concurso> concursos = gestionConcurso.todosLosConcursos(concursoRepo, LocalDate.now());
        assertEquals(3, concursos.size());
    }

    @Test
    public void inscribirParticipantes() throws IOException {
        GestionConcurso gestionConcurso = new GestionConcurso();
        ParticipanteRepoFake participaneRepo = new ParticipanteRepoFake();

        Participante p1 = new Participante("Aramis", "Sanchez", "0", "Ara.nos@gmail.com", "0923-098456", 2);
        Participante p2 = new Participante("Juan", "Perez", "1", "juan.perez@gmail.com", "1234-567890", 2);
        Participante p3 = new Participante("Maria", "Gomez", "2", "maria.gomez@gmail.com", "2345-678901", 3);
        Participante p4 = new Participante("Lucas", "Diaz", "3", "lucas.diaz@gmail.com", "3456-789012", 1);
        Participante p5 = new Participante("Sofia", "Lopez", "4", "sofia.lopez@gmail.com", "4567-890123", 2);

        gestionConcurso.saveInscription(p1, participaneRepo);
        gestionConcurso.saveInscription(p2, participaneRepo);
        gestionConcurso.saveInscription(p3, participaneRepo);
        gestionConcurso.saveInscription(p4, participaneRepo);
        gestionConcurso.saveInscription(p5, participaneRepo);

        assertEquals(5, participaneRepo.cantidadParticipantes());
    }

    @Test
    public void nombreVacio() throws IOException {
        InvalidParameterException ex = assertThrows(InvalidParameterException.class, () -> new Participante("", "Sanchez", "123", "test.nos@gmail.com", "1234-567890", 1));

        assertEquals("Nombre no puede ser vacio", ex.getMessage());
    }

    @Test
    public void apellidoVacio() throws IOException {
        InvalidParameterException ex = assertThrows(InvalidParameterException.class, () -> new Participante("Aramis", "", "123", "test.nos@gmail.com", "1234-567890", 1));

        assertEquals("apellido no puede ser vacio", ex.getMessage());
    }
    @Test
    public void idVacio() throws IOException {
        InvalidParameterException ex = assertThrows(InvalidParameterException.class, () -> new Participante("Aramis", "Sanchez", "", "test.nos@gmail.com", "1234-567890", 1));

        assertEquals("dni no puede ser vacio", ex.getMessage());
    }

    @Test
    public void emailInvalido() throws IOException {
        InvalidParameterException ex = assertThrows(InvalidParameterException.class, () -> new Participante("Aramis", "Sanchez", "87", "testgmail.com", "1234-567890", 1));

        assertEquals("email debe ser válido", ex.getMessage());
    }

    @Test
    public void phoneInvalido() throws IOException {
        InvalidParameterException ex = assertThrows(InvalidParameterException.class, () -> new Participante("Aramis", "Sanchez", "87", "test@gmail.com", "123567890", 1));

        assertEquals("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN", ex.getMessage());
    }

}

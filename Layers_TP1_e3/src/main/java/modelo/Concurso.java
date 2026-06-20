package modelo;

import java.time.LocalDate;

public class Concurso {
    private int id;
    private String nombre;
    private LocalDate incioInscripcion;
    private LocalDate finalInscripcion;

    public Concurso(int id, String nombre, LocalDate incioInscripcion, LocalDate finalInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.incioInscripcion = incioInscripcion;
        this.finalInscripcion = finalInscripcion;
    }

    @Override
    public String toString(){
        return nombre;
    }

    public LocalDate getIncioInscripcion() {
        return incioInscripcion;
    }

    public LocalDate getFinalInscripcion() {
        return finalInscripcion;
    }

    public int getId() {
        return id;
    }
}

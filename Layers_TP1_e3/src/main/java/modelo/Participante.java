package modelo;

import java.security.InvalidParameterException;

public class Participante {
    private String nombre;
    private String apellido;
    private String id;
    private String email;
    private String phone;
    private int concursoId;

    public Participante(String nombre, String apellido, String id, String email, String phone, int concursoId) throws InvalidParameterException {
        if (!isValidNombre(nombre)) {
            throw new InvalidParameterException("Nombre no puede ser vacio");
        }
        if (!isValidApellido(apellido)) {
            throw new InvalidParameterException("apellido no puede ser vacio");
        }
        if (!isValidId(id)) {
            throw new InvalidParameterException("dni no puede ser vacio");
        }
        if (!isValidEmail(email)) {
            throw new InvalidParameterException("email debe ser válido");
        }
        if (!isValidPhone(phone)) {
            throw new InvalidParameterException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (concursoId < 0) {
            throw new InvalidParameterException("Debe elegir un Concurso");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.concursoId = concursoId;
    }

    public boolean isValidNombre(String nombre) {
        return !"".equals(nombre);
    }

    public boolean isValidApellido(String apellido) {
        return !"".equals(apellido);
    }

    public boolean isValidId(String id) {
        return !"".equals(id);
    }

    public boolean isValidEmail(String email) {
        email = email.trim();
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }

    public boolean isValidPhone(String phone) {
        String regex = "\\d{4}-\\d{6}";
        return phone.matches(regex);
    }

    public String getApellido() {
        return apellido;
    }

    public String getPhone() {
        return phone;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getConcursoId() {
        return concursoId;
    }

    @Override
    public String toString() {
        return nombre + "|" +
                apellido + "|" +
                id + "|" +
                email + "|" +
                phone + "|" +
                concursoId;
    }

}

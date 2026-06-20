package persistencia;

import modelo.Concurso;
import modelo.ConcursoRepo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoRepoJDBC implements ConcursoRepo {

    private String url = "jdbc:mysql://localhost:3306/tu_db";
    private String user = "root";
    private String password = "1234";

    @Override
    public List<Concurso> obtenerTodos() {

        List<Concurso> concursos = new ArrayList<>();

        String sql = "SELECT id, nombre, fecha_inicio, fecha_fin FROM concursos";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                concursos.add(mapearConcurso(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return concursos;
    }

    private Concurso mapearConcurso(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");

        LocalDate inicio = rs.getDate("fecha_inicio").toLocalDate();
        LocalDate fin = rs.getDate("fecha_fin").toLocalDate();

        return new Concurso(id, nombre, inicio, fin);
    }
}
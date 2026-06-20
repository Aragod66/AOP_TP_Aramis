package persistencia;

import modelo.Participante;
import modelo.ParticipanteRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteRepoJDBC implements ParticipanteRepo {

    private String url = "jdbc:mysql://localhost:3306/tu_db";
    private String user = "root";
    private String password = "1234";

    @Override
    public void guardar(Participante participante) {

        String sql = "INSERT INTO participantes (apellido, nombre, telefono, email, concurso_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, participante.getApellido());
            stmt.setString(2, participante.getNombre());
            stmt.setString(3, participante.getPhone());
            stmt.setString(4, participante.getEmail());
            stmt.setInt(5, participante.getConcursoId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
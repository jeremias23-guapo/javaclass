package controlador;

import Modelo.Profesion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionController {

    private Connection conexion;

    // Constructor para inicializar la conexión
    public ProfesionController(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para crear una nueva profesión
    public boolean agregarProfesion(Profesion profesion) {
        String sql = "INSERT INTO Profesiones (NombreProfesion) VALUES (?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, profesion.getNombreProfesion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para leer todas las profesiones
    public List<Profesion> listarProfesiones() {
        List<Profesion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Profesiones";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Profesion profesion = new Profesion(
                    rs.getInt("IdProfesion"),
                    rs.getString("NombreProfesion")
                );
                lista.add(profesion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para actualizar una profesión
    public boolean actualizarProfesion(Profesion profesion) {
        String sql = "UPDATE Profesiones SET NombreProfesion = ? WHERE IdProfesion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, profesion.getNombreProfesion());
            ps.setInt(2, profesion.getIdProfesion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una profesión
    public boolean eliminarProfesion(int idProfesion) {
        String sql = "DELETE FROM Profesiones WHERE IdProfesion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idProfesion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


package Daos;

import beans.Sede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SedeDao extends DaoBase {

    public ArrayList<Sede> listarSedes() {
        ArrayList<Sede> listaSedes = new ArrayList<>();

        String sql = """
                SELECT s.id_sede, s.nombre, s.total_equipos, s.operativos, s.caidos
                FROM sedes s
                JOIN equipos e ON e.id_sede = s.id_sede
                """;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Sede sede = new Sede();
                sede.setIdSede(rs.getInt("id_sede"));
                sede.setNombre(rs.getString("nombre"));
                listaSedes.add(sede);
            }

        } catch (SQLException e) {

        }

        return listaSedes;
    }
}

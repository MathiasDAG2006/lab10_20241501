package Daos;

import beans.EquipoRed;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class EquipoDao extends DaoBase {

    public ArrayList<EquipoRed> listarEquipoRed() {
        ArrayList<EquipoRed> listaEquipoRed = new ArrayList<>();

        String sql = """
                     SELECT e.id_equipo, e.hostname, e.tipo, e.ip_gestion, e.estado, s.nombre
                     FROM equipos_red e
                     JOIN sedes s ON e.id_sede = s.id_sede;
                     """;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){

            while (rs.next()) {
                EquipoRed equipo = new EquipoRed();
                equipo.setIdEquipo(rs.getInt("e.id_equipo"));
                equipo.setEstado(rs.getString("e.estado"));
                equipo.setTipo(rs.getString("tipo"));
                equipo.setHostname(rs.getString("hostname"));
                equipo.setIp_gestion(rs.getString("ip_gestion"));
                listaEquipoRed.add(equipo);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


        return listaEquipoRed;
    }

    public void creacionEquipo(EquipoRed equipoRed) {
        String sql = """
                INSERT INTO equipos_red (hostname, tipo, ip_gestion, estado, fecha_alta, id_sede)
                VALUES (?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipoRed.getHostname());
            pstmt.setString(2, equipoRed.getTipo());
            pstmt.setString(3, equipoRed.getIp_gestion());
            pstmt.setString(4, equipoRed.getEstado());
            pstmt.setDate(5, (Date) equipoRed.getFecha_alta());
            pstmt.setInt(6, equipoRed.getIdSede());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package beans;

import java.util.Date;

public class EquipoRed {
    private int idEquipo;
    private String hostname;
    private String tipo;
    private String ip_gestion;
    private String estado;
    private Date fecha_alta;
    private int idSede;

    public EquipoRed() {
    }

    public EquipoRed(int idEquipo, String hostname, String tipo, String ip_gestion, String estado, Date fecha_alta, int idSede) {
        this.idEquipo = idEquipo;
        this.hostname = hostname;
        this.tipo = tipo;
        this.ip_gestion = ip_gestion;
        this.estado = estado;
        this.fecha_alta = fecha_alta;
        this.idSede = idSede;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIp_gestion() {
        return ip_gestion;
    }

    public void setIp_gestion(String ip_gestion) {
        this.ip_gestion = ip_gestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }
}

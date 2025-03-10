package BL;

import java.time.LocalDate;

public class SolicitudDeServicio extends Tickete{

    private String justificacionServicio;
    private int prioridad;

    public SolicitudDeServicio() {
    }

    public SolicitudDeServicio(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado, String justificacionServicio, int prioridad) {
        super(estado, nota, codigo, descripcion, usuarioCreador, usuarioTecnicoAsignado);
        this.justificacionServicio = justificacionServicio;
        this.prioridad = prioridad;
    }

    public String getJustificacionServicio() {
        return justificacionServicio;
    }

    public void setJustificacionServicio(String justificacionServicio) {
        this.justificacionServicio = justificacionServicio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "SolicitudDeServicio{" +
                "justificacionServicio='" + justificacionServicio + '\'' +
                ", prioridad=" + prioridad +
                '}' + super.toString();
    }
}

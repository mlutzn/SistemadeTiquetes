package BL;

import java.time.LocalDate;

public class SolicitudDeCambio extends Tickete {

    private LocalDate fechaReqCambio;
    private String pasosEjecCambio;

    public SolicitudDeCambio() {
    }

    public SolicitudDeCambio(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado, LocalDate fechaReqCambio, String pasosEjecCambio) {
        super(estado, nota, codigo, descripcion, usuarioCreador, usuarioTecnicoAsignado);
        this.fechaReqCambio = fechaReqCambio;
        this.pasosEjecCambio = pasosEjecCambio;
    }

    public LocalDate getFechaReqCambio() {
        return fechaReqCambio;
    }

    public void setFechaReqCambio(LocalDate fechaReqCambio) {
        this.fechaReqCambio = fechaReqCambio;
    }

    public String getPasosEjecCambio() {
        return pasosEjecCambio;
    }

    public void setPasosEjecCambio(String pasosEjecCambio) {
        this.pasosEjecCambio = pasosEjecCambio;
    }

    @Override
    public String toString() {
        return "SolicitudDeCambio{" +
                "fechaReqCambio=" + fechaReqCambio +
                ", pasosEjecCambio='" + pasosEjecCambio + '\'' +
                '}' + super.toString();
    }
}

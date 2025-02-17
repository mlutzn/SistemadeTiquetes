package BL;

import java.time.LocalDate;

public class SolicitudDeServicio {
    private String estado;
    private String nota;
    private String codigo;
    private String descripcion;
    private String usuarioCreador;
    private String usuarioTecnicoAsignado;
    private LocalDate fechaEjecucion;
    private String justificacionServicio;
    private int prioridad;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getUsuarioTecnicoAsignado() {
        return usuarioTecnicoAsignado;
    }

    public void setUsuarioTecnicoAsignado(String usuarioTecnicoAsignado) {
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
    }

    public LocalDate getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(LocalDate fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
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

    public SolicitudDeServicio() {
    }

    public SolicitudDeServicio(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado, LocalDate fechaEjecucion, String justificacionServicio, int prioridad) {
        this.estado = estado;
        this.nota = nota;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
        this.fechaEjecucion = fechaEjecucion;
        this.justificacionServicio = justificacionServicio;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "SolicitudDeServicio{" +
                "estado='" + estado + '\'' +
                ", nota='" + nota + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarioCreador='" + usuarioCreador + '\'' +
                ", usuarioTecnicoAsignado='" + usuarioTecnicoAsignado + '\'' +
                ", fechaEjecucion=" + fechaEjecucion +
                ", justificacionServicio='" + justificacionServicio + '\'' +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}

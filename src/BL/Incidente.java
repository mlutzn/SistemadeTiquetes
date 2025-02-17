package BL;

import java.time.LocalDate;

public class Incidente {
    private String estado;
    private String nota;
    private String codigo;
    private String descripcion;
    private String usuarioCreador;
    private String usuarioTecnicoAsignado;
    private LocalDate fechaSolucion;
    private String descripcionSolucion;

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

    public LocalDate getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(LocalDate fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getDescripcionSolucion() {
        return descripcionSolucion;
    }

    public void setDescripcionSolucion(String descripcionSolucion) {
        this.descripcionSolucion = descripcionSolucion;
    }

    public Incidente() {
    }

    public Incidente(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado, LocalDate fechaSolucion, String descripcionSolucion) {
        this.estado = estado;
        this.nota = nota;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
        this.fechaSolucion = fechaSolucion;
        this.descripcionSolucion = descripcionSolucion;
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "estado='" + estado + '\'' +
                ", nota='" + nota + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarioCreador='" + usuarioCreador + '\'' +
                ", usuarioTecnicoAsignado='" + usuarioTecnicoAsignado + '\'' +
                ", fechaSolucion=" + fechaSolucion +
                ", descripcionSolucion='" + descripcionSolucion + '\'' +
                '}';
    }
}

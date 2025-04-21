package BL;

public class Tickete {

        private String estado;
        private String nota;
        private String codigo;
        private String descripcion;
        private String usuarioCreador;
        private String usuarioTecnicoAsignado;

    public Tickete() {
    }

    public Tickete(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado) {
        this.estado = estado;
        this.nota = nota;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
    }

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

    public void setUsuarioTecnicoAsignado() {
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
    }

    @Override
    public String toString() {
        return "Tickete{" +
                "estado='" + estado + '\'' +
                ", nota='" + nota + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarioCreador='" + usuarioCreador + '\'' +
                ", usuarioTecnicoAsignado='" + usuarioTecnicoAsignado + '\'' +
                '}';
    }
}

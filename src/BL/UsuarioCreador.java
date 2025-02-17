package BL;

import java.util.Arrays;

public class UsuarioCreador {
        private String codigo;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String correoElectronico;
        private int telefono;
        private String password;
        private String departamento;
        private Incidente[] incidente;
        private SolicitudDeCambio[] solicitudDeCambio;
        private SolicitudDeServicio[] solicitudDeServicio;
        private UsuarioAdministrador[] usuarioAdministrador;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Incidente[] getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente[] incidente) {
        this.incidente = incidente;
    }

    public SolicitudDeCambio[] getSolicitudDeCambio() {
        return solicitudDeCambio;
    }

    public void setSolicitudDeCambio(SolicitudDeCambio[] solicitudDeCambio) {
        this.solicitudDeCambio = solicitudDeCambio;
    }

    public SolicitudDeServicio[] getSolicitudDeServicio() {
        return solicitudDeServicio;
    }

    public void setSolicitudDeServicio(SolicitudDeServicio[] solicitudDeServicio) {
        this.solicitudDeServicio = solicitudDeServicio;
    }

    public UsuarioAdministrador[] getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(UsuarioAdministrador[] usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }

    public UsuarioCreador() {
    }

    public UsuarioCreador(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, int telefono, String password, String departamento, Incidente[] incidente, SolicitudDeCambio[] solicitudDeCambio, SolicitudDeServicio[] solicitudDeServicio, UsuarioAdministrador[] usuarioAdministrador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.password = password;
        this.departamento = departamento;
        this.incidente = incidente;
        this.solicitudDeCambio = solicitudDeCambio;
        this.solicitudDeServicio = solicitudDeServicio;
        this.usuarioAdministrador = usuarioAdministrador;
    }

    @Override
    public String toString() {
        return "UsuarioCreador{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono=" + telefono +
                ", password='" + password + '\'' +
                ", departamento='" + departamento + '\'' +
                ", incidente=" + Arrays.toString(incidente) +
                ", solicitudDeCambio=" + Arrays.toString(solicitudDeCambio) +
                ", solicitudDeServicio=" + Arrays.toString(solicitudDeServicio) +
                ", usuarioAdministrador=" + Arrays.toString(usuarioAdministrador) +
                '}';
    }
}


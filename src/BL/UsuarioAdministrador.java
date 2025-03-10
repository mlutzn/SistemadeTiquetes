package BL;

import java.util.Arrays;

public class UsuarioAdministrador extends Usuario {
        private String estado;

    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, int telefono, String password) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioAdministrador{" +
                "estado='" + estado + '\'' +
                '}' + super.toString();
    }
}


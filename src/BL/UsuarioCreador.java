package BL;

import java.util.Arrays;

public class UsuarioCreador extends Usuario {

        private String departamento;

    public UsuarioCreador() {
    }

    public UsuarioCreador(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, int telefono, String password, String departamento) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "UsuarioCreador{" +
                "departamento='" + departamento + '\'' +
                '}' + super.toString();
    }
}


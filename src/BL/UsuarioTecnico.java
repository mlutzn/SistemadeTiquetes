package BL;

import java.util.Arrays;

public class UsuarioTecnico extends Usuario{

        private String rol;

    public UsuarioTecnico() {
    }

    public UsuarioTecnico(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, int telefono, String password, String rol) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioTecnico{" +
                "rol='" + rol + '\'' +
                '}' + super.toString();
    }
}


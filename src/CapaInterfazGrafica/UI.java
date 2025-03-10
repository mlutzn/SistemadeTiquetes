package CapaInterfazGrafica;

import BL.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

public class UI {
        static PrintStream out = System.out;
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static BL bl = new BL();

        public static void main(String[] args) throws IOException {

            int opcion;

            do {
                mostrarMenu();
                opcion = seleccionarOpcion();
                procesarOpcion(opcion);
            } while (opcion != 0);

        }
        public static void mostrarMenu() {

            out.println("1. Registrar incidente");
            out.println("2. Modificar incidente");
            out.println("3. Obtener Incidentes");
            out.println("4. Listar Incidentes");
            out.println("5. Eliminar Incidente");
            out.println("6. Registrar Usuario Creador");
            out.println("7. Modificar Usuario Creador");
            out.println("8. Obtener Usuario Creador");
            out.println("9. Listar Usuarios creadores");
            out.println("10. Eliminar Usuario Creador");
            out.println("11. Registrar Usuario Administrador");
            out.println("12. Modificar Usuario Administrador");
            out.println("13. Obtener Usuario Administrador");
            out.println("14. Listar Usuarios Administradores");
            out.println("15. Eliminar Usuario Administrador");
            out.println("0. Salir");
        }
        public static int seleccionarOpcion() throws IOException {
            int opcion;
            out.println("Digite la opción a ejecutar");
            opcion = Integer.parseInt(in.readLine());
            return opcion;
        }

        public static void procesarOpcion(int opcion) throws IOException {
            switch (opcion) {
                case 1:
                    agregarIncidente();
                    break;
                case 2:
                    modificarIncidente();
                    break;
                case 3:
                    obtenerIncidente();
                    break;
                case 4:
                    obtenerIncidentes();
                    break;
                case 5:
                    eliminarIncidente();
                    break;
                case 6:
                    agregarUsuarioCreador();
                    break;
                case 7:
                    modificarUsuarioCreador();
                    break;
                case 8:
                    obtenerUsuarioCreador();
                    break;
                case 9:
                    obtenerUsuariosCreadores();
                    break;
                case 10:
                    eliminarUsuarioCreador();
                    break;
                case 11:
                    agregarUsuarioAdministrador();
                    break;
                case 12:
                    modificarUsuarioAdministrador();
                    break;
                case 13:
                    obtenerUsuarioAdministrador();
                    break;
                case 14:
                    obtenerUsuariosAdministradores();
                    break;
                case 15:
                    eliminarUsuarioAdministrador();
                    break;
                case 0:
                    break;
                default:
                    out.println("Opción inválida");
                    break;
            }
        }
//Incidente
    public static void agregarIncidente() throws IOException {
        Incidente incidente = new Incidente();
        out.println("Digite el estado del incidente");
        incidente.setEstado(in.readLine());
        out.println("Digite el nota del incidente");
        incidente.setNota(in.readLine());
        out.println("Digite el codigo del incidente");
        incidente.setCodigo(in.readLine());
        out.println("Digite el descripcion incidente");
        incidente.setDescripcion(in.readLine());
        out.println("Digite el usuario creador del incidente");
        incidente.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado al incidente");
        incidente.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de solucion del incidente");
        incidente.setFechaSolucion(LocalDate.parse(in.readLine()));
        out.println("Digite la descripcion de la solucion del incidente");
        incidente.setDescripcionSolucion(in.readLine());
        bl.agregarIncidente(incidente);
    }

    public static void modificarIncidente() throws IOException {
        Incidente incidente = new Incidente();
        out.println("Digite el estado del incidente");
        incidente.setEstado(in.readLine());
        out.println("Digite el nota del incidente");
        incidente.setNota(in.readLine());
        out.println("Digite el codigo del incidente");
        incidente.setCodigo(in.readLine());
        out.println("Digite el descripcion incidente");
        incidente.setDescripcion(in.readLine());
        out.println("Digite el usuario creador del incidente");
        incidente.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado al incidente");
        incidente.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de solucion del incidente");
        incidente.setFechaSolucion(LocalDate.parse(in.readLine()));
        out.println("Digite la descripcion de la solucion del incidente");
        incidente.setDescripcionSolucion(in.readLine());
        if (bl.modificarIncidente(incidente))
            out.println("Incidente Modificado");
        else
            out.println("Incidente No Encontrado");
    }

    public static void obtenerIncidente() throws IOException {

        out.println("Digite el código del Incidente: ");
        Incidente incidente = bl.obtenerIncidente(in.readLine());
        if(incidente.getCodigo().isEmpty())
        {
            out.println("El incidente ingresado no existe");
        }
        else
            out.println(incidente.toString());
    }
    public static void obtenerIncidentes() throws IOException {

        for(Incidente incidente: bl.obtenerIncidentes())
        {
            out.println(incidente.toString());
        }
    }

    public static void eliminarIncidente() throws IOException {
        out.println("Digite el código del incidente a eliminar");
        if (bl.eliminarIncidente(in.readLine()))
            out.println("Incidente Eliminado");
        else
            out.println("Incidente No Encontrado");
    }



//Usuario Creador
        public static void agregarUsuarioCreador() throws IOException {
            UsuarioCreador usuariocreador = new UsuarioCreador();
            out.println("Digite el código del usuario");
            usuariocreador.setCodigo(in.readLine());
            out.println("Digite el nombre del usuario");
            usuariocreador.setNombre(in.readLine());
            out.println("Digite el primer appelido del usuario");
            usuariocreador.setPrimerApellido(in.readLine());
            out.println("Digite el segundo appelido del usuario");
            usuariocreador.setSegundoApellido(in.readLine());
            out.println("Digite el correo electronico del usuario");
            usuariocreador.setCorreoElectronico(in.readLine());
            out.println("Digite el telefono del usuario");
            usuariocreador.setTelefono(Integer.parseInt(in.readLine()));
            out.println("Digite el password del usuario");
            usuariocreador.setPassword(in.readLine());
            out.println("Digite el departamento del usuario");
            usuariocreador.setDepartamento(in.readLine());
            bl.agregarUsuarioCreador(usuariocreador);
        }

        public static void modificarUsuarioCreador() throws IOException {
            UsuarioCreador usuariocreador = new UsuarioCreador();
            out.println("Digite el código del usuario a modificar");
            usuariocreador.setCodigo(in.readLine());
            out.println("Digite el nombre del usuario a modificar");
            usuariocreador.setNombre(in.readLine());
            out.println("Digite el primer appelido del usuario a modificar");
            usuariocreador.setPrimerApellido(in.readLine());
            out.println("Digite el segundo appelido del usuario a modificar");
            usuariocreador.setSegundoApellido(in.readLine());
            out.println("Digite el correo electronico del usuario a modificar");
            usuariocreador.setCorreoElectronico(in.readLine());
            out.println("Digite el telefono del usuario a modificar");
            usuariocreador.setTelefono(Integer.parseInt(in.readLine()));
            out.println("Digite el password del usuario a modificar");
            usuariocreador.setPassword(in.readLine());
            out.println("Digite el departamento del usuario a modificar");
            usuariocreador.setDepartamento(in.readLine());
            if (bl.modificarUsuarioCreador(usuariocreador))
                out.println("Usuario Modificado");
            else
                out.println("Usuario No Encontrado");
        }

        public static void obtenerUsuarioCreador() throws IOException {

            out.println("Digite el código del usuario: ");
            UsuarioCreador usuariocreador = bl.obtenerUsuarioCreador(in.readLine());
            if(usuariocreador.getCodigo().isEmpty())
            {
                out.println("El usuario ingresado no existe");
            }
            else
                out.println(usuariocreador.toString());
        }
        public static void obtenerUsuariosCreadores() throws IOException {

            for(UsuarioCreador usuariocreador: bl.obtenerUsuariosCreadores())
            {
                out.println(usuariocreador.toString());
            }
        }

        public static void eliminarUsuarioCreador() throws IOException {
            out.println("Digite el código del usuario a eliminar");
            if (bl.eliminarUsuarioCreador(in.readLine()))
                out.println("Usuario Eliminado");
            else
                out.println("Usuario No Encontrado");
        }

//Usuario Administrador
        public static void agregarUsuarioAdministrador() throws IOException {
            UsuarioAdministrador usuarioadministrador = new UsuarioAdministrador();
            out.println("Digite el código del usuario");
            usuarioadministrador.setCodigo(in.readLine());
            out.println("Digite el nombre del usuario");
            usuarioadministrador.setNombre(in.readLine());
            out.println("Digite el primer appelido del usuario");
            usuarioadministrador.setPrimerApellido(in.readLine());
            out.println("Digite el segundo appelido del usuario");
            usuarioadministrador.setSegundoApellido(in.readLine());
            out.println("Digite el correo electronico del usuario");
            usuarioadministrador.setCorreoElectronico(in.readLine());
            out.println("Digite el telefono del usuario");
            usuarioadministrador.setTelefono(Integer.parseInt(in.readLine()));
            out.println("Digite el password del usuario");
            usuarioadministrador.setPassword(in.readLine());
            out.println("Digite el estado del usuario");
            usuarioadministrador.setEstado(in.readLine());
            bl.agregarUsuarioAdministrador(usuarioadministrador);
        }

        public static void modificarUsuarioAdministrador() throws IOException {
            UsuarioAdministrador usuarioadministrador = new UsuarioAdministrador();
            out.println("Digite el código del usuario");
            usuarioadministrador.setCodigo(in.readLine());
            out.println("Digite el nombre del usuario");
            usuarioadministrador.setNombre(in.readLine());
            out.println("Digite el primer appelido del usuario");
            usuarioadministrador.setPrimerApellido(in.readLine());
            out.println("Digite el segundo appelido del usuario");
            usuarioadministrador.setSegundoApellido(in.readLine());
            out.println("Digite el correo electronico del usuario");
            usuarioadministrador.setCorreoElectronico(in.readLine());
            out.println("Digite el telefono del usuario");
            usuarioadministrador.setTelefono(Integer.parseInt(in.readLine()));
            out.println("Digite el password del usuario");
            usuarioadministrador.setPassword(in.readLine());
            out.println("Digite el estado del usuario");
            usuarioadministrador.setEstado(in.readLine());
            if (bl.modificarUsuarioAdministrador(usuarioadministrador))
                out.println("Usuario Modificado");
            else
                out.println("Usuario No Encontrado");
        }

        public static void obtenerUsuarioAdministrador() throws IOException {

            out.println("Digite el código del usuario: ");
            UsuarioAdministrador usuarioadministrador = bl.obtenerUsuarioAdministrador(in.readLine());
            if(usuarioadministrador.getCodigo().isEmpty())
            {
                out.println("El usuario ingresado no existe");
            }
            else
                out.println(usuarioadministrador.toString());
        }

        public static void obtenerUsuariosAdministradores() throws IOException {

            for(UsuarioAdministrador usuarioadministrador: bl.obtenerUsuariosAdministradores())
            {
                out.println(usuarioadministrador.toString());
            }
        }

        public static void eliminarUsuarioAdministrador() throws IOException {
            out.println("Digite el código del usuario a eliminar");
            if (bl.eliminarUsuarioAdministrador(in.readLine()))
                out.println("Usuario Eliminado");
            else
                out.println("Usuario No Encontrado");
        }


}

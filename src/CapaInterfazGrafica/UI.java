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
            out.println("6. Registrar Solicitud De Cambio");
            out.println("7. Modificar Solicitud De Cambio");
            out.println("8. Obtener Solicitud De Cambio");
            out.println("9. Listar Solicitudes de Cambio");
            out.println("10. Eliminar Solicitud De Cambio");
            out.println("11. Registrar Solicitud De Servicio");
            out.println("12. Modificar Solicitud De Servicio");
            out.println("13. Obtener Solicitud De Servicio");
            out.println("14. Listar Solicitudes de Servicio");
            out.println("15. Eliminar Solicitud De Servicio");
            out.println("16. Registrar Usuario Creador");
            out.println("17. Modificar Usuario Creador");
            out.println("18. Obtener Usuario Creador");
            out.println("19. Listar Usuarios creadores");
            out.println("20. Eliminar Usuario Creador");
            out.println("21. Registrar Usuario Administrador");
            out.println("22. Modificar Usuario Administrador");
            out.println("23. Obtener Usuario Administrador");
            out.println("24. Listar Usuarios Administradores");
            out.println("25. Eliminar Usuario Administrador");
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
                    agregarSolicituddeCambio();
                    break;
                case 7:
                    modificarSolicituddeCambio();
                    break;
                case 8:
                    obtenerSolicituddeCambio();
                    break;
                case 9:
                    obtenerSolicitudesdeCambio();
                    break;
                case 10:
                    eliminarSolicituddeCambio();
                    break;
                case 11:
                    agregarSolicituddeServicio();
                    break;
                case 12:
                    modificarSolicituddeServicio();
                    break;
                case 13:
                    obtenerSolicituddeServicio();
                    break;
                case 14:
                    obtenerSolicitudesdeServicio();
                    break;
                case 15:
                    eliminarSolicituddeServicio();
                    break;
                case 16:
                    agregarUsuarioCreador();
                    break;
                case 17:
                    modificarUsuarioCreador();
                    break;
                case 18:
                    obtenerUsuarioCreador();
                    break;
                case 19:
                    obtenerUsuariosCreadores();
                    break;
                case 20:
                    eliminarUsuarioCreador();
                    break;
                case 21:
                    agregarUsuarioAdministrador();
                    break;
                case 22:
                    modificarUsuarioAdministrador();
                    break;
                case 23:
                    obtenerUsuarioAdministrador();
                    break;
                case 24:
                    obtenerUsuariosAdministradores();
                    break;
                case 25:
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

//Solicitud de Cambio
    public static void agregarSolicituddeCambio() throws IOException {
        SolicitudDeCambio solicituddecambio = new SolicitudDeCambio();
        out.println("Digite el estado de la Solicitud de cambio");
        solicituddecambio.setEstado(in.readLine());
        out.println("Digite el nota de la Solicitud de cambio");
        solicituddecambio.setNota(in.readLine());
        out.println("Digite el codigo de la Solicitud de cambio");
        solicituddecambio.setCodigo(in.readLine());
        out.println("Digite el descripcion de la Solicitud de cambio");
        solicituddecambio.setDescripcion(in.readLine());
        out.println("Digite el usuario creador de la Solicitud de cambio");
        solicituddecambio.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado de la Solicitud de cambio");
        solicituddecambio.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de ejecucion de la Solicitud de cambio");
        solicituddecambio.setFechaEjecucion(LocalDate.parse(in.readLine()));
        out.println("Digite fecha de requerimiento de la Solicitud de cambio");
        solicituddecambio.setFechaReqCambio(LocalDate.parse(in.readLine()));
        out.println("Digite los pasos de la ejecucion de la Solicitud de cambio");
        solicituddecambio.setPasosEjecCambio(in.readLine());
        bl.agregarSolicituddeCambio(solicituddecambio);
    }

    public static void modificarSolicituddeCambio() throws IOException {
        SolicitudDeCambio solicituddecambio = new SolicitudDeCambio();
        out.println("Digite el estado de la Solicitud de cambio");
        solicituddecambio.setEstado(in.readLine());
        out.println("Digite el nota de la Solicitud de cambio");
        solicituddecambio.setNota(in.readLine());
        out.println("Digite el codigo de la Solicitud de cambio");
        solicituddecambio.setCodigo(in.readLine());
        out.println("Digite el descripcion de la Solicitud de cambio");
        solicituddecambio.setDescripcion(in.readLine());
        out.println("Digite el usuario creador de la Solicitud de cambio");
        solicituddecambio.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado de la Solicitud de cambio");
        solicituddecambio.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de ejecucion de la Solicitud de cambio");
        solicituddecambio.setFechaEjecucion(LocalDate.parse(in.readLine()));
        out.println("Digite fecha de requerimiento de la Solicitud de cambio");
        solicituddecambio.setFechaReqCambio(LocalDate.parse(in.readLine()));
        out.println("Digite los pasos de la ejecucion de la Solicitud de cambio");
        solicituddecambio.setPasosEjecCambio(in.readLine());
        if (bl.modificarSolicitudDeCambio(solicituddecambio))
            out.println("Solicitud de cambio Modificado");
        else
            out.println("Solicitud de cambio No Encontrado");
    }

    public static void obtenerSolicituddeCambio() throws IOException {

        out.println("Digite el código de la solicitud de cambio: ");
        SolicitudDeCambio solicituddecambio = bl.obtenerSolicitudDeCambio(in.readLine());
        if(solicituddecambio.getCodigo().isEmpty())
        {
            out.println("La solicitud de cambio ingresado no existe");
        }
        else
            out.println(solicituddecambio.toString());
    }
    public static void obtenerSolicitudesdeCambio() throws IOException {

        for(SolicitudDeCambio solicituddecambio: bl.obtenerSolicitudesDeCambio())
        {
            out.println(solicituddecambio.toString());
        }
    }

    public static void eliminarSolicituddeCambio() throws IOException {
        out.println("Digite el código de la solicitud de cambio a eliminar");
        if (bl.eliminarSolicitudDeCambio(in.readLine()))
            out.println("Solicitud de cambio Eliminada");
        else
            out.println("Solicitud de cambio No Encontrada");
    }

//Solicitud de Servicio
    public static void agregarSolicituddeServicio() throws IOException {
        SolicitudDeServicio solicituddeservicio = new SolicitudDeServicio();
        out.println("Digite el estado de la Solicitud de servicio");
        solicituddeservicio.setEstado(in.readLine());
        out.println("Digite el nota de la Solicitud de servicio");
        solicituddeservicio.setNota(in.readLine());
        out.println("Digite el codigo de la Solicitud de servicio");
        solicituddeservicio.setCodigo(in.readLine());
        out.println("Digite el descripcion de la Solicitud de servicio");
        solicituddeservicio.setDescripcion(in.readLine());
        out.println("Digite el usuario creador de la Solicitud de servicio");
        solicituddeservicio.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado de la Solicitud de servicio");
        solicituddeservicio.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de ejecucion de la Solicitud de servicio");
        solicituddeservicio.setFechaEjecucion(LocalDate.parse(in.readLine()));
        out.println("Digite la justificacion de la Solicitud de servicio");
        solicituddeservicio.setJustificacionServicio(in.readLine());
        out.println("Digite prioridad de la Solicitud de servicio");
        solicituddeservicio.setPrioridad(Integer.parseInt(in.readLine()));
        bl.agregarSolicituddeServicio(solicituddeservicio);
    }


    public static void modificarSolicituddeServicio() throws IOException {
        SolicitudDeServicio solicituddeservicio = new SolicitudDeServicio();
        out.println("Digite el estado de la Solicitud de servicio");
        solicituddeservicio.setEstado(in.readLine());
        out.println("Digite el nota de la Solicitud de servicio");
        solicituddeservicio.setNota(in.readLine());
        out.println("Digite el codigo de la Solicitud de servicio");
        solicituddeservicio.setCodigo(in.readLine());
        out.println("Digite el descripcion de la Solicitud de servicio");
        solicituddeservicio.setDescripcion(in.readLine());
        out.println("Digite el usuario creador de la Solicitud de servicio");
        solicituddeservicio.setUsuarioCreador(in.readLine());
        out.println("Digite el usuario tecnico asignado de la Solicitud de servicio");
        solicituddeservicio.setUsuarioTecnicoAsignado(in.readLine());
        out.println("Digite fecha de ejecucion de la Solicitud de servicio");
        solicituddeservicio.setFechaEjecucion(LocalDate.parse(in.readLine()));
        out.println("Digite la justificacion de la Solicitud de servicio");
        solicituddeservicio.setJustificacionServicio(in.readLine());
        out.println("Digite prioridad de la Solicitud de servicio");
        solicituddeservicio.setPrioridad(Integer.parseInt(in.readLine()));
        bl.modificarSolicitudDeServicio(solicituddeservicio);
        if (bl.modificarSolicitudDeServicio(solicituddeservicio))
            out.println("Solicitud de servicio Modificado");
        else
            out.println("Solicitud de servicio No Encontrado");
    }

    public static void obtenerSolicituddeServicio() throws IOException {

        out.println("Digite el código de la solicitud de servicio: ");
        SolicitudDeServicio solicituddeservicio = bl.obtenerSolicitudDeServicio(in.readLine());
        if(solicituddeservicio.getCodigo().isEmpty())
        {
            out.println("La solicitud de servicio ingresado no existe");
        }
        else
            out.println(solicituddeservicio.toString());
    }
    public static void obtenerSolicitudesdeServicio() throws IOException {

        for(SolicitudDeServicio solicituddeservicio: bl.obtenerSolicitudesDeServicio())
        {
            out.println(solicituddeservicio.toString());
        }
    }

    public static void eliminarSolicituddeServicio() throws IOException {
        out.println("Digite el código de la solicitud de servicio a eliminar");
        if (bl.eliminarSolicitudDeServicio(in.readLine()))
            out.println("Solicitud de servicio Eliminada");
        else
            out.println("Solicitud de servicio No Encontrada");
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

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
    static CL cl = new CL();

    public static void main(String[] args) throws IOException {

        int opcion;

        do {
            mostrarMenu();
            opcion = seleccionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);

    }
    public static void mostrarMenu() {

        out.println("1. Registrar Periodo");
        out.println("2. Modificar Periodo");
        out.println("3. Listar Periodos");
        out.println("4. Obtener Periodo");
        out.println("5. Eliminar Periodo");
        out.println("6. Registrar Estudiante");
        out.println("7. Modificar Estudiante");
        out.println("8. Listar Estudiante");
        out.println("9. Obtener Estudiante");
        out.println("10. Eliminar Estudiante");
        out.println("11. Registrar Profesor");
        out.println("12. Modificar Profesor");
        out.println("13. Listar Profesores");
        out.println("14. Obtener Profesor");
        out.println("15. Eliminar Profesores");
        out.println("16. Registrar Curso");
        out.println("17. Modificar Curso");
        out.println("18. Listar Curso");
        out.println("19. Obtener Cursos");
        out.println("20. Eliminar Cursos");
        out.println("21. Asignar Profesor");
        out.println("22. Desasignar Profesor");
        out.println("23. Matricular Estudiante");
        out.println("24. Desmatricular Estudiante");
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
                RegistrarPeriodo();
                break;
            case 2:
                ModificarPeriodo();
                break;
            case 3:
                ListarPeriodos();
                break;
            case 4:
                ObtenerPeriodo();
                break;
            case 5:
                EliminarPeriodo();
                break;
            case 6:
                RegistrarEstudiante();
                break;
            case 7:
                ModificarEstudiante();
                break;
            case 8:
                ListarEstudiantes();
                break;
            case 9:
                ObtenerEstudiante();
                break;
            case 10:
                EliminarEstudiante();
                break;
            case 11:
                RegistrarProfesor();
                break;
            case 12:
                ModificarProfesor();
                break;
            case 13:
                ListarProfesores();
                break;
            case 14:
                ObtenerProfesor();
                break;
            case 15:
                EliminarProfesor();
                break;
            case 16:
                RegistrarCurso();
                break;
            case 17:
                ModificarCurso();
                break;
            case 18:
                ListarCursos();
                break;
            case 19:
                ObtenerCurso();
                break;
            case 20:
                EliminarCurso();
                break;
            case 21:
                AsignarProfesor();
                break;
            case 22:
                DesasignarProfesor();
                break;
            case 23:
                MatricularEstudiante();
                break;
            case 24:
                DesmatricularEstudiante();
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void RegistrarPeriodo() throws IOException {
        Periodo periodo = new Periodo();
        out.println("Digite el código del Periodo");
        periodo.setCodigo(Integer.parseInt(in.readLine()));
        out.println("Digite el tipo del Periodo");
        periodo.setTipo(in.readLine());
        out.println("Digite la fecha de Inicio del Periodo");
        periodo.setFechaInicio(LocalDate.parse(in.readLine()));
        out.println("Digite la fecha de Fin del Periodo");
        periodo.setFechaFin(LocalDate.parse(in.readLine()));
        cl.agregarPeriodo(periodo);
    }

    public static void ModificarPeriodo() throws IOException {
        Periodo periodo = new Periodo();
        out.println("Digite el código del Periodo a modificar");
        periodo.setCodigo(Integer.parseInt(in.readLine()));
        out.println("Digite el tipo del Periodo a modificar");
        periodo.setTipo(in.readLine());
        out.println("Digite la fecha de Inicio del Periodo a modificar");
        periodo.setFechaInicio(LocalDate.parse(in.readLine()));
        out.println("Digite la fecha de Fin del Periodo a modificar");
        periodo.setFechaFin(LocalDate.parse(in.readLine()));
        if (cl.modificarPeriodo(periodo))
            out.println("Periodo Modificado");
        else
            out.println("Periodo No Encontrado");
    }

    public static void EliminarPeriodo() throws IOException {
        out.println("Digite el código del Periodo a eliminar");
        if (cl.eliminarPeriodo(Integer.parseInt(in.readLine())))
            out.println("Periodo Eliminado");
        else
            out.println("Periodo No Encontrado");
    }

    public static void ListarPeriodos() throws IOException {

        for(Periodo periodo: cl.obtenerPeriodos())
        {
            out.println(periodo.toString());
        }
    }

    public static void ObtenerPeriodo() throws IOException {

        out.println("Digite el código del periodo: ");
        Periodo periodo = cl.obtenerPeriodo(Integer.parseInt(in.readLine()));
        if(periodo.getCodigo() == 0)
        {
            out.println("El periodo ingresado no existe");
        }
        else
            out.println(periodo.toString());

    }

    public static void RegistrarEstudiante() throws IOException {
        Estudiante estudiante = new Estudiante();
        out.println("Digite la cédula del Estudiante");
        estudiante.setCedula(in.readLine());
        out.println("Digite el nombre del Estudiante");
        estudiante.setNombre(in.readLine());
        out.println("Digite el primer Apellido del Estudiante");
        estudiante.setPrimerApellido(in.readLine());
        out.println("Digite el segundo Apellido del Estudiante");
        estudiante.setSegundoApellido(in.readLine());
        out.println("Digite el correo del Estudiante");
        estudiante.setCorreoElectronico(in.readLine());
        out.println("Digite la fecha de Nacimiento del Estudiante");
        estudiante.setFechaNacimiento(LocalDate.parse(in.readLine()));
        out.println("Digite si el estudiante es becado");
        estudiante.setBecado(Boolean.valueOf(in.readLine()));
        cl.agregarEstudiante(estudiante);
    }

    public static void ModificarEstudiante() throws IOException {
        Estudiante estudiante = new Estudiante();
        out.println("Digite la cédula del Estudiante a modificar");
        estudiante.setCedula(in.readLine());
        out.println("Digite el nombre del Estudiante");
        estudiante.setNombre(in.readLine());
        out.println("Digite el primer Apellido del Estudiante");
        estudiante.setPrimerApellido(in.readLine());
        out.println("Digite el segundo Apellido del Estudiante");
        estudiante.setSegundoApellido(in.readLine());
        out.println("Digite el correo del Estudiante");
        estudiante.setCorreoElectronico(in.readLine());
        out.println("Digite la fecha de Nacimiento del Estudiante");
        estudiante.setFechaNacimiento(LocalDate.parse(in.readLine()));
        out.println("Digite si el estudiante es becado");
        estudiante.setBecado(Boolean.valueOf(in.readLine()));
        if (cl.modificarEstudiante(estudiante))
            out.println("Estudiante Modificado");
        else
            out.println("Estudiante No Encontrado");
    }

    public static void EliminarEstudiante() throws IOException {
        out.println("Digite la cédula del Estudiante a eliminar");
        if (cl.eliminarEstudiante(in.readLine()))
            out.println("Estudiante Eliminado");
        else
            out.println("Estudiante No Encontrado");
    }

    public static void ListarEstudiantes() {

        for(Estudiante estudiante: cl.obtenerEstudiantes())
        {
            out.println(estudiante.toString());
        }
    }

    public static void ObtenerEstudiante() throws IOException {

        out.println("Digite la cédula del estudiante: ");
        Estudiante estudiante = cl.obtenerEstudiante(in.readLine());
        if(estudiante.getCedula()==null)
        {
            out.println("El estudiante ingresado no existe");
        }
        else
            out.println(estudiante.toString());

    }

    public static void RegistrarProfesor() throws IOException {
        Profesor profesor = new Profesor();
        out.println("Digite la cédula del Profesor");
        profesor.setCedula(in.readLine());
        out.println("Digite el nombre del Profesor");
        profesor.setNombre(in.readLine());
        out.println("Digite el primer Apellido del Profesor");
        profesor.setPrimerApellido(in.readLine());
        out.println("Digite el segundo Apellido del Profesor");
        profesor.setSegundoApellido(in.readLine());
        out.println("Digite el correo del Profesor");
        profesor.setCorreoElectronico(in.readLine());
        out.println("Digite la fecha de Nacimiento del Profesor");
        profesor.setFechaNacimiento(LocalDate.parse(in.readLine()));
        out.println("Digite el escalafon del profesor");
        profesor.setEscalafon(in.readLine());
        cl.agregarProfesor(profesor);
    }

    public static void ModificarProfesor() throws IOException {
        Profesor profesor = new Profesor();
        out.println("Digite la cédula del Profesor a modificar");
        profesor.setCedula(in.readLine());
        out.println("Digite el nombre del Profesor");
        profesor.setNombre(in.readLine());
        out.println("Digite el primer Apellido del Profesor");
        profesor.setPrimerApellido(in.readLine());
        out.println("Digite el segundo Apellido del Profesor");
        profesor.setSegundoApellido(in.readLine());
        out.println("Digite el correo del Profesor");
        profesor.setCorreoElectronico(in.readLine());
        out.println("Digite la fecha de Nacimiento del Profesor");
        profesor.setFechaNacimiento(LocalDate.parse(in.readLine()));
        out.println("Digite el escalafon del profesor");
        profesor.setEscalafon(in.readLine());
        if (cl.modificarProfesor(profesor))
            out.println("Profesor Modificado");
        else
            out.println("Profesor No Encontrado");
    }

    public static void EliminarProfesor() throws IOException {
        out.println("Digite la cédula del Profesor a eliminar");
        if (cl.eliminarProfesor(in.readLine()))
            out.println("Profesor Eliminado");
        else
            out.println("Profesor No Encontrado");
    }

    public static void ListarProfesores() {

        for(Profesor profesor: cl.obtenerProfesores())
        {
            out.println(profesor.toString());
        }
    }

    public static void ObtenerProfesor() throws IOException {

        out.println("Digite la cédula del profesor: ");
        Profesor profesor = cl.obtenerProfesor(in.readLine());
        if(profesor.getCedula()==null)
        {
            out.println("El profesor ingresado no existe");
        }
        else
            out.println(profesor.toString());

    }

    public static void RegistrarCurso() throws IOException {
        Curso curso = new Curso();
        out.println("Digite el código del Curso");
        curso.setCodigo(Integer.parseInt(in.readLine()));
        out.println("Digite el nombre del Curso");
        curso.setNombre(in.readLine());
        out.println("Digite el horario del Curso");
        curso.setHorario(in.readLine());
        out.println("Digite la cantidad de Creditos del Curso");
        curso.setCantidadCreditos(Integer.parseInt(in.readLine()));
        out.println("Digite el cupo Maximo del Curso");
        curso.setCupoMaximo(Integer.parseInt(in.readLine()));
        out.println("Digite la modalidad del Curso");
        curso.setModalidad(in.readLine());
        out.println("Digite el costo del Curso");
        curso.setCosto(Double.parseDouble(in.readLine()));
        cl.agregarCurso(curso);
    }

    public static void ModificarCurso() throws IOException {
        Curso curso = new Curso();
        out.println("Digite el código del Curso a modificar");
        curso.setCodigo(Integer.parseInt(in.readLine()));
        out.println("Digite el nombre del Curso");
        curso.setNombre(in.readLine());
        out.println("Digite el horario del Curso");
        curso.setHorario(in.readLine());
        out.println("Digite la cantidad de Creditos del Curso");
        curso.setCantidadCreditos(Integer.parseInt(in.readLine()));
        out.println("Digite el cupo Maximo del Curso");
        curso.setCupoMaximo(Integer.parseInt(in.readLine()));
        out.println("Digite la modalidad del Curso");
        curso.setModalidad(in.readLine());
        out.println("Digite el costo del Curso");
        curso.setCosto(Double.parseDouble(in.readLine()));
        if (cl.modificarCurso(curso))
            out.println("Curso Modificado");
        else
            out.println("Curso No Encontrado");
    }

    public static void EliminarCurso() throws IOException {
        out.println("Digite el código del Curso a eliminar");
        if (cl.eliminarCurso(Integer.parseInt(in.readLine())))
            out.println("Curso Eliminado");
        else
            out.println("Curso No Encontrado");
    }

    public static void ListarCursos() throws IOException {

        for(Curso curso: cl.obtenerCursos())
        {
            out.println(curso.toString());
        }
    }

    public static void ObtenerCurso() throws IOException {

        out.println("Digite el código del curso: ");
        Curso curso = cl.obtenerCurso(Integer.parseInt(in.readLine()));
        if(curso.getCodigo() == 0)
        {
            out.println("El curso ingresado no existe");
        }
        else
            out.println(curso.toString());

    }


    public static void AsignarProfesor() throws IOException {
        out.println("Digite la cédula del Profesor a Asignar");
        String cedula = in.readLine();
        out.println("Digite el código de curso");
        int codigo = Integer.parseInt(in.readLine());
        if (cl.asignarProfesor(codigo,cedula))
            out.println("Profesor Asignado");
        else
            out.println("Profesor no Asignado");
    }

    public static void DesasignarProfesor() throws IOException {
        out.println("Digite la cédula del Profesor a Desasignar");
        String cedula = in.readLine();
        out.println("Digite el código de curso");
        int codigo = Integer.parseInt(in.readLine());
        if (cl.desasignarProfesor(codigo, cedula))
            out.println("Profesor Desasignado");
        else
            out.println("Profesor no Desasignado");
    }

    public static void MatricularEstudiante() throws IOException {
        out.println("Digite la cédula del Estudiante a Matricular");
        String cedula = in.readLine();
        out.println("Digite el código de curso");
        int codigo = Integer.parseInt(in.readLine());
        if (cl.matricularEstudiante(codigo,cedula))
            out.println("Estudiante Matriculado");
        else
            out.println("Estudiante No Matriculado");
    }

    public static void DesmatricularEstudiante() throws IOException {
        out.println("Digite la cédula del Estudiante a Matricular");
        String cedula = in.readLine();
        out.println("Digite el código de curso");
        int codigo = Integer.parseInt(in.readLine());
        if (cl.desmatricularEstudiante(codigo,cedula))
            out.println("Estudiante Desmatriculado");
        else
            out.println("Estudiante No Desmatriculado");
    }

}

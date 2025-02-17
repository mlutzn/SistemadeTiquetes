package BL;

import java.util.ArrayList;

public class CL {
    private ArrayList<Periodo> periodos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;

    public void agregarPeriodo(Periodo periodo) {
        if(periodos == null) {
            periodos = new ArrayList<>();
        }
        periodos.add(periodo);
    }
    public boolean modificarPeriodo(Periodo periodo)
    {   boolean modificado = false;
        for(Periodo periodoAux : periodos) {
            if(periodoAux.getCodigo()==periodo.getCodigo()) {
                periodoAux.setTipo(periodo.getTipo());
                periodoAux.setFechaFin(periodo.getFechaFin());
                periodoAux.setFechaInicio(periodo.getFechaInicio());
                modificado = true;
            }
        }
        return modificado;
    }
    public Periodo obtenerPeriodo(int codigoPeriodo) {
        Periodo miPeriodo = new Periodo();
        for(Periodo periodoAux : periodos) {
            if(periodoAux.getCodigo()==codigoPeriodo) {

                miPeriodo=periodoAux;
            }
        }
        return miPeriodo;
    }
    public ArrayList<Periodo> obtenerPeriodos() {
        return periodos;
    }
    public boolean eliminarPeriodo(int codigoPeriodo) {
        boolean eliminado = false;
        for(Periodo periodoAux : periodos) {
            if(periodoAux.getCodigo()==codigoPeriodo) {
                periodos.remove(periodoAux);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }


    public void agregarEstudiante(Estudiante estudiante) {
        if(estudiantes == null) {
            estudiantes = new ArrayList<>();
        }
        estudiantes.add(estudiante);
    }
    public boolean modificarEstudiante(Estudiante estudiante)
    {   boolean modificado = false;
        for(Estudiante estudianteAux : estudiantes) {
            if(estudianteAux.getCedula().equals(estudiante.getCedula())) {
                estudianteAux.setNombre(estudiante.getNombre());
                estudianteAux.setPrimerApellido(estudiante.getPrimerApellido());
                estudianteAux.setSegundoApellido(estudiante.getSegundoApellido());
                estudianteAux.setCorreoElectronico(estudiante.getCorreoElectronico());
                estudianteAux.setFechaNacimiento(estudiante.getFechaNacimiento());
                estudianteAux.setBecado(estudiante.isBecado());
                modificado = true;
            }
        }
        return modificado;
    }
    public Estudiante obtenerEstudiante(String cedula) {
        Estudiante miEstudiante = new Estudiante();
        for(Estudiante estudianteAux : estudiantes) {
            if(estudianteAux.getCedula().equals(cedula)) {

                miEstudiante=estudianteAux;
            }
        }
        return miEstudiante;
    }
    public ArrayList<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }
    public boolean eliminarEstudiante(String cedula) {
        boolean eliminado = false;
        for(Estudiante estudiante : estudiantes) {
            if(estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public void agregarProfesor(Profesor profesor) {
        if(profesores == null) {
            profesores = new ArrayList<>();
        }
        profesores.add(profesor);
    }
    public boolean modificarProfesor(Profesor profesor)
    {   boolean modificado = false;
        for(Profesor profesorAux : profesores) {
            if(profesorAux.getCedula().equals(profesor.getCedula())) {
                profesorAux.setNombre(profesor.getNombre());
                profesorAux.setPrimerApellido(profesor.getPrimerApellido());
                profesorAux.setSegundoApellido(profesor.getSegundoApellido());
                profesorAux.setCorreoElectronico(profesor.getCorreoElectronico());
                profesorAux.setFechaNacimiento(profesor.getFechaNacimiento());
                profesorAux.setEscalafon(profesor.getEscalafon());
                modificado = true;
            }
        }
        return modificado;
    }
    public Profesor obtenerProfesor(String cedula) {
        Profesor miProfesor = new Profesor();
        for(Profesor profesorAux : profesores) {
            if(profesorAux.getCedula().equals(cedula)) {

                miProfesor=profesorAux;
            }
        }
        return miProfesor;
    }
    public ArrayList<Profesor> obtenerProfesores() {
        return profesores;
    }
    public boolean eliminarProfesor(String cedula) {
        boolean eliminado = false;
        for(Profesor profesor : profesores) {
            if(profesor.getCedula().equals(cedula)) {
                profesores.remove(profesor);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }


    public void agregarCurso(Curso curso) {
        if(cursos == null) {
            cursos = new ArrayList<>();
        }
        cursos.add(curso);
    }

    public boolean modificarCurso(Curso curso)
    {   boolean modificado = false;
        for(Curso cursoAux : cursos) {
            if(cursoAux.getCodigo()==curso.getCodigo()) {
                cursoAux.setNombre(curso.getNombre());
                cursoAux.setHorario(curso.getHorario());
                cursoAux.setCantidadCreditos(curso.getCantidadCreditos());
                cursoAux.setCupoMaximo(curso.getCupoMaximo());
                cursoAux.setModalidad(curso.getModalidad());
                cursoAux.setCosto(curso.getCosto());
                modificado = true;
            }
        }
        return modificado;
    }
    public Curso obtenerCurso(int codigoCurso) {
        Curso miCurso = new Curso();
        for(Curso cursoAux : cursos) {
            if(cursoAux.getCodigo()==codigoCurso) {

                miCurso=cursoAux;
            }
        }
        return miCurso;
    }
    public ArrayList<Curso> obtenerCursos() {
        return cursos;
    }
    public boolean eliminarCurso(int codigoCurso) {
        boolean eliminado = false;
        for(Curso cursoAux : cursos) {
            if(cursoAux.getCodigo()==codigoCurso) {
                cursos.remove(cursoAux);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public boolean matricularEstudiante(int codigoCurso,String cedulaEstudiante)
    {
        boolean matriculado=false;
        if(cursos!=null)
        {
            for(Curso cursoAux : cursos)
            {
                if(cursoAux.getCodigo()==codigoCurso) {
                    if(cursoAux.getEstudiantes()==null)
                    {
                        cursoAux.setEstudiantes(new ArrayList<>());
                    }
                    for(Estudiante estudianteAux: estudiantes)
                    {
                        if(estudianteAux.getCedula().equals(cedulaEstudiante)) {
                            cursoAux.getEstudiantes().add(estudianteAux);
                            matriculado=true;
                        }
                    }

                }
            }
        }
        return matriculado;
    }

    public boolean desmatricularEstudiante(int codigoCurso,String cedulaEstudiante)
    {
        boolean desmatriculado=false;
        if(cursos!=null)
        {
            for(Curso cursoAux : cursos)
            {
                if(cursoAux.getCodigo()==codigoCurso) {
                    if(cursoAux.getEstudiantes()==null)
                    {
                        cursoAux.setEstudiantes(new ArrayList<>());
                    }
                    for(Estudiante estudianteAux: cursoAux.getEstudiantes())
                    {
                        if(estudianteAux.getCedula().equals(cedulaEstudiante)) {
                            cursoAux.getEstudiantes().remove(estudianteAux);
                            desmatriculado=true;
                            break;
                        }
                    }

                }
            }
        }
        return desmatriculado;
    }
    public boolean asignarProfesor(int codigoCurso,String cedulaProfesor)
    {
        boolean asignado=false;
        if(cursos!=null)
        {
            for(Curso cursoAux : cursos)
            {
                if(cursoAux.getCodigo()==codigoCurso) {
                    if(cursoAux.getProfesores()==null)
                    {
                        cursoAux.setProfesores(new ArrayList<>());
                    }
                    for(Profesor profesorAux: profesores)
                    {
                        if(profesorAux.getCedula().equals(cedulaProfesor)) {
                            cursoAux.getProfesores().add(profesorAux);
                            asignado=true;
                        }
                    }

                }
            }
        }
        return asignado;
    }

    public boolean desasignarProfesor(int codigoCurso,String cedulaProfesor)
    {
        boolean desasignado=false;
        if(cursos!=null)
        {
            for(Curso cursoAux : cursos)
            {
                if(cursoAux.getCodigo()==codigoCurso) {
                    if(cursoAux.getProfesores()==null)
                    {
                        cursoAux.setProfesores(new ArrayList<>());
                    }
                    for(Profesor profesorAux: cursoAux.getProfesores())
                    {
                        if(profesorAux.getCedula().equals(cedulaProfesor)) {
                            cursoAux.getProfesores().remove(profesorAux);
                            desasignado=true;
                            break;
                        }
                    }

                }
            }
        }
        return desasignado;
    }

}

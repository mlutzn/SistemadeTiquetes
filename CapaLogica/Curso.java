package BL;

import java.util.ArrayList;
import java.util.Arrays;

public class Curso {
    private int codigo;
    private String nombre;
    private String horario;
    private int cantidadCreditos;
    private int cupoMaximo;
    private String modalidad;
    private double costo;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Curso() {
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Curso(int codigo, String nombre, String horario, int cantidadCreditos, int cupoMaximo, String modalidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horario = horario;
        this.cantidadCreditos = cantidadCreditos;
        this.cupoMaximo = cupoMaximo;
        this.modalidad = modalidad;
        this.costo = costo;
    }

    public Curso(int codigo, String nombre, String horario, int cantidadCreditos, int cupoMaximo, String modalidad, double costo, ArrayList<Estudiante> estudiantes, ArrayList<Profesor> profesores) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horario = horario;
        this.cantidadCreditos = cantidadCreditos;
        this.cupoMaximo = cupoMaximo;
        this.modalidad = modalidad;
        this.costo = costo;
        this.estudiantes = estudiantes;
        this.profesores = profesores;
    }

    public Curso(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", cantidadCreditos=" + cantidadCreditos +
                ", cupoMaximo=" + cupoMaximo +
                ", modalidad='" + modalidad + '\'' +
                ", costo=" + costo +
                ", estudiantes=" + estudiantes +
                ", profesores=" + profesores +
                '}';
    }
}

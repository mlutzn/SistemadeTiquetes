package BL;

import java.time.LocalDate;
import java.util.Arrays;

public class Periodo {
    private int codigo;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Curso[] cursos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public Periodo(int codigo, String tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Periodo() {
    }

    public Periodo(int codigo, String tipo, LocalDate fechaInicio, LocalDate fechaFin, Curso[] cursos) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cursos=" + Arrays.toString(cursos) +
                '}';
    }
}

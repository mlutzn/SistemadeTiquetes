package BL;

import java.time.LocalDate;
import java.util.Arrays;

public class Factura {
    private String codigo;
    private LocalDate fecha;
    private double montoTotal;
    private String metodoPago;
    private String estado;
    private Estudiante estudiante;
    private Curso[] cursos;

    public Factura() {
    }

    public Factura(String codigo, LocalDate fecha, double montoTotal, String metodoPago, String estado) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public Factura(String codigo, LocalDate fecha, double montoTotal, String metodoPago, String estado, Estudiante estudiante) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public Factura(String codigo, LocalDate fecha, double montoTotal, String metodoPago, String estado, Estudiante estudiante, Curso[] cursos) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.estudiante = estudiante;
        this.cursos = cursos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", montoTotal=" + montoTotal +
                ", metodoPago='" + metodoPago + '\'' +
                ", estado='" + estado + '\'' +
                ", estudiante=" + estudiante +
                ", cursos=" + Arrays.toString(cursos) +
                '}';
    }
}

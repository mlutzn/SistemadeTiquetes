package BL;

import java.time.LocalDate;

public class Incidente extends Tickete {

    private LocalDate fechaSolucion;
    private String descripcionSolucion;

    public Incidente() {
    }

    public Incidente(String estado, String nota, String codigo, String descripcion, String usuarioCreador, String usuarioTecnicoAsignado, LocalDate fechaSolucion, String descripcionSolucion) {
        super(estado, nota, codigo, descripcion, usuarioCreador, usuarioTecnicoAsignado);
        this.fechaSolucion = fechaSolucion;
        this.descripcionSolucion = descripcionSolucion;
    }

    public LocalDate getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(LocalDate fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getDescripcionSolucion() {
        return descripcionSolucion;
    }

    public void setDescripcionSolucion(String descripcionSolucion) {
        this.descripcionSolucion = descripcionSolucion;
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "fechaSolucion=" + fechaSolucion +
                ", descripcionSolucion='" + descripcionSolucion + '\'' +
                '}' + super.toString();
    }
}

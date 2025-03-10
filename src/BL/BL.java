package BL;

import java.util.ArrayList;

public class BL {
    private ArrayList<UsuarioCreador> usuariocreador;
    private ArrayList<UsuarioAdministrador> usuarioadministrador;
    private ArrayList<Incidente> incidentes;
//Incidente
public void agregarIncidente(Incidente incidente) {
    if(incidentes == null) {
        incidentes = new ArrayList<>();
    }
    incidentes.add(incidente);
}
    public boolean modificarIncidente(Incidente incidente)
    {   boolean modificado = false;
        for(Incidente incidenteAux : incidentes) {
            if(incidenteAux.getCodigo().equals(incidente.getCodigo())) {
                incidenteAux.setEstado(incidente.getEstado());
                incidenteAux.setNota(incidente.getNota());
                incidenteAux.setDescripcion(incidente.getDescripcion());
                incidenteAux.setUsuarioCreador(incidente.getUsuarioCreador());
                incidenteAux.setUsuarioTecnicoAsignado(incidente.getUsuarioTecnicoAsignado());
                incidenteAux.setFechaSolucion(incidente.getFechaSolucion());
                incidenteAux.setDescripcionSolucion(incidente.getDescripcionSolucion());
                modificado = true;
            }
        }
        return modificado;
    }
    public Incidente obtenerIncidente(String codigo) {
        Incidente miIncidente = new Incidente();
        for(Incidente incidenteAux : incidentes) {
            if(incidenteAux.getCodigo().equals(codigo)) {

                miIncidente=incidenteAux;
            }
        }
        return miIncidente;
    }
    public ArrayList<Incidente> obtenerIncidentes() {
        return incidentes;
    }
    public boolean eliminarIncidente(String codigo) {
        boolean eliminado = false;
        for(Incidente incidenteAux : incidentes) {
            if(incidenteAux.getCodigo().equals(codigo)) {
                incidentes.remove(incidenteAux);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }


//UsuarioCreador
    public void agregarUsuarioCreador(UsuarioCreador usuarioCreador) {
        if(usuariocreador == null) {
            usuariocreador = new ArrayList<>();
        }
        usuariocreador.add(usuarioCreador);
    }
    public boolean modificarUsuarioCreador(UsuarioCreador usuarioCreador)
    {   boolean modificado = false;
        for(UsuarioCreador usuariocreadorAux : usuariocreador) {
            if(usuariocreadorAux.getCodigo().equals(usuarioCreador.getCodigo())) {
                usuariocreadorAux.setDepartamento(usuarioCreador.getDepartamento());
                usuariocreadorAux.setPassword(usuarioCreador.getPassword());
                usuariocreadorAux.setNombre(usuarioCreador.getNombre());
                usuariocreadorAux.setCorreoElectronico(usuarioCreador.getCorreoElectronico());
                usuariocreadorAux.setTelefono(usuarioCreador.getTelefono());
                usuariocreadorAux.setPrimerApellido(usuarioCreador.getPrimerApellido());
                usuariocreadorAux.setSegundoApellido(usuarioCreador.getSegundoApellido());
                modificado = true;
            }
        }
        return modificado;
    }
    public UsuarioCreador obtenerUsuarioCreador(String codigo) {
        UsuarioCreador miUsuarioCreador = new UsuarioCreador();
        for(UsuarioCreador usuariocreadorAux : usuariocreador) {
            if(usuariocreadorAux.getCodigo().equals(codigo)) {

                miUsuarioCreador=usuariocreadorAux;
            }
        }
        return miUsuarioCreador;
    }
    public ArrayList<UsuarioCreador> obtenerUsuariosCreadores() {
        return usuariocreador;
    }
    public boolean eliminarUsuarioCreador(String codigo) {
        boolean eliminado = false;
        for(UsuarioCreador usuariocreadorAux : usuariocreador) {
            if(usuariocreadorAux.getCodigo().equals(codigo)) {
                usuariocreador.remove(usuariocreadorAux);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
//UsuarioAdministrador

    public void agregarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        if(usuarioadministrador == null) {
            usuarioadministrador = new ArrayList<>();
        }
        usuarioadministrador.add(usuarioAdministrador);
    }
    public boolean modificarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador)
    {   boolean modificado = false;
        for(UsuarioAdministrador usuarioadministradorAux : usuarioadministrador) {
            if(usuarioadministradorAux.getCodigo().equals(usuarioAdministrador.getCodigo())) {
                usuarioadministradorAux.setPassword(usuarioAdministrador.getPassword());
                usuarioadministradorAux.setNombre(usuarioAdministrador.getNombre());
                usuarioadministradorAux.setCorreoElectronico(usuarioAdministrador.getCorreoElectronico());
                usuarioadministradorAux.setTelefono(usuarioAdministrador.getTelefono());
                usuarioadministradorAux.setPrimerApellido(usuarioAdministrador.getPrimerApellido());
                usuarioadministradorAux.setSegundoApellido(usuarioAdministrador.getSegundoApellido());
                usuarioadministradorAux.setEstado(usuarioAdministrador.getEstado());
                modificado = true;
            }
        }
        return modificado;
    }
    public UsuarioAdministrador obtenerUsuarioAdministrador(String codigo) {
        UsuarioAdministrador miUsuarioAdministrador = new UsuarioAdministrador();
        for(UsuarioAdministrador usuarioadministradorAux : usuarioadministrador) {
            if(usuarioadministradorAux.getCodigo().equals(codigo)) {
                miUsuarioAdministrador=usuarioadministradorAux;
            }
        }
        return miUsuarioAdministrador;
    }
    public ArrayList<UsuarioAdministrador> obtenerUsuariosAdministradores() {
        return usuarioadministrador;
    }
    public boolean eliminarUsuarioAdministrador(String codigo) {
        boolean eliminado = false;
        for(UsuarioAdministrador usuarioadministradorAux : usuarioadministrador) {
            if(usuarioadministradorAux.getCodigo().equals(codigo)) {
                usuarioadministrador.remove(usuarioadministradorAux);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
}

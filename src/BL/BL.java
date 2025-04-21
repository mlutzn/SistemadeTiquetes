package BL;

import DAO.TiqueteDAO;
import DAO.UsuarioDAO;

import java.util.ArrayList;

public class BL {

    private UsuarioDAO usuariodao;
    private TiqueteDAO tiquetedao;

    public BL() {
        usuariodao = new UsuarioDAO();
        tiquetedao = new TiqueteDAO();
    }
    // Métodos para Incidente
    public boolean agregarIncidente(Incidente incidente) {
        boolean duplicado = false;
        try {
            for(Incidente incidenteTmp:tiquetedao.listarIncidentes())
            {
                if(incidenteTmp.getCodigo().equals(incidente.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                tiquetedao.insertarIncidente(incidente);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

    public boolean modificarIncidente(Incidente incidente) {
        boolean modificado = false;
        try {
            tiquetedao.modificarIncidente(incidente);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public Incidente obtenerIncidente(String codigo) {
        Incidente miIncidente = new Incidente();
        try{
            miIncidente=tiquetedao.obtenerIncidente(codigo);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return miIncidente;
    }

    public ArrayList<Incidente> obtenerIncidentes() {
        ArrayList<Incidente> incidentes = new ArrayList<>();
        try
        {
            incidentes = tiquetedao.listarIncidentes();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return incidentes;
    }

    public boolean eliminarIncidente(String codigo) {
        boolean eliminado = false;
        try{
                tiquetedao.eliminarIncidente(codigo);
                eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }

    // Métodos para SolicitudDeCambio
    public boolean agregarSolicitudDeCambio(SolicitudDeCambio solicituddecambio) {
        boolean duplicado = false;
        try {
            for(SolicitudDeCambio SolicitudDeCambioTmp:tiquetedao.listarSolicitudDeCambio())
            {
                if(SolicitudDeCambioTmp.getCodigo().equals(solicituddecambio.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                tiquetedao.insertarSolicitudDeCambio(solicituddecambio);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

    public boolean modificarSolicitudDeCambio(SolicitudDeCambio solicituddecambio) {
        boolean modificado = false;
        try {
            tiquetedao.modificarSolicitudDeCambio(solicituddecambio);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public SolicitudDeCambio obtenerSolicitudDeCambio(String codigo) {
        SolicitudDeCambio miSolicitudDeCambio = new SolicitudDeCambio();
        try{
            miSolicitudDeCambio=tiquetedao.obtenerSolicitudDeCambio(codigo);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return miSolicitudDeCambio;
    }

    public ArrayList<SolicitudDeCambio> obtenerSolicitudDeCambio() {
        ArrayList<SolicitudDeCambio> solicituddecambios = new ArrayList<>();
        try
        {
            solicituddecambios = tiquetedao.listarSolicitudDeCambio();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return solicituddecambios;
    }

    public boolean eliminarSolicitudDeCambio(String codigo) {
        boolean eliminado = false;
        try{
            tiquetedao.eliminarSolicitudDeCambio(codigo);
            eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    public ArrayList<SolicitudDeCambio> listarSolicitudDeCambio() {
        ArrayList<SolicitudDeCambio> solicituddecambios = new ArrayList<>();
        try
        {
            solicituddecambios = tiquetedao.listarSolicitudDeCambio();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return solicituddecambios;
    }

    // Métodos para SolicitudDeServicio
    public boolean agregarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio) {
        boolean duplicado = false;
        try {
            for(SolicitudDeServicio solicituddeservicioTmp:tiquetedao.listarSolicitudDeServicio())
            {
                if(solicituddeservicioTmp.getCodigo().equals(solicituddeservicio.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                tiquetedao.insertarSolicitudDeServicio(solicituddeservicio);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

    public boolean modificarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio) {
        boolean modificado = false;
        try {
            tiquetedao.modificarSolicitudDeServicio(solicituddeservicio);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public SolicitudDeServicio obtenerSolicitudDeServicio(String codigo) {
        SolicitudDeServicio miSolicitudDeServicio = new SolicitudDeServicio();
        try{
            miSolicitudDeServicio=tiquetedao.obtenerSolicitudDeServicio(codigo);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return miSolicitudDeServicio;
    }

    public ArrayList<SolicitudDeServicio> listarSolicitudDeServicio() {
        ArrayList<SolicitudDeServicio> solicituddeservicios = new ArrayList<>();
        try
        {
            solicituddeservicios = tiquetedao.listarSolicitudDeServicio();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return solicituddeservicios;
    }

    public boolean eliminarSolicitudDeServicio(String codigo) {
        boolean eliminado = false;
        try{
            tiquetedao.eliminarSolicitudDeServicio(codigo);
            eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    // Métodos para UsuarioCreador
    public boolean agregarUsuarioCreador(UsuarioCreador usuariocreador) {
        boolean duplicado = false;
        try {
            for(UsuarioCreador usuariocreadorTmp:usuariodao.listarUsuarioCreador())
            {
                if(usuariocreadorTmp.getCodigo().equals(usuariocreador.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                usuariodao.insertarUsuarioCreador(usuariocreador);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

    public boolean modificarUsuarioCreador(UsuarioCreador usuarioCreador) {
        boolean modificado = false;
        try {
            usuariodao.modificarUsuarioCreador(usuarioCreador);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public boolean eliminarUsuarioCreador(String codigo) {
        boolean eliminado = false;
        try{
            usuariodao.eliminarUsuarioCreador(codigo);
            eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }

    // Métodos para UsuarioAdministrador
    public boolean agregarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        boolean duplicado = false;
        try {
            for(UsuarioAdministrador usuarioadministradorTmp:usuariodao.listarUsuarioAdministrador())
            {
                if(usuarioadministradorTmp.getCodigo().equals(usuarioAdministrador.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                usuariodao.insertarUsuarioAdmin(usuarioAdministrador);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

    public boolean modificarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        boolean modificado = false;
        try {
            usuariodao.modificarUsuarioAdministrador(usuarioAdministrador);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public boolean eliminarUsuarioAdministrador(String codigo) {
        boolean eliminado = false;
        try{
            usuariodao.eliminarUsuarioAdministrador(codigo);
            eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    // Métodos para UsuarioTecnico
    public boolean agregarUsuarioTecnico(UsuarioTecnico usuariotecnico) {
        boolean duplicado = false;
        try {
            for(UsuarioTecnico usuariotecnicoTmp:usuariodao.listarUsuarioTecnico())
            {
                if(usuariotecnicoTmp.getCodigo().equals(usuariotecnico.getCodigo())) {
                    duplicado = true;
                }
            }
            if(!duplicado) {
                usuariodao.insertarUsuarioTecnico(usuariotecnico);
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return duplicado;
    }

public boolean modificarUsuarioTecnico(UsuarioTecnico usuariotecnico) {
    boolean modificado = false;
    try {
        usuariodao.modificarUsuarioTecnico(usuariotecnico);
        modificado = true;
    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
    return modificado;
}

public boolean eliminarusuariotecnico(String codigo) {
    boolean eliminado = false;
    try{
        usuariodao.eliminarUsuarioTecnico(codigo);
        eliminado = true;
    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
    return eliminado;
}

//Usuario
public boolean agregarUsuario(Usuario usuario) {
    boolean duplicado = false;
    try {
        for(Usuario usuarioTmp:usuariodao.listarUsuario())
        {
            if(usuarioTmp.getCodigo().equals(usuario.getCodigo())) {
                duplicado = true;
            }
        }
        if(!duplicado) {
            usuariodao.insertarUsuario(usuario);
        }

    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
    return duplicado;
}

    public boolean modificarUsuario(Usuario usuario) {
        boolean modificado = false;
        try {
            usuariodao.modificarUsuario(usuario);
            modificado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public boolean eliminarusuario(String codigo) {
        boolean eliminado = false;
        try{
            usuariodao.eliminarUsuario(codigo);
            eliminado = true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    public Usuario obtenerUsuario(String codigo) {
        Usuario miUsuario = new Usuario();
        try{
            miUsuario=usuariodao.obtenerUsuario(codigo);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return miUsuario;
    }

/*    // Métodos auxiliares de validación
    private boolean existeIncidente(String codigo) {
        if (incidentes == null) return false;
        for (Incidente incidente : incidentes) {
            if (incidente.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    private boolean existeSolicitudDeCambio(String codigo) {
        if (solicituddecambios == null) return false;
        for (SolicitudDeCambio solicituddeservicio : solicituddecambios) {
            if (solicituddecambio.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    private boolean existeSolicitudDeServicio(String codigo) {
        if (solicituddeservicios == null) return false;
        for (SolicitudDeServicio solicituddeservicio : solicituddeservicios) {
            if (solicituddeservicio.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeUsuarioCreador(String codigo) {
        if (usuariocreador == null) return false;
        for (UsuarioCreador usuarioCreador : usuariocreador) {
            if (usuarioCreador.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeUsuarioAdministrador(String codigo) {
        if (usuarioadministrador == null) return false;
        for (UsuarioAdministrador usuarioadministrador : usuarioadministrador) {
            if (usuarioadministrador.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    private boolean existeUsuarioTecnico(String codigo) {
        if (usuariotecnico == null) return false;
        for (UsuarioTecnico usuariotecnico : usuariotecnico) {
            if (usuariotecnico.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

 */
}
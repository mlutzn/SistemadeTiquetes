package BL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class BL {
    private ArrayList<UsuarioCreador> usuariocreador;
    private ArrayList<UsuarioAdministrador> usuarioadministrador;
    private ArrayList<UsuarioTecnico> usuariotecnico;
    private ArrayList<Incidente> incidentes;
    private ArrayList<SolicitudDeCambio> solicituddecambios;
    private ArrayList<SolicitudDeServicio> solicituddeservicios;


    // Métodos para Incidente
    public void agregarIncidente(Incidente incidente) {
        if (incidente == null) {
            throw new IllegalArgumentException("El incidente no puede ser nulo");
        }

        if (incidentes == null) {
            incidentes = new ArrayList<>();
        }

        if (existeIncidente(incidente.getCodigo())) {
            throw new IllegalStateException("Ya existe un incidente con el código: " + incidente.getCodigo());
        }

        incidentes.add(incidente);
    }

    public boolean modificarIncidente(Incidente incidente) {
        if (incidente == null) {
            throw new IllegalArgumentException("El incidente no puede ser nulo");
        }

        if (incidentes == null || incidentes.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (Incidente incidenteAux : incidentes) {
                if (incidenteAux.getCodigo().equals(incidente.getCodigo())) {
                    incidenteAux.setEstado(incidente.getEstado());
                    incidenteAux.setNota(incidente.getNota());
                    incidenteAux.setDescripcion(incidente.getDescripcion());
                    incidenteAux.setUsuarioCreador(incidente.getUsuarioCreador());
                    incidenteAux.setUsuarioTecnicoAsignado(incidente.getUsuarioTecnicoAsignado());
                    incidenteAux.setFechaSolucion(incidente.getFechaSolucion());
                    incidenteAux.setDescripcionSolucion(incidente.getDescripcionSolucion());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar el incidente", e);
        }
        return modificado;
    }

    public Incidente obtenerIncidente(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (incidentes == null || incidentes.isEmpty()) {
            return null;
        }

        for (Incidente incidenteAux : incidentes) {
            if (incidenteAux.getCodigo().equals(codigo)) {
                return incidenteAux;
            }
        }
        return null;
    }

    public ArrayList<Incidente> obtenerIncidentes() {
        if (incidentes == null) {
            return new ArrayList<>(); // Retorna lista vacía en lugar de null
        }
        return new ArrayList<>(incidentes); // Retorna copia para evitar modificaciones externas
    }

    public boolean eliminarIncidente(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (incidentes == null || incidentes.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<Incidente> iterator = incidentes.iterator();
            while (iterator.hasNext()) {
                Incidente incidenteAux = iterator.next();
                if (incidenteAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar incidente", e);
        }
        return eliminado;
    }
    // Métodos para SolicitudDeCambio
    public void agregarSolicitudDeCambio(SolicitudDeCambio solicituddecambio) {
        if (solicituddecambio == null) {
            throw new IllegalArgumentException("La Solicitud De Cambio no puede ser nulo");
        }

        if (solicituddecambios == null) {
            solicituddecambios = new ArrayList<>();
        }

        if (existeSolicitudDeCambio(solicituddecambio.getCodigo())) {
            throw new IllegalStateException("Ya existe un incidente con el código: " + solicituddecambio.getCodigo());
        }

        solicituddecambios.add(solicituddecambio);
    }

    public boolean modificarSolicitudDeCambio(SolicitudDeCambio solicituddecambio) {
        if (solicituddecambio == null) {
            throw new IllegalArgumentException("La Solicitud de Cambio no puede ser nulo");
        }

        if (solicituddecambios == null || solicituddecambios.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (SolicitudDeCambio solicituddecambioAux : solicituddecambios) {
                if (solicituddecambioAux.getCodigo().equals(solicituddecambio.getCodigo())) {
                    solicituddecambioAux.setEstado(solicituddecambio.getEstado());
                    solicituddecambioAux.setNota(solicituddecambio.getNota());
                    solicituddecambioAux.setDescripcion(solicituddecambio.getDescripcion());
                    solicituddecambioAux.setUsuarioCreador(solicituddecambio.getUsuarioCreador());
                    solicituddecambioAux.setUsuarioTecnicoAsignado(solicituddecambio.getUsuarioTecnicoAsignado());
                    solicituddecambioAux.setFechaReqCambio(solicituddecambio.getFechaReqCambio());
                    solicituddecambioAux.setPasosEjecCambio(solicituddecambio.getPasosEjecCambio());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la Solicitud de Cambio", e);
        }
        return modificado;
    }

    public SolicitudDeCambio obtenerSolicitudDeCambio(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (solicituddecambios == null || solicituddecambios.isEmpty()) {
            return null;
        }

        for (SolicitudDeCambio solicituddecambioAux : solicituddecambios) {
            if (solicituddecambioAux.getCodigo().equals(codigo)) {
                return solicituddecambioAux;
            }
        }
        return null;
    }

    public ArrayList<SolicitudDeCambio> obtenerSolicitudDeCambio() {
        if (solicituddecambios == null) {
            return new ArrayList<>(); // Retorna lista vacía en lugar de null
        }
        return new ArrayList<>(solicituddecambios); // Retorna copia para evitar modificaciones externas
    }

    public boolean eliminarSolicitudDeCambio(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (solicituddecambios == null || solicituddecambios.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<SolicitudDeCambio> iterator = solicituddecambios.iterator();
            while (iterator.hasNext()) {
                SolicitudDeCambio solicituddecambioAux = iterator.next();
                if (solicituddecambioAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar Solicitud De Cambio", e);
        }
        return eliminado;
    }

    // Métodos para SolicitudDeServicio
    public void agregarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio) {
        if (solicituddeservicio == null) {
            throw new IllegalArgumentException("La Solicitud de Servicio no puede ser nulo");
        }

        if (solicituddeservicios == null) {
            solicituddeservicios = new ArrayList<>();
        }

        if (existeSolicitudDeServicio(solicituddeservicio.getCodigo())) {
            throw new IllegalStateException("Ya existe una Solicitud de Servicio con el código: " + solicituddeservicio.getCodigo());
        }

        solicituddeservicios.add(solicituddeservicio);
    }

    public boolean modificarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio) {
        if (solicituddeservicio == null) {
            throw new IllegalArgumentException("La Solicitud de Servicio no puede ser nulo");
        }

        if (solicituddeservicios == null || solicituddeservicios.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (SolicitudDeServicio solicituddeservicioAux : solicituddeservicios) {
                if (solicituddeservicioAux.getCodigo().equals(solicituddeservicio.getCodigo())) {
                    solicituddeservicioAux.setEstado(solicituddeservicio.getEstado());
                    solicituddeservicioAux.setNota(solicituddeservicio.getNota());
                    solicituddeservicioAux.setDescripcion(solicituddeservicio.getDescripcion());
                    solicituddeservicioAux.setUsuarioCreador(solicituddeservicio.getUsuarioCreador());
                    solicituddeservicioAux.setUsuarioTecnicoAsignado(solicituddeservicio.getUsuarioTecnicoAsignado());
                    solicituddeservicioAux.setJustificacionServicio(solicituddeservicio.getJustificacionServicio());
                    solicituddeservicioAux.setPrioridad(solicituddeservicio.getPrioridad());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la Solicitud de Servicio", e);
        }
        return modificado;
    }

    public SolicitudDeServicio obtenerSolicitudDeServicio(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (solicituddeservicios == null || solicituddeservicios.isEmpty()) {
            return null;
        }

        for (SolicitudDeServicio solicituddeservicioAux : solicituddeservicios) {
            if (solicituddeservicioAux.getCodigo().equals(codigo)) {
                return solicituddeservicioAux;
            }
        }
        return null;
    }

    public ArrayList<SolicitudDeServicio> obtenerSolicitudDeServicios() {
        if (solicituddeservicios == null) {
            return new ArrayList<>(); // Retorna lista vacía en lugar de null
        }
        return new ArrayList<>(solicituddeservicios); // Retorna copia para evitar modificaciones externas
    }

    public boolean eliminarSolicitudDeServicio(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (solicituddeservicios == null || solicituddeservicios.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<SolicitudDeServicio> iterator = solicituddeservicios.iterator();
            while (iterator.hasNext()) {
                SolicitudDeServicio solicituddeservicioAux = iterator.next();
                if (solicituddeservicioAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar La Solicitud de Servicio", e);
        }
        return eliminado;
    }
    // Métodos para UsuarioCreador
    public void agregarUsuarioCreador(UsuarioCreador usuarioCreador) {
        if (usuarioCreador == null) {
            throw new IllegalArgumentException("El usuario creador no puede ser nulo");
        }

        if (usuariocreador == null) {
            usuariocreador = new ArrayList<>();
        }

        if (existeUsuarioCreador(usuarioCreador.getCodigo())) {
            throw new IllegalStateException("Ya existe un usuario creador con el código: " + usuarioCreador.getCodigo());
        }

        usuariocreador.add(usuarioCreador);
    }

    public boolean modificarUsuarioCreador(UsuarioCreador usuarioCreador) {
        if (usuarioCreador == null) {
            throw new IllegalArgumentException("El usuario creador no puede ser nulo");
        }

        if (usuariocreador == null || usuariocreador.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (UsuarioCreador usuariocreadorAux : usuariocreador) {
                if (usuariocreadorAux.getCodigo().equals(usuarioCreador.getCodigo())) {
                    usuariocreadorAux.setDepartamento(usuarioCreador.getDepartamento());
                    usuariocreadorAux.setPassword(usuarioCreador.getPassword());
                    usuariocreadorAux.setNombre(usuarioCreador.getNombre());
                    usuariocreadorAux.setCorreoElectronico(usuarioCreador.getCorreoElectronico());
                    usuariocreadorAux.setTelefono(usuarioCreador.getTelefono());
                    usuariocreadorAux.setPrimerApellido(usuarioCreador.getPrimerApellido());
                    usuariocreadorAux.setSegundoApellido(usuarioCreador.getSegundoApellido());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar usuario creador", e);
        }
        return modificado;
    }

    public UsuarioCreador obtenerUsuarioCreador(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuariocreador == null || usuariocreador.isEmpty()) {
            return null;
        }

        for (UsuarioCreador usuariocreadorAux : usuariocreador) {
            if (usuariocreadorAux.getCodigo().equals(codigo)) {
                return usuariocreadorAux;
            }
        }
        return null;
    }

    public ArrayList<UsuarioCreador> obtenerUsuariosCreadores() {
        if (usuariocreador == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(usuariocreador);
    }

    public boolean eliminarUsuarioCreador(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuariocreador == null || usuariocreador.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<UsuarioCreador> iterator = usuariocreador.iterator();
            while (iterator.hasNext()) {
                UsuarioCreador usuariocreadorAux = iterator.next();
                if (usuariocreadorAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar usuario creador", e);
        }
        return eliminado;
    }

    // Métodos para UsuarioAdministrador
    public void agregarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        if (usuarioAdministrador == null) {
            throw new IllegalArgumentException("El usuario administrador no puede ser nulo");
        }

        if (usuarioadministrador == null) {
            usuarioadministrador = new ArrayList<>();
        }

        if (existeUsuarioAdministrador(usuarioAdministrador.getCodigo())) {
            throw new IllegalStateException("Ya existe un usuario administrador con el código: " + usuarioAdministrador.getCodigo());
        }

        usuarioadministrador.add(usuarioAdministrador);
    }

    public boolean modificarUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        if (usuarioAdministrador == null) {
            throw new IllegalArgumentException("El usuario administrador no puede ser nulo");
        }

        if (usuarioadministrador == null || usuarioadministrador.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (UsuarioAdministrador usuarioadministradorAux : usuarioadministrador) {
                if (usuarioadministradorAux.getCodigo().equals(usuarioAdministrador.getCodigo())) {
                    usuarioadministradorAux.setPassword(usuarioAdministrador.getPassword());
                    usuarioadministradorAux.setNombre(usuarioAdministrador.getNombre());
                    usuarioadministradorAux.setCorreoElectronico(usuarioAdministrador.getCorreoElectronico());
                    usuarioadministradorAux.setTelefono(usuarioAdministrador.getTelefono());
                    usuarioadministradorAux.setPrimerApellido(usuarioAdministrador.getPrimerApellido());
                    usuarioadministradorAux.setSegundoApellido(usuarioAdministrador.getSegundoApellido());
                    usuarioadministradorAux.setEstado(usuarioAdministrador.getEstado());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar usuario administrador", e);
        }
        return modificado;
    }

    public UsuarioAdministrador obtenerUsuarioAdministrador(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuarioadministrador == null || usuarioadministrador.isEmpty()) {
            return null;
        }

        for (UsuarioAdministrador usuarioadministradorAux : usuarioadministrador) {
            if (usuarioadministradorAux.getCodigo().equals(codigo)) {
                return usuarioadministradorAux;
            }
        }
        return null;
    }

    public ArrayList<UsuarioAdministrador> obtenerUsuariosAdministradores() {
        if (usuarioadministrador == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(usuarioadministrador);
    }

    public boolean eliminarUsuarioAdministrador(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuarioadministrador == null || usuarioadministrador.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<UsuarioAdministrador> iterator = usuarioadministrador.iterator();
            while (iterator.hasNext()) {
                UsuarioAdministrador usuarioadministradorAux = iterator.next();
                if (usuarioadministradorAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar usuario administrador", e);
        }
        return eliminado;
    }
    // Métodos para UsuarioTecnico
    public void agregarUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
        if (usuarioTecnico == null) {
            throw new IllegalArgumentException("El usuario administrador no puede ser nulo");
        }

        if (usuariotecnico == null) {
            usuariotecnico = new ArrayList<>();
        }

        if (existeUsuarioTecnico(usuarioTecnico.getCodigo())) {
            throw new IllegalStateException("Ya existe un usuario administrador con el código: " + usuarioTecnico.getCodigo());
        }

        usuariotecnico.add(usuarioTecnico);
    }

    public boolean modificarUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
        if (usuarioTecnico == null) {
            throw new IllegalArgumentException("El usuario administrador no puede ser nulo");
        }

        if (usuariotecnico == null || usuariotecnico.isEmpty()) {
            return false;
        }

        boolean modificado = false;
        try {
            for (UsuarioTecnico usuariotecnicoAux : usuariotecnico) {
                if (usuariotecnicoAux.getCodigo().equals(usuarioTecnico.getCodigo())) {
                    usuariotecnicoAux.setPassword(usuarioTecnico.getPassword());
                    usuariotecnicoAux.setNombre(usuarioTecnico.getNombre());
                    usuariotecnicoAux.setCorreoElectronico(usuarioTecnico.getCorreoElectronico());
                    usuariotecnicoAux.setTelefono(usuarioTecnico.getTelefono());
                    usuariotecnicoAux.setPrimerApellido(usuarioTecnico.getPrimerApellido());
                    usuariotecnicoAux.setSegundoApellido(usuarioTecnico.getSegundoApellido());
                    usuariotecnicoAux.setRol(usuarioTecnico.getRol());
                    modificado = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar usuario administrador", e);
        }
        return modificado;
    }

    public UsuarioTecnico obtenerUsuarioTecnico(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuariotecnico == null || usuariotecnico.isEmpty()) {
            return null;
        }

        for (UsuarioTecnico usuariotecnicoAux : usuariotecnico) {
            if (usuariotecnicoAux.getCodigo().equals(codigo)) {
                return usuariotecnicoAux;
            }
        }
        return null;
    }

    public ArrayList<UsuarioTecnico> obtenerUsuariosTecnico() {
        if (usuariotecnico == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(usuariotecnico);
    }

    public boolean eliminarUsuarioTecnico(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }

        if (usuariotecnico == null || usuariotecnico.isEmpty()) {
            return false;
        }

        boolean eliminado = false;
        try {
            Iterator<UsuarioTecnico> iterator = usuariotecnico.iterator();
            while (iterator.hasNext()) {
                UsuarioTecnico usuariotecnicoAux = iterator.next();
                if (usuariotecnicoAux.getCodigo().equals(codigo)) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }
        } catch (ConcurrentModificationException e) {
            throw new RuntimeException("Error de modificación concurrente al eliminar usuario administrador", e);
        }
        return eliminado;
    }

    // Métodos auxiliares de validación
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
        for (SolicitudDeCambio solicituddecambio : solicituddecambios) {
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
}
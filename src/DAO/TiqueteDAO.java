package DAO;

import BL.Incidente;
import BL.SolicitudDeServicio;
import BL.SolicitudDeCambio;


import java.sql.*;
import java.util.ArrayList;

public class TiqueteDAO {

    BL.Configuracion configuracion = new BL.Configuracion();

    //Incidentes
    public void insertarIncidente(Incidente incidente)
    {
        try {

            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "INSERT INTO tiquete(estado,nota,codigo,descripcion,usuariocreador,usuariotecnicoasignado,fechaSolucion,descripcionSolucion ) VALUES(?,?,?,?,?,?,?,?)";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1,incidente.getEstado());
            stmt.setString(2,incidente.getNota());
            stmt.setString(3,incidente.getCodigo());
            stmt.setString(4,incidente.getDescripcion());
            stmt.setString(5,incidente.getUsuarioCreador());
            stmt.setString(6,incidente.getUsuarioTecnicoAsignado());
            stmt.setDate(7,java.sql.Date.valueOf(incidente.getFechaSolucion()));
            stmt.setString(8,incidente.getDescripcionSolucion());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Incidente> listarIncidentes()
    {
        ArrayList<Incidente> incientes = new ArrayList<>();
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM tiquete WHERE codigo LIKE 'IN%'";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                Incidente incidente = new Incidente();
                incidente.setEstado(rs.getString("estado"));
                incidente.setNota(rs.getString("nota"));
                incidente.setCodigo(rs.getString("codigo"));
                incidente.setDescripcion(rs.getString("descripcion"));
                incidente.setUsuarioCreador(rs.getString("usuariocreador"));
                incidente.setUsuarioTecnicoAsignado();
                incidente.setFechaSolucion(rs.getDate("fechaSolucion").toLocalDate());
                incidente.setDescripcionSolucion(rs.getString("descripcionSolucion"));
                incientes.add(incidente);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return incientes;
    }

    public void modificarIncidente(Incidente incidente)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "UPDATE tiquete SET estado=?,nota=?,descripcion=?,usuariocreador=?,usuariotecnicoasignado=?,fechaSolucion=?,descripcionSolucion=? where codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);

            stmt.setString(1,incidente.getEstado());
            stmt.setString(2,incidente.getNota());
            stmt.setString(3,incidente.getDescripcion());
            stmt.setString(4,incidente.getUsuarioCreador());
            stmt.setString(5,incidente.getUsuarioTecnicoAsignado());
            stmt.setDate(6,java.sql.Date.valueOf(incidente.getFechaSolucion()));
            stmt.setString(7,incidente.getDescripcionSolucion());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarIncidente(String codigo)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "DELETE FROM tiquete WHERE codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1, codigo);
            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Incidente obtenerIncidente(String codigo) {
        Incidente incidente = new Incidente();
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "select * from tiquete where codigo = ?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,codigo);
            ResultSet rs = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(rs.next()){
                incidente.setEstado(rs.getString("estado"));
                incidente.setNota(rs.getString("nota"));
                incidente.setCodigo(rs.getString("codigo"));
                incidente.setDescripcion(rs.getString("descripcion"));
                incidente.setUsuarioCreador(rs.getString("usuariocreador"));
                incidente.setUsuarioTecnicoAsignado();
                incidente.setFechaSolucion(rs.getDate("fechaSolucion").toLocalDate());
                incidente.setDescripcionSolucion(rs.getString("descripcionSolucion"));
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return incidente;
    }

    //Solicitudes de Servicio
    public void insertarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio)
    {
        try {

            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "INSERT INTO tiquete(estado,nota,codigo,descripcion,usuariocreador,usuariotecnicoasignado,justificacionServicio,prioridad ) VALUES(?,?,?,?,?,?,?,?)";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1,solicituddeservicio.getEstado());
            stmt.setString(2,solicituddeservicio.getNota());
            stmt.setString(3,solicituddeservicio.getCodigo());
            stmt.setString(4,solicituddeservicio.getDescripcion());
            stmt.setString(5,solicituddeservicio.getUsuarioCreador());
            stmt.setString(6,solicituddeservicio.getUsuarioTecnicoAsignado());
            stmt.setString(7,solicituddeservicio.getJustificacionServicio());
            stmt.setInt(8,solicituddeservicio.getPrioridad());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SolicitudDeServicio> listarSolicitudDeServicio()
    {
        ArrayList<SolicitudDeServicio> solicituddeservicios = new ArrayList<>();
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM tiquete WHERE CODIGO LIKE 'SS%'";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                SolicitudDeServicio solicituddeservicio = new SolicitudDeServicio();
                solicituddeservicio.setEstado(rs.getString("estado"));
                solicituddeservicio.setNota(rs.getString("nota"));
                solicituddeservicio.setCodigo(rs.getString("codigo"));
                solicituddeservicio.setDescripcion(rs.getString("descripcion"));
                solicituddeservicio.setUsuarioCreador(rs.getString("usuariocreador"));
                solicituddeservicio.setUsuarioTecnicoAsignado();
                solicituddeservicio.setJustificacionServicio(rs.getString("justificacionServicio"));
                solicituddeservicio.setPrioridad(rs.getInt("prioridad"));
                solicituddeservicios.add(solicituddeservicio);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return solicituddeservicios;
    }

    public void modificarSolicitudDeServicio(SolicitudDeServicio solicituddeservicio)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "UPDATE tiquete SET estado=?,nota=?,descripcion=?,usuariocreador=?,usuariotecnicoasignado=?,justificacionServicio=?,prioridad=? where codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);

            stmt.setString(1,solicituddeservicio.getEstado());
            stmt.setString(2,solicituddeservicio.getNota());
            stmt.setString(3,solicituddeservicio.getDescripcion());
            stmt.setString(4,solicituddeservicio.getUsuarioCreador());
            stmt.setString(5,solicituddeservicio.getUsuarioTecnicoAsignado());
            stmt.setString(6,solicituddeservicio.getJustificacionServicio());
            stmt.setInt(7,solicituddeservicio.getPrioridad());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSolicitudDeServicio(String codigo)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "DELETE FROM tiquete WHERE codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1, codigo);
            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public SolicitudDeServicio obtenerSolicitudDeServicio(String codigo) {
        SolicitudDeServicio solicituddeservicio = new SolicitudDeServicio();
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "select * from CURSO where CODIGO = ?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,codigo);
            ResultSet rs = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(rs.next()){
                solicituddeservicio.setEstado(rs.getString("estado"));
                solicituddeservicio.setNota(rs.getString("nota"));
                solicituddeservicio.setCodigo(rs.getString("codigo"));
                solicituddeservicio.setDescripcion(rs.getString("descripcion"));
                solicituddeservicio.setUsuarioCreador(rs.getString("usuariocreador"));
                solicituddeservicio.setUsuarioTecnicoAsignado();
                solicituddeservicio.setJustificacionServicio(rs.getString("justificacionServicio"));
                solicituddeservicio.setPrioridad(rs.getInt("prioridad"));
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return solicituddeservicio;
    }
// Solicitud de cambio
public void insertarSolicitudDeCambio(SolicitudDeCambio solicituddecambio)
{
    try {

        BL.Configuracion configuracion = new BL.Configuracion();
        Class.forName(configuracion.getClaseJDBC());

        String query = "INSERT INTO tiquete(estado,nota,codigo,descripcion,usuariocreador,usuariotecnicoasignado,fechaeeqcambio,pasosejeccambio ) VALUES(?,?,?,?,?,?,?,?)";

        Connection conn=null;
        PreparedStatement stmt=null;
        String strConexion =configuracion.getStringConexion();
        conn= DriverManager.getConnection(strConexion);
        stmt= conn.prepareStatement(query);
        stmt.setString(1,solicituddecambio.getEstado());
        stmt.setString(2,solicituddecambio.getNota());
        stmt.setString(3,solicituddecambio.getCodigo());
        stmt.setString(4,solicituddecambio.getDescripcion());
        stmt.setString(5,solicituddecambio.getUsuarioCreador());
        stmt.setString(6,solicituddecambio.getUsuarioTecnicoAsignado());
        stmt.setDate(7,java.sql.Date.valueOf(solicituddecambio.getFechaReqCambio()));
        stmt.setString(8,solicituddecambio.getPasosEjecCambio());


        stmt.execute();
        conn.close();

    } catch (ClassNotFoundException e) {
        e.printStackTrace();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public ArrayList<SolicitudDeCambio> listarSolicitudDeCambio()
    {
        ArrayList<SolicitudDeCambio> solicituddecambios = new ArrayList<>();
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM tiquete WHERE codigo LIKE 'IN%'";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                SolicitudDeCambio solicituddecambio = new SolicitudDeCambio();
                solicituddecambio.setEstado(rs.getString("estado"));
                solicituddecambio.setNota(rs.getString("nota"));
                solicituddecambio.setCodigo(rs.getString("codigo"));
                solicituddecambio.setDescripcion(rs.getString("descripcion"));
                solicituddecambio.setUsuarioCreador(rs.getString("usuariocreador"));
                solicituddecambio.setUsuarioTecnicoAsignado();
                solicituddecambio.setFechaReqCambio(rs.getDate("fechaeeqcambio").toLocalDate());
                solicituddecambio.setPasosEjecCambio(rs.getString("pasosejeccambio"));
                solicituddecambios.add(solicituddecambio);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return solicituddecambios;
    }

    public void modificarSolicitudDeCambio(SolicitudDeCambio solicituddecambio)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "UPDATE tiquete SET estado=?,nota=?,descripcion=?,usuariocreador=?,usuariotecnicoasignado=?,fechaeeqcambio=?,pasosejeccambio=? where codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);

            stmt.setString(1,solicituddecambio.getEstado());
            stmt.setString(2,solicituddecambio.getNota());
            stmt.setString(3,solicituddecambio.getDescripcion());
            stmt.setString(4,solicituddecambio.getUsuarioCreador());
            stmt.setString(5,solicituddecambio.getUsuarioTecnicoAsignado());
            stmt.setDate(6,java.sql.Date.valueOf(solicituddecambio.getFechaReqCambio()));
            stmt.setString(7,solicituddecambio.getPasosEjecCambio());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSolicitudDeCambio(String codigo)
    {
        try {
            BL.Configuracion configuracion = new BL.Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "DELETE FROM tiquete WHERE codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1, codigo);
            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public SolicitudDeCambio obtenerSolicitudDeCambio(String codigo) {
        SolicitudDeCambio solicituddecambio = new SolicitudDeCambio();
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "select * from tiquete where codigo = ?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,codigo);
            ResultSet rs = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(rs.next()){
                solicituddecambio.setEstado(rs.getString("estado"));
                solicituddecambio.setNota(rs.getString("nota"));
                solicituddecambio.setCodigo(rs.getString("codigo"));
                solicituddecambio.setDescripcion(rs.getString("descripcion"));
                solicituddecambio.setUsuarioCreador(rs.getString("usuariocreador"));
                solicituddecambio.setUsuarioTecnicoAsignado();
                solicituddecambio.setFechaReqCambio(rs.getDate("fechaeeqcambio").toLocalDate());
                solicituddecambio.setPasosEjecCambio(rs.getString("pasosejeccambio"));
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return solicituddecambio;
    }
// Estadisticas
/*
    public int numeroTiquetestipoestado(String cedulaEstudiante) {

        int cantidadtiquetes=0;

        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "SELECT COUNT(*) FROM CURSO_ESTUDIANTE WHERE CEDULAESTUDIANTE=?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,cedulaEstudiante);
            ResultSet resultSet = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(resultSet.next()){
                cantidadMatriculados=resultSet.getInt(1);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cantidadMatriculados;
    }


    public int numeroTiquetesusuariotecasig(int codigoCurso) {

        int cantidadtiquetesasig=0;

        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "SELECT COUNT(*) FROM CURSO_ESTUDIANTE WHERE CODIGOCURSO=?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1,codigoCurso);
            ResultSet resultSet = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(resultSet.next()){
                cantidadMatriculados=resultSet.getInt(1);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cantidadMatriculados;
    }
    public int numeroTiquetesusuariocreador(int codigoCurso) {

        int cantidadtiquetesusuariocreador=0;

        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "SELECT COUNT(*) FROM CURSO_ESTUDIANTE WHERE CODIGOCURSO=?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1,codigoCurso);
            ResultSet resultSet = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(resultSet.next()){
                cantidadMatriculados=resultSet.getInt(1);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cantidadMatriculados;
    }
*/
}

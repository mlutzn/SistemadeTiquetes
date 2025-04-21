package DAO;

import BL.*;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {
    Configuracion configuracion = new Configuracion();
        //Usr Admin
        public void insertarUsuarioAdmin(UsuarioAdministrador usuarioadministrador)
        {
            try {

                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "INSERT INTO usuario(codigo,nombre,primerapellido,segundoapellido,correoelectronico,telefono,password,estado) VALUES(?,?,?,?,?,?,?,?)";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);
                stmt.setString(1,usuarioadministrador.getCodigo());
                stmt.setString(2,usuarioadministrador.getNombre());
                stmt.setString(3,usuarioadministrador.getPrimerApellido());
                stmt.setString(4,usuarioadministrador.getSegundoApellido());
                stmt.setString(5,usuarioadministrador.getCorreoElectronico());
                stmt.setInt(6,usuarioadministrador.getTelefono());
                stmt.setString(7,usuarioadministrador.getPassword());
                stmt.setString(8,usuarioadministrador.getEstado());

                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void modificarUsuarioAdministrador(UsuarioAdministrador usuarioadministrador)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "UPDATE usuario SET nombre=?,primerapellido=?,segundoapellido=?,correoelectronico=?,telefono=?,password=?,estado=? where codigo=?";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);

                stmt.setString(1,usuarioadministrador.getCodigo());
                stmt.setString(2,usuarioadministrador.getNombre());
                stmt.setString(3,usuarioadministrador.getPrimerApellido());
                stmt.setString(4,usuarioadministrador.getSegundoApellido());
                stmt.setString(5,usuarioadministrador.getCorreoElectronico());
                stmt.setInt(6,usuarioadministrador.getTelefono());
                stmt.setString(7,usuarioadministrador.getPassword());
                stmt.setString(8,usuarioadministrador.getEstado());

                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void eliminarUsuarioAdministrador(String codigo)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "DELETE FROM usuario WHERE codigo=?";

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
    public ArrayList<UsuarioAdministrador> listarUsuarioAdministrador()
    {
        ArrayList<UsuarioAdministrador> usuarioadministradores = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM usuario";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                UsuarioAdministrador usuarioadministrador = new UsuarioAdministrador();
                usuarioadministrador.setCodigo(rs.getString("codigo"));
                usuarioadministrador.setNombre(rs.getString("nombre"));
                usuarioadministrador.setPrimerApellido(rs.getString("primerapellido"));
                usuarioadministrador.setSegundoApellido(rs.getString("segundoapellido"));
                usuarioadministrador.setCorreoElectronico(rs.getString("correoelectronico"));
                usuarioadministrador.setTelefono(rs.getInt("telefono"));
                usuarioadministrador.setPassword(rs.getString("password"));
                usuarioadministrador.setEstado(rs.getString("estado"));
                usuarioadministradores.add(usuarioadministrador);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuarioadministradores;
    }

        //Usr Creador
        public void insertarUsuarioCreador(UsuarioCreador usuariocreador)
        {
            try {

                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "INSERT INTO usuario(codigo,nombre,primerapellido,segundoapellido,correoelectronico,telefono,password,departamento) VALUES(?,?,?,?,?,?,?,?)";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);
                stmt.setString(1,usuariocreador.getCodigo());
                stmt.setString(2,usuariocreador.getNombre());
                stmt.setString(3,usuariocreador.getPrimerApellido());
                stmt.setString(4,usuariocreador.getSegundoApellido());
                stmt.setString(5,usuariocreador.getCorreoElectronico());
                stmt.setInt(6,usuariocreador.getTelefono());
                stmt.setString(7,usuariocreador.getPassword());
                stmt.setString(8,usuariocreador.getDepartamento());

                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void modificarUsuarioCreador(UsuarioCreador usuariocreador)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "UPDATE usuario SET nombre=?,primerapellido=?,segundoapellido=?,correoelectronico=?,telefono=?,password=?,departamento=? where codigo=?";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);

                stmt.setString(1,usuariocreador.getCodigo());
                stmt.setString(2,usuariocreador.getNombre());
                stmt.setString(3,usuariocreador.getPrimerApellido());
                stmt.setString(4,usuariocreador.getSegundoApellido());
                stmt.setString(5,usuariocreador.getCorreoElectronico());
                stmt.setInt(6,usuariocreador.getTelefono());
                stmt.setString(7,usuariocreador.getPassword());
                stmt.setString(8,usuariocreador.getDepartamento());

                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void eliminarUsuarioCreador(String codigo)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "DELETE FROM usuario WHERE codigo=?";

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
    public ArrayList<UsuarioCreador> listarUsuarioCreador()
    {
        ArrayList<UsuarioCreador> usuariocreadores = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM usuario";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                UsuarioCreador usuariocreador = new UsuarioCreador();
                usuariocreador.setCodigo(rs.getString("codigo"));
                usuariocreador.setNombre(rs.getString("nombre"));
                usuariocreador.setPrimerApellido(rs.getString("primerapellido"));
                usuariocreador.setSegundoApellido(rs.getString("segundoapellido"));
                usuariocreador.setCorreoElectronico(rs.getString("correoelectronico"));
                usuariocreador.setTelefono(rs.getInt("telefono"));
                usuariocreador.setPassword(rs.getString("password"));
                usuariocreador.setDepartamento(rs.getString("departamento"));
                usuariocreadores.add(usuariocreador);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuariocreadores;
    }

        // usr Tecnico
        public void insertarUsuarioTecnico(UsuarioTecnico usuariotecnico)
        {
            try {

                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "INSERT INTO usuario(codigo,nombre,primerapellido,segundoapellido,correoelectronico,telefono,password,rol) VALUES(?,?,?,?,?,?,?,?)";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);
                stmt.setString(1,usuariotecnico.getCodigo());
                stmt.setString(2,usuariotecnico.getNombre());
                stmt.setString(3,usuariotecnico.getPrimerApellido());
                stmt.setString(4,usuariotecnico.getSegundoApellido());
                stmt.setString(5,usuariotecnico.getCorreoElectronico());
                stmt.setInt(6,usuariotecnico.getTelefono());
                stmt.setString(7,usuariotecnico.getPassword());
                stmt.setString(8,usuariotecnico.getRol());


                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void modificarUsuarioTecnico(UsuarioTecnico usuariotecnico)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "UPDATE usuario SET nombre=?,primerapellido=?,segundoapellido=?,correoelectronico=?,telefono=?,password=?,rol=? where codigo=?";

                Connection conn=null;
                PreparedStatement stmt=null;
                String strConexion =configuracion.getStringConexion();
                conn= DriverManager.getConnection(strConexion);
                stmt= conn.prepareStatement(query);

                stmt.setString(1,usuariotecnico.getCodigo());
                stmt.setString(2,usuariotecnico.getNombre());
                stmt.setString(3,usuariotecnico.getPrimerApellido());
                stmt.setString(4,usuariotecnico.getSegundoApellido());
                stmt.setString(5,usuariotecnico.getCorreoElectronico());
                stmt.setInt(6,usuariotecnico.getTelefono());
                stmt.setString(7,usuariotecnico.getPassword());
                stmt.setString(8,usuariotecnico.getRol());

                stmt.execute();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void eliminarUsuarioTecnico(String codigo)
        {
            try {
                Configuracion configuracion = new Configuracion();
                Class.forName(configuracion.getClaseJDBC());

                String query = "DELETE FROM usuario WHERE codigo=?";

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
    public ArrayList<UsuarioTecnico> listarUsuarioTecnico()
    {
        ArrayList<UsuarioTecnico> usuariotecnicos = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM usuario";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                UsuarioTecnico usuariotecnico = new UsuarioTecnico();
                usuariotecnico.setCodigo(rs.getString("codigo"));
                usuariotecnico.setNombre(rs.getString("nombre"));
                usuariotecnico.setPrimerApellido(rs.getString("primerapellido"));
                usuariotecnico.setSegundoApellido(rs.getString("segundoapellido"));
                usuariotecnico.setCorreoElectronico(rs.getString("correoelectronico"));
                usuariotecnico.setTelefono(rs.getInt("telefono"));
                usuariotecnico.setPassword(rs.getString("password"));
                usuariotecnico.setRol(rs.getString("rol"));
                usuariotecnicos.add(usuariotecnico);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuariotecnicos;
    }

    //Usuario
    public ArrayList<Usuario> listarUsuario()
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM usuario";
            Statement stmt=null;
            ResultSet rs=null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //No se cuanto registros vienes, tengo que recorrer el resulset
            while (rs.next())
            {
                Usuario usuario = new UsuarioTecnico();
                usuario.setCodigo(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPrimerApellido(rs.getString("primerapellido"));
                usuario.setSegundoApellido(rs.getString("segundoapellido"));
                usuario.setCorreoElectronico(rs.getString("correoelectronico"));
                usuario.setTelefono(rs.getInt("telefono"));
                usuario.setPassword(rs.getString("password"));
                usuarios.add(usuario);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public void insertarUsuario(Usuario usuario)
    {
        try {

            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "INSERT INTO usuario(codigo,nombre,primerapellido,segundoapellido,correoelectronico,telefono,password, estado, departamento,rol) VALUES(?,?,?,?,?,?,?,?,?,?)";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);
            stmt.setString(1,usuario.getCodigo());
            stmt.setString(2,usuario.getNombre());
            stmt.setString(3,usuario.getPrimerApellido());
            stmt.setString(4,usuario.getSegundoApellido());
            stmt.setString(5,usuario.getCorreoElectronico());
            stmt.setInt(6,usuario.getTelefono());
            stmt.setString(7,usuario.getPassword());

            // Campos específicos según el tipo de usuario
            if (usuario instanceof UsuarioAdministrador) {
                UsuarioAdministrador admin = (UsuarioAdministrador) usuario;
                stmt.setString(8, admin.getEstado());
                stmt.setString(9, null); // Departamento no aplica
                stmt.setString(10, "Administrador");
            }
            else if (usuario instanceof UsuarioTecnico) {
                UsuarioTecnico tecnico = (UsuarioTecnico) usuario;
                stmt.setString(8, null); // Estado no aplica
                stmt.setString(9, null); // Departamento no aplica
                stmt.setString(10, "Técnico");
            }
            else if (usuario instanceof UsuarioCreador) {
                UsuarioCreador creador = (UsuarioCreador) usuario;
                stmt.setString(8, null); // Estado no aplica
                stmt.setString(9, creador.getDepartamento());
                stmt.setString(10, "Creador");
            }


            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarUsuario(Usuario usuario)
    {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "UPDATE usuario SET nombre=?,primerapellido=?,segundoapellido=?,correoelectronico=?,telefono=?,password=?,rol=? where codigo=?";

            Connection conn=null;
            PreparedStatement stmt=null;
            String strConexion =configuracion.getStringConexion();
            conn= DriverManager.getConnection(strConexion);
            stmt= conn.prepareStatement(query);

            stmt.setString(1,usuario.getCodigo());
            stmt.setString(2,usuario.getNombre());
            stmt.setString(3,usuario.getPrimerApellido());
            stmt.setString(4,usuario.getSegundoApellido());
            stmt.setString(5,usuario.getCorreoElectronico());
            stmt.setInt(6,usuario.getTelefono());
            stmt.setString(7,usuario.getPassword());

            stmt.execute();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(String codigo)
    {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());

            String query = "DELETE FROM usuario WHERE codigo=?";

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
        public String autenticarUsuario(String codigo, String password){
                String Password = null;
                String Rol = null;
                try {
                    Class.forName(configuracion.getClaseJDBC());
                    String url = configuracion.getStringConexion();

                    //La instrucción sql que voy a ejecutar
                    String query= "select rol, password from usuario where codigo = ?";
                    //Crear la conexion de base de datos
                    Connection conexion = DriverManager.getConnection(url);
                    //Operaciones en la base de datos
                    PreparedStatement statement = conexion.prepareStatement(query);
                    statement.setString(1,codigo);
                    ResultSet rs = statement.executeQuery();
                    //Necesito recorrer los datos del resultset
                    while(rs.next()){
                        Password = rs.getString("password");
                        Rol = rs.getString("rol");
                    }
                    conexion.close();

                    if (password.equals(Password))
                    {
                        return Rol;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return null;
            }

    public Usuario obtenerUsuario(String codigo) {
        Usuario usuario = new Usuario();
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();

            //La instrucción sql que voy a ejecutar
            String query= "select * from usuario where codigo = ?";
            //Crear la conexion de base de datos
            Connection conexion = DriverManager.getConnection(url);
            //Operaciones en la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,codigo);
            ResultSet rs = statement.executeQuery();
            //Necesito recorrer los datos del resultset
            while(rs.next()){
                usuario.setCodigo(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPrimerApellido(rs.getString("primerapellido"));
                usuario.setSegundoApellido(rs.getString("segundoapellido"));
                usuario.setCorreoElectronico(rs.getString("correoelectronico"));
                usuario.setTelefono(rs.getInt("telefono"));
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

        //

     //
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




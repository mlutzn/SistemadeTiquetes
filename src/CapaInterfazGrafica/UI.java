package CapaInterfazGrafica;

import BL.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class UI extends JFrame {
    private BL bl = new BL();

    private JTabbedPane tabbedPane;

    private JPanel panelIncidentes;
    private JPanel panelUsuariosCreadores;

    public UI() {
        setTitle("Sistema de Gestión de Incidentes y Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        panelIncidentes = crearPanelIncidentes();
        panelUsuariosCreadores = crearPanelUsuariosCreadores();

        tabbedPane.addTab("Incidentes", panelIncidentes);
        tabbedPane.addTab("Usuarios Creadores", panelUsuariosCreadores);

        add(tabbedPane);
    }

    private JPanel crearPanelIncidentes() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));

        JTextField txtCodigo = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtNota = new JTextField();
        JTextField txtDescripcion = new JTextField();
        JTextField txtUsuarioCreador = new JTextField();
        JTextField txtUsuarioTecnico = new JTextField();
        JTextField txtFechaSolucion = new JTextField();
        JTextField txtDescripcionSolucion = new JTextField();

        formPanel.add(new JLabel("Código:"));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(txtEstado);
        formPanel.add(new JLabel("Nota:"));
        formPanel.add(txtNota);
        formPanel.add(new JLabel("Descripción:"));
        formPanel.add(txtDescripcion);
        formPanel.add(new JLabel("Usuario Creador:"));
        formPanel.add(txtUsuarioCreador);
        formPanel.add(new JLabel("Usuario Técnico:"));
        formPanel.add(txtUsuarioTecnico);
        formPanel.add(new JLabel("Fecha Solución (AAAA-MM-DD):"));
        formPanel.add(txtFechaSolucion);
        formPanel.add(new JLabel("Descripción Solución:"));
        formPanel.add(txtDescripcionSolucion);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar Todos");

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnListar);

        JTextArea txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            try {
                Incidente incidente = new Incidente();
                incidente.setCodigo(txtCodigo.getText());
                incidente.setEstado(txtEstado.getText());
                incidente.setNota(txtNota.getText());
                incidente.setDescripcion(txtDescripcion.getText());
                incidente.setUsuarioCreador(txtUsuarioCreador.getText());
                incidente.setUsuarioTecnicoAsignado(txtUsuarioTecnico.getText());

                if (!txtFechaSolucion.getText().isEmpty()) {
                    incidente.setFechaSolucion(LocalDate.parse(txtFechaSolucion.getText()));
                }

                incidente.setDescripcionSolucion(txtDescripcionSolucion.getText());

                bl.agregarIncidente(incidente);
                txtResultados.setText("Incidente agregado exitosamente!\n" + incidente.toString());
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnModificar.addActionListener(e -> {
            try {
                Incidente incidente = new Incidente();
                incidente.setCodigo(txtCodigo.getText());
                incidente.setEstado(txtEstado.getText());
                incidente.setNota(txtNota.getText());
                incidente.setDescripcion(txtDescripcion.getText());
                incidente.setUsuarioCreador(txtUsuarioCreador.getText());
                incidente.setUsuarioTecnicoAsignado(txtUsuarioTecnico.getText());

                if (!txtFechaSolucion.getText().isEmpty()) {
                    incidente.setFechaSolucion(LocalDate.parse(txtFechaSolucion.getText()));
                }

                incidente.setDescripcionSolucion(txtDescripcionSolucion.getText());

                if (bl.modificarIncidente(incidente)) {
                    txtResultados.setText("Incidente modificado exitosamente!\n" + incidente.toString());
                } else {
                    txtResultados.setText("No se encontró el incidente con el código especificado.");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBuscar.addActionListener(e -> {
            try {
                Incidente incidente = bl.obtenerIncidente(txtCodigo.getText());
                if (incidente == null || incidente.getCodigo() == null || incidente.getCodigo().isEmpty()) {
                    txtResultados.setText("No se encontró el incidente con el código especificado.");
                } else {
                    txtResultados.setText("Datos del incidente:\n" + incidente.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                if (bl.eliminarIncidente(txtCodigo.getText())) {
                    txtResultados.setText("Incidente eliminado exitosamente!");
                } else {
                    txtResultados.setText("No se encontró el incidente con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnListar.addActionListener(e -> {
            try {
                ArrayList<Incidente> incidentes = bl.obtenerIncidentes();
                if (incidentes == null || incidentes.isEmpty()) {
                    txtResultados.setText("No hay incidentes registrados.");
                } else {
                    StringBuilder sb = new StringBuilder("Listado de incidentes:\n\n");
                    for (Incidente incidente : incidentes) {
                        sb.append(incidente.toString()).append("\n-----------------------\n");
                    }
                    txtResultados.setText(sb.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel crearPanelUsuariosCreadores() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));

        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtPrimerApellido = new JTextField();
        JTextField txtSegundoApellido = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtPassword = new JTextField();
        JTextField txtDepartamento = new JTextField();

        formPanel.add(new JLabel("Código:"));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(txtNombre);
        formPanel.add(new JLabel("Primer Apellido:"));
        formPanel.add(txtPrimerApellido);
        formPanel.add(new JLabel("Segundo Apellido:"));
        formPanel.add(txtSegundoApellido);
        formPanel.add(new JLabel("Correo Electrónico:"));
        formPanel.add(txtCorreo);
        formPanel.add(new JLabel("Teléfono:"));
        formPanel.add(txtTelefono);
        formPanel.add(new JLabel("Contraseña:"));
        formPanel.add(txtPassword);
        formPanel.add(new JLabel("Departamento:"));
        formPanel.add(txtDepartamento);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar Todos");

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnListar);

        JTextArea txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            try {
                UsuarioCreador usuario = new UsuarioCreador();
                usuario.setCodigo(txtCodigo.getText());
                usuario.setNombre(txtNombre.getText());
                usuario.setPrimerApellido(txtPrimerApellido.getText());
                usuario.setSegundoApellido(txtSegundoApellido.getText());
                usuario.setCorreoElectronico(txtCorreo.getText());

                if (!txtTelefono.getText().isEmpty()) {
                    usuario.setTelefono(Integer.parseInt(txtTelefono.getText()));
                }

                usuario.setPassword(txtPassword.getText());
                usuario.setDepartamento(txtDepartamento.getText());

                bl.agregarUsuarioCreador(usuario);
                txtResultados.setText("Usuario creador agregado exitosamente!\n" + usuario.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnModificar.addActionListener(e -> {
            try {
                UsuarioCreador usuario = new UsuarioCreador();
                usuario.setCodigo(txtCodigo.getText());
                usuario.setNombre(txtNombre.getText());
                usuario.setPrimerApellido(txtPrimerApellido.getText());
                usuario.setSegundoApellido(txtSegundoApellido.getText());
                usuario.setCorreoElectronico(txtCorreo.getText());

                if (!txtTelefono.getText().isEmpty()) {
                    usuario.setTelefono(Integer.parseInt(txtTelefono.getText()));
                }

                usuario.setPassword(txtPassword.getText());
                usuario.setDepartamento(txtDepartamento.getText());

                if (bl.modificarUsuarioCreador(usuario)) {
                    txtResultados.setText("Usuario modificado exitosamente!\n" + usuario.toString());
                } else {
                    txtResultados.setText("No se encontró el usuario con el código especificado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBuscar.addActionListener(e -> {
            try {
                UsuarioCreador usuario = bl.obtenerUsuarioCreador(txtCodigo.getText());
                if (usuario == null || usuario.getCodigo() == null || usuario.getCodigo().isEmpty()) {
                    txtResultados.setText("No se encontró el usuario con el código especificado.");
                } else {
                    txtResultados.setText("Datos del usuario:\n" + usuario.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                if (bl.eliminarUsuarioCreador(txtCodigo.getText())) {
                    txtResultados.setText("Usuario eliminado exitosamente!");
                } else {
                    txtResultados.setText("No se encontró el usuario con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnListar.addActionListener(e -> {
            try {
                ArrayList<UsuarioCreador> usuarios = bl.obtenerUsuariosCreadores();
                if (usuarios == null || usuarios.isEmpty()) {
                    txtResultados.setText("No hay usuarios creadores registrados.");
                } else {
                    StringBuilder sb = new StringBuilder("Listado de usuarios creadores:\n\n");
                    for (UsuarioCreador usuario : usuarios) {
                        sb.append(usuario.toString()).append("\n-----------------------\n");
                    }
                    txtResultados.setText(sb.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            UI frame = new UI();
            frame.setVisible(true);
        });
    }
}
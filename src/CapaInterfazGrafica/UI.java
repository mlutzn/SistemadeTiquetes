package CapaInterfazGrafica;

import BL.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class UI extends JFrame {
    private BL bl = new BL();

    private String usuarioActual;
    private String rolUsuarioActual;

    private JTabbedPane tabbedPane;
    private JComboBox<String> tipoSolicitudComboBox;

    // Paneles para cada tipo de solicitud
    private JPanel panelIncidentes;
    private JPanel panelSolicitudesServicio;
    private JPanel panelSolicitudesCambio;
    private JPanel panelUsuarios;

    public UI(String usuario, String rol) {
        this.usuarioActual = usuario;
        this.rolUsuarioActual = rol;

        setTitle("Sistema de Gestión de Tickets - Usuario: " + usuario + " (" + rol + ")");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Configurar opciones según rol de usuario
        String[] opciones;
        if (rolUsuarioActual.equals("Administrador")) {
            opciones = new String[]{"Incidentes", "Solicitudes de Servicio", "Solicitudes de Cambio", "Usuarios"};
        } else if (rolUsuarioActual.equals("Técnico")) {
            opciones = new String[]{"Incidentes", "Solicitudes de Servicio"};
        } else { // Usuario Creador
            opciones = new String[]{"Incidentes", "Solicitudes de Servicio"};
        }

        tipoSolicitudComboBox = new JComboBox<>(opciones);

        // Panel superior para el combo box
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(new JLabel("Tipo de solicitud: "));
        panelSuperior.add(tipoSolicitudComboBox);

        // Crear los paneles
        panelIncidentes = crearPanelIncidentes();
        panelSolicitudesServicio = crearPanelSolicitudesServicio();
        panelSolicitudesCambio = crearPanelSolicitudesCambio();
        panelUsuarios = crearPanelUsuarios();

        // Configurar el tabbedPane
        tabbedPane = new JTabbedPane();
        actualizarTabsSegunSeleccion((String) tipoSolicitudComboBox.getSelectedItem());

        // Listener para cambios en la selección del combo box
        tipoSolicitudComboBox.addActionListener(e -> {
            String seleccion = (String) tipoSolicitudComboBox.getSelectedItem();
            actualizarTabsSegunSeleccion(seleccion);
        });

        // Configurar el layout principal
        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void actualizarTabsSegunSeleccion(String tipoSolicitud) {
        tabbedPane.removeAll();

        switch(tipoSolicitud) {
            case "Incidentes":
                tabbedPane.addTab("Incidentes", panelIncidentes);
                if (rolUsuarioActual.equals("Administrador")) {
                    tabbedPane.addTab("Usuarios", panelUsuarios);
                }
                break;
            case "Solicitudes de Servicio":
                tabbedPane.addTab("Solicitudes Servicio", panelSolicitudesServicio);
                if (rolUsuarioActual.equals("Administrador")) {
                    tabbedPane.addTab("Usuarios", panelUsuarios);
                }
                break;
            case "Solicitudes de Cambio":
                tabbedPane.addTab("Solicitudes Cambio", panelSolicitudesCambio);
                tabbedPane.addTab("Usuarios", panelUsuarios);
                break;
            case "Usuarios":
                tabbedPane.addTab("Usuarios", panelUsuarios);
                break;
        }
    }

    private JPanel crearPanelIncidentes() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        JTextField txtCodigo = new JTextField();
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"Creado", "Asignado", "En Progreso", "Resuelto", "Cancelado"});
        JTextField txtNota = new JTextField();
        JTextArea txtDescripcion = new JTextArea(3, 20);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        JTextField txtUsuarioTecnicoAsig = new JTextField();
        JTextField txtFechaSolucion = new JTextField();
        JTextArea txtDescripcionSolucion = new JTextArea(3, 20);
        JScrollPane scrollDescSolucion = new JScrollPane(txtDescripcionSolucion);

        // Usuario creador es el usuario actual (solo lectura)
        JTextField txtUsuarioCreador = new JTextField(usuarioActual);
        txtUsuarioCreador.setEditable(false);

        formPanel.add(new JLabel("Código:"));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(cbEstado);
        formPanel.add(new JLabel("Nota:"));
        formPanel.add(txtNota);
        formPanel.add(new JLabel("Descripción:"));
        formPanel.add(scrollDescripcion);
        formPanel.add(new JLabel("Usuario Creador:"));
        formPanel.add(txtUsuarioCreador);
        formPanel.add(new JLabel("Usuario Técnico Asignado:"));
        formPanel.add(txtUsuarioTecnicoAsig);
        formPanel.add(new JLabel("Fecha Solución (AAAA-MM-DD):"));
        formPanel.add(txtFechaSolucion);
        formPanel.add(new JLabel("Descripción Solución:"));
        formPanel.add(scrollDescSolucion);

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
                incidente.setEstado(cbEstado.getSelectedItem().toString());
                incidente.setNota(txtNota.getText());
                incidente.setDescripcion(txtDescripcion.getText());
                incidente.setUsuarioCreador(usuarioActual);
                incidente.setUsuarioTecnicoAsignado();

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
// Listener para Modificar Incidente
        btnModificar.addActionListener(e -> {
            try {
                Incidente incidente = new Incidente();
                incidente.setCodigo(txtCodigo.getText());
                incidente.setEstado(cbEstado.getSelectedItem().toString());
                incidente.setNota(txtNota.getText());
                incidente.setDescripcion(txtDescripcion.getText());
                incidente.setUsuarioCreador(usuarioActual);
                incidente.setUsuarioTecnicoAsignado();

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

// Listener para Buscar Incidente
        btnBuscar.addActionListener(e -> {
            try {
                Tickete tiquete = bl.obtenerIncidente((txtCodigo.getText()));

                if (tiquete instanceof Incidente incidente) {
                    // Llenar los campos con los datos del incidente
                    cbEstado.setSelectedItem(incidente.getEstado());
                    txtNota.setText(incidente.getNota());
                    txtDescripcion.setText(incidente.getDescripcion());
                    txtUsuarioTecnicoAsig.setText(incidente.getUsuarioTecnicoAsignado());

                    if (incidente.getFechaSolucion() != null) {
                        txtFechaSolucion.setText(incidente.getFechaSolucion().toString());
                    }

                    txtDescripcionSolucion.setText(incidente.getDescripcionSolucion());

                    txtResultados.setText("Datos del incidente cargados correctamente");
                } else if (tiquete != null) {
                    txtResultados.setText("El código corresponde a un tipo de ticket diferente");
                } else {
                    txtResultados.setText("No se encontró el incidente con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Eliminar Incidente
        btnEliminar.addActionListener(e -> {
            try {
                if (bl.eliminarIncidente(txtCodigo.getText())) {
                    // Limpiar campos después de eliminar
                    txtCodigo.setText("");
                    cbEstado.setSelectedIndex(0);
                    txtNota.setText("");
                    txtDescripcion.setText("");
                    txtUsuarioTecnicoAsig.setText("");
                    txtFechaSolucion.setText("");
                    txtDescripcionSolucion.setText("");

                    txtResultados.setText("Incidente eliminado exitosamente!");
                } else {
                    txtResultados.setText("No se encontró el incidente con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Listar Incidentes
        btnListar.addActionListener(e -> {
            try {
                ArrayList<Incidente> incidentes = bl.obtenerIncidentes();
                StringBuilder sb = new StringBuilder("Listado de Incidentes:\n\n");

                incidentes.stream()
                        .filter(t -> t instanceof Incidente)
                        .map(t -> (Incidente) t)
                        .forEach(incidente -> {
                            sb.append("Código: ").append(incidente.getCodigo()).append("\n");
                            sb.append("Estado: ").append(incidente.getEstado()).append("\n");
                            sb.append("Descripción: ").append(incidente.getDescripcion()).append("\n");
                            sb.append("Técnico asignado: ").append(incidente.getUsuarioTecnicoAsignado()).append("\n");
                            sb.append("-----------------------\n");
                        });

                if (sb.length() > 25) { // Si hay resultados
                    txtResultados.setText(sb.toString());
                } else {
                    txtResultados.setText("No hay incidentes registrados.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel crearPanelSolicitudesServicio() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField txtCodigo = new JTextField();
        JTextArea txtDescripcion = new JTextArea(3, 20);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        JTextField txtUsuarioTecnico = new JTextField();
        JTextField txtJustificacion = new JTextField();
        JComboBox<Integer> cbPrioridad = new JComboBox<>(new Integer[]{1, 2, 3, 4});
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"Creado", "Asignado", "En Progreso", "Resuelto", "Cancelado"});

        // Usuario creador es el usuario actual (solo lectura)
        JTextField txtUsuarioCreador = new JTextField(usuarioActual);
        txtUsuarioCreador.setEditable(false);

        formPanel.add(new JLabel("Código:"));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Descripción:"));
        formPanel.add(scrollDescripcion);
        formPanel.add(new JLabel("Usuario Creador:"));
        formPanel.add(txtUsuarioCreador);
        formPanel.add(new JLabel("Usuario Técnico:"));
        formPanel.add(txtUsuarioTecnico);
        formPanel.add(new JLabel("Justificación:"));
        formPanel.add(txtJustificacion);
        formPanel.add(new JLabel("Prioridad:"));
        formPanel.add(cbPrioridad);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(cbEstado);

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
                SolicitudDeServicio solicitud = new SolicitudDeServicio();
                solicitud.setCodigo(txtCodigo.getText());
                solicitud.setDescripcion(txtDescripcion.getText());
                solicitud.setUsuarioCreador(usuarioActual);
                solicitud.setUsuarioTecnicoAsignado();
                solicitud.setJustificacionServicio(txtJustificacion.getText());
                solicitud.setPrioridad((Integer) cbPrioridad.getSelectedItem());
                solicitud.setEstado(cbEstado.getSelectedItem().toString());

                bl.agregarSolicitudDeServicio(solicitud);
                txtResultados.setText("Solicitud de servicio agregada exitosamente!\n" + solicitud.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        // Listener para Modificar Solicitud de Servicio
        btnModificar.addActionListener(e -> {
            try {
                SolicitudDeServicio solicitud = new SolicitudDeServicio();
                solicitud.setCodigo(txtCodigo.getText());
                solicitud.setDescripcion(txtDescripcion.getText());
                solicitud.setUsuarioCreador(usuarioActual);
                solicitud.setUsuarioTecnicoAsignado();
                solicitud.setJustificacionServicio(txtJustificacion.getText());
                solicitud.setPrioridad((Integer) cbPrioridad.getSelectedItem());
                solicitud.setEstado(cbEstado.getSelectedItem().toString());

                if (bl.modificarSolicitudDeServicio(solicitud)) {
                    txtResultados.setText("Solicitud de servicio modificada exitosamente!\n" + solicitud.toString());
                } else {
                    txtResultados.setText("No se encontró la solicitud con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Buscar Solicitud de Servicio
        btnBuscar.addActionListener(e -> {
            try {
                Tickete tiquete = bl.obtenerSolicitudDeServicio(txtCodigo.getText());

                if (tiquete instanceof SolicitudDeServicio solicitud) {
                    txtDescripcion.setText(solicitud.getDescripcion());
                    txtUsuarioTecnico.setText(solicitud.getUsuarioTecnicoAsignado());
                    txtJustificacion.setText(solicitud.getJustificacionServicio());
                    cbPrioridad.setSelectedItem(solicitud.getPrioridad());
                    cbEstado.setSelectedItem(solicitud.getEstado());

                    txtResultados.setText("Datos de la solicitud cargados correctamente");
                } else if (tiquete != null) {
                    txtResultados.setText("El código corresponde a un tipo de ticket diferente");
                } else {
                    txtResultados.setText("No se encontró la solicitud con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Eliminar Solicitud de Servicio
        btnEliminar.addActionListener(e -> {
            try {
                if (bl.eliminarSolicitudDeServicio(txtCodigo.getText())) {
                    // Limpiar campos
                    txtCodigo.setText("");
                    txtDescripcion.setText("");
                    txtUsuarioTecnico.setText("");
                    txtJustificacion.setText("");
                    cbPrioridad.setSelectedIndex(0);
                    cbEstado.setSelectedIndex(0);

                    txtResultados.setText("Solicitud de servicio eliminada exitosamente!");
                } else {
                    txtResultados.setText("No se encontró la solicitud con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Listar Solicitudes de Servicio
        btnListar.addActionListener(e -> {
            try {
                List<SolicitudDeServicio> solicituddeservicio = bl.listarSolicitudDeServicio();
                StringBuilder sb = new StringBuilder("Listado de Solicitudes de Servicio:\n\n");

                solicituddeservicio.stream()
                        .filter(t -> t instanceof SolicitudDeServicio)
                        .map(t -> (SolicitudDeServicio) t)
                        .forEach(solicitud -> {
                            sb.append("Código: ").append(solicitud.getCodigo()).append("\n");
                            sb.append("Prioridad: ").append(solicitud.getPrioridad()).append("\n");
                            sb.append("Estado: ").append(solicitud.getEstado()).append("\n");
                            sb.append("Técnico asignado: ").append(solicitud.getUsuarioTecnicoAsignado()).append("\n");
                            sb.append("-----------------------\n");
                        });

                if (sb.length() > 30) {
                    txtResultados.setText(sb.toString());
                } else {
                    txtResultados.setText("No hay solicitudes de servicio registradas.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel crearPanelSolicitudesCambio() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));

        JTextField txtCodigo = new JTextField();
        JTextArea txtDescripcion = new JTextArea(3, 20);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        JTextField txtNota = new JTextField();
        JTextField txtPasosEjecucion = new JTextField();
        JTextField txtFechaReqCambio = new JTextField();
        JTextField txtusuarioTecnicoAsignado = new JTextField();
        JComboBox<String> cbEstado = new JComboBox<>(new String[]{"Creado", "Asignado", "En Progreso", "Resuelto", "Cancelado"});

        // Usuario creador es el usuario actual (solo lectura)
        JTextField txtUsuarioCreador = new JTextField(usuarioActual);
        txtUsuarioCreador.setEditable(false);


        formPanel.add(new JLabel("Código:"));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Descripción:"));
        formPanel.add(scrollDescripcion);
        formPanel.add(new JLabel("Usuario Creador:"));
        formPanel.add(txtUsuarioCreador);
        formPanel.add(new JLabel("Nota:"));
        formPanel.add(txtNota);
        formPanel.add(new JLabel("Pasos Ejecución:"));
        formPanel.add(txtPasosEjecucion);
        formPanel.add(new JLabel("Fecha Req. Cambio (AAAA-MM-DD):"));
        formPanel.add(txtFechaReqCambio);
        formPanel.add(new JLabel("Usuario tecnico Asignado"));
        formPanel.add(txtusuarioTecnicoAsignado);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(cbEstado);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar Todos");
        JButton btnAprobar = new JButton("Aprobar");

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnListar);
        if (rolUsuarioActual.equals("Administrador")) {
            buttonPanel.add(btnAprobar);
        }

        JTextArea txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            try {
                SolicitudDeCambio solicitud = new SolicitudDeCambio();
                solicitud.setCodigo(txtCodigo.getText());
                solicitud.setDescripcion(txtDescripcion.getText());
                solicitud.setUsuarioCreador(usuarioActual);
                solicitud.setNota(txtNota.getText());
                solicitud.setPasosEjecCambio(txtPasosEjecucion.getText());

                if (!txtFechaReqCambio.getText().isEmpty()) {
                    solicitud.setFechaReqCambio(LocalDate.parse(txtFechaReqCambio.getText()));
                }
                solicitud.setUsuarioTecnicoAsignado();

                solicitud.setEstado(cbEstado.getSelectedItem().toString());

                bl.agregarSolicitudDeCambio(solicitud);
                txtResultados.setText("Solicitud de cambio agregada exitosamente!\n" + solicitud.toString());
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Modificar Solicitud de Cambio
        btnModificar.addActionListener(e -> {
            try {
                SolicitudDeCambio solicitud = new SolicitudDeCambio();
                solicitud.setCodigo(txtCodigo.getText());
                solicitud.setDescripcion(txtDescripcion.getText());
                solicitud.setUsuarioCreador(usuarioActual);
                solicitud.setNota(txtNota.getText());
                solicitud.setPasosEjecCambio(txtPasosEjecucion.getText());

                if (!txtFechaReqCambio.getText().isEmpty()) {
                    solicitud.setFechaReqCambio(LocalDate.parse(txtFechaReqCambio.getText()));
                }

                solicitud.setUsuarioTecnicoAsignado();


                solicitud.setEstado(cbEstado.getSelectedItem().toString());

                if (bl.modificarSolicitudDeCambio(solicitud)) {
                    txtResultados.setText("Solicitud de cambio modificada exitosamente!\n" + solicitud.toString());
                } else {
                    txtResultados.setText("No se encontró la solicitud con el código especificado.");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Buscar Solicitud de Cambio
        btnBuscar.addActionListener(e -> {
            try {
                Tickete tiquete = bl.obtenerSolicitudDeCambio((txtCodigo.getText()));

                if (tiquete instanceof SolicitudDeCambio solicitud) {
                    txtDescripcion.setText(solicitud.getDescripcion());
                    txtNota.setText(solicitud.getNota());
                    txtPasosEjecucion.setText(solicitud.getPasosEjecCambio());
                    cbEstado.setSelectedItem(solicitud.getEstado());

                    if (solicitud.getFechaReqCambio() != null) {
                        txtFechaReqCambio.setText(solicitud.getFechaReqCambio().toString());
                    }
                    //txtusuarioTecnicoAsignado.setText(solicitud.setUsuarioTecnicoAsignado());

                    txtResultados.setText("Datos de la solicitud cargados correctamente");
                } else if (tiquete != null) {
                    txtResultados.setText("El código corresponde a un tipo de ticket diferente");
                } else {
                    txtResultados.setText("No se encontró la solicitud con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Eliminar Solicitud de Cambio
        btnEliminar.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea eliminar esta solicitud de cambio?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    if (bl.eliminarSolicitudDeCambio(txtCodigo.getText())) {
                        // Limpiar campos
                        txtCodigo.setText("");
                        txtDescripcion.setText("");
                        txtNota.setText("");
                        txtPasosEjecucion.setText("");
                        txtFechaReqCambio.setText("");
                        txtusuarioTecnicoAsignado.setText("");
                        cbEstado.setSelectedIndex(0);

                        txtResultados.setText("Solicitud de cambio eliminada exitosamente!");
                    } else {
                        txtResultados.setText("No se encontró la solicitud con el código especificado.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

// Listener para Listar Solicitudes de Cambio
        btnListar.addActionListener(e -> {
            try {
                ArrayList<SolicitudDeCambio> solicituddecambio = bl.listarSolicitudDeCambio();
                StringBuilder sb = new StringBuilder("Listado de Solicitudes de Cambio:\n\n");

                solicituddecambio.stream()
                        .filter(t -> t instanceof SolicitudDeCambio)
                        .map(t -> (SolicitudDeCambio) t)
                        .forEach(solicitud -> {
                            sb.append("Código: ").append(solicitud.getCodigo()).append("\n");
                            sb.append("Estado: ").append(solicitud.getEstado()).append("\n");
                            sb.append("Impacto: ").append(solicitud.getNota()).append("\n");
                            sb.append("Fecha Req.: ").append(solicitud.getFechaReqCambio()).append("\n");
                            sb.append("Fecha Aprob.: ").append(solicitud.getUsuarioTecnicoAsignado()).append("\n");
                            sb.append("-----------------------\n");
                        });

                if (sb.length() > 30) {
                    txtResultados.setText(sb.toString());
                } else {
                    txtResultados.setText("No hay solicitudes de cambio registradas.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        return panel;
    }

    private JPanel crearPanelUsuarios() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(9, 2, 5, 5));

        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtPrimerApellido = new JTextField();
        JTextField txtSegundoApellido = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtTelefono = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JComboBox<String> cbDepartamento = new JComboBox<>(new String[]{"TI", "Ventas", "Recursos Humanos", "Operaciones"});
        JComboBox<String> cbRol = new JComboBox<>(new String[]{"Administrador", "Técnico", "Creador"});

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
        formPanel.add(cbDepartamento);
        formPanel.add(new JLabel("Rol:"));
        formPanel.add(cbRol);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);

        JTextArea txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            try {
                Usuario usuario;
                String rol = cbRol.getSelectedItem().toString();

                switch(rol) {
                    case "Administrador":
                        usuario = new UsuarioAdministrador();
                        ((UsuarioAdministrador)usuario).setEstado("Activo");
                        break;
                    case "Técnico":
                        usuario = new UsuarioTecnico();
                        ((UsuarioTecnico)usuario).setRol("Técnico");
                        break;
                    case "Creador":
                        usuario = new UsuarioCreador();
                        ((UsuarioCreador)usuario).setDepartamento(cbDepartamento.getSelectedItem().toString());
                        break;
                    default:
                        usuario = new Usuario();
                }

                usuario.setCodigo(txtCodigo.getText());
                usuario.setNombre(txtNombre.getText());
                usuario.setPrimerApellido(txtPrimerApellido.getText());
                usuario.setSegundoApellido(txtSegundoApellido.getText());
                usuario.setCorreoElectronico(txtCorreo.getText());
                usuario.setTelefono(Integer.parseInt(txtTelefono.getText()));
                usuario.setPassword(new String(txtPassword.getPassword()));


                bl.agregarUsuario(usuario);
                txtResultados.setText("Usuario agregado exitosamente!\n" + usuario.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Listener para Modificar Usuario
        btnModificar.addActionListener(e -> {
            try {
                Usuario usuario;
                String rol = cbRol.getSelectedItem().toString();

                switch(rol) {
                    case "Administrador":
                        usuario = new UsuarioAdministrador();
                        ((UsuarioAdministrador)usuario).setEstado("Activo");
                        break;
                    case "Técnico":
                        usuario = new UsuarioTecnico();
                        ((UsuarioTecnico)usuario).setRol("Técnico");
                        break;
                    case "Creador":
                        usuario = new UsuarioCreador();
                        ((UsuarioCreador)usuario).setDepartamento(cbDepartamento.getSelectedItem().toString());
                        break;
                    default:
                        usuario = new Usuario();
                }

                usuario.setCodigo(txtCodigo.getText());
                usuario.setNombre(txtNombre.getText());
                usuario.setPrimerApellido(txtPrimerApellido.getText());
                usuario.setSegundoApellido(txtSegundoApellido.getText());
                usuario.setCorreoElectronico(txtCorreo.getText());
                usuario.setTelefono(Integer.parseInt(txtTelefono.getText()));
                usuario.setPassword(new String(txtPassword.getPassword()));

                if (bl.modificarUsuario(usuario)) {
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

// Listener para Buscar Usuario
        btnBuscar.addActionListener(e -> {
            try {
                Usuario usuario = bl.obtenerUsuario(txtCodigo.getText());

                if (usuario != null) {
                    // Llenar formulario con datos del usuario
                    txtNombre.setText(usuario.getNombre());
                    txtPrimerApellido.setText(usuario.getPrimerApellido());
                    txtSegundoApellido.setText(usuario.getSegundoApellido());
                    txtCorreo.setText(usuario.getCorreoElectronico());
                    txtTelefono.setText(String.valueOf(usuario.getTelefono()));
                    txtPassword.setText(usuario.getPassword());

                    if (usuario instanceof UsuarioCreador creador) {
                        cbDepartamento.setSelectedItem(creador.getDepartamento());
                        cbRol.setSelectedItem("Creador");
                    } else if (usuario instanceof UsuarioTecnico) {
                        cbRol.setSelectedItem("Técnico");
                    } else if (usuario instanceof UsuarioAdministrador admin) {
                        cbRol.setSelectedItem("Administrador");
                    }

                    txtResultados.setText("Datos del usuario cargados correctamente");
                } else {
                    txtResultados.setText("No se encontró el usuario con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

// Listener para Eliminar Usuario
        btnEliminar.addActionListener(e -> {
            try {
                if (bl.eliminarusuario(txtCodigo.getText())) {
                    // Limpiar formulario
                    txtCodigo.setText("");
                    txtNombre.setText("");
                    txtPrimerApellido.setText("");
                    txtSegundoApellido.setText("");
                    txtCorreo.setText("");
                    txtTelefono.setText("");
                    txtPassword.setText("");
                    cbDepartamento.setSelectedIndex(0);
                    cbRol.setSelectedIndex(0);

                    txtResultados.setText("Usuario eliminado exitosamente!");
                } else {
                    txtResultados.setText("No se encontró el usuario con el código especificado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        return panel;
    }
    // Método auxiliar para obtener tipo de usuario
    private String obtenerTipoUsuario(Usuario usuario) {
        if (usuario instanceof UsuarioAdministrador) return "Administrador";
        if (usuario instanceof UsuarioTecnico) return "Técnico";
        if (usuario instanceof UsuarioCreador) return "Creador";
        return "Genérico";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                // Iniciar con la pantalla de login
                LoginUI login = new LoginUI();
                login.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
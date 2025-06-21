package layering_1.UI;

import layering_1.MODEL.IApi;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AgregarParticipanteVista extends JFrame {

    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;

    private IApi api;

    public AgregarParticipanteVista(IApi api) throws SQLException {
        this.api = api;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
                /*
        botonCargar.addActionListener(e -> {
            try {
                onBotonCargar();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        });

        */

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreString = nombre.getText();
                    String telefonoString = telefono.getText();
                    String regionString = region.getText();

                    api.onBotonCargar(nombreString, telefonoString, regionString);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(AgregarParticipanteVista.this,
                            "Participante agregado exitosamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Limpiar campos
                    nombre.setText("");
                    telefono.setText("");
                    region.setText("China");

                } catch (Exception e1) {
                    // Mostrar error al usuario
                    JOptionPane.showMessageDialog(AgregarParticipanteVista.this,
                            "Error: " + e1.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

   // dispose();
}
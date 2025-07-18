package layering_3.UI;

import layering_3.MODEL.IApi;
import layering_3.MODEL.dto.ConcursoDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class RadioCompetition {

    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<ConcursoDTO> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    private List<ConcursoDTO> concursosActivos;

    //private IApi api;

    public RadioCompetition(IApi api) {

        //this.api = api;

        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements(api);
        layout();
        frame.setVisible(true);
    }

    private void formElements(IApi api) {

        //INFO DE INSCRIPTOS
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);

        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);

        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);

        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);

        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<>();
        comboBox.addItem(null);
        concursosActivos = api.todosLosConcursos(LocalDate.now());
        for (ConcursoDTO concurso : concursosActivos){
            comboBox.addItem(concurso);
        }


        //BOTON OK
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);

                try {
                    if (comboBox.getSelectedIndex() <= 0 || comboBox.getSelectedItem() == null) {
                        throw new RuntimeException("Debe elegir un Concurso");
                    }

                    String apellido = txtLastName.getText();
                    String nombre = txtName.getText();
                    int dni = Integer.parseInt(txtId.getText());  // Esto deberías validar también
                    String telefono = txtPhone.getText();
                    String email = txtEmail.getText();

                    ConcursoDTO concurso = (ConcursoDTO) comboBox.getSelectedItem();

                    api.saveInscription(apellido, nombre, dni, email, telefono, concurso);

                    JOptionPane.showMessageDialog(contentPane, "Inscripción guardada correctamente");
                    limpiarCampos();

                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error de validación", JOptionPane.WARNING_MESSAGE);
                } finally {
                    btnOk.setEnabled(true);
                }
            }
        });
    }

    private void limpiarCampos() {
        txtName.setText("");
        txtLastName.setText("");
        txtId.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        comboBox.setSelectedIndex(0); // vuelve a "Seleccione..."
    }

    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane
                                .createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(
                                                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtEmail, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtPhone, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtId, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtLastName, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtName, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, GroupLayout.Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLastName).addComponent(txtLastName,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblId).addComponent(
                                                txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lblEmail))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                        gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblCompetition))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOk)
                                .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}
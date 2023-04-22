package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import beisbol.Entrenador;
import beisbol.Equipo;
import Interfaces_creadas.JTextFieldNombre;
import Interfaces_creadas.JTextFieldCarnet;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import beisbol.Brazo_Hábil;
import javax.swing.SpinnerNumberModel;

public class Manager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Ingresar_equipo ingresar_equipo;
	private Equipo equipo;
	private JComboBox comboBox;
	private JTextFieldNombre textFieldNombre_1;
	private JTextFieldNombre textFieldNombre;
	private JTextFieldCarnet textFieldCarnet;
	private JSpinner spinner_tiempo_experiencia;
	private JSpinner spinner_tiempo_equipo;
	private JLabel lblNmero;
	private JSpinner spinner_numero;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param equipo 
	 * @param ingresar_equipo 
	 */
	public Manager(Ingresar_equipo ingresar_equipo, Equipo equipo) {
		setModal(true);
		this.equipo=equipo;
		this.ingresar_equipo=ingresar_equipo;
		setTitle("Entrenador");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnAadir = new JButton("Aceptar");
			btnAadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textFieldCarnet.getText().isEmpty() || textFieldNombre.getText().isEmpty() || textFieldNombre_1.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Campos obligatorios vacíos", "Error",JOptionPane.ERROR_MESSAGE);
					}
					else 
					{			
						ingresar_manager(textFieldNombre.getText(), textFieldNombre_1.getText(), textFieldCarnet.getText(), (Integer) spinner_numero.getValue(), (Integer) spinner_tiempo_equipo.getValue(), (Brazo_Hábil)comboBox.getSelectedItem(), (Integer) spinner_tiempo_experiencia.getValue());
						dispose();
					}
				}
			});
			btnAadir.setBounds(23, 227, 89, 23);
			contentPanel.add(btnAadir);
		}
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(157, 227, 89, 23);
		contentPanel.add(btnCancelar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCarnet.setText("");
				textFieldNombre.setText("");
				textFieldNombre_1.setText("");
				spinner_tiempo_experiencia.setValue(0);
				spinner_tiempo_equipo.setValue(0);
				spinner_numero.setValue(0);
			}
		});
		btnLimpiar.setBounds(282, 227, 89, 23);
		contentPanel.add(btnLimpiar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 11, 89, 23);
		contentPanel.add(lblNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 76, 89, 23);
		contentPanel.add(lblId);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia");
		lblAosDeExperiencia.setBounds(23, 140, 154, 23);
		contentPanel.add(lblAosDeExperiencia);
		
		spinner_tiempo_experiencia = new JSpinner();
		spinner_tiempo_experiencia.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_tiempo_experiencia.setBounds(187, 141, 86, 20);
		contentPanel.add(spinner_tiempo_experiencia);
		
		textFieldNombre = new JTextFieldNombre();
		textFieldNombre.setBounds(132, 45, 86, 20);
		contentPanel.add(textFieldNombre);
		
		textFieldCarnet = new JTextFieldCarnet();
		textFieldCarnet.setBounds(132, 77, 86, 20);
		contentPanel.add(textFieldCarnet);
		
		JLabel lblApellidos = new JLabel("Apellido\r\n");
		lblApellidos.setBounds(23, 45, 66, 20);
		contentPanel.add(lblApellidos);
		
		textFieldNombre_1 = new JTextFieldNombre();
		textFieldNombre_1.setBounds(132, 12, 86, 20);
		contentPanel.add(textFieldNombre_1);
		
		JLabel lblBrazo = new JLabel("Brazo");
		lblBrazo.setBounds(23, 110, 66, 19);
		contentPanel.add(lblBrazo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Brazo_Hábil.values()));
		comboBox.setBounds(132, 108, 86, 20);
		contentPanel.add(comboBox);
		
		JLabel lblAosTrabajandoEn = new JLabel("A\u00F1os trabajando en el equipo");
		lblAosTrabajandoEn.setBounds(23, 174, 154, 23);
		contentPanel.add(lblAosTrabajandoEn);
		
		spinner_tiempo_equipo = new JSpinner();
		spinner_tiempo_equipo.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_tiempo_equipo.setBounds(187, 175, 86, 20);
		contentPanel.add(spinner_tiempo_equipo);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(228, 13, 89, 19);
		contentPanel.add(lblNmero);
		
		spinner_numero = new JSpinner();
		spinner_numero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_numero.setBounds(327, 12, 97, 20);
		contentPanel.add(spinner_numero);
		CargarDatos();
	}
	
	public void ingresar_manager(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo,int cantidad_años_experiencia)
	{
		equipo.ingresar_manager(nombre, apellido, id, numero, años_equipo, brazo, cantidad_años_experiencia);
	}
	
	private void CargarDatos(){
		Entrenador ent = equipo.getEntrenador();
		if(ent!= null)
		{
			textFieldNombre.setText(ent.getNombre());
			textFieldNombre_1.setText(ent.getApellido());
			textFieldCarnet.setText(ent.getId());
			spinner_tiempo_experiencia.setValue(ent.getCantidad_años_experiencia());
			spinner_tiempo_equipo.setValue(ent.getAños_equipo());
			spinner_numero.setValue(ent.getNumero());
			
		}
	}
}

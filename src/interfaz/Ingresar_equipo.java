package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import beisbol.Equipo;
import beisbol.Inder;
import beisbol.Serie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import Interfaces_creadas.JTextFieldNombre;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ingresar_equipo extends JDialog {

	private JPanel contentPane;
	private Serie serieActiva;
    private JTextField textField_3;
    private JComboBox comboBox_1;
    private JButton btnModificarEquipos;
    private JTable table;
    private JComboBox comboBox;
    private JTextFieldNombre textFieldNombre;
    private JTextFieldNombre textFieldNombre_1;
    private JButton btnListadoDeJugadores;
    private JButton btnEliminar;
    private JButton btnManager;
    private JButton btnEliminar_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param serieActiva 
	 */
	public Ingresar_equipo(Serie_interfaz serie, Serie serieActiva) {
		setModal(true);
		this.serieActiva=serieActiva;
		setTitle("Equipo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 610);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setBounds(10, 11, 107, 26);
		contentPane.add(lblIngresarNombre);
		
		JButton btnFinalizar = new JButton("A\u00F1adir\r\n");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearEquipo();
			}
		});
		btnFinalizar.setBounds(364, 5, 151, 38);
		contentPane.add(btnFinalizar);
		
		JLabel lblIngresarProvincia = new JLabel("Provincia");
		lblIngresarProvincia.setBounds(10, 48, 107, 26);
		contentPane.add(lblIngresarProvincia);
		
		JLabel lblNewLabel = new JLabel("Mascota");
		lblNewLabel.setBounds(10, 85, 107, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstadio = new JLabel("Estadio");
		lblEstadio.setBounds(10, 122, 107, 26);
		contentPane.add(lblEstadio);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 122, 117, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 159, 107, 26);
		contentPane.add(lblColor);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Negro", "Azul", "Amarillo", "Verde", "Rojo", "Rosado"}));
		comboBox.setBounds(106, 162, 117, 20);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pinar del R\u00EDo", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Villa Clara", "Cienfuegos", "Santi Sp\u00EDritus", "Ciego de \u00C1vila", "Camag\u00FCey", "Holgu\u00EDn", "Granma", "Santiago De Cuba", "Guant\u00E1namo", "La Isla de la Juventud"}));
		comboBox_1.setBounds(106, 48, 117, 20);
		contentPane.add(comboBox_1);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setText("");
				textFieldNombre_1.setText("");
				textField_3.setText("");
			}
		});
		btnLimpiar.setBounds(364, 54, 151, 38);
		contentPane.add(btnLimpiar);
		
		JButton btnFinalizar_1 = new JButton("Finalizar");
		btnFinalizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFinalizar_1.setBounds(364, 103, 151, 38);
		contentPane.add(btnFinalizar_1);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ActualizarBotón();
				SeleccionarFila();
			}
		});
		table.setEnabled(true);
		table.setBounds(10, 280, 505, 262);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ActualizarBotón();
				SeleccionarFila();
			}
		});
		contentPane.add(table);
		
		btnModificarEquipos = new JButton("Modificar equipo");
		btnModificarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarEquipo();
			}
		});
		btnModificarEquipos.setEnabled(false);
		btnModificarEquipos.setBounds(198, 229, 151, 38);
		contentPane.add(btnModificarEquipos);
		
		textFieldNombre = new JTextFieldNombre();
		textFieldNombre.setBounds(106, 14, 117, 20);
		contentPane.add(textFieldNombre);
		
		textFieldNombre_1 = new JTextFieldNombre();
		textFieldNombre_1.setBounds(106, 85, 117, 20);
		contentPane.add(textFieldNombre_1);
		
		btnListadoDeJugadores = new JButton("Listado de jugadores");
		btnListadoDeJugadores.setEnabled(false);
		btnListadoDeJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo equipo = equipo();
				Listado_jugadores listado=new Listado_jugadores(Ingresar_equipo.this,equipo);
				listado.setVisible(true);
				
			}
		});
		btnListadoDeJugadores.setBounds(27, 229, 151, 38);
		contentPane.add(btnListadoDeJugadores);
		
		btnManager = new JButton("Manager ");
		btnManager.setEnabled(false);
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo equipo = equipo();
				Manager manager = new Manager(Ingresar_equipo.this,equipo);
			    manager.setVisible(true);
			}
		});
		btnManager.setBounds(27, 190, 151, 38);
		contentPane.add(btnManager);
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setEnabled(false);
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Ingresar_equipo.this,"¿Desea eliminar?","Confirmar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					int pos;
					for(int contador=0;contador<table.getSelectedRows().length;contador++){
						pos = equipo_elegido(contador);
						if(pos!=-1){
							eliminar(pos);
						}
					}
				}
				actualizarTabla();
			}
		});
		btnEliminar_1.setBounds(198, 193, 151, 35);
		contentPane.add(btnEliminar_1);
		actualizarTabla();
	}
    private void crearEquipo() {
		if(textFieldNombre.getText().isEmpty() || textFieldNombre_1.getText().isEmpty() || textField_3.getText().isEmpty()){
			JOptionPane.showMessageDialog(Ingresar_equipo.this,"Campos obligatorios vacíos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
			String nombre = textFieldNombre.getText();
			String provincia =comboBox_1.getSelectedItem().toString();
			String estadio=textField_3.getText();
			String mascota=textFieldNombre_1.getText();
			String color=comboBox.getSelectedItem().toString();
			if(serieActiva.buscar_equipo(nombre)!=null){
				JOptionPane.showMessageDialog(Ingresar_equipo.this,"Nombre de equipo ya ingresado", "Advertencia",JOptionPane.ERROR_MESSAGE);
			}
			else{
				Equipo equipo = new Equipo(nombre , estadio, provincia , mascota,color);
				Manager manager = new Manager(Ingresar_equipo.this,equipo);
			    manager.setVisible(true);
			    if(equipo.getEntrenador()!=null)
			    {
				serieActiva.getEquipos().add(equipo);
				textFieldNombre.setText("");
				textFieldNombre_1.setText("");
				textField_3.setText("");
				btnListadoDeJugadores.setEnabled(true);
				btnModificarEquipos.setEnabled(true);
				btnEliminar_1.setEnabled(true);
				actualizarTabla();
			    }
			}
		}
	}
    private void actualizarTabla() {
		String[] encabezado = {"Nombre", "Provincia", "Estadio", "Mascota","Color",};		
		Object [] [] tabla = new Object[serieActiva.getEquipos().size()][encabezado.length];		

		for(int i=0; i<serieActiva.getEquipos().size(); i++){
			tabla [i] [0] = serieActiva.getEquipos().get(i).getNombre();
			tabla [i] [1] = serieActiva.getEquipos().get(i).getProvincia();
			tabla [i] [2] = serieActiva.getEquipos().get(i).getEstadio();
			tabla [i] [3] = serieActiva.getEquipos().get(i).getMascota();
			tabla [i] [4] = serieActiva.getEquipos().get(i).getColor();
		}		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla, encabezado){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table.setModel(defaultTableModel);
		ActualizarBotón();
	}
    public Equipo equipo(){
    	Equipo equipo = serieActiva.getEquipos().get(table.getSelectedRow());
    	return equipo;
    }
    private void ActualizarBotón() {
		btnModificarEquipos.setEnabled(table.getSelectedRowCount() == 1);
		btnListadoDeJugadores.setEnabled(table.getSelectedRowCount() == 1);
		btnManager.setEnabled(table.getSelectedRowCount() == 1);
		btnEliminar_1.setEnabled(table.getSelectedRowCount()>0);
	}    

    
    public void ModificarEquipo(){
    	if(table.getSelectedRowCount()== 1){		
			String nombre = (String) table.getValueAt(table.getSelectedRows()[0], 0);
			Equipo equipo = serieActiva.buscar_equipo(nombre);
			if(equipo != null)
			{
			Equipo eq2 = serieActiva.buscar_equipo(textFieldNombre.getText());
			if(eq2 == null || eq2 == equipo){
			equipo.setNombre(textFieldNombre.getText());
			equipo.setMascota(textFieldNombre_1.getText());
			equipo.setEstadio(textField_3.getText());
			equipo.setColor(comboBox.getSelectedItem().toString());
			equipo.setProvincia(comboBox_1.getSelectedItem().toString());
			actualizarTabla();
			}
			else
				JOptionPane.showMessageDialog(Ingresar_equipo.this,"Nombre de equipo ya ingresado", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}
    }
    
    public void SeleccionarFila()
    {
    	if(table.getSelectedRowCount()== 1){		
			String nombre = (String) table.getValueAt(table.getSelectedRows()[0], 0);
			Equipo equipo = serieActiva.buscar_equipo(nombre);
			if(equipo != null)
			{
			textFieldNombre.setText(equipo.getNombre());
			textFieldNombre_1.setText(equipo.getMascota());
			textField_3.setText(equipo.getEstadio());
			comboBox.setSelectedItem(equipo.getColor());
			comboBox_1.setSelectedItem(equipo.getProvincia());
			}
		}
    }
    public int equipo_elegido(int contador){
    	return serieActiva.posicion((String) table.getValueAt(table.getSelectedRows()[contador], 0));
    }
    public void eliminar(int pos){
    	serieActiva.getEquipos().remove(pos);
    }
    
}


package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import beisbol.Equipo;
import beisbol.Jugador_cuadro;
import beisbol.Lanzador;
import beisbol.Pelotero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Interfaces_creadas.JTextFieldNombre;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

import Interfaces_creadas.JTextFieldCarnet;

import javax.swing.DefaultComboBoxModel;

import beisbol.Brazo_Hábil;
import beisbol.Posicion_específica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SpinnerNumberModel;

public class Listado_jugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Equipo equipo;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextFieldNombre textFieldNombre;
	private JTextFieldNombre textFieldNombre_1;
	private JSpinner spinner_numero;
	private JSpinner spinner_1_experiencia;
	private JComboBox comboBox_brazo;
	private JComboBox comboBox_posicion;
	private JTextFieldCarnet textFieldCarnet;
	private JSpinner spinner_sencillos;
	private JComboBox comboBox_posicion_especifica;
	private JSpinner spinner_dobles;
	private JSpinner spinner_triples;
	private JSpinner spinner_homeround;
	private JSpinner spinner_outs;
	private JSpinner spinner_errores;
	private JPanel panel_cuadro;
	private JPanel panel_lanzador;
	private JComboBox comboBox_lanzamiento;
	private JSpinner spinner_velocidad;
	private JButton btnAadir;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * @param equipo 
	 * @param ingresar_equipo 
	 */
	public Listado_jugadores(Ingresar_equipo ingresar_equipo, Equipo equipo) {
		setModal(true);
		this.equipo=equipo;
		setTitle("Listado de jugadores\r\n");
		setBounds(100, 100, 657, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblJugadores = new JLabel("Listado de jugadores");
			lblJugadores.setBounds(10, 11, 402, 43);
			lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(lblJugadores);
		}
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				actualizar();
				actualizarBotones();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				actualizar();
				actualizarBotones();
		
			}
		});
		table.setBounds(10, 253, 310, 281);
		table.setSurrendersFocusOnKeystroke(true);
		contentPanel.add(table);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(349, 394, 111, 33);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadir_jugador();
			}
		});
		contentPanel.add(btnAadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(470, 394, 111, 33);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
				actualizar_tabla();
			}
		});
		contentPanel.add(btnModificar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(470, 438, 111, 33);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPanel.add(btnSalir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Listado_jugadores.this,"¿Desea eliminar?","Confirmar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					int pos;
					for(int i=0;i<table.getSelectedRows().length;i++)
					{
						pos = posicion_equipo(i) ;
						if(pos != -1)
							equipo_remover(pos);		
					}
					actualizar_tabla();
				}
			}
		});
		btnEliminar.setBounds(349, 438, 111, 33);
		btnEliminar.setEnabled(false);
		contentPanel.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 48, 254, 194);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 11, 65, 20);
		panel.add(label);
		
		textFieldNombre = new JTextFieldNombre();
		textFieldNombre.setBounds(85, 8, 146, 20);
		panel.add(textFieldNombre);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setBounds(10, 36, 65, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("N\u00FAmero");
		label_2.setBounds(10, 61, 65, 20);
		panel.add(label_2);
		
		spinner_numero = new JSpinner();
		spinner_numero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_numero.setBounds(85, 61, 146, 20);
		panel.add(spinner_numero);
		
		textFieldNombre_1 = new JTextFieldNombre();
		textFieldNombre_1.setBounds(85, 33, 146, 20);
		panel.add(textFieldNombre_1);
		
		JLabel label_3 = new JLabel("Experiencia");
		label_3.setBounds(10, 86, 65, 20);
		panel.add(label_3);
		
		spinner_1_experiencia = new JSpinner();
		spinner_1_experiencia.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_1_experiencia.setBounds(85, 86, 146, 20);
		panel.add(spinner_1_experiencia);
		
		JLabel label_4 = new JLabel("Brazo");
		label_4.setBounds(10, 112, 65, 20);
		panel.add(label_4);
		
		comboBox_brazo = new JComboBox();
		comboBox_brazo.setModel(new DefaultComboBoxModel(Brazo_Hábil.values()));
		comboBox_brazo.setBounds(85, 112, 146, 20);
		panel.add(comboBox_brazo);
		
		JLabel label_5 = new JLabel("Tipo");
		label_5.setBounds(10, 140, 65, 20);
		panel.add(label_5);
		
		comboBox_posicion = new JComboBox();
		comboBox_posicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_posicion.getSelectedItem().toString() == "Lanzador"){
					panel_lanzador.setVisible(true);
					panel_cuadro.setVisible(false);
				}
				else{
					panel_lanzador.setVisible(false);
					panel_cuadro.setVisible(true);
				}
			}
		});
		comboBox_posicion.setModel(new DefaultComboBoxModel(new String[] {"Jugador de cuadro", "Lanzador"}));
		comboBox_posicion.setBounds(85, 140, 146, 20);
		panel.add(comboBox_posicion);
		
		JLabel label_6 = new JLabel("Carnet ");
		label_6.setBounds(10, 165, 65, 20);
		panel.add(label_6);
		
		textFieldCarnet = new JTextFieldCarnet();
		textFieldCarnet.setBounds(85, 165, 146, 20);
		panel.add(textFieldCarnet);
		
		panel_cuadro = new JPanel();
		panel_cuadro.setBounds(339, 11, 292, 237);
		contentPanel.add(panel_cuadro);
		panel_cuadro.setLayout(null);
		
		JLabel label_7 = new JLabel("Posici\u00F3n espec\u00EDfica");
		label_7.setBounds(10, 11, 119, 14);
		panel_cuadro.add(label_7);
		
		comboBox_posicion_especifica = new JComboBox();
		comboBox_posicion_especifica.setModel(new DefaultComboBoxModel(Posicion_específica.values()));
		comboBox_posicion_especifica.setBounds(152, 8, 88, 20);
		panel_cuadro.add(comboBox_posicion_especifica);
		
		JLabel lblCantidadDeSencillos = new JLabel("Cantidad de sencillos");
		lblCantidadDeSencillos.setBounds(10, 36, 119, 23);
		panel_cuadro.add(lblCantidadDeSencillos);
		
		spinner_sencillos = new JSpinner();
		spinner_sencillos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_sencillos.setBounds(152, 37, 88, 20);
		panel_cuadro.add(spinner_sencillos);
		
		JLabel label_9 = new JLabel("Cantidad de dobles");
		label_9.setBounds(10, 70, 119, 20);
		panel_cuadro.add(label_9);
		
		spinner_dobles = new JSpinner();
		spinner_dobles.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_dobles.setBounds(152, 68, 88, 20);
		panel_cuadro.add(spinner_dobles);
		
		JLabel label_10 = new JLabel("Cantidad de triples");
		label_10.setBounds(10, 101, 119, 20);
		panel_cuadro.add(label_10);
		
		spinner_triples = new JSpinner();
		spinner_triples.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_triples.setBounds(152, 99, 88, 20);
		panel_cuadro.add(spinner_triples);
		
		JLabel label_11 = new JLabel("Cantidad de homeround");
		label_11.setBounds(10, 132, 132, 23);
		panel_cuadro.add(label_11);
		
		spinner_homeround = new JSpinner();
		spinner_homeround.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_homeround.setBounds(152, 133, 88, 20);
		panel_cuadro.add(spinner_homeround);
		
		JLabel label_12 = new JLabel("Cantidad de outs");
		label_12.setBounds(10, 166, 132, 23);
		panel_cuadro.add(label_12);
		
		spinner_outs = new JSpinner();
		spinner_outs.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_outs.setBounds(152, 167, 88, 20);
		panel_cuadro.add(spinner_outs);
		
		JLabel label_13 = new JLabel("Cantidad de errores");
		label_13.setBounds(10, 200, 119, 20);
		panel_cuadro.add(label_13);
		
		spinner_errores = new JSpinner();
		spinner_errores.setBounds(152, 198, 88, 20);
		panel_cuadro.add(spinner_errores);
		
		panel_lanzador = new JPanel();
		panel_lanzador.setBounds(339, 11, 292, 121);
		contentPanel.add(panel_lanzador);
		panel_lanzador.setLayout(null);
		
		JLabel lblLanzmientoPreferido = new JLabel("Lanzmiento preferido");
		lblLanzmientoPreferido.setBounds(10, 11, 122, 21);
		panel_lanzador.add(lblLanzmientoPreferido);
		
		comboBox_lanzamiento = new JComboBox();
		comboBox_lanzamiento.setModel(new DefaultComboBoxModel(new String[] {"Slider", "Recta de cuatro costuras", "Recta de dos costuras", "Submarino", "Curva", "SInker"}));
		comboBox_lanzamiento.setBounds(142, 11, 108, 20);
		panel_lanzador.add(comboBox_lanzamiento);
		
		JLabel lblMximaVelocidad = new JLabel("M\u00E1xima velocidad");
		lblMximaVelocidad.setBounds(10, 43, 122, 21);
		panel_lanzador.add(lblMximaVelocidad);
		
		spinner_velocidad = new JSpinner();
		spinner_velocidad.setBounds(142, 42, 108, 20);
		panel_lanzador.add(spinner_velocidad);
		actualizar_tabla();
		actualizar_interfaz();
		actualizarBotones();
	}
	
	public void añadir_jugador(){
		if(textFieldNombre.getText().isEmpty() && textFieldNombre_1.getText().isEmpty() && textFieldCarnet.getText().isEmpty())
			JOptionPane.showMessageDialog(Listado_jugadores.this,"Campos obligatorios vacíos", "Error",JOptionPane.ERROR_MESSAGE);
			else{
				if(equipo.buscador_pelotero((Integer) spinner_numero.getValue())== null){
					if(comboBox_posicion.getSelectedIndex()== 1){
						String nombre=textFieldNombre.getText();
						String ID=textFieldCarnet.getText();
						String apellido=textFieldNombre_1.getText();
						int numero=spinner_numero.getValue().hashCode();
						int años_experiencia=spinner_1_experiencia.getValue().hashCode();
						Brazo_Hábil brazo=(Brazo_Hábil)comboBox_brazo.getSelectedItem();
						String lanzamiento=comboBox_lanzamiento.getSelectedItem().toString();
						int velocidad=spinner_velocidad.getValue().hashCode();
						ingresar_lanzador(nombre, apellido, ID, numero, años_experiencia, brazo, lanzamiento, velocidad);
						actualizar_tabla();
						limpiar();
					}
						else{
							String nombre=textFieldNombre.getText();
							String ID=textFieldCarnet.getText();
							String apellido=textFieldNombre_1.getText();
							int numero=(Integer) spinner_numero.getValue();
							int años_experiencia=spinner_1_experiencia.getValue().hashCode();
							Brazo_Hábil brazo=(Brazo_Hábil)comboBox_brazo.getSelectedItem();
							Posicion_específica posicion = (Posicion_específica)comboBox_posicion_especifica.getSelectedItem();
							int sencillo=(Integer) spinner_sencillos.getValue();
							int dobles=(Integer) spinner_dobles.getValue();
							int triples=(Integer) spinner_triples.getValue();
							int homeround=(Integer) spinner_homeround.getValue();
							int outs=(Integer) spinner_outs.getValue();
							int errores=(Integer) spinner_velocidad.getValue();
							ingresar_jugador_cuadro(nombre, apellido, ID, numero, años_experiencia, brazo, posicion, errores, outs, sencillo, dobles, triples, homeround);
							actualizar_tabla();
							limpiar();
						}
				}
				else 
				JOptionPane.showMessageDialog(Listado_jugadores.this,"Número de jugador ya ingresado", "Error",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void actualizar_tabla(){
		String[] encabezado = {"Nombre","Posición","Número"};	
		Object [] [] tabla = new Object[equipo.getJugadores().size()][encabezado.length];
		
		for(int i=0; i<equipo.getJugadores().size(); i++){
			tabla [i] [0] = equipo.getJugadores().get(i).getNombre();
			tabla [i] [2] = equipo.getJugadores().get(i).getNumero();
			if(equipo.getJugadores().get(i)instanceof Lanzador){
				tabla[i][1]="Lanzador";
			}
			else{
				tabla[i][1]="Jugador de cuadro";
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla, encabezado){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table.setModel(defaultTableModel);
		encabezado.toString();
	}
	public void actualizarBotones(){
		btnEliminar.setEnabled(table.getSelectedRowCount()>0);
		btnModificar.setEnabled(table.getSelectedRowCount()==1);
	}
	public void actualizar_interfaz(){
		panel_lanzador.setEnabled(comboBox_posicion.getSelectedIndex()==1);
		panel_cuadro.setEnabled(comboBox_posicion.getSelectedIndex()==0);
	}
	public void ingresar_lanzador(String nombre, String apellido, String ID, int numero,int años_experiencia, Brazo_Hábil brazo,String lanzamiento,int velocidad){
		equipo.ingresar_jugador_lanzador(nombre, apellido, ID, numero, años_experiencia, brazo, lanzamiento, velocidad);
	}
	public void ingresar_jugador_cuadro(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo, Posicion_específica posición, int cantidad_errores, int outs, int sencillo, int dobles, int triples, int homerun){
		equipo.ingresar_jugador_cuadro(nombre, apellido, id, numero, años_equipo, brazo, posición, cantidad_errores, outs, sencillo, dobles, triples, homerun);
	}

	public void limpiar(){
		textFieldNombre.setText("");
		textFieldNombre_1.setText("");
		textFieldCarnet.setText("");
		spinner_numero.setValue(0);
		spinner_1_experiencia.setValue(0);
		spinner_sencillos.setValue(0);
		spinner_dobles.setValue(0);
		spinner_triples.setValue(0);
		spinner_homeround.setValue(0);
		spinner_outs.setValue(0);
		spinner_errores.setValue(0);
		spinner_velocidad.setValue(0);
	}
	public int  posicion_equipo (int i){
		return equipo.posicion_jugador((Integer)table.getValueAt(table.getSelectedRows()[i], 2));
	}
	public void equipo_remover(int pos){
		equipo.getJugadores().remove(pos);
	}
	public void actualizar(){
		if(table.getSelectedRowCount()==1){
			int numero = (Integer)table.getValueAt(table.getSelectedRows()[0],2);
			Pelotero pelotero = equipo.buscador_pelotero(numero);
			if(pelotero!=null){
				textFieldNombre.setText(pelotero.getNombre());
				textFieldNombre_1.setText(pelotero.getApellido());
				spinner_numero.setValue(pelotero.getNumero());
				spinner_1_experiencia.setValue(pelotero.getAños_equipo());
				textFieldCarnet.setText(pelotero.getId());
				comboBox_brazo.setSelectedItem(pelotero.getBrazo());
				if(pelotero instanceof Lanzador){
					comboBox_posicion.setSelectedItem("Lanzador");
					spinner_velocidad.setValue(((Lanzador) pelotero).getVelocidad_maxima());
					comboBox_lanzamiento.setSelectedItem(((Lanzador) pelotero).getLanzamiento());
				}
				else{
					comboBox_posicion.setSelectedItem("Jugador de cuadro");
					spinner_sencillos.setValue(((Jugador_cuadro)pelotero).getSencillo());
					spinner_dobles.setValue(((Jugador_cuadro)pelotero).getDobles());
					spinner_triples.setValue(((Jugador_cuadro)pelotero).getTriples());
					spinner_homeround.setValue(((Jugador_cuadro)pelotero).getHomerun());
					spinner_outs.setValue(((Jugador_cuadro)pelotero).getOuts());
					spinner_errores.setValue(((Jugador_cuadro)pelotero).getCantidad_errores());
					comboBox_posicion_especifica.setSelectedItem(((Jugador_cuadro)pelotero).getPosición());
				}
			}
		}
	}
	public void modificar(){
		if(table.getSelectedRowCount()== 1){
			int numero = (Integer) table.getValueAt(table.getSelectedRows()[0],2);
			Pelotero pelotero = equipo.buscador_pelotero(numero);
			if(pelotero != null){
				Pelotero pelotero2= equipo.buscador_pelotero((Integer) spinner_numero.getValue());
				if(pelotero2 == null || pelotero==pelotero2){
					int pos = equipo.posicion_jugador(numero);
					if(comboBox_posicion.getSelectedIndex() == 0){
						String nombre=textFieldNombre.getText();
						String ID=textFieldCarnet.getText();
						String apellido=textFieldNombre_1.getText();
						int años_experiencia=spinner_1_experiencia.getValue().hashCode();
						Brazo_Hábil brazo=(Brazo_Hábil)comboBox_brazo.getSelectedItem();
						Posicion_específica posicion = (Posicion_específica)comboBox_posicion_especifica.getSelectedItem();
						int sencillo=(Integer) spinner_sencillos.getValue();
						int dobles=(Integer) spinner_dobles.getValue();
						int triples=(Integer) spinner_triples.getValue();
						int homeround=(Integer) spinner_homeround.getValue();
						int outs=(Integer) spinner_outs.getValue();
						int errores=(Integer) spinner_velocidad.getValue();
						pelotero = new Jugador_cuadro(nombre, apellido, ID, numero, años_experiencia, brazo, posicion, errores, outs, sencillo, dobles, triples, homeround);
					}
					else{
						String nombre=textFieldNombre.getText();
						String ID=textFieldCarnet.getText();
						String apellido=textFieldNombre_1.getText();
						int años_experiencia=spinner_1_experiencia.getValue().hashCode();
						Brazo_Hábil brazo=(Brazo_Hábil)comboBox_brazo.getSelectedItem();
						String lanzamiento=comboBox_lanzamiento.getSelectedItem().toString();
						int velocidad=spinner_velocidad.getValue().hashCode();
						pelotero = new Lanzador(nombre, apellido, ID, numero, años_experiencia, brazo, lanzamiento, velocidad);
					}
					equipo.getJugadores().set(pos, pelotero);
				}
			}
		}
    }
}

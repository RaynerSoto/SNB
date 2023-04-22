package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import beisbol.Equipo;
import beisbol.Jugador_cuadro;
import beisbol.Lanzador;
import beisbol.Serie;

import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estadisticas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Serie_elegida serie_elegida;
	private Serie serie_Activa;
	private JTable table;
	private JComboBox comboBox_equipos;
	private JTable table_1;
	private JComboBox comboBox_peticiones;
	private JLabel lblCampen;
	private JLabel lblNewLabelCampeón;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * @param serie_Activa 
	 * @param serie_elegida 
	 */
	public Estadisticas(Serie_elegida serie_elegida, Serie serie_Activa) {
		setModal(true);
		setTitle("Est\u00E1disticas");
		this.serie_elegida=serie_elegida;
		this.serie_Activa=serie_Activa;
		setBounds(100, 100, 674, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 65, 343, 247);
		contentPanel.add(table);
		
		JLabel lblTablaDePosiciones = new JLabel("Tabla de posiciones");
		lblTablaDePosiciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTablaDePosiciones.setBounds(10, 9, 277, 21);
		contentPanel.add(lblTablaDePosiciones);
		
		JLabel lblPeticin = new JLabel("Equipo");
		lblPeticin.setBounds(394, 15, 95, 14);
		contentPanel.add(lblPeticin);
		
		JLabel lblPeticin_1 = new JLabel("Petici\u00F3n");
		lblPeticin_1.setBounds(394, 40, 95, 14);
		contentPanel.add(lblPeticin_1);
		
		comboBox_equipos = new JComboBox();
		comboBox_equipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar_tabla_estadística();
			}
		});
		comboBox_equipos.setBounds(499, 11, 103, 20);
		contentPanel.add(comboBox_equipos);
		
		comboBox_peticiones = new JComboBox();
		comboBox_peticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar_tabla_estadística();
			}
		});
		comboBox_peticiones.setModel(new DefaultComboBoxModel(new String[] {"Average", "Hits", "Sencillos", "Dobles", "Triples", "Homeround", "Cantidad de ganados", "Cantidad de perdidos", "PCL"}));
		comboBox_peticiones.setBounds(499, 37, 103, 20);
		contentPanel.add(comboBox_peticiones);
		
		table_1 = new JTable();
		table_1.setBounds(394, 65, 254, 247);
		contentPanel.add(table_1);
		
		lblCampen = new JLabel("Campe\u00F3n");
		lblCampen.setBounds(10, 39, 54, 17);
		contentPanel.add(lblCampen);
		
		lblNewLabelCampeón = new JLabel("");
		lblNewLabelCampeón.setBounds(77, 38, 288, 17);
		contentPanel.add(lblNewLabelCampeón);
		actualiza_combox();
		actualizar_tabla();
		actualizar_tabla_estadística();
	}
	public void actualiza_combox(){
		for(int i=0;i<serie_Activa.getEquipos().size();i++){
			comboBox_equipos.addItem(serie_Activa.getEquipos().get(i).getNombre());
		}
	}
	public void actualizar_tabla(){
		String[] encabezado = {"Nombre", "Cantidad de ganados","Cantidad de perdidos"};		
		Object [] [] tabla = new Object[serie_Activa.getEquipos().size()][encabezado.length];
		ArrayList<Equipo>tabla_final = serie_Activa.Ganadores(serie_Activa.getEquipos().size());
		if(serie_Activa.Campeon()!=null){
			lblNewLabelCampeón.setText(serie_Activa.Campeon().getNombre());
		}
		else{
			lblNewLabelCampeón.setText("La final no se ha celebrado o marcha empatada");
		}
		for(int i=0; i<serie_Activa.getEquipos().size(); i++){
			tabla[i][0] = tabla_final.get(i).getNombre();
			tabla[i][1] = tabla_final.get(i).getCantidad_ganados();
			tabla[i][2] = tabla_final.get(i).getCantidad_perdidos();
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla, encabezado){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table.setModel(defaultTableModel);
	}
	public void actualizar_tabla_estadística(){
		Equipo equipo = serie_Activa.getEquipos().get(comboBox_equipos.getSelectedIndex());
		String[] encabezado = {"Nombre", "Dato"};
		Object [] [] tabla_1 = null;
		if(comboBox_peticiones.getSelectedItem() == "Average")
		{
			ArrayList<Jugador_cuadro>list = equipo.AverageJC();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).Average();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Hits"){
			ArrayList<Jugador_cuadro>list = equipo.Hits();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).Hits();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Sencillos"){
			ArrayList<Jugador_cuadro>list = equipo.Sencillo();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).getSencillo();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Dobles"){
			ArrayList<Jugador_cuadro>list = equipo.Dobles();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).getDobles();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Triples"){
			ArrayList<Jugador_cuadro>list = equipo.Triples();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).getTriples();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Homeround"){
			ArrayList<Jugador_cuadro>list = equipo.Triples();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Jugador_cuadro)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Jugador_cuadro)list.get(i)).getHomerun();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Cantidad de ganados"){
			ArrayList<Lanzador>list = equipo.Ganadores();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Lanzador)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Lanzador)list.get(i)).getJuegos_ganados();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "Cantidad de perdidos"){
			ArrayList<Lanzador>list = equipo.Perdedores();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Lanzador)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Lanzador)list.get(i)).getJuegos_perdidos();
			}
		}
		else if(comboBox_peticiones.getSelectedItem() == "PCL"){
			ArrayList<Lanzador>list = equipo.PCL();
			tabla_1 = new Object[list.size()][encabezado.length];
			for(int i=0; i<list.size(); i++){
				tabla_1[i][0] =  ((Lanzador)list.get(i)).getNombre();
				tabla_1[i][1] =  ((Lanzador)list.get(i)).PCL();
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla_1, encabezado){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table_1.setModel(defaultTableModel);
	}
}
	

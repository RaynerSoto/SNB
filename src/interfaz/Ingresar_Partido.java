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
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.Font;

import javax.swing.JTable;

import beisbol.Equipo;
import beisbol.Fases;
import beisbol.Jugador_cuadro;
import beisbol.Lanzador;
import beisbol.Partidos;
import beisbol.Pelotero;
import beisbol.Serie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;

import sun.rmi.transport.LiveRef;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SpinnerNumberModel;

public class Ingresar_Partido extends JDialog {
	private JSpinner spinner_carrera_homeclub;
	private JComboBox comboBox_home;
	private JComboBox comboBox_visitante;
	private JTable table;
	private Serie_interfaz serie_interfaz;
	private Serie ser;
	private JComboBox comboBox_pitcher_home;
	private JComboBox comboBox_pitcher_visitante;
	private JComboBox comboBoxFase;
	private JSpinner spinner_carrera_visitador;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.

	/**
	 * Create the dialog.
	 * @param ser 
	 * @param serie_interfaz 
	 */
	public Ingresar_Partido(Serie_interfaz serie_interfaz, Serie ser) {
		setModal(true);
		this.ser=ser;
		this.serie_interfaz=serie_interfaz;
		setTitle("Partido\r\n");
		setBounds(100, 100, 486, 434);
		getContentPane().setLayout(null);
		
		JLabel lblHomeClub = new JLabel("Home Club");
		lblHomeClub.setBounds(10, 43, 69, 21);
		getContentPane().add(lblHomeClub);
		
		comboBox_home = new JComboBox();
		comboBox_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargar_Pitcher_Home();
			}
		});
		comboBox_home.setBounds(89, 43, 95, 20);
		getContentPane().add(comboBox_home);
		
		JLabel lblVisitador = new JLabel("Visitador");
		lblVisitador.setBounds(242, 43, 77, 21);
		getContentPane().add(lblVisitador);
		
		comboBox_visitante = new JComboBox();
		comboBox_visitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargar_Pitcher_Visitante();
			}
		});
		comboBox_visitante.setBounds(329, 43, 95, 20);
		getContentPane().add(comboBox_visitante);
		
		JLabel lblCarreras = new JLabel("Carreras");
		lblCarreras.setBounds(10, 75, 69, 21);
		getContentPane().add(lblCarreras);
		
		spinner_carrera_homeclub = new JSpinner();
		spinner_carrera_homeclub.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_carrera_homeclub.setBounds(89, 75, 95, 20);
		getContentPane().add(spinner_carrera_homeclub);
		
		JLabel lblCarreras_1 = new JLabel("Carreras");
		lblCarreras_1.setBounds(242, 75, 77, 21);
		getContentPane().add(lblCarreras_1);
		
		spinner_carrera_visitador = new JSpinner();
		spinner_carrera_visitador.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_carrera_visitador.setBounds(329, 75, 95, 20);
		getContentPane().add(spinner_carrera_visitador);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setBounds(10, 107, 69, 21);
		getContentPane().add(lblPitcher);
		
		comboBox_pitcher_home = new JComboBox();
		comboBox_pitcher_home.setBounds(89, 106, 95, 20);
		getContentPane().add(comboBox_pitcher_home);
		
		JLabel lblPitcher_1 = new JLabel("Pitcher");
		lblPitcher_1.setBounds(242, 107, 77, 17);
		getContentPane().add(lblPitcher_1);
		
		comboBox_pitcher_visitante = new JComboBox();
		comboBox_pitcher_visitante.setBounds(329, 107, 95, 20);
		getContentPane().add(comboBox_pitcher_visitante);
		
		JLabel lblPartido = new JLabel("Partido");
		lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartido.setBounds(177, 0, 108, 32);
		getContentPane().add(lblPartido);
		
		JButton btnAadir = new JButton("Ingresar");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validaciones())
				{
					AdicionarPartido();
					actualizar_estadísticas();
					}
			}
		});
		btnAadir.setBounds(10, 166, 108, 32);
		getContentPane().add(btnAadir);
		
		JButton btnCancelar = new JButton("Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(353, 166, 110, 32);
		getContentPane().add(btnCancelar);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				actualizar();
				actualizar_botones();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				actualizar();
				actualizar_botones();
			}
		});
		table.setBounds(10, 215, 450, 169);
		getContentPane().add(table);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 139, 46, 14);
		getContentPane().add(lblFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(89, 135, 95, 20);
		getContentPane().add(dateChooser);
		
		JLabel lblFase = new JLabel("Fase");
		lblFase.setBounds(242, 135, 46, 14);
		getContentPane().add(lblFase);
		
		comboBoxFase = new JComboBox();
		comboBoxFase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambioDeFase();
			}
		});
		comboBoxFase.setModel(new DefaultComboBoxModel(new String[] {"1era Fase", "2da Fase", "Semifinal", "Final"}));
		comboBoxFase.setBounds(329, 138, 95, 20);
		getContentPane().add(comboBoxFase);
		dateChooser.setDate(Calendar.getInstance().getTime());
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxFase.getSelectedIndex() < 3 && validar()>0)
				{
					JOptionPane.showMessageDialog(Ingresar_Partido.this,"La fase actual ya ha terminado", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(PuedeModificar())
				{
					actualizar_modificar();
					modificar();
					actualizar_estadísticas();
				}
			}
		});
		btnModificar.setBounds(128, 166, 108, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxFase.getSelectedIndex() < 3 && validar()>0){
					JOptionPane.showMessageDialog(Ingresar_Partido.this,"La fase actual ya ha terminado", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(JOptionPane.showConfirmDialog(Ingresar_Partido.this,"¿Desea eliminar?","Confirmar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						int pos;
						for(int contador=0;contador<table.getSelectedRows().length;contador++){
							pos = posicion(contador);
							if(pos!=-1){
								actualizar_estadistica_eliminado(pos);
								eliminar_partido(pos);
							}
						}
						actualizar_tabla();
						ActInterfazAnterior();
					}
				}
			}
		});
		btnEliminar.setBounds(242, 166, 101, 32);
		getContentPane().add(btnEliminar);
		CambioDeFase();
	}
	
	private void ActInterfazAnterior(){
		serie_interfaz.ActualizarBoton();
	}
	
	private void Cargar_Pitcher_Home(){
		comboBox_pitcher_home.removeAllItems();
		if(comboBox_home.getSelectedIndex() != -1){
		Equipo eq = (Equipo)comboBox_home.getSelectedItem();
			Pelotero pel;
			for(int i = 0; i < eq.getJugadores().size(); i++){
				pel = eq.getJugadores().get(i);
				if(pel instanceof Lanzador)
					comboBox_pitcher_home.addItem(pel);
		}
		}
	}
	
	private void Cargar_Pitcher_Visitante(){
		comboBox_pitcher_visitante.removeAllItems();
		if(comboBox_visitante.getSelectedIndex() != -1){
		Equipo eq = (Equipo)comboBox_visitante.getSelectedItem();
			Pelotero pel;
			for(int i = 0; i < eq.getJugadores().size(); i++){
				pel = eq.getJugadores().get(i);
				if(pel instanceof Lanzador)
					comboBox_pitcher_visitante.addItem(pel);
		}
		}
	}
	
	private ArrayList<Equipo> EquiposPorFase(int fase)
	{
		switch (fase) {
		case 1:
			return ser.Ganadores(8);
		case 2:
			return ser.Ganadores(4);
		case 3:
			return ser.Ganadores(2);
		default:
			return ser.getEquipos();
		}
	}
	
	private void CambioDeFase()
	{
		ArrayList<Equipo> equipos = EquiposPorFase(comboBoxFase.getSelectedIndex());
		comboBox_home.removeAllItems();
		comboBox_visitante.removeAllItems();
		for(int contador = 0;contador<equipos.size();contador++){
			comboBox_home.addItem(equipos.get(contador));
			comboBox_visitante.addItem(equipos.get(contador));
		}
		actualizar_tabla();
	}
	
	public boolean validaciones(){
		if(comboBox_home.getSelectedIndex() == -1 || comboBox_visitante.getSelectedIndex() == -1 || comboBox_pitcher_home.getSelectedIndex() == -1 || comboBox_pitcher_visitante.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(Ingresar_Partido.this,"Tiene que seleccionarse los equipos y los pitchers", "Error",JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		if(comboBox_home.getSelectedIndex() == comboBox_visitante.getSelectedIndex())
		{
			JOptionPane.showMessageDialog(Ingresar_Partido.this,"No pueden jugar equpos iguales", "Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(spinner_carrera_homeclub.getValue().hashCode() == spinner_carrera_visitador.getValue().hashCode())
		{
			JOptionPane.showMessageDialog(Ingresar_Partido.this,"Un partido no puede acabar empatado", "Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo)comboBox_home.getSelectedItem(), (Equipo)comboBox_visitante.getSelectedItem(),dateChooser.getCalendar().getTime()) != null)
		{
			JOptionPane.showMessageDialog(Ingresar_Partido.this,"Partido ya celebrado", "Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(comboBoxFase.getSelectedIndex() < 3 && ser.getFase().get(comboBoxFase.getSelectedIndex()+1).getPartido().size()>0)
		{
			JOptionPane.showMessageDialog(Ingresar_Partido.this,"La fase actual ya ha terminado", "Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	    if(comboBoxFase.getSelectedIndex() > 0)
	    {
	    	int i =0, j;
	    	boolean continuar = true, encontrado;
	    	Equipo eq;
	    	Partidos par;
	    	Fases fase = ser.getFase().get(comboBoxFase.getSelectedIndex()-1);
	    	ArrayList<Equipo> equipos = EquiposPorFase(comboBoxFase.getSelectedIndex()-1);
	    	while(i < equipos.size() && continuar)
	    	{
	    		encontrado = false;
	    		eq = equipos.get(i);
	    		j = 0;
	    		while(j < fase.getPartido().size() && continuar && !encontrado)
	    		{
	    			par = fase.getPartido().get(j);
	    			if(par.getHomeClub() == eq || par.getVisitante() == eq)
	    				encontrado = true;
	    			else
	    			    j++;
	    		}
	    		if(!encontrado)
	    			continuar = false;
	    		i++;
	    	}
	    	if(!continuar)
	    	{
	    		JOptionPane.showMessageDialog(Ingresar_Partido.this,"Los equipos clasificados deben jugar al menos una vez en cada fase", "Error",JOptionPane.ERROR_MESSAGE);
				return false;
	    	}
	    }
		return true;
	}
	public void ActualizarBoton(){
		btnEliminar.setEnabled(table.getSelectedRowCount()>0);
		btnModificar.setEnabled(table.getSelectedRowCount()==1);
	}
	public void actualizar_tabla(){
		String[] encabezado = {"Equipo HomeClub","Carreras Homeclub","Equipo Visitante","Carreras Visitante","Fecha"};
		Object [] [] tabla = new Object[ser.getFase().get(comboBoxFase.getSelectedIndex()).getPartido().size()][encabezado.length];
		Partidos p;
		for(int contador=0; contador<ser.getFase().get(comboBoxFase.getSelectedIndex()).getPartido().size();contador++){
			p = ser.getFase().get(comboBoxFase.getSelectedIndex()).getPartido().get(contador);
		    tabla [contador] [0] = p.getHomeClub();
		    tabla [contador] [1] = p.getHomeclub_carreras();
		    tabla [contador] [2] = p.getVisitante();
		    tabla [contador] [3] = p.getVisitante_carreras();
		    tabla [contador] [4] = p.getFecha();
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(tabla, encabezado){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table.setModel(defaultTableModel);
		ActualizarBoton();
	}
	
	private void AdicionarPartido(){
		ser.getFase().get(comboBoxFase.getSelectedIndex()).ingresar_partido((Equipo)comboBox_home.getSelectedItem(), (Equipo)comboBox_visitante.getSelectedItem(), (Lanzador)comboBox_pitcher_home.getSelectedItem(), (Lanzador)comboBox_pitcher_visitante.getSelectedItem(), (Integer)spinner_carrera_homeclub.getValue(), (Integer)spinner_carrera_visitador.getValue(), dateChooser.getCalendar().getTime());
		actualizar_tabla();
		ActInterfazAnterior();
	}
	public void actualizar_botones(){
		btnEliminar.setEnabled(table.getSelectedRowCount()>0);
		btnModificar.setEnabled(table.getSelectedRowCount()==1);
	}
	public void actualizar(){
		if(table.getSelectedRowCount()==1){
		Partidos p=ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo) table.getValueAt(table.getSelectedRows()[0],0), (Equipo) table.getValueAt(table.getSelectedRows()[0],2), (Date)table.getValueAt(table.getSelectedRows()[0],4));
		if(p!= null){
			comboBox_home.setSelectedItem(p.getHomeClub());
			comboBox_visitante.setSelectedItem(p.getVisitante());
			spinner_carrera_homeclub.setValue(p.getHomeclub_carreras());
			spinner_carrera_visitador.setValue(p.getVisitante_carreras());
			comboBox_pitcher_home.setSelectedItem(p.getHomeClub_lanzador());
			comboBox_pitcher_visitante.setSelectedItem(p.getVisitante_lanzador());
			dateChooser.setDate(p.getFecha());
		}
		}
	}
	public void actualizar_estadísticas(){
		Lanzador lhc = ((Lanzador)comboBox_pitcher_home.getSelectedItem());
		lhc.setCarreras_permitidas(lhc.getCarreras_permitidas()+spinner_carrera_visitador.getValue().hashCode());
		Lanzador lvis = ((Lanzador)comboBox_pitcher_visitante.getSelectedItem());
		lvis.setCarreras_permitidas(lvis.getCarreras_permitidas()+(Integer)spinner_carrera_homeclub.hashCode());
		if(spinner_carrera_homeclub.getValue().hashCode()>spinner_carrera_visitador.getValue().hashCode()){
			lhc.setJuegos_ganados(lhc.getJuegos_ganados()+1);
			lvis.setJuegos_perdidos(lvis.getJuegos_perdidos()+1);
		}
		else{
			lvis.setJuegos_ganados(lvis.getJuegos_ganados()+1);
			lhc.setJuegos_perdidos(lhc.getJuegos_perdidos()+1);	
		}
	}
	
	public boolean PuedeModificar()
	{
		Partidos p=ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo) table.getValueAt(table.getSelectedRows()[0],0), (Equipo) table.getValueAt(table.getSelectedRows()[0],2), (Date)table.getValueAt(table.getSelectedRows()[0],4));
		if(p != null)
		{
			Partidos p2 = ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo) comboBox_home.getSelectedItem(), (Equipo) comboBox_visitante.getSelectedItem(), dateChooser.getDate());
			if(p2 == null || p == p2)
				return true;
			else
			{
				JOptionPane.showMessageDialog(Ingresar_Partido.this,"Partido ya celebrado", "Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void actualizar_modificar(){
		Partidos p=ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo) table.getValueAt(table.getSelectedRows()[0],0), (Equipo) table.getValueAt(table.getSelectedRows()[0],2), (Date)table.getValueAt(table.getSelectedRows()[0],4));
		Lanzador lhc = p.getHomeClub_lanzador();
		Lanzador lvis = p.getVisitante_lanzador();
		lhc.setCarreras_permitidas(lhc.getCarreras_permitidas()-p.getVisitante_carreras());
		lvis.setCarreras_permitidas(lvis.getCarreras_permitidas()-p.getHomeclub_carreras());
		if(p.getHomeclub_carreras()>p.getVisitante_carreras()){
			lhc.setJuegos_ganados(lhc.getJuegos_ganados()-1);
			lvis.setJuegos_perdidos(lvis.getJuegos_perdidos()-1);
		}
		else{
			lvis.setJuegos_ganados(lhc.getJuegos_ganados()-1);
			lhc.setJuegos_perdidos(lvis.getJuegos_perdidos()-1);
		}
	}
	public void modificar(){
		Partidos p=ser.getFase().get(comboBoxFase.getSelectedIndex()).partido((Equipo) table.getValueAt(table.getSelectedRows()[0],0), (Equipo) table.getValueAt(table.getSelectedRows()[0],2), (Date)table.getValueAt(table.getSelectedRows()[0],4));
		p.setHomeClub((Equipo) comboBox_home.getSelectedItem());
		p.setVisitante((Equipo) comboBox_visitante.getSelectedItem());
		p.setHomeclub_carreras((Integer) spinner_carrera_homeclub.getValue());
		p.setVisitante_carreras((Integer) spinner_carrera_visitador.getValue());
		p.setHomeClub_lanzador((Lanzador) comboBox_pitcher_home.getSelectedItem());
		p.setVisitante_lanzador((Lanzador) comboBox_pitcher_visitante.getSelectedItem());
		actualizar_tabla();
	}
	public int posicion(int contador){
		return ser.getFase().get(comboBoxFase.getSelectedIndex()).buscar_posicion_partido((Equipo)table.getValueAt(table.getSelectedRows()[contador],0),(Equipo)table.getValueAt(table.getSelectedRows()[contador],2) ,(Date)table.getValueAt(table.getSelectedRows()[contador],4));
	}
	public void eliminar_partido(int pos){
		ser.getFase().get(comboBoxFase.getSelectedIndex()).getPartido().remove(pos);
	}
	public void actualizar_estadistica_eliminado(int pos){
		Partidos p = ser.getFase().get(comboBoxFase.getSelectedIndex()).getPartido().get(pos);
		Lanzador lhc = p.getHomeClub_lanzador();
		Lanzador lvis = p.getVisitante_lanzador();
		lhc.setCarreras_permitidas(lhc.getCarreras_permitidas()-p.getVisitante_carreras());
		lvis.setCarreras_permitidas(lvis.getCarreras_permitidas()-p.getHomeclub_carreras());
		if(p.getHomeclub_carreras()>p.getVisitante_carreras()){
			lhc.setJuegos_ganados(lhc.getJuegos_ganados()-1);
			lvis.setJuegos_perdidos(lvis.getJuegos_perdidos()-1);
		}
		else
		{
			lvis.setJuegos_ganados(lhc.getJuegos_ganados()-1);
			lhc.setJuegos_perdidos(lvis.getJuegos_perdidos()-1);
		}
	}
	public int validar(){
		return ser.getFase().get(comboBoxFase.getSelectedIndex()+1).getPartido().size();
	}
}

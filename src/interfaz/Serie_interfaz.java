package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Interfaces_creadas.JTextFieldSerie;

import javax.swing.JTable;

import beisbol.Inder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import sun.security.jca.GetInstance;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Serie_interfaz extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spinner;
	private JTable table;
	private JButton btnFinalizar;
	private JButton btnInsertat;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAadirPartido;
	private Menú menú;

	/**
	 * Launch the application.
	 * @param menú 
	 */
	public Serie_interfaz(Menú menú) {
		this.menú=menú;
		setTitle("Ingresar serie");
		setBounds(100, 100, 442, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNmeroDeSerie = new JLabel("N\u00FAmero de serie");
		lblNmeroDeSerie.setBounds(10, 11, 111, 33);
		contentPanel.add(lblNmeroDeSerie);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ActualizarBoton();
				if(table.getSelectedRowCount() == 1)
					spinner.setValue((Integer)table.getValueAt(table.getSelectedRows()[0], 0));
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActualizarBoton();
				if(table.getSelectedRowCount() == 1)
					spinner.setValue((Integer)table.getValueAt(table.getSelectedRows()[0], 0));
			}
		});
		table.setBounds(10, 147, 406, 150);
		contentPanel.add(table);
		btnAceptar = new JButton("A\u00F1adir");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Inder.getInstancia().buscarSerie((Integer)spinner.getValue())!=null)
					JOptionPane.showMessageDialog(Serie_interfaz.this,"La serie ya está insertada", "Error",JOptionPane.ERROR_MESSAGE);
				else{
					beisbol.Serie ser = new beisbol.Serie((Integer)spinner.getValue());
					Inder.getInstancia().getSeries().add(ser);
					actualizar();
				}
			}
		});
		btnAceptar.setBounds(206, 14, 100, 30);
		contentPanel.add(btnAceptar);
		
		btnInsertat = new JButton("A\u00F1adir equipo");
		btnInsertat.setEnabled(false);
		btnInsertat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beisbol.Serie ser = Inder.getInstancia().buscarSerie((Integer)table.getValueAt(table.getSelectedRow(), 0));
				if(ser != null){
				Ingresar_equipo ingresar = new Ingresar_equipo(Serie_interfaz.this,ser);
				ingresar.setVisible(true);}
			}
		});
		btnInsertat.setBounds(48, 100, 124, 36);
		contentPanel.add(btnInsertat);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spinner.setBounds(131, 17, 65, 20);
		contentPanel.add(spinner);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar_menú();
				dispose();
			}
		});
		btnFinalizar.setBounds(316, 14, 100, 30);
		contentPanel.add(btnFinalizar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beisbol.Serie ser = Inder.getInstancia().buscarSerie((Integer)table.getValueAt(table.getSelectedRow(), 0));
				if(ser != null)
				{
					beisbol.Serie ser2 = Inder.getInstancia().buscarSerie((Integer)spinner.getValue());
					if(ser2 == null || ser == ser2){
						ser.setId((Integer)spinner.getValue());
						actualizar();
					}
					else
						JOptionPane.showMessageDialog(Serie_interfaz.this,"La serie ya está insertada", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(206, 55, 100, 30);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Serie_interfaz.this,"¿Desea eliminar?","Confirmar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				int pos;
				for(int i=0;i<table.getSelectedRows().length;i++)
				{
					pos = Inder.getInstancia().buscarSeriePos((Integer)table.getValueAt(table.getSelectedRows()[i], 0));
					if(pos != -1)
						Inder.getInstancia().getSeries().remove(pos);
				}
				actualizar();
				}
			}
		});
		btnEliminar.setBounds(316, 55, 100, 30);
		contentPanel.add(btnEliminar);
		
		btnAadirPartido = new JButton("A\u00F1adir partido");
		btnAadirPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beisbol.Serie ser = Inder.getInstancia().buscarSerie((Integer)table.getValueAt(table.getSelectedRow(), 0));
				if(ser != null){
					if(ser.EsOk()){
						Ingresar_Partido partido = new Ingresar_Partido(Serie_interfaz.this,ser);
						partido.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(Serie_interfaz.this,"No hay la cantidad mínina de equipos para competir", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAadirPartido.setEnabled(false);
		btnAadirPartido.setBounds(249, 100, 131, 36);
		contentPanel.add(btnAadirPartido);
		actualizar();
	}
	public void actualizar(){
		String[] encabezado = {"Numero de serie"};
		Object [] [] tabla = new Object[Inder.getInstancia().getSeries().size()][encabezado.length];
		for(int contador=0; contador<Inder.getInstancia().getSeries().size();contador++){
			tabla [contador] [0] = Inder.getInstancia().getSeries().get(contador).getId();
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
		ActualizarBoton();
	}
	
	public void ActualizarBoton(){
		btnInsertat.setEnabled(table.getSelectedRowCount() == 1 && !tieneSerie());
		btnEliminar.setEnabled(table.getSelectedRowCount()> 0);
		btnModificar.setEnabled(table.getSelectedRowCount() == 1);
		btnAadirPartido.setEnabled(table.getSelectedRowCount()==1);
	}
	
	public boolean tieneSerie()
	{
		beisbol.Serie ser = Inder.getInstancia().buscarSerie((Integer)table.getValueAt(table.getSelectedRow(), 0));
		if(ser != null)
		{
			return ser.getFase().get(0).getPartido().size() >0 ||ser.getFase().get(1).getPartido().size() >0 ||ser.getFase().get(2).getPartido().size() >0 ||ser.getFase().get(3).getPartido().size() >0;
		}
		return false;
	}
	public void actualizar_menú(){
		menú.actualizar_boton();
	}
}

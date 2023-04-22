package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import beisbol.Inder;
import beisbol.Serie;

import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;

public class Menú extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmSerie_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menú frame = new Menú();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menú() {
		setTitle("Serie Nacional de Beisbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 464, 21);
		contentPane.add(menuBar);
		JMenu mnIngresar = new JMenu("Gestionar\r\n");
		menuBar.add(mnIngresar);
		
		JMenuItem mntmSerie = new JMenuItem("Serie");
		mntmSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serie_interfaz serie=new Serie_interfaz(Menú.this);
				serie.setVisible(true);
			}
		});
		mnIngresar.add(mntmSerie);
		
		JMenu mnEstdisticas = new JMenu("Est\u00E1disticas");
		mnEstdisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar_boton();
			}
		});
		menuBar.add(mnEstdisticas);
		
		mntmSerie_1 = new JMenuItem("Seleccionar serie");
		mntmSerie_1.setEnabled(false);
		mntmSerie_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Inder.getInstancia().getSeries().size()>0){
					Serie_elegida elegir = new Serie_elegida(Menú.this);
					elegir.setVisible(true);
				}
			}
		});
		mnEstdisticas.add(mntmSerie_1);
		
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Poty\\Downloads\\B\u00E9isbol en Cuba. Resultados y estad\u00EDsticas de la Serie Nacional_files\\cienfuegos.jfif"));
		label_3.setBounds(387, 32, 46, 40);
		contentPane.add(label_3);
		actualizar_boton();
	}
	public void actualizar_boton(){
		if(Inder.getInstancia().getSeries().size()>0){
			mntmSerie_1.setEnabled(true);
		}
		else{
			mntmSerie_1.setEnabled(false);
		}
	}
}

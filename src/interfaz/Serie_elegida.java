package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import beisbol.Inder;
import beisbol.Serie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Serie_elegida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private Menú menú;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param menú 
	 */
	public Serie_elegida(Menú menú) {
		this.menú=menú;
		setModal(true);
		setTitle("Serie a elegir");
		setBounds(100, 100, 229, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setBounds(10, 11, 57, 25);
		contentPanel.add(lblSerie);
		
		comboBox = new JComboBox();
		comboBox.setBounds(77, 13, 89, 20);
		contentPanel.add(comboBox);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serie serie_Activa = Inder.getInstancia().getSeries().get(comboBox.getSelectedIndex());
				if(serie_Activa.getEquipos().size()==0){
					JOptionPane.showMessageDialog(Serie_elegida.this,"La serie selecionada no cuenta con equipos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					Estadisticas estadistica = new Estadisticas(Serie_elegida.this,serie_Activa);
					estadistica.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(10, 54, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(109, 54, 89, 23);
		contentPanel.add(btnCancelar);
		actualizar_combox();
	}
	public void actualizar_combox(){
		for(int i = 0; i<Inder.getInstancia().getSeries().size();i++){
			comboBox.addItem(Inder.getInstancia().getSeries().get(i).getId());
		}
	}
}

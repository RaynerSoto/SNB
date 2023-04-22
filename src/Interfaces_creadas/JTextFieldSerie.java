package Interfaces_creadas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldSerie extends JTextField {
	
	private static final long serialVersionUID = 1136231456938276120L;
	private int limite = 4;

	public int getLimite()
	{
		return this.limite;
	}
	public void setLimite(int limite)
	{
		if(limite<=4)
			this.limite = limite;
	}
	
	public JTextFieldSerie() {	
		this.setColumns(4);
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField) e.getSource();
				if(!Character.isJavaIdentifierPart(e.getKeyChar())){
					e.consume();
				}
				else if (Character.isAlphabetic(e.getKeyChar()))
					e.consume();
			}
		});
	}

}

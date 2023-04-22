package Interfaces_creadas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldCarnet extends JTextField {
	
	private static final long serialVersionUID = 1136231456938276120L;
	private int limite = 11;

	public int getLimite()
	{
		return this.limite;
	}
	public void setLimite(int limite)
	{
		if(limite<=11)
			this.limite = limite;
	}
	
	public JTextFieldCarnet() {	
		this.setColumns(10);
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField) e.getSource();
				if(text.getText().length() >= limite)
					e.consume();
				else if(!Character.isDigit(e.getKeyChar()))
					e.consume();
				else if(text.getText().length() == limite-1 && Character.digit(e.getKeyChar(), 10)%2==0)
					e.consume();
			}
		});
	}

}

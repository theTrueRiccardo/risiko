package client.view.gioco;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
public class ObiettivoGUIConcreto extends ObiettivoGUI {
	
	private JTextPane area ;
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public ObiettivoGUIConcreto() {
		
		setLayout(new BorderLayout());
		
		setBorder(BorderFactory.createLineBorder(new Color(255,204,51),3,true));
		
		
		area = new JTextPane();
		area.setEditable(false);
		area.setBackground(Color.BLACK);
		StyledDocument documentoPane = area.getStyledDocument();
		SimpleAttributeSet attributiDocumento = new SimpleAttributeSet();
		StyleConstants.setForeground(attributiDocumento, Color.WHITE);
		StyleConstants.setAlignment(attributiDocumento, StyleConstants.ALIGN_CENTER);
		documentoPane.setParagraphAttributes(0, documentoPane.getLength(), attributiDocumento, true);
		add(BorderLayout.CENTER,area);
	}
	
	
	
	
	
	@Override
	public void inserisciTestoObiettivo(String testo) {
		String daMettere = "OBBIETTIVO\n";
		String s = daMettere+testo;
		area.setText(s);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String...args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		JFrame frame = new JFrame();
		frame.setSize(d);
		ObiettivoGUI obiettivo = new ObiettivoGUIConcreto();
		Container c = frame.getContentPane();
		//c.setLayout(new FlowLayout());
		obiettivo.inserisciTestoObiettivo("Devi distruggere le armate rosse. In caso sia tu il proprietario delle armate rosse devi conquistare 24 territori");
		
		c.add(obiettivo);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	

}

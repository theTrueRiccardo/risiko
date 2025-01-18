package utilita;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console {

	private JFrame console;
	
	private JTextArea errori;
	
	private ArrayList<String> passi;
	
	
	public Console() {
		passi= new ArrayList<String>();
		console = new JFrame("Errori/Controllo");
		console.setSize(600,600);
		console.setLocation(600,600);
		console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		errori = new JTextArea();
		errori.setEditable(false);
		errori.setForeground(Color.RED);
		JScrollPane pane = new JScrollPane(errori);
		
		
		console.add(BorderLayout.CENTER,pane);
		console.setVisible(true);
	}
	
	
	public void scriviEccezione(String errore) {
		errori.append(errore+"\n");
	}
	
	public void esecuzione(String s) {
		passi.add(s);
	}
	
	public void scriviEsecuzione() {
		for(int i = 0; i < passi.size(); i++) {
			errori.append(i+": "+passi.get(i)+"\n");
		}
	}
	public static void main(String[] args) {
		Console c = new Console();
		c.scriviEccezione("aru culu");
		c.scriviEccezione("ciao");
		c.esecuzione("add 5");
		c.esecuzione("printf coccode");
		c.scriviEsecuzione();
	}

}

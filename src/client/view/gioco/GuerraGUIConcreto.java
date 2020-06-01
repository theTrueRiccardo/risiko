package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GuerraGUIConcreto extends GuerraGUI{
	
	private JLabel attaccante,difensore;
	
	private JTextPane risultatoAttacco,risultatoDifesa;
	
	public GuerraGUIConcreto() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.LIGHT_GRAY);
		JPanel panAttaccante = new JPanel();
		JPanel panDifensore = new JPanel();
		JPanel panRisAttacco = new JPanel();
		JPanel panRisDifesa = new JPanel();
		
		attaccante = new JLabel("attaccante");
		attaccante.setForeground(Color.RED);
		panAttaccante.add(attaccante);
		add(panAttaccante);
		
		
		risultatoAttacco = new JTextPane();
		risultatoAttacco.setEditable(false);
		risultatoAttacco.setBackground(Color.LIGHT_GRAY);
		StyledDocument documentoRisultatoAttacco = risultatoAttacco.getStyledDocument();
		SimpleAttributeSet attributiDocumentoRisultatoAttacco = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributiDocumentoRisultatoAttacco, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(attributiDocumentoRisultatoAttacco, Color.RED);
		documentoRisultatoAttacco.setParagraphAttributes(0, documentoRisultatoAttacco.getLength(), attributiDocumentoRisultatoAttacco, true);
		panRisAttacco.setLayout(new BorderLayout());
		panRisAttacco.add(BorderLayout.CENTER,risultatoAttacco);
		add(panRisAttacco);
		
		
		difensore = new JLabel("difensore");
		difensore.setForeground(Color.BLUE);
		panDifensore.add(difensore);
		add(panDifensore);
		
		risultatoDifesa=new JTextPane();
		risultatoDifesa.setEditable(false);
		risultatoDifesa.setBackground(Color.LIGHT_GRAY);
		StyledDocument documentoRisultatoDifesa = risultatoDifesa.getStyledDocument();
		SimpleAttributeSet attributiDocumentoRisultatoDifesa = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributiDocumentoRisultatoDifesa, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(attributiDocumentoRisultatoDifesa, Color.BLUE);
		documentoRisultatoDifesa.setParagraphAttributes(0, documentoRisultatoDifesa.getLength(), attributiDocumentoRisultatoDifesa, true);
		panRisDifesa.setLayout(new BorderLayout());
		panRisDifesa.add(BorderLayout.CENTER,risultatoDifesa);
		add(panRisDifesa);

		panAttaccante.setBackground(Color.LIGHT_GRAY);
		panDifensore.setBackground(Color.LIGHT_GRAY);
		
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuerraGUI gg = new GuerraGUIConcreto();
		f.add(gg);
		f.setVisible(true);
		gg.setAttaccante("Riccardo");
		gg.mostraRisultatoAttaccante("5  4  1");
		gg.setDifensore("Salvatore");
		gg.mostraRisultatoDifensore("1  1  1");
		//gg.reset();
	}

	@Override
	public void setAttaccante(String attaccante) {
		this.attaccante.setText(attaccante);
	}

	@Override
	public void setDifensore(String difensore) {
		this.difensore.setText(difensore);
	}

	@Override
	public void mostraRisultatoAttaccante(String attacco) {
		risultatoAttacco.setText(attacco);
	}

	@Override
	public void mostraRisultatoDifensore(String difesa) {
		risultatoDifesa.setText(difesa);
	}

	@Override
	public void reset() {
		attaccante.setText("attaccante");
		difensore.setText("difensore");
		risultatoAttacco.setText("");
		risultatoDifesa.setText("");
	}

	

}

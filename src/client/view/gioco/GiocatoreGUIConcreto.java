package client.view.gioco;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GiocatoreGUIConcreto extends GiocatoreGUI {
	
	private int base,altezza;
	private ObiettivoGUI obiettivoGUI;
	private ArmateGUI armateGUI;
	private GuerraGUI guerraGUI;
	private PannelloAttaccoGUI pannelloAttaccoGUI;
	private PannelloSpostaPassaGUI pannelloSpostaPassaGUI;
	private InformazioniGUI informazioniGUI;

	public GiocatoreGUIConcreto(int base, int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setLayout(new GridLayout(1,6));
		obiettivoGUI=new ObiettivoGUIConcreto();
		armateGUI = new ArmateGUIConcreto();
		guerraGUI = new GuerraGUIConcreto();
		pannelloAttaccoGUI = new PannelloAttaccoGUIConcreto();
		pannelloSpostaPassaGUI = new PannelloSpostaPassaGUIConcreto();
		informazioniGUI = new InformazioniGUIConcreto();
		add(obiettivoGUI);
		add(armateGUI);
		add(guerraGUI);
		add(pannelloAttaccoGUI);
		add(pannelloSpostaPassaGUI);
		add(informazioniGUI);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(base,altezza);
	}
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(1000,500);
				frame.setLocation(500,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GiocatoreGUI g = new GiocatoreGUIConcreto(1000,500);
				frame.add(g);
				g.settaObbiettivo("Devi distruggere le armate rosse. Se sei tu stesso il proprietario delle armate rosse o nessuno ha (più) le armate rosse, devi conquistare 24 territori");
				frame.setVisible(true);
			}
		});
		
	}

	@Override
	public void settaObbiettivo(String testoObbiettivo) {
		obiettivoGUI.inserisciTestoObiettivo(testoObbiettivo);
	}

	@Override
	public void settaColoreArmate(Color colore) {
		armateGUI.coloraArmate(colore);
	}

	@Override
	public void settaAttaccante(String attaccante) {
		guerraGUI.setAttaccante(attaccante);
	}

	@Override
	public void settaRisultatoAttaccante(String risultatoAttaccante) {
		guerraGUI.mostraRisultatoAttaccante(risultatoAttaccante);
	}

	@Override
	public void settaDifensore(String difensore) {
		guerraGUI.setDifensore(difensore);
	}

	@Override
	public void settaRisultatoDifensore(String risultatoDifensore) {
		guerraGUI.mostraRisultatoDifensore(risultatoDifensore);
	}

	@Override
	public void settaNazioneDallaAttacco(String nazione) {
		pannelloAttaccoGUI.mostraNazioneDalla(nazione);
	}

	@Override
	public void settaNazioneAllaAttacco(String nazione) {
		pannelloAttaccoGUI.mostraNazioneAlla(nazione);
	}

	@Override
	public void incrementaCarriAttacco() {
		pannelloAttaccoGUI.mostraIncremento();
	}

	@Override
	public void settaNazioneDallaSpostaPassa(String nazione) {
		pannelloSpostaPassaGUI.mostraNazioneDalla(nazione);
	}

	@Override
	public void settaNazioneAllaSpostaPassa(String nazione) {
		pannelloSpostaPassaGUI.mostraNazioneAlla(nazione);
	}

	@Override
	public void incrementaCarriSpostaPassa() {
		pannelloSpostaPassaGUI.mostraIncremento();
	}

	@Override
	public void settaArmateDisponibili(String numeroArmate) {
		informazioniGUI.setArmateDisponibili(numeroArmate);
	}

	@Override
	public void settaTurnista(String turnista) {
		informazioniGUI.setTurnista(turnista);
	}

}

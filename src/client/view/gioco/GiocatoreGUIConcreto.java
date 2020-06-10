package client.view.gioco;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneBandiera;
import client.controller.gioco.ControllerBottoneCarro;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneFaseAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;

public class GiocatoreGUIConcreto extends GiocatoreGUI {
	
	private int base,altezza;
	private ObiettivoGUI obiettivoGUI;
	private ArmateGUI armateGUI;
	private GuerraGUI guerraGUI;
	private PannelloAttaccoGUI pannelloAttaccoGUI;
	private PannelloSpostaGUI pannelloSpostaGUI;
	private InformazioniGUI informazioniGUI;

	public GiocatoreGUIConcreto(int base, int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new GridLayout(1,6));
		obiettivoGUI=new ObiettivoGUIConcreto();
		
		
		armateGUI = new ArmateGUIConcreto();
		guerraGUI = new GuerraGUIConcreto();
		pannelloAttaccoGUI = new PannelloAttaccoGUIConcreto();
		pannelloSpostaGUI = new PannelloSpostaGUIConcreto();
		informazioniGUI = new InformazioniGUIConcreto();
		add(obiettivoGUI);
		add(armateGUI);
		add(guerraGUI);
		add(pannelloAttaccoGUI);
		add(pannelloSpostaGUI);
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
		pannelloAttaccoGUI.mostraNazioneDA(nazione);
	}

	@Override
	public void settaNazioneAllaAttacco(String nazione) {
		pannelloAttaccoGUI.mostraNazioneA(nazione);
	}

	@Override
	public void scriviArmateAttacco(int armate) {
		pannelloAttaccoGUI.mostraArmate(armate);
	}

	@Override
	public void settaNazioneDallaSpostaPassa(String nazione) {
		pannelloSpostaGUI.mostraNazioneDA(nazione);
	}

	@Override
	public void settaNazioneAllaSpostaPassa(String nazione) {
		pannelloSpostaGUI.mostraNazioneA(nazione);
	}

	@Override
	public void scriviArmateSposta(int armate) {
		pannelloSpostaGUI.mostraArmate(armate);
	}

	
	

	@Override
	public void congelaArmate() {
		armateGUI.congela();
	}

	@Override
	public void scongelaArmate() {
		armateGUI.scongela();
	}

	
	
	
	
	
	
	
	@Override
	public void setControllerBottoneCarro(ControllerBottoneCarro controllerBottoneCarro) {
		armateGUI.setControllerBottoneCarro(controllerBottoneCarro);
	}

	@Override
	public void setControllerBottoneBandiera(ControllerBottoneBandiera controllerBottoneBandiera) {
		armateGUI.setControllerBottoneBandiera(controllerBottoneBandiera);
	}

	@Override
	public void setControllerBottoneFaseAttacco(ControllerBottoneFaseAttacco controllerBottoneFaseAttacco) {
		armateGUI.setControllerBottoneFaseAttacco(controllerBottoneFaseAttacco);
	}

	@Override
	public void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca) {
		pannelloAttaccoGUI.setControllerBottoneAttacca(controllerBottoneAttacca);
	}

	@Override
	public void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco) {
		pannelloAttaccoGUI.setControllerBottoneIncrementoArmateAttacco(controllerBottoneIncrementoArmateAttacco);
	}

	@Override
	public void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco) {
		pannelloAttaccoGUI.setControllerBottoneDecrementoArmateAttacco(controllerBottoneDecrementoArmateAttacco);
	}

	@Override
	public void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento) {
		pannelloAttaccoGUI.setControllerBottoneFaseSpostamento(controllerBottoneFaseSpostamento);
	}

	@Override
	public void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta) {
		pannelloSpostaGUI.setControllerBottoneSposta(controllerBottoneSposta);
	}

	@Override
	public void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta) {
		pannelloSpostaGUI.setControllerBottoneIncrementoArmateSposta(controllerBottoneIncrementoArmateSposta);
		
	}

	@Override
	public void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta) {
		pannelloSpostaGUI.setControllerBottoneDecrementoArmateSposta(controllerBottoneDecrementoArmateSposta);
		
	}

	@Override
	public void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa) {
		pannelloSpostaGUI.setControllerBottonePassa(controllerBottonePassa);
	}

	@Override
	public void scriviTurnista(String turnista) {
		informazioniGUI.scriviTurnista(turnista);
	}

	@Override
	public void scriviArmateDisponibili(String numeroArmate) {
		informazioniGUI.scriviArmateDisponibili(numeroArmate);
	}

	

}

package client.view.gioco;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

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
import client.controller.gioco.ControllerMappa;
import utilità.Musica;



public class GiocoGUIConcreto implements GiocoGUI {

	private JFrame finestraGioco;
	
	private MappaGUI mappaGUI;
	
	private ComunicazioneGUI comunicazioneGUI;
	
	private GiocatoreGUI giocatoreGUI;
	
	
	
	public GiocoGUIConcreto() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int baseMappa = (d.width/9)*7; int altezzaMappa = (d.height/9)*6;
		int baseComunicazione = (d.height/9)*2; int altezzaComunicazione=altezzaMappa;
		int baseGiocatore = d.width; int altezzaGiocatore = (d.height/9)*3;
		
		
		mappaGUI = new MappaGUIConcreto(baseMappa,altezzaMappa);
		comunicazioneGUI = new ComunicazioneGUIConcreto(baseComunicazione,altezzaComunicazione);
		giocatoreGUI = new GiocatoreGUIConcreto(baseGiocatore,altezzaGiocatore);
		
		finestraGioco = new JFrame();
		finestraGioco.setSize(d);
		finestraGioco.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Container contenitore = finestraGioco.getContentPane();
		
		
		
		GroupLayout gl = new GroupLayout(contenitore);
		contenitore.setLayout(gl);
		gl.setVerticalGroup(
				gl.createSequentialGroup().addGroup(
						gl.createParallelGroup().addComponent(mappaGUI).addComponent(comunicazioneGUI)
				).addComponent(giocatoreGUI)
		); 
		gl.setHorizontalGroup(
				gl.createParallelGroup().addGroup(
						gl.createSequentialGroup().addComponent(mappaGUI).addComponent(comunicazioneGUI)
				).addComponent(giocatoreGUI)
		);
		
		finestraGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		GiocoGUIConcreto ggc = new GiocoGUIConcreto();
		ggc.apriFinestra();
	}

	
	
	
	@Override
	public void apriFinestra() {
		finestraGioco.setVisible(true);
		Musica.suonaPanzers();
	}


	@Override
	public void settaObbiettivo(String testoObbiettivo) {
		giocatoreGUI.settaObbiettivo(testoObbiettivo);
	}


	@Override
	public void settaColoreArmate(Color colore) {
		giocatoreGUI.settaColoreArmate(colore);
	}


	@Override
	public void settaAttaccante(String attaccante) {
		giocatoreGUI.settaAttaccante(attaccante);
	}


	@Override
	public void settaRisultatoAttaccante(String risultatoAttaccante) {
		giocatoreGUI.settaRisultatoAttaccante(risultatoAttaccante);
	}


	@Override
	public void settaDifensore(String difensore) {
		giocatoreGUI.settaDifensore(difensore);
	}


	@Override
	public void settaRisultatoDifensore(String risultatoDifensore) {
		giocatoreGUI.settaRisultatoDifensore(risultatoDifensore);
	}


	@Override
	public void scriviNazioneAttaccoDA(String nazione) {
		giocatoreGUI.settaNazioneDallaAttacco(nazione);
	}


	@Override
	public void scriviNazioneAttaccoA(String nazione) {
		giocatoreGUI.settaNazioneAllaAttacco(nazione);
	}


	@Override
	public void scriviArmateAttacco(int armate) {
		giocatoreGUI.scriviArmateAttacco(armate);
	}



	@Override
	public void scriviNazioneSpostaDA(String nazione) {
		giocatoreGUI.settaNazioneDallaSpostaPassa(nazione);
	}


	@Override
	public void scriviNazioneSpostaA(String nazione) {
		giocatoreGUI.settaNazioneAllaSpostaPassa(nazione);
	}


	@Override
	public void scriviArmateSposta(int armate) {
		giocatoreGUI.scriviArmateSposta(armate);
	}


	

	@Override
	public void mostraMessaggio(String messaggio) {
		JOptionPane.showMessageDialog(null, messaggio);
	}


	@Override
	public void congelaArmate() {
		giocatoreGUI.congelaArmate();
	}


	@Override
	public void scongelaArmate() {
		giocatoreGUI.scongelaArmate();
	}



	@Override
	public int getLarghezzaMappa() {
		return mappaGUI.getWidth();
	}


	@Override
	public int getAltezzaMappa() {
		return mappaGUI.getHeight();
	}


	@Override
	public void setControllerBottoneCarro(ControllerBottoneCarro controllerBottoneCarro) {
		giocatoreGUI.setControllerBottoneCarro(controllerBottoneCarro);
	}


	@Override
	public void setControllerBottoneBandiera(ControllerBottoneBandiera controllerBottoneBandiera) {
		giocatoreGUI.setControllerBottoneBandiera(controllerBottoneBandiera);
		
	}


	@Override
	public void setControllerBottoneFaseAttacco(ControllerBottoneFaseAttacco controllerBottoneFaseAttacco) {
		giocatoreGUI.setControllerBottoneFaseAttacco(controllerBottoneFaseAttacco);
	}


	@Override
	public void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca) {
		giocatoreGUI.setControllerBottoneAttacca(controllerBottoneAttacca);
	}


	@Override
	public void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco) {
		giocatoreGUI.setControllerBottoneIncrementoArmateAttacco(controllerBottoneIncrementoArmateAttacco);
		
	}


	@Override
	public void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco) {
		giocatoreGUI.setControllerBottoneDecrementoArmateAttacco(controllerBottoneDecrementoArmateAttacco);
		
	}


	@Override
	public void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento) {
		giocatoreGUI.setControllerBottoneFaseSpostamento(controllerBottoneFaseSpostamento);
	}


	@Override
	public void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta) {
		giocatoreGUI.setControllerBottoneSposta(controllerBottoneSposta);
	}


	@Override
	public void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta) {
		giocatoreGUI.setControllerBottoneIncrementoArmateSposta(controllerBottoneIncrementoArmateSposta);
	}


	@Override
	public void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta) {
		giocatoreGUI.setControllerBottoneDecrementoArmateSposta(controllerBottoneDecrementoArmateSposta);
	}


	@Override
	public void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa) {
		giocatoreGUI.setControllerBottonePassa(controllerBottonePassa);
	}


	@Override
	public void setControllerMappa(ControllerMappa controllerMappa) {
		mappaGUI.setControllerMappa(controllerMappa);
	}


	@Override
	public void scriviTurnista(String turnista) {
		giocatoreGUI.scriviTurnista(turnista);
	}


	@Override
	public void scriviArmateDisponibili(String numeroArmate) {
		giocatoreGUI.scriviArmateDisponibili(numeroArmate);
	}


	@Override
	public void disegnaArmata(double percx, double percy, Color colore, boolean eCarro) {
		mappaGUI.disegnaArmata(percx, percy, colore, eCarro);
	}

	
}

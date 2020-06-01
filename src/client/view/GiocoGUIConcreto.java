package client.view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import client.view.gioco.ComunicazioneGUI;
import client.view.gioco.ComunicazioneGUIConcreto;
import client.view.gioco.GiocatoreGUI;
import client.view.gioco.GiocatoreGUIConcreto;
import client.view.gioco.MappaGUI;
import client.view.gioco.MappaGUIConcreto;
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
	public void settaNazioneDallaAttacco(String nazione) {
		giocatoreGUI.settaNazioneDallaAttacco(nazione);
	}


	@Override
	public void settaNazioneAllaAttacco(String nazione) {
		giocatoreGUI.settaNazioneAllaAttacco(nazione);
	}


	@Override
	public void incrementaCarriAttacco() {
		giocatoreGUI.incrementaCarriAttacco();
	}


	@Override
	public void disegnaCarro(Color coloreCarro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void disegnaBandiera(Color coloreBandiera) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void settaNazioneDallaSpostaPassa(String nazione) {
		giocatoreGUI.settaNazioneDallaSpostaPassa(nazione);
	}


	@Override
	public void settaNazioneAllaSpostaPassa(String nazione) {
		giocatoreGUI.settaNazioneAllaSpostaPassa(nazione);
	}


	@Override
	public void incrementaCarriSpostaPassa() {
		giocatoreGUI.incrementaCarriSpostaPassa();
	}


	@Override
	public void settaArmateDisponibili(String numeroArmate) {
		giocatoreGUI.settaArmateDisponibili(numeroArmate);
	}


	@Override
	public void settaTurnista(String turnista) {
		giocatoreGUI.settaTurnista(turnista);
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		
	}

	
}

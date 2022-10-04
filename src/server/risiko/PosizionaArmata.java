package server.risiko;

import java.awt.Color;
import java.rmi.RemoteException;

import server.Notificatore;

public class PosizionaArmata extends AzioneAstratta{
	
	private String nomePartecipante;
	
	private boolean eCarro;
	
	private String nazioneInteressata;
	
	private double percx,percy;
	
	private Color colore;

	public PosizionaArmata(String nomePartecipante, boolean eCarro, double percx, double percy, Color colore, String nazioneInteressata,Notificatore notificatore) {
		super(notificatore);
		this.nazioneInteressata=nazioneInteressata;
		this.nomePartecipante=nomePartecipante;
		this.eCarro=eCarro;
		this.percx=percx;
		this.percy=percy;
		this.colore=colore;
	}

	@Override
	public void esegui() {
		int indiceNazione = Risiko.nazioni.indexOf(nazioneInteressata);
		int armate = (eCarro == true) ? 1 : 10;
		Risiko.armateSulleNazioni[indiceNazione] += armate;
		int indiceGiocatore = Risiko.giocatori.indexOf(nomePartecipante);
		Risiko.armateGiocatoriSullaMappa[indiceGiocatore]+=armate;
		try {
			notificatore.notificaPosizionamentoArmata(nomePartecipante, percx, percy, colore, eCarro, Risiko.armateSulleNazioni,nazioneInteressata);
			if(eCarro)System.out.println(nomePartecipante + " mette un carro su "+nazioneInteressata);
			else System.out.println(nomePartecipante +" mette una bandiera su "+nazioneInteressata);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	
	
	
	
}

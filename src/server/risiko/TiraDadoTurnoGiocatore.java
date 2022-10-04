package server.risiko;

import java.rmi.RemoteException;
import java.util.Random;

import server.Notificatore;

public class TiraDadoTurnoGiocatore extends AzioneAstratta{
	
	private String nomePartecipante;

	public TiraDadoTurnoGiocatore(String nomePartecipante,Notificatore notificatore) {
		super(notificatore);
		this.nomePartecipante=nomePartecipante;
	}
	
	@Override
	public void esegui() {
		Random r = new Random();
		int faccia = r.nextInt(6)+1;
		int indice = indiceGiocatore(nomePartecipante);
		Risiko.dadiTurnoGiocatori.set(indice, faccia);
		try {
			notificatore.notificaRisultatoDadoTurno(nomePartecipante, faccia);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(nomePartecipante +" "+"ha tirato "+faccia);
	}
	
	
	private int indiceGiocatore(String giocatore) {
		int indice=-1;
		for(int i = 0; i < Risiko.giocatori.size(); i++) {
			if(Risiko.giocatori.get(i).equals(nomePartecipante)) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	

}

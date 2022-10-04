package server.risiko;

import java.awt.Color;
import java.rmi.RemoteException;

import server.Notificatore;

public class AssegnaColoreArmateGiocatore extends AzioneAstratta{
	
	private String nomePartecipante;
	private Color coloreArmate;
	
	public AssegnaColoreArmateGiocatore(String nomePartecipante, Color coloreArmate,Notificatore notificatore) {
		super(notificatore);
		this.nomePartecipante = nomePartecipante;
		this.coloreArmate=coloreArmate;
	}
	
	
	@Override
	public void esegui() {
		int colore = codiceColore(coloreArmate);
		if(Risiko.coloriScelti.get(colore)) return;
		int indice = indiceGiocatore(nomePartecipante);
		Risiko.coloriGiocatori.set(indice, coloreArmate);
		Risiko.coloriScelti.set(colore);
		try {
			notificatore.notificaSceltaColoreArmatePartecipante(nomePartecipante, coloreArmate);
		} catch (RemoteException e) {e.printStackTrace();}
		System.out.println(nomePartecipante+" ha scelto le armate "+coloreArmate);
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
	
	private int codiceColore(Color coloreArmate) {
		int colore = 0;
		if(coloreArmate.equals(Color.RED)) colore = 0;
		else if(coloreArmate.equals(Color.BLACK)) colore = 4;
		else if(coloreArmate.equals(Color.BLUE)) colore = 3;
		else if(coloreArmate.equals(Color.GREEN)) colore = 2;
		else if(coloreArmate.equals(Color.YELLOW)) colore = 1;
		else colore = 5;
		return colore;
	}

}

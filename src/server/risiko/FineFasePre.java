package server.risiko;

import java.rmi.RemoteException;
import java.util.BitSet;

import server.Notificatore;

public class FineFasePre extends AzioneAstratta{

	private String nomePartecipante;
	
	public FineFasePre(String nomePartecipante,Notificatore notificatore) {
		super(notificatore);
		this.nomePartecipante=nomePartecipante;
	}

	

	@Override
	public void esegui() {
		int indice = indiceGiocatore(nomePartecipante);
		Risiko.fineFasePre.set(indice);
		if(Risiko.fineFasePre.cardinality()==Risiko.numGiocatori) {
			try {
				Risiko.turnista=Risiko.giocatori.get(Risiko.indiceGiocatoriOrdinati[Risiko.numGiocatori-1]);
				notificatore.notificaFineFasePre();
			} catch (Exception e) {e.printStackTrace();}
		}
		PassaTurno p =new PassaTurno(notificatore);
		p.esegui();
		
	}
	
	
	
	private int indiceGiocatore(String nomePartecipante) {
		for(int i = 0; i < Risiko.numGiocatori; i++) {
			if(Risiko.giocatori.get(Risiko.indiceGiocatoriOrdinati[i]).equals(nomePartecipante)) return i;
		}
		return -1;
	}
}

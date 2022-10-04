package server.risiko;

import java.rmi.RemoteException;

import server.Notificatore;
import server.risiko.obbiettivi.Obbiettivo;
import server.risiko.obbiettivi.ObbiettivoFactory;

public class VerificaObbiettivo extends AzioneAstratta {
	
	private String nomePartecipante;

	public VerificaObbiettivo(String nomePartecipante,Notificatore notificatore) {
		super(notificatore);
		this.nomePartecipante=nomePartecipante;
	}

	@Override
	public void esegui() {
		int indiceGiocatore = Risiko.giocatori.indexOf(nomePartecipante);
		int indiceObbiettivo = Risiko.obbiettiviGiocatori.get(indiceGiocatore);
		String testo = Risiko.obbiettivi[indiceObbiettivo];
		Obbiettivo obbiettivo = ObbiettivoFactory.crea(testo);
		System.out.println(nomePartecipante +" sta verificando il suo obbiettivo:\n"+testo);
		if(obbiettivo.eSoddisfatto()) {
			try {
				System.out.println(nomePartecipante +" ha vinto");
				notificatore.notificaVittoria(nomePartecipante, testo);
			} catch (Exception e) {e.printStackTrace();}
		}
		else {
			try {
				System.out.println(nomePartecipante +" non ha ancora vinto");
				notificatore.notificaNonVittoria(nomePartecipante);
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	

}

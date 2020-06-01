package server;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import comune.Ascoltatore;
public class NotificatoreConcreto implements Notificatore{
	
	private HashMap<String,Ascoltatore> ascoltatoriPartecipanti;
	
	public NotificatoreConcreto() {
		ascoltatoriPartecipanti = new HashMap<String,Ascoltatore>();
	}


	@Override
	public void registraAscoltatoreClient(String nomePartecipante, Ascoltatore ascoltatore) throws RemoteException {
		ascoltatoriPartecipanti.put(nomePartecipante, ascoltatore);
		ascoltatore.ascoltaRegistrazionePartecipante(nomePartecipante);
	}


	@Override
	public void notificaSceltaColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaSceltaColoreArmate(nomePartecipante, coloreArmate);
		}
	}


	@Override
	public void notificaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException{
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaRisultatoDadoTurno(nomePartecipante, faccia);
		}
	}


	@Override
	public void notificaAvvioGioco(HashMap<String,Giocatore> giocatori,String turnista) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			Giocatore giocatore = giocatori.get(k);
			ascoltatoriPartecipanti.get(k).ascoltaAvvioGioco(
					giocatore.getObbiettivo().getTesto(),
					giocatore.getColoreArmate(),
					giocatore.getArmateDisponibili()+"",
					turnista
					);
		}
	}


	@Override
	public void notificaOrdinamentoTurni(String giocatoriOrdinati) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaTurni(giocatoriOrdinati);
		}
	}
	
	
	
}

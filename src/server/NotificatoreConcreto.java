package server;
import java.awt.Color;
import java.rmi.RemoteException;
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
	public void notificaAvvioGioco(HashMap<String,Object[]> giocatori,String turnista, String[] posseditori) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			Object[] infoGiocatore = giocatori.get(k);
			ascoltatoriPartecipanti.get(k).ascoltaAvvioGioco(
					(String)infoGiocatore[0],
					(Color)infoGiocatore[1],
					(String)infoGiocatore[2],
					turnista,
					posseditori
					);
		}
	}


	@Override
	public void notificaOrdinamentoTurni(String giocatoriOrdinati) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaTurni(giocatoriOrdinati);
		}
	}


	@Override
	public void notificaPosizionamentoArmata(String nomePartecipante, double percx, double percy, Color coloreArmate,boolean eCarro) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaPosizionamentoArmata(nomePartecipante, percx, percy, coloreArmate, eCarro);
		}
	}


	@Override
	public void notificaPassaggioTurnoPre(String turnista, int rinforzi) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaPassaggioTurnoPre(turnista, rinforzi);
		}
	}


	@Override
	public void notificaPassaggioTurno(String turnista, int rinforzi) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

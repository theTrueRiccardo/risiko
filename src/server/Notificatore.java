package server;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.HashMap;

import comune.Ascoltatore;
public interface Notificatore {
	
	void registraAscoltatoreClient(String nomePartecipante,Ascoltatore ascoltatore) throws RemoteException;
	
	void notificaSceltaColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void notificaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void notificaAvvioGioco(HashMap<String,Object[]> giocatori, String turnista, String[] posseditori) throws RemoteException;

	void notificaOrdinamentoTurni(String giocatoriOrdinati) throws RemoteException;
	
	void notificaPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro) throws RemoteException;
	
	void notificaPassaggioTurnoPre(String turnista, int rinforzi) throws RemoteException;
	
	void notificaPassaggioTurno(String turnista, int rinforzi) throws RemoteException;

}

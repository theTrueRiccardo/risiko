package server;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import comune.Ascoltatore;
public interface Notificatore {
	
	void registraAscoltatoreClient(String nomePartecipante,Ascoltatore ascoltatore) throws RemoteException;
	
	void notificaSceltaColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void notificaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void notificaAvvioGioco(HashMap<String,Giocatore> giocatori, String turnista) throws RemoteException;

	void notificaOrdinamentoTurni(String giocatoriOrdinati) throws RemoteException;

}

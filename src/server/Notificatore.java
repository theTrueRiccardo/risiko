package server;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.BitSet;
import java.util.HashMap;

import comune.Ascoltatore;
public interface Notificatore {
	
	void registraAscoltatoreClient(String nomePartecipante,Ascoltatore ascoltatore) throws RemoteException;
	
	void notificaSceltaColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void notificaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void notificaAvvioGioco(
			HashMap<String,String> obbiettiviGiocatori,
			HashMap<String,Color> coloriGiocatori, 
			HashMap<String,Integer> armateGiocatori,
			String turnista, 
			HashMap<String,BitSet> possedimentiGiocatori,
			int[] armateSulleNazioni) throws RemoteException;

	void notificaOrdinamentoTurni(String giocatoriOrdinati) throws RemoteException;
	
	void notificaPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro, int[] armateSulleNazioni, String nazione) throws RemoteException;
	
	void notificaPassaggioTurnoPre(String turnista) throws RemoteException;
	
	void notificaFineFasePre() throws RemoteException;
	
	void notificaPassaggioTurno(String turnista, int rinforzi,boolean fattaCombinazione,String combinazioneFatta,int codiceCombinazione) throws RemoteException;
	
	void notificaMessaggio(String messaggio) throws RemoteException;
	
	void notificaRisultatoBattaglia(String attaccante, String difensore, String risultatoAttaccante, String risultatoDifensore, int[] armateSulleNazioni, BitSet possedimentiAttaccante, BitSet possedimentiDifensore) throws RemoteException;
	
	void notificaConquistaNazione(String nazione,String conquistatore) throws RemoteException;

	void notificaCancellamentoArmate(int armate, String nazione) throws RemoteException;
	
	void notificaVittoria(String vincitore, String obbiettivo) throws RemoteException;
	
	void notificaNonVittoria(String nomePartecipante) throws RemoteException;
	
	void notificaCarta(String nomePartecipante, String carta) throws RemoteException;
	
	void notificaTelegramma(String telegramma,String destinatario) throws RemoteException;
}

package comune;
import java.awt.Color;
import java.rmi.*;

import client.view.gioco.GiocoGUI;
import client.view.pregioco.OpzioneGUI;
import client.view.pregioco.RegistrazioneGUI;
public interface Ascoltatore extends Remote {
	
	void ascoltaRegistrazionePartecipante(String nomePartecipante) throws RemoteException;

	void ascoltaSceltaColoreArmate(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void ascoltaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista, String[] posseditori) throws RemoteException;
	
	void ascoltaTurni(String giocatoriOrdinati) throws RemoteException;
	
	void ascoltaPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro) throws RemoteException;
	
	void ascoltaPassaggioTurnoPre(String turnista, int rinforzi) throws RemoteException;
	
	void ascoltaPassaggioTurno(String turnista, int rinforzi) throws RemoteException;

}

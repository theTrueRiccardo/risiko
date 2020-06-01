package comune;
import java.awt.Color;
import java.rmi.*;

import client.view.GiocoGUI;
import client.view.OpzioneGUI;
import client.view.RegistrazioneGUI;
public interface Ascoltatore extends Remote {
	
	void ascoltaRegistrazionePartecipante(String nomePartecipante) throws RemoteException;

	void ascoltaSceltaColoreArmate(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void ascoltaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista) throws RemoteException;
	
	void ascoltaTurni(String giocatoriOrdinati) throws RemoteException;

}

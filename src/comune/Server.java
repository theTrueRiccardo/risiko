package comune;
import java.awt.Color;
import java.rmi.*;
public interface Server extends Remote {
	
	void registraPartecipante(String nomePartecipante, String indirizzoIP) throws RemoteException;
	
	void registraColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void registraTiroDadoPartecipante(String nomePartecipante) throws RemoteException;
	
	void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy,Color coloreArmate, boolean eCarro) throws RemoteException;
	
	void registraPassaggioTurno() throws RemoteException;
	
	

}

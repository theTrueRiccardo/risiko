package comune;
import java.awt.Color;
import java.rmi.*;
public interface Server extends Remote {
	
	void registraPartecipante(String nomePartecipante, String indirizzoIP) throws RemoteException;
	
	void registraColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void registraTiroDadoPartecipante(String nomePartecipante) throws RemoteException;
	
	void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy,Color coloreArmate, boolean eCarro, String nazioneInteressata) throws RemoteException;
	
	void registraPassaggioTurno() throws RemoteException;
	
	void registraFineFasePre(String nomePartecipante) throws RemoteException;
	
	void inviaMessaggio(String messaggio) throws RemoteException;
	
	void registraAttacco(String nazioneDA, String nazioneA, int armateImpiegate) throws RemoteException;
	
	void registraSpostamento(String nazioneDA, String nazioneA, int armateImpiegate,boolean easy) throws RemoteException;
	
	void registraVerificaObbiettivo(String nomePartecipante) throws RemoteException;
	
	void inviaTelegramma(String telegramma,String destinatario) throws RemoteException;

}

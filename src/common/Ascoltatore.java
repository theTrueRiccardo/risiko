package comune;
import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.BitSet;
public interface Ascoltatore extends Remote {
	
	void ascoltaRegistrazionePartecipante(String nomePartecipante) throws RemoteException;

	void ascoltaSceltaColoreArmate(String nomePartecipante, Color coloreArmate) throws RemoteException;
	
	void ascoltaRisultatoDadoTurno(String nomePartecipante, int faccia) throws RemoteException;
	
	void ascoltaAvvioGioco(String testoObbiettivo, Color coloreArmate, String armateDisponibili, String turnista, BitSet possedimenti, int[] armateSulleNazioni) throws RemoteException;
	
	void ascoltaTurni(String giocatoriOrdinati) throws RemoteException;
	
	void ascoltaPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro, int[] armateSulleNazioni, String nazione) throws RemoteException;
	
	void ascoltaPassaggioTurnoPre(String turnista) throws RemoteException;
	
	void ascoltaPassaggioTurno(String turnista, int rinforzi, boolean fattaCombinazione,String combinazioneFatta, int codiceCombinazione) throws RemoteException;
	
	void ascoltaFineFasePre() throws RemoteException;
	
	void ascoltaMessaggio(String messaggio) throws RemoteException;

	void ascoltaRisultatoBattaglia(String attaccante, String difensore, String risultatoAttaccante,String risultatoDifensore, int[] armateSulleNazioni, BitSet possedimentiAttaccante,BitSet possedimentiDifensore) throws RemoteException;
	
	void ascoltaConquistaNazione(String nazione, String conquistatore) throws RemoteException;
	
	void ascoltaCancellamentoArmate(int armate, String nazione) throws RemoteException;
	
	void ascoltaVittoria(String vincitore, String obbiettivo) throws RemoteException;
	
	void ascoltaNonVittoria() throws RemoteException;
	
	void ascoltaCarta(String carta) throws RemoteException;
	
	void ascoltaTelegramma(String telegramma) throws RemoteException;
}

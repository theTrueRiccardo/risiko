package server;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.BitSet;
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
	public void notificaAvvioGioco(
			HashMap<String,String> obbiettiviGiocatori,
			HashMap<String,Color> coloriGiocatori, 
			HashMap<String,Integer> armateGiocatori,
			String turnista, 
			HashMap<String,BitSet> possedimentiGiocatori,int[] armateSulleNazioni) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaAvvioGioco(
					obbiettiviGiocatori.get(k),
					coloriGiocatori.get(k),
					armateGiocatori.get(k)+"",
					turnista,
					possedimentiGiocatori.get(k),
					armateSulleNazioni
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
	public void notificaPosizionamentoArmata(String nomePartecipante, double percx, double percy, Color coloreArmate,boolean eCarro, int[] armateSulleNazioni, String nazione) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaPosizionamentoArmata(nomePartecipante, percx, percy, coloreArmate, eCarro,armateSulleNazioni,nazione);
		}
	}


	@Override
	public void notificaPassaggioTurnoPre(String turnista) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaPassaggioTurnoPre(turnista);
		}
	}


	@Override
	public void notificaPassaggioTurno(String turnista, int rinforzi,boolean fattaCombinazione,String combinazioneFatta, int codiceCombinazione) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaPassaggioTurno(turnista,rinforzi,fattaCombinazione,combinazioneFatta,codiceCombinazione);
		}
	}


	@Override
	public void notificaFineFasePre() throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaFineFasePre();
		}
	}


	@Override
	public void notificaMessaggio(String messaggio) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaMessaggio(messaggio);
		}
	}


	


	@Override
	public void notificaConquistaNazione(String nazione, String conquistatore) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaConquistaNazione(nazione, conquistatore);
		}
	}


	@Override
	public void notificaRisultatoBattaglia(String attaccante, String difensore, String risultatoAttaccante,String risultatoDifensore, int[] armateSulleNazioni, BitSet possedimentiAttaccante,BitSet possedimentiDifensore) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaRisultatoBattaglia(attaccante, difensore, risultatoAttaccante, risultatoDifensore, armateSulleNazioni, possedimentiAttaccante, possedimentiDifensore);
		}
	}


	@Override
	public void notificaCancellamentoArmate(int armate, String nazione) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaCancellamentoArmate(armate, nazione);
		}
	}


	@Override
	public void notificaVittoria(String vincitore, String obbiettivo) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			ascoltatoriPartecipanti.get(k).ascoltaVittoria(vincitore, obbiettivo);
		}
	}


	@Override
	public void notificaNonVittoria(String nomePartecipante) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			if(k.equals(nomePartecipante))ascoltatoriPartecipanti.get(k).ascoltaNonVittoria();
		}
	}


	@Override
	public void notificaCarta(String nomePartecipante, String carta) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			if(k.equals(nomePartecipante))ascoltatoriPartecipanti.get(k).ascoltaCarta(carta);
		}
	}


	@Override
	public void notificaTelegramma(String telegramma, String destinatario) throws RemoteException {
		for(String k : ascoltatoriPartecipanti.keySet()) {
			if(k.equals(destinatario))ascoltatoriPartecipanti.get(k).ascoltaTelegramma(telegramma);
		}
	}
	
	
	
}

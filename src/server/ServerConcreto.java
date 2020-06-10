package server;
import java.awt.Color;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import comune.Ascoltatore;
import comune.Server;
import server.risiko.Risiko;



public class ServerConcreto extends UnicastRemoteObject implements Server{
	
	private Notificatore notificatore;

	
	public ServerConcreto() throws RemoteException {
		super();
		notificatore = new NotificatoreConcreto();
	}

	
	
	@Override
	public void registraPartecipante(String nomePartecipante, String indirizzoIP) throws RemoteException {
		System.out.println("Si è registrato " + nomePartecipante);
		Risiko.inserisciGiocatore(nomePartecipante);
		String URL = "rmi://"+indirizzoIP+":9001/ASCOLTATORE";
		Registry registroClient = LocateRegistry.getRegistry(indirizzoIP,9001);
		try {
			Ascoltatore ascoltatore = (Ascoltatore)registroClient.lookup(URL);
			System.out.println("fatta la lookup");
			notificatore.registraAscoltatoreClient(nomePartecipante, ascoltatore);
			System.out.println("Si è registrato " + nomePartecipante);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	

	@Override
	public void registraColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException {
		Risiko.registraColoreArmateGiocatore(nomePartecipante, coloreArmate);
		notificatore.notificaSceltaColoreArmatePartecipante(nomePartecipante, coloreArmate);
		System.out.println(nomePartecipante + " ha scelto le armate " + coloreArmate);
		if(Risiko.prontiTutti()) {
			avviaGioco();
		}
	}
	
	

	@Override
	public void registraTiroDadoPartecipante(String nomePartecipante) throws RemoteException {
		Risiko.registraTiroDadoTurnoGiocatore(nomePartecipante);
		int faccia = Risiko.getDadoTurnoPartecipante(nomePartecipante);
		notificatore.notificaRisultatoDadoTurno(nomePartecipante, faccia);
		System.out.println(nomePartecipante + " ha tirato " + faccia);
		if(Risiko.prontiTutti()) {
			avviaGioco();
		}
	}

	
	
	@Override
	public void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro) throws RemoteException {
		notificatore.notificaPosizionamentoArmata(nomePartecipante, percx, percy, coloreArmate, eCarro);
	}
	
	
	

	@Override
	public void registraPassaggioTurno() throws RemoteException {
		Risiko.gestisciPassaggioTurno();
		String turnista = Risiko.getTurnista();
		int rinforzi = Risiko.getRinforzi(turnista);
		if(Risiko.pre()) {
			notificatore.notificaPassaggioTurnoPre(turnista, rinforzi);
		}
		else {
			notificatore.notificaPassaggioTurno(turnista, rinforzi);
		}
		
	}

	
	private void avviaGioco() throws RemoteException{
		Risiko.ordinaGiocatori();
		String giocatoriOrdinati = Risiko.getGiocatori();
		notificatore.notificaOrdinamentoTurni(giocatoriOrdinati);
		Risiko.avviaGioco();
		HashMap<String,Object[]> infoGiocatori = Risiko.informazioniGiocatori(); //per ogni partecipante (String) tutte le sue informazioni (dentro Giocatore)
		String turnista = Risiko.getTurnista();
		String[] posseditori = Risiko.getPosseditori();
		notificatore.notificaAvvioGioco(infoGiocatori,turnista,posseditori);
	}
}

package server;
import java.awt.Color;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import comune.Ascoltatore;
import comune.Server;


public class ServerConcreto extends UnicastRemoteObject implements Server{
	
	private Notificatore notificatore;
	
	private Risiko risiko;
	
	public ServerConcreto() throws RemoteException {
		super();
		risiko = new RisikoConcreto();
		notificatore = new NotificatoreConcreto();
	}

	@Override
	public void registraPartecipante(String nomePartecipante, String indirizzoIP) throws RemoteException {
		System.out.println("Si è registrato " + nomePartecipante);
		risiko.inserisciGiocatore(nomePartecipante);
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
		risiko.assegnaColoreArmate(nomePartecipante,coloreArmate);
		notificatore.notificaSceltaColoreArmatePartecipante(nomePartecipante, coloreArmate);
		System.out.println(nomePartecipante + " ha scelto le armate " + coloreArmate);
		if(risiko.prontiTutti()) {
			String giocatoriOrdinati = risiko.getGiocatoriOrdinati();
			notificatore.notificaOrdinamentoTurni(giocatoriOrdinati);
			HashMap<String,Giocatore> giocatori = risiko.avviaGioco();
			String turnista = risiko.getTurnista();
			notificatore.notificaAvvioGioco(giocatori,turnista);
		}
	}

	@Override
	public void registraTiroDadoPartecipante(String nomePartecipante) throws RemoteException {
		int faccia = risiko.tiraDadoTurno(nomePartecipante);
		notificatore.notificaRisultatoDadoTurno(nomePartecipante, faccia);
		System.out.println(nomePartecipante + " ha tirato " + faccia);
		if(risiko.prontiTutti()) {
			String giocatoriOrdinati = risiko.getGiocatoriOrdinati();
			notificatore.notificaOrdinamentoTurni(giocatoriOrdinati);
			HashMap<String,Giocatore> giocatori = risiko.avviaGioco(); //per ogni partecipante (String) tutte le sue informazioni (dentro Giocatore)
			String turnista = risiko.getTurnista();
			notificatore.notificaAvvioGioco(giocatori,turnista);
		}
	}

	
	
}

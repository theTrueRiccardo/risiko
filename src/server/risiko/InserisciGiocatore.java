package server.risiko;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.BitSet;
import java.util.Random;

import comune.Ascoltatore;
import server.Notificatore;

public class InserisciGiocatore extends AzioneAstratta{
	
	private String nomePartecipante;
	
	private String indirizzoIP;
	
	
	
	public InserisciGiocatore(String nomePartecipante,String indirizzoIP, Notificatore notificatore) {
		super(notificatore);
		this.nomePartecipante = new String(nomePartecipante);
		this.indirizzoIP=indirizzoIP;
		this.notificatore = notificatore;
	}
	
	@Override
	public void esegui() {
		Risiko.giocatori.add(nomePartecipante);
		Risiko.nazioniGiocatori.add(new BitSet(42));
		Risiko.giocatoriUccisiGiocatori.add(new BitSet(Risiko.numGiocatori));
		Random r = new Random();
		int obbiettivo = r.nextInt(14);
		Risiko.obbiettiviGiocatori.add(obbiettivo);
		Risiko.obbiettiviScelti.set(obbiettivo);
		String URL = "rmi://"+indirizzoIP+":9001/ASCOLTATORE";
		Registry registroClient;
		try {
			registroClient = LocateRegistry.getRegistry(indirizzoIP,9001);
			Ascoltatore ascoltatore = (Ascoltatore)registroClient.lookup(URL);
			notificatore.registraAscoltatoreClient(nomePartecipante, ascoltatore);
			System.out.println("Si è registrato " + nomePartecipante);
		}catch(Exception e) {e.printStackTrace();}
	}
	
}

package server;
import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import comune.Server;
import server.risiko.AssegnaColoreArmateGiocatore;
import server.risiko.Attacco;
import server.risiko.AvviaGioco;
import server.risiko.FineFasePre;
import server.risiko.InserisciGiocatore;
import server.risiko.InviaMessaggio;
import server.risiko.InviaTelegramma;
import server.risiko.PassaTurno;
import server.risiko.PosizionaArmata;
import server.risiko.Risiko;
import server.risiko.Spostamento;
import server.risiko.TiraDadoTurnoGiocatore;
import server.risiko.VerificaObbiettivo;



public class ServerConcreto extends UnicastRemoteObject implements Server{
	
	private Notificatore notificatore;
	
	private Motore motore;
	
	private MotoreEasy motoreEasy;
	
	public ServerConcreto() throws RemoteException {
		super();
		Risiko.init();
		notificatore = new NotificatoreConcreto();
		motore = new MotoreConcreto();
		motoreEasy=new MotoreEasyConcreto();
		Thread threadMotore = new Thread(motore);
		Thread threadMotoreEasy=new Thread(motoreEasy);
		threadMotoreEasy.start();
		threadMotore.start();
	}

	
	
	@Override
	public void registraPartecipante(String nomePartecipante, String indirizzoIP) throws RemoteException {
		motore.schedula(new InserisciGiocatore(nomePartecipante, indirizzoIP, notificatore));
	}
	
	

	@Override
	public void registraColoreArmatePartecipante(String nomePartecipante, Color coloreArmate) throws RemoteException {
		motore.schedula(new AssegnaColoreArmateGiocatore(nomePartecipante, coloreArmate, notificatore));
		motore.schedula(new AvviaGioco(notificatore));
	}
	
	

	@Override
	public void registraTiroDadoPartecipante(String nomePartecipante) throws RemoteException {
		motore.schedula(new TiraDadoTurnoGiocatore(nomePartecipante, notificatore));
		motore.schedula(new AvviaGioco(notificatore));
	}

	
	
	@Override
	public void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy, Color coloreArmate, boolean eCarro,String nazioneInteressata) throws RemoteException {
		motore.schedula(new PosizionaArmata(nomePartecipante, eCarro, percx, percy, coloreArmate, nazioneInteressata, notificatore));
	}
	
	
	

	@Override
	public void registraPassaggioTurno() throws RemoteException {
		motore.schedula(new PassaTurno(notificatore));
	}



	@Override
	public void registraFineFasePre(String nomePartecipante) throws RemoteException {
		motore.schedula(new FineFasePre(nomePartecipante, notificatore));
	}



	@Override
	public void inviaMessaggio(String messaggio) throws RemoteException {
		motoreEasy.schedulaEasy(new InviaMessaggio(messaggio,notificatore));
	}



	@Override
	public void registraAttacco(String nazioneDA, String nazioneA, int armateImpiegate) throws RemoteException {
		motore.schedula(new Attacco(nazioneDA,nazioneA,armateImpiegate,notificatore));
	}



	@Override
	public void registraSpostamento(String nazioneDA, String nazioneA, int armateImpiegate,boolean easy) throws RemoteException {
		if(easy)motoreEasy.schedulaEasy(new Spostamento(nazioneDA,nazioneA,armateImpiegate,notificatore));
		else motore.schedula(new Spostamento(nazioneDA,nazioneA,armateImpiegate,notificatore));
	}



	@Override
	public void registraVerificaObbiettivo(String nomePartecipante) throws RemoteException {
		motore.schedula(new VerificaObbiettivo(nomePartecipante, notificatore));
	}



	@Override
	public void inviaTelegramma(String telegramma, String destinatario) throws RemoteException {
		motoreEasy.schedulaEasy(new InviaTelegramma(telegramma,destinatario,notificatore));
	}


}

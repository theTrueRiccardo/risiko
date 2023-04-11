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
	public void registerPlayer(String playerName, String addressIP) throws RemoteException {
		motore.schedula(new InserisciGiocatore(playerName, addressIP, notificatore));
	}
	
	

	@Override
	public void registerColorPlayer(String playerName, Color color) throws RemoteException {
		motore.schedula(new AssegnaColoreArmateGiocatore(playerName, color, notificatore));
		motore.schedula(new AvviaGioco(notificatore));
	}
	
	

	@Override
	public void registerDicePlayer(String playerName) throws RemoteException {
		motore.schedula(new TiraDadoTurnoGiocatore(playerName, notificatore));
		motore.schedula(new AvviaGioco(notificatore));
	}

	
	
	@Override
	public void registerLocationArmy(String playerName,double percx, double percy,Color color, boolean isCarro, String nation) throws RemoteException {
		motore.schedula(new PosizionaArmata(playerName, isCarro, percx, percy, color, nation, notificatore));
	}
	
	
	

	@Override
	public void registerPassTurn() throws RemoteException {
		motore.schedula(new PassaTurno(notificatore));
	}



	@Override
	public void registerEndPreparation(String playerName) throws RemoteException {
		motore.schedula(new FineFasePre(playerName, notificatore));
	}



	@Override
	public void sentMessage(String message) throws RemoteException {
		motoreEasy.schedulaEasy(new InviaMessaggio(message,notificatore));
	}



	@Override
	public void registerAttack(String nationFrom, String nationTo, int usedArmy) throws RemoteException {
		motore.schedula(new Attacco(nationFrom,nationTo,usedArmy,notificatore));
	}



	@Override
	public void registerMovement(String nationFrom, String nationTo, int usedArmy,boolean easy) throws RemoteException {
		if(easy)motoreEasy.schedulaEasy(new Spostamento(nationFrom,nationTo,usedArmy,notificatore));
		else motore.schedula(new Spostamento(nazioneDA,nazioneA,armateImpiegate,notificatore));
	}



	@Override
	public void registerCheckObjective(String playerName) throws RemoteException {
		motore.schedula(new VerificaObbiettivo(playerName, notificatore));
	}



	@Override
	public void sentTelegram(String telegram,String recipient) throws RemoteException {
		motoreEasy.schedulaEasy(new InviaTelegramma(telegram,recipient,notificatore));
	}


}

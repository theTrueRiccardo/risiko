package client.model;
import java.awt.Color;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.StringTokenizer;

import client.view.pregioco.*;
import comune.Ascoltatore;
import comune.Server;
import utilita.Console;
import utilita.ElementiDelGioco;
 
public class ClientModelConcreto implements ClientModel{
	
	private static Registry registroClient,registroServer;
	
	private Gioco gioco;
	
	private Ascoltatore ascoltatore;
	
	private Server server;
	
	private Console console;
	
	


	@Override
	public void registraPartecipante(String nomePartecipante, String ip, String ipServer){
		gioco.setNomePartecipante(nomePartecipante);
		System.setProperty("java.rmi.server.hostname", ip);
		String URLServer = "rmi://"+ipServer+":9000/SERVER";
		String URLClient = "rmi://"+ip+":9001/ASCOLTATORE";
		try{
			UnicastRemoteObject.exportObject(ascoltatore, 0);
			registroServer = LocateRegistry.getRegistry(ipServer,9000);
			registroClient = LocateRegistry.createRegistry(9001);
			registroClient.rebind(URLClient, ascoltatore);
			this.server = (Server)registroServer.lookup(URLServer);
			server.registraPartecipante(nomePartecipante, ip);
		}catch(Exception e) {
			console.scriviEccezione(e.toString());
			console.scriviEsecuzione();
		}
	}


	
	
	
	@Override
	public void registraColoreArmate(String nomePartecipante, Color coloreArmate) {
		gioco.setColoreArmate(coloreArmate);
		try {
			server.registraColoreArmatePartecipante(nomePartecipante, coloreArmate);
		}catch(Exception e) {
			console.scriviEccezione(e.toString());
		}
	}
	
	
	
	
	
	@Override
	public void registraTiroDadoTurno(String nomePartecipante) {
		try {
			server.registraTiroDadoPartecipante(nomePartecipante);
		}catch(Exception e) {
			console.scriviEccezione(e.toString());
		}
	}


	
	
	
	@Override
	public void setAscoltatore(Ascoltatore ascoltatore) {
		this.ascoltatore=ascoltatore;
	}


	
	
	

	@Override
	public void setConsole(Console console) {
		this.console=console;
	}





	
	
	@Override
	public void inviaMessaggio(String messaggio) {
		try {
			server.inviaMessaggio(messaggio);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}




	
	
	
	@Override
	public void registraAttacco(String nomeNazioneDA, String nomeNazioneA, int armateImpiegate) {
		try {
			server.registraAttacco(nomeNazioneDA,nomeNazioneA,armateImpiegate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	
	
	
	@Override
	public void registraPosizionamentoArmata(String nomePartecipante,double percx, double percy,Color coloreArmate, boolean eCarro,String nazioneInteressata) {
		try {
			server.registraPosizionamentoArmata(nomePartecipante, percx,percy,coloreArmate,eCarro,nazioneInteressata);
		} catch (RemoteException e) {
			console.scriviEccezione(e.toString());
		}
		
	}





	@Override
	public void registraSpostamento(String nomeNazioneDA, String nomeNazioneA,int armateImpiegate,boolean easy) {
		try {
			server.registraSpostamento(nomeNazioneDA, nomeNazioneA, armateImpiegate,easy);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}





	@Override
	public void registraPassaggioTurno() {
		try {
			server.registraPassaggioTurno();
		} catch (RemoteException e) {
			console.scriviEccezione(e.toString());
		}
	}





	@Override
	public void setGioco(Gioco gioco) {
		this.gioco=gioco;
	}





	@Override
	public void registraFineFasePre(String nomePartecipante) {
		try {
			server.registraFineFasePre(nomePartecipante);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}





	@Override
	public void verificaObbiettivo(String nomePartecipante) {
		try {
			server.registraVerificaObbiettivo(nomePartecipante);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}





	@Override
	public void inviaTelegramma(String telegramma,String destinatario) {
		try {
			server.inviaTelegramma(telegramma, destinatario);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	


	


	
	
	
}

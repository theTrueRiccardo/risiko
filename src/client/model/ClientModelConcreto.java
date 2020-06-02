package client.model;
import client.view.*;
import java.awt.Color;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import comune.Ascoltatore;
import comune.Server;
import utilità.Console;
 
public class ClientModelConcreto implements ClientModel{
	
	private static Registry registroClient,registroServer;
	
	private String nomePartecipante, indirizzoIP, ipServer;
	
	private Color coloreArmate;
	
	private Ascoltatore ascoltatore;
	
	private Server server;
	
	private Console console;
	
	


	@Override
	public void settaColoreArmate(Color colore) {
		this.coloreArmate = colore;
		try {
			server.registraColoreArmatePartecipante(nomePartecipante, colore);
		}catch(Exception e) {
			console.scriviEccezione(e.toString());
		}
	}


	@Override
	public void registraPartecipante(String nomePartecipante, String ip, String ipServer){
		this.nomePartecipante=nomePartecipante;
		this.indirizzoIP=ip;
		this.ipServer=ipServer;
		
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
	public void tiraDado() {
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
	public String getNomePartecipante() {
		return nomePartecipante;
	}


	@Override
	public void setConsole(Console console) {
		this.console=console;
	}
	
	
}

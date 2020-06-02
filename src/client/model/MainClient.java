package client.model;
import client.view.*;
import comune.Ascoltatore;
import utilità.Console;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import client.controller.*;

public class MainClient {

	public static void main(String[] args) throws Exception{
		
		ClientModel clientModel = new ClientModelConcreto();
		Console console = new Console();
		clientModel.setConsole(console);
		
		RegistrazioneGUI registrazioneGUI = new RegistrazioneGUIConcreto();
		ControllerBottoneRegistrazione controllerBottoneRegistrazione = new ControllerBottoneRegistrazione();
		registrazioneGUI.setControllerBottoneRegistrazione(controllerBottoneRegistrazione);
		controllerBottoneRegistrazione.setRegistrazioneGUI(registrazioneGUI);
		controllerBottoneRegistrazione.setClientModel(clientModel);
	
		
		OpzioneGUI opzioneGUI = new OpzioneGUIConcreto();
		Controller controllerBottoneColoreArmate = new ControllerBottoneColoreArmate();
		Controller controllerBottoneDado = new ControllerBottoneDadoTurno();
		opzioneGUI.setControllerBottoneColoreArmate(controllerBottoneColoreArmate);
		opzioneGUI.setControllerBottoneDado(controllerBottoneDado);
		
		
		
		
		GiocoGUI giocoGUI = new GiocoGUIConcreto();
		opzioneGUI.setGiocoGUI(giocoGUI);
			
	
		AscoltatoreConcreto ascoltatore = new AscoltatoreConcreto();
		ascoltatore.setClientModel(clientModel);
		ascoltatore.setRegistrazioneGUI(registrazioneGUI);
		ascoltatore.setOpzioneGUI(opzioneGUI);
		ascoltatore.setGiocoGUI(giocoGUI);
		
		
		clientModel.setAscoltatore(ascoltatore);
		
			
	}

}

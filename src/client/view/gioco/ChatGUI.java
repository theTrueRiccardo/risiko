package client.view.gioco;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneInvia;

public abstract class ChatGUI extends JPanel{

	public abstract void chat(String messaggio);
	
	public abstract String getMessaggioUtente();

	public abstract void setControllerBottoneInvia(ControllerBottoneInvia controllerBottoneInvia);
}

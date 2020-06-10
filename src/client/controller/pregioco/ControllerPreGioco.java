package client.controller.pregioco;
import java.awt.event.ActionListener;


import client.model.ClientModel;
import client.model.Gioco;

public abstract class ControllerPreGioco implements ActionListener{
	
	protected ClientModel clientModel;
	
	protected Gioco gioco;
	
	public ControllerPreGioco(ClientModel clientModel, Gioco gioco) {
		this.clientModel=clientModel;
		this.gioco=gioco;
	}
	

}

package client.controller;
import java.awt.event.ActionListener;
import client.model.ClientModel;

public abstract class Controller implements ActionListener{
	
	protected ClientModel clientModel;
	
	public void setClientModel(ClientModel clientModel) {
		this.clientModel=clientModel;
	}

}

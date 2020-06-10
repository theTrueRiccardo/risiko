package client.controller.pregioco;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import client.model.ClientModel;
import client.model.Gioco;

public class ControllerBottoneColoreArmate extends ControllerPreGioco{
	
	public ControllerBottoneColoreArmate(ClientModel clientModel, Gioco gioco) {
		super(clientModel,gioco);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bottoneColoreArmate = (JButton)e.getSource();
		Color coloreBottone = bottoneColoreArmate.getBackground();
		Color coloreArmate = coloreBottone;
		gioco.setColoreArmate(coloreArmate);
		clientModel.registraColoreArmate(gioco.getNomePartecipante(), coloreArmate);
	}
	
}

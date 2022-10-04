package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneObbiettivo implements ActionListener {
	
	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneObbiettivo(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.verificaObbiettivo();
	}
	
	

}

package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneInviaTelegramma implements ActionListener{
	
	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneInviaTelegramma(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.inviaTelegramma();
	}

}

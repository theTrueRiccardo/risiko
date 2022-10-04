package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneInvia implements ActionListener{
	
	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneInvia(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.chat();
	}

}

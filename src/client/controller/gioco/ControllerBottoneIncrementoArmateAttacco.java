package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerBottoneIncrementoArmateAttacco implements ActionListener{
	
	private ControllerApplicazione controllerApplicazione;

	public ControllerBottoneIncrementoArmateAttacco(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoIncrementoAttacco();
	}

}

package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneDecrementoArmateAttacco implements ActionListener{

	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneDecrementoArmateAttacco(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoDecrementoAttacco();
	}

}

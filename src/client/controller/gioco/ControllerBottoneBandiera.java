package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerBottoneBandiera implements ActionListener {

	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneBandiera(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccataBandiera();
	}

}

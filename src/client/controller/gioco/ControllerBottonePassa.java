package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottonePassa implements ActionListener {

	private ControllerApplicazione controllerApplicazione;
	
	
	public ControllerBottonePassa(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoPassa();
	}

}

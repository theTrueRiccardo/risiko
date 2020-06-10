package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControllerBottoneCarro implements ActionListener {
	
	private ControllerApplicazione controllerApplicazione;

	public ControllerBottoneCarro(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoCarro();
	}

}

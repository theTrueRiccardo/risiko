package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerBottoneIncrementoArmateSposta implements ActionListener{

	private ControllerApplicazione controllerApplicazione;
	
	
	public ControllerBottoneIncrementoArmateSposta(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoIncrementoSposta();		
	}

}

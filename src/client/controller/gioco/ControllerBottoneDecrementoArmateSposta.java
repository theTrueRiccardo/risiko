package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneDecrementoArmateSposta implements ActionListener{

	private ControllerApplicazione controllerApplicazione;
	
	
	public ControllerBottoneDecrementoArmateSposta(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoDecrementoSposta();
	}

}

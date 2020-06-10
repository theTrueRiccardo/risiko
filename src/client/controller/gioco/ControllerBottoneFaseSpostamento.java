package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneFaseSpostamento implements ActionListener {

	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneFaseSpostamento(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoBottoneFaseSposta();
	}

}

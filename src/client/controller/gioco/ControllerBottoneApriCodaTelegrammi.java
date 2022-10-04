package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneApriCodaTelegrammi implements ActionListener {

	private ControllerApplicazione controllerApplicazione;
	public ControllerBottoneApriCodaTelegrammi(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.apriCodaTelegrammi();
		
	}
}

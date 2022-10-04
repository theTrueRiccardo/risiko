package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneCodaTelegrammi implements ActionListener{

	private ControllerApplicazione controllerApplicazione;
	
	public ControllerBottoneCodaTelegrammi(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.apriCodaTelegrammi();
	}
}

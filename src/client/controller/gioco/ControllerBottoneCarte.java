package client.controller.gioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBottoneCarte implements ActionListener{
	
	ControllerApplicazione controllerApplicazione;
	public ControllerBottoneCarte(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione=controllerApplicazione;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		controllerApplicazione.cliccatoCarte();
	}
	
	

}

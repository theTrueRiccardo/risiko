package client.controller.pregioco;

import java.awt.event.ActionEvent;
import client.model.ClientModel;
import client.model.Gioco;
import utilita.Musica;

public class ControllerBottoneDadoTurno extends ControllerPreGioco{
	
	public ControllerBottoneDadoTurno(ClientModel clientModel, Gioco gioco) {
		super(clientModel,gioco);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Musica.suonaDado();
		clientModel.registraTiroDadoTurno(gioco.getNomePartecipante());
		
	}

}

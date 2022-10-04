package client.view.gioco;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneCarte;
import client.controller.gioco.ControllerBottoneObbiettivo;
import client.controller.gioco.ControllerBottoneTerritori;

public abstract class InformazioniGUI extends JPanel{
	
	public abstract void scriviTurnista(String turnista);
	
	public abstract void scriviArmateDisponibili(String numeroArmate);
	
	public abstract void setControllerBottoneTerritori(ControllerBottoneTerritori controllerBottoneTerritori);

	public abstract void setControllerBottoneObbiettivo(ControllerBottoneObbiettivo controllerBottoneObbiettivo);

	public abstract void setControllerBottoneCarte(ControllerBottoneCarte controllerBottoneCarte);
}

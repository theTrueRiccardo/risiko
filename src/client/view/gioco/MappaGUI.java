package client.view.gioco;

import java.awt.Color;

import javax.swing.JComponent;

import client.controller.gioco.ControllerMappa;



public abstract class MappaGUI extends JComponent {
	
	public void setControllerMappa(ControllerMappa controllerMappa) {
		addMouseListener(controllerMappa);
	}
	
	public abstract void disegnaArmata(double percx, double percy, Color colore, boolean eCarro);
	
	

}

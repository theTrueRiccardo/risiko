package client.view.gioco;
import java.awt.Color;

import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneBandiera;
import client.controller.gioco.ControllerBottoneCarro;
import client.controller.gioco.ControllerBottoneFaseAttacco;


public abstract class ArmateGUI extends JPanel {
	
	public abstract void coloraArmate(Color colore);
	
	public abstract void congela();
	
	public abstract void scongela();
	
	
	public abstract void setControllerBottoneCarro(ControllerBottoneCarro controllerBottoneCarro);
	
	public abstract void setControllerBottoneBandiera(ControllerBottoneBandiera controllerBottoneBandiera);
	
	public abstract void setControllerBottoneFaseAttacco(ControllerBottoneFaseAttacco controllerBottoneFaseAttacco);
	
	
	
	

}

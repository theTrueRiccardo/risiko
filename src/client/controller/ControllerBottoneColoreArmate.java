package client.controller;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class ControllerBottoneColoreArmate extends Controller{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bottoneSceltaColoreArmate = (JButton)e.getSource();
		Color coloreBottone = bottoneSceltaColoreArmate.getBackground();
		Color coloreArmate = coloreArmate(coloreBottone);
		clientModel.settaColoreArmate(coloreArmate);
	}
	
	
	private Color coloreArmate(Color coloreBottone) {
		if(coloreBottone==Color.RED) return Color.RED;
		if(coloreBottone==Color.BLACK) return Color.BLACK;
		if(coloreBottone==Color.BLUE) return Color.BLUE;
		if(coloreBottone==Color.GREEN) return Color.GREEN;
		if(coloreBottone==Color.YELLOW) return Color.YELLOW;
		return new Color(102,0,153); //colore blaga
	}

}

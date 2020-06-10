package client.controller.gioco;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;


public class ControllerMappa implements MouseListener{
	
	private ControllerApplicazione controllerApplicazione;
	
	
	
	public ControllerMappa(ControllerApplicazione controllerApplicazione) {
		this.controllerApplicazione = controllerApplicazione;
	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if(SwingUtilities.isLeftMouseButton(e)) {
			controllerApplicazione.cliccataMappaTastoSinistro(x, y);
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			controllerApplicazione.cliccataMappaTastoDestro(x, y);
		}
	}
	
	
	

	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}

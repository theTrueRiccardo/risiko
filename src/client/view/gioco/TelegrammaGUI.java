package client.view.gioco;
import javax.swing.JPanel;

import client.controller.gioco.ControllerBottoneApriCodaTelegrammi;
import client.controller.gioco.ControllerBottoneInviaTelegramma;
public abstract class TelegrammaGUI extends JPanel {

	public abstract void report(String report);
	
	public abstract void setControllerBottoneApriCodaTelegrammi(ControllerBottoneApriCodaTelegrammi controllerBottoneApriCodaTelegrammi);
	
	public abstract String getDestinatario();
	
	public abstract void setControllerBottoneInviaTelegramma(ControllerBottoneInviaTelegramma controllerBottoneInviaTelegramma);
}

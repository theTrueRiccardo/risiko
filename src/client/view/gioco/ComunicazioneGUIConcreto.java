package client.view.gioco;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import client.controller.gioco.ControllerBottoneApriCodaTelegrammi;
import client.controller.gioco.ControllerBottoneInvia;
import client.controller.gioco.ControllerBottoneInviaTelegramma;
import client.controller.gioco.ControllerBottoneTerritori;

public class ComunicazioneGUIConcreto extends ComunicazioneGUI {
	
	private int base,altezza;

	private ChatGUI chatGUI;
	
	private TelegrammaGUI telegrammaGUI;
	
	public ComunicazioneGUIConcreto(int base, int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		chatGUI=new ChatGUIConcreto();
		telegrammaGUI = new TelegrammaGUIConcreto();
		add(chatGUI);add(telegrammaGUI);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(base,altezza);
	}
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setLocation(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ComunicazioneGUI c = new ComunicazioneGUIConcreto(500,500);
		frame.add(c);
		frame.setVisible(true);
	}

	@Override
	public void report(String report) {
		telegrammaGUI.report(report);
	}

	@Override
	public void chat(String messaggio) {
		chatGUI.chat(messaggio);
	}

	@Override
	public String getMessaggioUtente() {
		return chatGUI.getMessaggioUtente();
	}

	@Override
	public void setControllerBottoneInvia(ControllerBottoneInvia controllerBottoneInvia) {
		chatGUI.setControllerBottoneInvia(controllerBottoneInvia);
	}

	@Override
	public String getDestinatario() {
		return telegrammaGUI.getDestinatario();
	}

	@Override
	public void setControllerBottoneInviaTelegramma(ControllerBottoneInviaTelegramma controllerBottoneInviaTelegramma) {
		telegrammaGUI.setControllerBottoneInviaTelegramma(controllerBottoneInviaTelegramma);
		
	}

	@Override
	public void setControllerBottoneApriCodaTelegrammi(ControllerBottoneApriCodaTelegrammi controllerBottoneApriCodaTelegrammi) {
		telegrammaGUI.setControllerBottoneApriCodaTelegrammi(controllerBottoneApriCodaTelegrammi);
	}


}

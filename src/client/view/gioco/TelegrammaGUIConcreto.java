package client.view.gioco;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import client.controller.gioco.ControllerBottoneApriCodaTelegrammi;
import client.controller.gioco.ControllerBottoneInviaTelegramma;
import client.controller.gioco.ControllerBottoneTerritori;
public class TelegrammaGUIConcreto extends TelegrammaGUI {

	private JLabel a;
	private JTextField inserire;
	private JButton bottoneInvia;
	private JButton codaMessaggi;
	
	private JTextArea commando;
	
	public TelegrammaGUIConcreto() {
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setLayout(new BorderLayout());
		
		JPanel pan0 = new JPanel();
		pan0.setLayout(new BoxLayout(pan0, BoxLayout.X_AXIS));
		//pan0.setLayout(new BorderLayout());
		a=new JLabel("A:");
		inserire = new JTextField();
		pan0.add(a);pan0.add(inserire);
		add(BorderLayout.NORTH,pan0);
		
		JPanel pan12 = new JPanel();
		pan12.setLayout(new BorderLayout());
		
		JPanel pan1 = new JPanel();
		bottoneInvia = new JButton("Invia telegramma confidenziale");
		pan1.add(bottoneInvia);
		pan12.add(BorderLayout.NORTH,pan1);
		
		JPanel pan2 = new JPanel();
		codaMessaggi = new JButton("Apri coda telegrammi");
		pan2.add(codaMessaggi);
		pan12.add(BorderLayout.SOUTH,pan2);
		commando = new JTextArea();
		commando.setEditable(false);
		commando.setBackground(new Color(128,128,0));
		commando.setForeground(new Color(204,204,0));
		JScrollPane j = new JScrollPane(commando);
		pan12.add(j);
		
		add(BorderLayout.CENTER,pan12);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setLocation(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TelegrammaGUI t = new TelegrammaGUIConcreto();
		frame.add(t);
		frame.setVisible(true);
		
		for(int i = 0; i < 100; i++) t.report("aru culu");
	}

	@Override
	public void report(String report) {
		commando.append(report+"\n");
	}

	

	@Override
	public String getDestinatario() {
		return inserire.getText();
	}

	@Override
	public void setControllerBottoneInviaTelegramma(ControllerBottoneInviaTelegramma controllerBottoneInviaTelegramma) {
		bottoneInvia.addActionListener(controllerBottoneInviaTelegramma);
	}

	@Override
	public void setControllerBottoneApriCodaTelegrammi(ControllerBottoneApriCodaTelegrammi controllerBottoneApriCodaTelegrammi) {
		codaMessaggi.addActionListener(controllerBottoneApriCodaTelegrammi);
	}

}

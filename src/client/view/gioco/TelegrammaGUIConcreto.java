package client.view.gioco;
import java.awt.BorderLayout;

import javax.swing.*;
public class TelegrammaGUIConcreto extends TelegrammaGUI {

	private JLabel a;
	private JTextField inserire;
	private JButton bottoneInvia;
	private JButton codaMessaggi;
	
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
	}

}

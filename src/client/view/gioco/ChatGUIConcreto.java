package client.view.gioco;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGUIConcreto extends ChatGUI{

	private JTextArea area;
	
	private JTextField inserire;
	
	private JButton bottoneInvia;
	
	private String messaggi="";
	
	public ChatGUIConcreto() {
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		JPanel pan0 = new JPanel();
		pan0.setLayout(new BorderLayout());
		area = new JTextArea();
		area.setEditable(false);
		JScrollPane pane = new JScrollPane(area);
		pan0.add(pane);
		add(BorderLayout.CENTER,pan0);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.X_AXIS));
		inserire = new JTextField();
		bottoneInvia = new JButton("Invia");
		pan1.add(inserire); pan1.add(bottoneInvia);
		add(BorderLayout.SOUTH,pan1);
		
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		String daMettere = "-"+messaggio+"\n";
		messaggi+=daMettere;
		area.setText(messaggi);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setLocation(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChatGUI cg = new ChatGUIConcreto();
		frame.add(cg);
		frame.setVisible(true);
		for(int i = 0; i < 100; i++) {
			cg.mostraMessaggio("aru culu");
		}
	}

}

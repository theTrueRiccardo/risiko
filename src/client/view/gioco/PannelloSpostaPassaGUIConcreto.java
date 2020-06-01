package client.view.gioco;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PannelloSpostaPassaGUIConcreto extends PannelloSpostaPassaGUI {
	
private int armate = 0;
	
	private JLabel etichettaDalla,etichettaAlla;
	
	private JTextField nomeDalla, nomeAlla, numeroArmate;
	
	private JButton bottoneIncremento,bottonePassa;
	

	public PannelloSpostaPassaGUIConcreto() {
		
		JPanel pannello0 = new JPanel();
		pannello0.setLayout(new BorderLayout());
		bottonePassa = new JButton("Sposta e passa");
		bottonePassa.setEnabled(false);
		pannello0.add(bottonePassa);
		
		JPanel pannello1 = new JPanel();
		pannello1.setLayout(new BoxLayout(pannello1, BoxLayout.X_AXIS));
		etichettaDalla = new JLabel("Dalla:");
		nomeDalla = new JTextField();
		nomeDalla.setEditable(false);
		pannello1.add(etichettaDalla);
		pannello1.add(nomeDalla);
		
		
		JPanel pannello2 = new JPanel();
		pannello2.setLayout(new BoxLayout(pannello2, BoxLayout.X_AXIS));
		etichettaAlla = new JLabel("Alla:");
		nomeAlla = new JTextField();
		nomeAlla.setEditable(false);
		pannello2.add(etichettaAlla);
		pannello2.add(nomeAlla);
		
		
		JPanel pannello3 = new JPanel();
		pannello3.setLayout(new BoxLayout(pannello3, BoxLayout.X_AXIS));
		numeroArmate= new JTextField();
		numeroArmate.setEditable(false);
		bottoneIncremento = new JButton("+");
		pannello3.add(numeroArmate);
		pannello3.add(bottoneIncremento);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(pannello0);
		add(pannello1);
		add(pannello2);
		add(pannello3);
		
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 500);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PannelloSpostaPassaGUI p = new PannelloSpostaPassaGUIConcreto();
		frame.add(p);
		frame.setVisible(true);
		p.mostraNazioneDalla("Siberia");
		p.mostraNazioneAlla("Mongolia");
	}

	@Override
	public void mostraNazioneDalla(String nomeNazione) {
		nomeDalla.setText(nomeNazione);
	}

	@Override
	public void mostraNazioneAlla(String nomeNazione) {
		nomeAlla.setText(nomeNazione);
	}

	@Override
	public void mostraIncremento() {
		numeroArmate.setText(armate+"");
	}

	@Override
	public void reset() {
		armate=0;
		numeroArmate.setText("");
		nomeAlla.setText("");
		nomeDalla.setText("");
	}

}

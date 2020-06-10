package client.view.gioco;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InformazioniGUIConcreto extends InformazioniGUI {

	private JButton bottoneTerritori,bottoneCarte;
	
	private JLabel etichettaArmate, etichettaTurno;
	
	private JTextField numeroArmate, turnista;
	
	
	
	
	
	public InformazioniGUIConcreto() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JPanel pan1 = new JPanel();
		bottoneTerritori = new JButton("territori");
		pan1.add(bottoneTerritori);
		add(pan1);
		
		JPanel pan2 = new JPanel();
		etichettaArmate = new JLabel("Armate disponibili:",JLabel.RIGHT);
		numeroArmate = new JTextField("        ");
		numeroArmate.setEditable(false);
		pan2.add(etichettaArmate);
		pan2.add(numeroArmate);
		add(pan2);
		
		JPanel pan3 = new JPanel();
		bottoneCarte = new JButton("Carte");
		pan3.add(bottoneCarte);
		add(pan3);
		
		JPanel pan4 = new JPanel();
		etichettaTurno=new JLabel("Turno:",JLabel.RIGHT);
		turnista = new JTextField("        ");
		turnista.setEditable(false);
		pan4.add(etichettaTurno);
		pan4.add(turnista);
		add(pan4);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLocation(500,500);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InformazioniGUI ig = new InformazioniGUIConcreto();
		f.add(ig);
		f.setVisible(true);
	}





	@Override
	public void scriviTurnista(String turnista) {
		this.turnista.setText(turnista);
	}





	@Override
	public void scriviArmateDisponibili(String numeroArmate) {
		this.numeroArmate.setText(numeroArmate);
	}

}

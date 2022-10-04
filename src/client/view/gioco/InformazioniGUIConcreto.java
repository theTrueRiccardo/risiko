package client.view.gioco;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.gioco.ControllerBottoneCarte;
import client.controller.gioco.ControllerBottoneObbiettivo;
import client.controller.gioco.ControllerBottoneTerritori;

public class InformazioniGUIConcreto extends InformazioniGUI {

	private JButton bottoneTerritori,bottoneCarte, bottoneObbiettivo;
	
	private JLabel etichettaArmate, etichettaTurno;
	
	private JTextField numeroArmate, turnista;
	
	
	
	
	
	public InformazioniGUIConcreto() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JPanel pan1 = new JPanel();
		bottoneTerritori = new JButton("territori");
		pan1.add(bottoneTerritori);
		add(pan1);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2,BoxLayout.X_AXIS));
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
		pan4.setLayout(new BoxLayout(pan4,BoxLayout.X_AXIS));
		etichettaTurno=new JLabel("Turno:",JLabel.RIGHT);
		turnista = new JTextField("        ");
		turnista.setEditable(false);
		pan4.add(etichettaTurno);
		pan4.add(turnista);
		add(pan4);
		
		bottoneObbiettivo=new JButton("Verifica obbiettivo");
		add(bottoneObbiettivo);
	}
	
	
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLocation(500,500);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InformazioniGUI ig = new InformazioniGUIConcreto();
		f.add(ig);
		f.setVisible(true);
		ig.scriviArmateDisponibili(100+"");
		ig.scriviTurnista("francoooo");
	}





	@Override
	public void scriviTurnista(String turnista) {
		this.turnista.setText(turnista);
	}





	@Override
	public void scriviArmateDisponibili(String numeroArmate) {
		this.numeroArmate.setText(numeroArmate);
	}





	@Override
	public void setControllerBottoneTerritori(ControllerBottoneTerritori controllerBottoneTerritori) {
		bottoneTerritori.addActionListener(controllerBottoneTerritori);
	}





	@Override
	public void setControllerBottoneObbiettivo(ControllerBottoneObbiettivo controllerBottoneObbiettivo) {
		bottoneObbiettivo.addActionListener(controllerBottoneObbiettivo);
	}





	@Override
	public void setControllerBottoneCarte(ControllerBottoneCarte controllerBottoneCarte) {
		bottoneCarte.addActionListener(controllerBottoneCarte);
	}

}

package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.gioco.ControllerBottoneDecrementoArmateSposta;
import client.controller.gioco.ControllerBottoneIncrementoArmateSposta;
import client.controller.gioco.ControllerBottonePassa;
import client.controller.gioco.ControllerBottoneSposta;

public class PannelloSpostaGUIConcreto extends PannelloSpostaGUI {
	
	private JLabel etichettaDA,etichettaA;
	
	private JTextField nomeDA, nomeA, numeroArmate;
	
	private JButton bottoneIncremento, bottoneDecremento, bottoneSposta,bottonePassa;
	

	public PannelloSpostaGUIConcreto() {
		
		JPanel pannello0 = new JPanel();
		pannello0.setLayout(new BorderLayout());
		bottoneSposta = new JButton("Sposta");
		pannello0.add(bottoneSposta);
		
		JPanel pannello1 = new JPanel();
		pannello1.setLayout(new BoxLayout(pannello1, BoxLayout.X_AXIS));
		etichettaDA = new JLabel("DA:");
		nomeDA = new JTextField();
		nomeDA.setEditable(false);
		pannello1.add(etichettaDA);
		pannello1.add(nomeDA);
		
		
		JPanel pannello2 = new JPanel();
		pannello2.setLayout(new BoxLayout(pannello2, BoxLayout.X_AXIS));
		etichettaA = new JLabel("A:");
		nomeA = new JTextField();
		nomeA.setEditable(false);
		pannello2.add(etichettaA);
		pannello2.add(nomeA);
		
		
		JPanel pannello3 = new JPanel();
		pannello3.setLayout(new BoxLayout(pannello3, BoxLayout.X_AXIS));
		numeroArmate = new JTextField();
		numeroArmate.setEditable(false);
		JPanel panIncrementoDecremento = new JPanel();
		panIncrementoDecremento.setLayout(new GridLayout(2,1));
		bottoneIncremento = new JButton("+");
		bottoneDecremento = new JButton("-");
		panIncrementoDecremento.add(bottoneIncremento);
		panIncrementoDecremento.add(bottoneDecremento);
		pannello3.add(numeroArmate);
		pannello3.add(panIncrementoDecremento);
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BorderLayout());
		bottonePassa = new JButton("Passa");
		pan4.add(bottonePassa);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(pannello0);
		add(pannello1);
		add(pannello2);
		add(pannello3);
		add(pan4);
		
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 500);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PannelloSpostaGUI p = new PannelloSpostaGUIConcreto();
		frame.add(p);
		frame.setVisible(true);
		p.mostraNazioneDA("Siberia");
		p.mostraNazioneA("Mongolia");
	}

	@Override
	public void mostraNazioneDA(String nomeNazione) {
		nomeDA.setText(nomeNazione);
	}

	@Override
	public void mostraNazioneA(String nomeNazione) {
		nomeA.setText(nomeNazione);
	}

	@Override
	public void mostraArmate(int armate) {
		numeroArmate.setText(armate+"");
	}

	@Override
	public void reset() {
		numeroArmate.setText("");
		nomeA.setText("");
		nomeDA.setText("");
	}

	@Override
	public void setControllerBottoneSposta(ControllerBottoneSposta controllerBottoneSposta) {
		bottoneSposta.addActionListener(controllerBottoneSposta);
	}

	@Override
	public void setControllerBottoneIncrementoArmateSposta(ControllerBottoneIncrementoArmateSposta controllerBottoneIncrementoArmateSposta) {
		bottoneIncremento.addActionListener(controllerBottoneIncrementoArmateSposta);
		
	}

	@Override
	public void setControllerBottoneDecrementoArmateSposta(ControllerBottoneDecrementoArmateSposta controllerBottoneDecrementoArmateSposta) {
		bottoneDecremento.addActionListener(controllerBottoneDecrementoArmateSposta);
		
	}

	@Override
	public void setControllerBottonePassa(ControllerBottonePassa controllerBottonePassa) {
		bottonePassa.addActionListener(controllerBottonePassa);
	}

}

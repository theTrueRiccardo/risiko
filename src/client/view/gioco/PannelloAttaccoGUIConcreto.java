package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.gioco.ControllerBottoneAttacca;
import client.controller.gioco.ControllerBottoneDecrementoArmateAttacco;
import client.controller.gioco.ControllerBottoneFaseSpostamento;
import client.controller.gioco.ControllerBottoneIncrementoArmateAttacco;

public class PannelloAttaccoGUIConcreto extends PannelloAttaccoGUI {
	
	private JLabel etichettaDA,etichettaA;
	
	private JTextField nomeDA, nomeA, numeroArmate;
	
	private JButton bottoneIncremento,bottoneDecremento,bottoneAttacca, bottoneFaseSpostamento;
	

	public PannelloAttaccoGUIConcreto() {
		
		JPanel pannello0 = new JPanel();
		pannello0.setLayout(new BorderLayout());
		bottoneAttacca = new JButton("Attacca");
		bottoneAttacca.setEnabled(false);
		pannello0.add(bottoneAttacca);
		
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
		
		
		JPanel panArmate = new JPanel();
		panArmate.setLayout(new BoxLayout(panArmate, BoxLayout.X_AXIS));
		JPanel panIncrementoDecremento = new JPanel();
		panIncrementoDecremento.setLayout(new GridLayout(2,1));
		
		numeroArmate=new JTextField();
		numeroArmate.setEditable(false);
		bottoneIncremento = new JButton("+");
		bottoneDecremento = new JButton("-");
		panIncrementoDecremento.add(bottoneIncremento);
		panIncrementoDecremento.add(bottoneDecremento);
		panArmate.add(numeroArmate);
		panArmate.add(panIncrementoDecremento);
		
		
		bottoneFaseSpostamento = new JButton("Vai alla fase spostamento");
		JPanel panBottoneFaseSpostamento = new JPanel();
		panBottoneFaseSpostamento.setLayout(new BorderLayout());
		panBottoneFaseSpostamento.add(bottoneFaseSpostamento);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(pannello0);
		add(pannello1);
		add(pannello2);
		add(panArmate);
		add(panBottoneFaseSpostamento);
		
		
	}

	@Override
	public void mostraNazioneDA(String nomeNazione) {
		nomeA.setText(nomeNazione);
	}

	@Override
	public void mostraNazioneA(String nomeNazione) {
		nomeDA.setText(nomeNazione);
	}

	@Override
	public void mostraArmate(int armate) {
		numeroArmate.setText(armate+"");
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 500);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PannelloAttaccoGUI p = new PannelloAttaccoGUIConcreto();
		frame.add(p);
		frame.setVisible(true);
		p.mostraNazioneDA("Siberia");
		p.mostraNazioneA("Mongolia");
	}

	@Override
	public void reset() {
		nomeDA.setText("");
		nomeA.setText("");
		numeroArmate.setText("");
	}

	@Override
	public void setControllerBottoneAttacca(ControllerBottoneAttacca controllerBottoneAttacca) {
		bottoneAttacca.addActionListener(controllerBottoneAttacca);
	}

	@Override
	public void setControllerBottoneIncrementoArmateAttacco(ControllerBottoneIncrementoArmateAttacco controllerBottoneIncrementoArmateAttacco) {
		bottoneIncremento.addActionListener(controllerBottoneIncrementoArmateAttacco);
	}

	@Override
	public void setControllerBottoneDecrementoArmateAttacco(ControllerBottoneDecrementoArmateAttacco controllerBottoneDecrementoArmateAttacco) {
		bottoneDecremento.addActionListener(controllerBottoneDecrementoArmateAttacco);
		
	}

	@Override
	public void setControllerBottoneFaseSpostamento(ControllerBottoneFaseSpostamento controllerBottoneFaseSpostamento) {
		bottoneFaseSpostamento.addActionListener(controllerBottoneFaseSpostamento);
	}

}

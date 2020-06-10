package client.view.pregioco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import client.controller.pregioco.ControllerPreGioco;

public class RegistrazioneGUIConcreto implements RegistrazioneGUI {
	
	private JFrame finestra;
	
	private Container contenitore;
	
	private JLabel etichettaNome;
	
	private JTextField campoNome;
	
	private JLabel etichettaIP;
	
	private JTextField campoIP;
	
	private JLabel etichettaIpServer;
	
	private JTextField campoIpServer;
	
	private JButton bottoneRegistrazione;
	
	
	
	
	public RegistrazioneGUIConcreto() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensioneFrame = t.getScreenSize();
		int larghezzaFrame = dimensioneFrame.width/3;
		int altezzaFrame = dimensioneFrame.height/5;
		int x = dimensioneFrame.width/2-dimensioneFrame.width/8;
		int y = dimensioneFrame.height/2-dimensioneFrame.height/8;
		
		finestra = new JFrame("Registrazione");
		finestra.setSize(larghezzaFrame, altezzaFrame);
		finestra.setLocation(x, y);
		//finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setResizable(false);
		
		contenitore = finestra.getContentPane();
		finestra.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
		
		etichettaNome = new JLabel("Inserisci il tuo nome da guerra:");
		finestra.add(etichettaNome);
		
		
		campoNome = new JTextField();
		finestra.add(campoNome);
		
		etichettaIP = new JLabel("Inserisci il tuo indirizzo IP:");
		finestra.add(etichettaIP);
		
		campoIP = new JTextField();
		finestra.add(campoIP);
		
		etichettaIpServer = new JLabel("Inserisci l'indirizzo IP di Riccardo:");
		finestra.add(etichettaIpServer);
		
		campoIpServer = new JTextField();
		finestra.add(campoIpServer);
		
		JPanel pannello = new JPanel();
		bottoneRegistrazione = new JButton("Registrati");
		pannello.add(bottoneRegistrazione);
		finestra.add(pannello);
		
		finestra.setVisible(true);
	}
	
	
	
	@Override
	public void setControllerBottoneRegistrazione(ControllerPreGioco controllerBottoneRegistrazione) {
		bottoneRegistrazione.addActionListener(controllerBottoneRegistrazione);
	}
	


	@Override
	public String getNome() {
		return campoNome.getText();
	}




	@Override
	public String getIndirizzoIP() {
		return campoIP.getText();
	}



	@Override
	public void chiudiFinestra() {
		finestra.setVisible(false);
	}




	@Override
	public void disabilitaBottoneRegistrazione() {
		bottoneRegistrazione.setEnabled(false);
	}



	@Override
	public void mostraMessaggio(String messaggio) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog(null, messaggio);
			}
		}
		);
			
		
	}


	@Override
	public String getIndirizzoIpServer() {
		return campoIpServer.getText();
	}


	public static void main(String[] args) {
		RegistrazioneGUI rg = new RegistrazioneGUIConcreto();
		rg.mostraMessaggio("ip errato");
	}
}

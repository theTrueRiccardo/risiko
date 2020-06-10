package client.view.pregioco;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;
import client.controller.pregioco.ControllerPreGioco;
import client.view.gioco.GiocoGUI;
import utilità.Musica;

public class OpzioneGUIConcreto implements OpzioneGUI {
	
	private JFrame opzioni;
	
	private Container contenitore;
	
	private JButton bottoneArmateRosse, bottoneArmateNere, bottoneArmateViola, bottoneArmateVerdi, bottoneArmateGialle, bottoneArmateBlu;
	
	private JTextArea aggiornamenti;
	
	private JLabel etichettaScegliColore;
	
	private String testoAggiornamenti="";
	
	private CanvasDado canvasDado;
	
	private JButton bottoneDado;
	
	private int contoAllaRovescia = 10;
	
	private Timer timer;
	
	private GiocoGUI giocoGUI;
	
	
	public OpzioneGUIConcreto() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensioneFrame = t.getScreenSize();
		int larghezzaFrame = dimensioneFrame.width/3;
		int altezzaFrame = dimensioneFrame.height/2;
		int x = dimensioneFrame.width/2-dimensioneFrame.width/8;
		int y = dimensioneFrame.height/2-dimensioneFrame.height/8;
		
		opzioni = new JFrame("Opzioni");
		
		opzioni.setSize(larghezzaFrame, altezzaFrame);
		opzioni.setLocation(x, y);
		
		opzioni.setResizable(false);
		
		contenitore = opzioni.getContentPane();
		opzioni.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
		
		
		JPanel pannelloAggiornamenti = new JPanel();
		pannelloAggiornamenti.setLayout(new BorderLayout());
		aggiornamenti = new JTextArea();
		aggiornamenti.setEditable(false);
		JScrollPane area = new JScrollPane(aggiornamenti);
		pannelloAggiornamenti.add(BorderLayout.CENTER,area);
		contenitore.add(pannelloAggiornamenti);
		
		etichettaScegliColore = new JLabel("Scegli il colore delle tue armate:");
		contenitore.add(etichettaScegliColore);
		
		JPanel pannelloBottoni = new JPanel();
		bottoneArmateBlu=new JButton("   ");
		bottoneArmateBlu.setBackground(Color.BLUE);
		bottoneArmateNere = new JButton("   ");
		bottoneArmateNere.setBackground(Color.BLACK);
		bottoneArmateGialle = new JButton("   ");
		bottoneArmateGialle.setBackground(Color.YELLOW);
		bottoneArmateRosse = new JButton("   ");
		bottoneArmateRosse.setBackground(Color.RED);
		bottoneArmateViola = new JButton("   ");
		bottoneArmateViola.setBackground(new Color(102,0,153)); //VIOLA
		bottoneArmateVerdi = new JButton("   ");
		bottoneArmateVerdi.setBackground(Color.GREEN);
		
		pannelloBottoni.add(bottoneArmateBlu);
		pannelloBottoni.add(bottoneArmateNere);
		pannelloBottoni.add(bottoneArmateGialle);
		pannelloBottoni.add(bottoneArmateRosse);
		pannelloBottoni.add(bottoneArmateViola);
		pannelloBottoni.add(bottoneArmateVerdi);
		opzioni.add(pannelloBottoni);
		
		JPanel pannello = new JPanel();
		bottoneDado = new JButton("Tira il dado!");
		pannello.add(bottoneDado);
		opzioni.add(pannello);
		
		
		int larghezzaCanvas = opzioni.getWidth();
		int altezzaCanvas = opzioni.getHeight()/7;
		canvasDado = new CanvasDado(larghezzaCanvas,altezzaCanvas);
		opzioni.add(canvasDado);
		
		
		opzioni.setVisible(false);
	}
	
	
	
	
	
	
	private class CanvasDado extends JPanel {
		private int larghezza, altezza, faccia;
		
		private Color coloreDado;
		
		public void setFaccia(int faccia) {
			this.faccia=faccia;
		}
		
		public void setColoreDado(Color coloreDado) {
			this.coloreDado=coloreDado;
		}
		public CanvasDado(int larghezza, int altezza) {
			this.larghezza=larghezza;
			this.altezza=altezza;
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(larghezza,altezza);
		}
		
		private void disegnaDado(Graphics2D disegnatore) {
			int x = larghezza/2;
			int y = altezza/2; 
			disegnatore.drawRect(x-36, y-36, 36, 36);
			disegnatore.setColor(Color.WHITE);
			disegnatore.fillRect(x-35, y-35, 36-1, 36-1);
			disegnatore.setColor(Color.BLUE);
			disegnatore.fillArc(x-32, y-32, 7, 7, 0, 360);
			disegnatore.fillArc(x-11, y-32, 7, 7, 0, 360);
			disegnatore.fillArc(x-11, y-12, 7, 7, 0, 360);
			disegnatore.fillArc(x-32, y-12, 7, 7, 0, 360);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D disegnatore = (Graphics2D)g;
			disegnaDado(disegnatore);
		}
	}

	






	@Override
	public void mostraAggiornamento(String aggiornamento) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String daAggiungere = "-" + aggiornamento +"\n";
				testoAggiornamenti += daAggiungere;
				aggiornamenti.setText(testoAggiornamenti);
			}
		});
	}








	@Override
	public void disabilitaBottone(String nomeBottone) {
		switch(nomeBottone){
		case "bottoneArmateRosse": bottoneArmateRosse.setEnabled(false); break;  
		case "bottoneArmateNere": bottoneArmateNere.setEnabled(false); break;
		case "bottoneArmateViola": bottoneArmateViola.setEnabled(false); break;
		case "bottoneArmateVerdi": bottoneArmateVerdi.setEnabled(false); break;
		case "bottoneArmateGialle": bottoneArmateGialle.setEnabled(false); break;
		case "bottoneArmateBlu": bottoneArmateBlu.setEnabled(false); break;
		case "bottoneDado": bottoneDado.setEnabled(false);break;
		}
	}







	@Override
	public void mostraRisultatoDadoTurno(int faccia) {
		canvasDado.setFaccia(faccia);
		canvasDado.repaint();
	}
	

	

	@Override
	public void setControllerBottoneDadoTurno(ControllerPreGioco controllerBottoneDadoTurno) {
		bottoneDado.addActionListener(controllerBottoneDadoTurno);
	}



	@Override
	public void apriFinestra() {
		opzioni.setVisible(true);
	}
	
	
	



	@Override
	public void chiudiFinestra() {
		opzioni.dispatchEvent(new WindowEvent(opzioni, WindowEvent.WINDOW_CLOSING));
	}
	
	
	

	@Override
	public void setControllerBottoneColoreArmate(ControllerPreGioco controllerBottoneColoreArmate) {
		bottoneArmateRosse.addActionListener(controllerBottoneColoreArmate);
		bottoneArmateNere.addActionListener(controllerBottoneColoreArmate);
		bottoneArmateBlu.addActionListener(controllerBottoneColoreArmate);
		bottoneArmateGialle.addActionListener(controllerBottoneColoreArmate);
		bottoneArmateVerdi.addActionListener(controllerBottoneColoreArmate);
		bottoneArmateViola.addActionListener(controllerBottoneColoreArmate);
	}
	

	public static void main(String[] args) {
		OpzioneGUIConcreto ogc = new OpzioneGUIConcreto();
		ogc.apriFinestra();
		//for(int i = 0; i < 100; i++)ogc.mostraAggiornamento("aru culu");
	}








	@Override
	public void disabilitaColori() {
		bottoneArmateRosse.setEnabled(false);
		bottoneArmateNere.setEnabled(false);
		bottoneArmateBlu.setEnabled(false);
		bottoneArmateGialle.setEnabled(false);
		bottoneArmateVerdi.setEnabled(false);
		bottoneArmateViola.setEnabled(false);
	}








	@Override
	public void mostraContoAllaRovescia() {
		Musica.suonaChitarra();
		timer = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAggiornamento("........."+contoAllaRovescia);
				contoAllaRovescia--;
				if(contoAllaRovescia==0) {
					timer.stop();
					chiudiFinestra();
					giocoGUI.apriFinestra();
				}
			}
		});
		timer.start();
	}








	@Override
	public void setGiocoGUI(GiocoGUI giocoGUI) {
		this.giocoGUI=giocoGUI;
	}









}

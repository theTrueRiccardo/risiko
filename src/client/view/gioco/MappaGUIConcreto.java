package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MappaGUIConcreto extends MappaGUI{

	private ArrayList<Color> colori = new ArrayList<Color>();
	private ArrayList<Double> listaPercx = new ArrayList<Double>();
	private ArrayList<Double> listaPercy = new ArrayList<Double>();
	private ArrayList<Boolean> eCarro = new ArrayList<Boolean>();
	
	
	private Image mappa;
	
	private int base,altezza;
	
	private final String URL = "mappa.png";
	
	
	
	
	public MappaGUIConcreto(int base,int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new BorderLayout());
		mappa=new ImageIcon(getClass().getClassLoader().getResource(URL)).getImage();
	}
	
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(mappa, 0, 0, this.getWidth(), this.getHeight(), 0, 0, mappa.getWidth(null), mappa.getHeight(null), null);
		disegnaArmate(g);
	}

	
	
	
	public Dimension getPreferredSize() {
		return new Dimension(base,altezza);
	}
	
	
	
	
	private void disegnaArmate(Graphics g) {
		int armate = colori.size();
		for(int i = 0; i < armate; i++) {
			Color colore = colori.get(i);
			double percx = listaPercx.get(i);
			double percy = listaPercy.get(i);
			double x = (this.getWidth()*percx)/100;
			double y = (this.getHeight()*percy)/100;
			g.setColor(colore);
			g.fillOval((int)x, (int)y, getWidth()/100, getHeight()/100);
			g.fillRect((int)x+getWidth()/500, (int)y-getHeight()/250, getWidth()/200, getHeight()/200);
			g.fillRect((int)x+getWidth()/500, (int)y-getHeight()/500, getWidth()/100, getHeight()/400);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setLocation(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MappaGUI m = new MappaGUIConcreto(500,500);
		frame.add(m);
		frame.setVisible(true);
		
	}





	@Override
	public void disegnaArmata(double percx, double percy, Color colore, boolean eCarro) {
		listaPercx.add(percx);
		listaPercy.add(percy);
		colori.add(colore);
		this.eCarro.add(eCarro);
		this.repaint();
	}


}

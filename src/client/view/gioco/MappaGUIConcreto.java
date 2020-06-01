package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

import utilità.Immagine;

public class MappaGUIConcreto extends MappaGUI{

	private Image mappa;
	
	private int base,altezza;
	
	private final String URL= "src//immagini//mappa.png";
	
	public MappaGUIConcreto(int base,int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new BorderLayout());
		mappa = new ImageIcon(URL).getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(mappa, 0, 0, this.getWidth(), this.getHeight(), 0, 0, mappa.getWidth(null), mappa.getHeight(null), null);
		//g.drawImage(mappa, 0,0,null);
	}

	public Dimension getPreferredSize() {
		return new Dimension(base,altezza);
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
}

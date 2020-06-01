package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArmateGUIConcreto extends ArmateGUI {
	
	private JButton bottoneCarro;
	
	private JButton bottoneBandiera;
	
	private Color colore;
	
	public ArmateGUIConcreto() {
		
		JPanel panCarro = new JPanel();
		panCarro.setLayout(new BorderLayout());
		JPanel panBandiera = new JPanel();
		panBandiera.setLayout(new BorderLayout());
		
		colore = Color.WHITE;
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		bottoneCarro = new JButton(new IconaCarro(colore));
		bottoneCarro.setBackground(Color.GRAY);
		panCarro.add(bottoneCarro);
		
		
		bottoneBandiera = new JButton(new IconaBandiera(colore));
		bottoneBandiera.setBackground(Color.GRAY);
		panBandiera.add(bottoneBandiera);
		
		
		add(panCarro);
		add(panBandiera);
	}
	
	
	
	private static class IconaCarro implements Icon {
		private Color colore;
		public IconaCarro(Color colore) {
			this.colore=colore;
		}
		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(colore);
			g.fillOval(x-c.getWidth()/2, y-c.getHeight()/12, c.getWidth(), c.getHeight()/2);
			g.fillRect(x-c.getWidth()/8, y-c.getHeight()/4, c.getWidth()/4, c.getHeight()/4);
			g.fillRect(x-c.getWidth()/8, y-c.getHeight()/4, c.getWidth(), c.getHeight()/8);
		}
		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	
	
	
	private static class IconaBandiera implements Icon {
		private Color colore;
		public IconaBandiera(Color colore) {
			this.colore=colore;
		}
		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(colore);
			g.fillOval(x-c.getWidth()/2, y+c.getHeight()/4, c.getWidth(), c.getHeight()/4);
			g.fillRect(x-c.getWidth()/16, y-c.getHeight()/3, c.getWidth()/8, c.getHeight()-c.getHeight()/10);
			int xp[] = {x,c.getWidth(),x};
			int yp[] = {y-c.getHeight()/3,y+c.getHeight()/30,y+2*c.getHeight()/30};
			Polygon p = new Polygon(xp,yp, 3);
			g.drawPolygon(p);
			g.fillPolygon(p);
		}
		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	}




	@Override
	public void coloraArmate(Color colore) {
		this.colore = colore;
		bottoneCarro.setIcon(new IconaCarro(colore));
		bottoneBandiera.setIcon(new IconaBandiera(colore));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		ArmateGUIConcreto a = new ArmateGUIConcreto();
		frame.add(BorderLayout.CENTER,a);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		a.coloraArmate(Color.RED);
	}

}

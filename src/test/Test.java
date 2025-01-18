package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import client.view.gioco.MappaGUIConcreto;
import utilita.GloboGrafico;
import utilita.GloboGraficoConcreto;
import utilita.Rettangolo;
import utilita.RettangoloConcreto;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GloboGrafico gg = new GloboGraficoConcreto();
		JFrame f = new JFrame();
		f.setSize(800,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mappa m = new Mappa(800,400);
		f.add(m);
		m.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				double x = e.getX(), y = e.getY();
				double percx = (x/m.getWidth())*100, percy= (y/m.getHeight())*100;
				JOptionPane.showMessageDialog(null, gg.nazioneAlPunto(percx, percy));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			

			
		});
		
		f.setVisible(true);
		
		
	}
	
	
	private static class Mappa extends MappaGUIConcreto{
		
		private ArrayList<Double> x = new ArrayList<Double>();
		private ArrayList<Double> y = new ArrayList<Double>();
		private ArrayList<Double> x2 = new ArrayList<Double>();
		private ArrayList<Double> y2 = new ArrayList<Double>();
		
		private ArrayList<Rettangolo> rettangoli = new ArrayList<Rettangolo>();

		public Mappa(int base, int altezza) {
			super(base, altezza);
			// TODO Auto-generated constructor stub
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.WHITE);
			
			for(int i = 0; i < x.size(); i++) {
				double px = (x.get(i)*this.getWidth())/100;
				double py = (y.get(i)*this.getHeight())/100;
				double px2 = (x2.get(i)*this.getWidth())/100;
				double py2 = (y2.get(i)*this.getHeight())/100;
				g.fillRect((int)px, (int)py,(int)px2-(int)px, (int)py2-(int)py);
				System.out.println(px + "  "+ py + "   "+ px2 + "   "+   py2);
			}
		}
		
		public void inserisci(double px, double py, double px2, double py2) {
			x.add(px);
			y.add(py);
			x2.add(px2);
			y2.add(py2);
			rettangoli.add(new RettangoloConcreto(px,py,px2,py2));
			System.out.println(px+"   "+py + "   " + px2 + "    " + py2);
		}
		
		
		public void stampaNazione() {
			String ris = "Venezuela ";
			for(Rettangolo r : rettangoli) {
				ris = ris +r.toString() + " | ";
			}
			System.out.println(ris);
		}
		
	}

}

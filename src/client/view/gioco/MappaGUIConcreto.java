package client.view.gioco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import utilita.GloboGrafico;
import utilita.GloboGraficoConcreto;
import utilita.NazioneGrafica;
import utilita.Rettangolo;

public class MappaGUIConcreto extends MappaGUI{

	private ArrayList<Color> colori = new ArrayList<Color>();
	private ArrayList<Double> listaPercx = new ArrayList<Double>();
	private ArrayList<Double> listaPercy = new ArrayList<Double>();
	private ArrayList<Boolean> eCarro = new ArrayList<Boolean>();
	private ArrayList<String> nazioni = new ArrayList<String>();
	
	
	//private Image mappa;
	
	private Image mappa;
	
	private int base,altezza;
	
	private final String URL = "mappa.png";
	
	
	
	
	public MappaGUIConcreto(int base,int altezza) {
		this.base=base; this.altezza=altezza;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(new BorderLayout());
		mappa=new ImageIcon(MappaGUIConcreto.class.getResource(URL)).getImage();
		
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
			if(eCarro.get(i)) {
				g.fillOval((int)x, (int)y, getWidth()/100, getHeight()/100);
				g.fillRect((int)x+getWidth()/500, (int)y-getHeight()/250, getWidth()/200, getHeight()/200);
				g.fillRect((int)x+getWidth()/500, (int)y-getHeight()/500, getWidth()/100, getHeight()/400);
			}
			else {
				g.fillOval((int)x,(int)y, getWidth()/100, getHeight()/100);
				g.fillRect((int)x+getWidth()/250, (int)y-getHeight()/80, getWidth()/400, getHeight()/50);
				int xp[] = {(int)x+getWidth()/250,(int)x+getWidth()/170+getWidth()/250,(int)x+getWidth()/250};
				int yp[] = {(int)y-getHeight()/80,(int)y-getHeight()/80+getHeight()/270,(int)y-getHeight()/80+2*getHeight()/270};
				Polygon p = new Polygon(xp,yp, 3);
				g.drawPolygon(p);
				g.fillPolygon(p);
			}
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
	public void disegnaArmata(double percx, double percy, Color colore, boolean eCarro,String nazione) {
		listaPercx.add(percx);
		listaPercy.add(percy);
		colori.add(colore);
		this.eCarro.add(eCarro);
		nazioni.add(nazione);
		this.repaint();
	}





	@Override
	public void cancellaArmate(int armate, String nazione) {
		int rimaste = armate;
		for(int i = 0; i < nazioni.size();i++) {
			if(rimaste==0) return;
			if(nazioni.get(i).equals(nazione)) {
				if(!eCarro.get(i)) {
					if(rimaste>=10) {
						nazioni.remove(i);
						colori.remove(i);
						listaPercx.remove(i);
						listaPercy.remove(i);
						eCarro.remove(i);
						rimaste-=10;
						i--;
					}
					else break;
				}
			}
		}
		if(rimaste==0) {
			this.repaint();
			return;
		}
		boolean ancoraBandiere=false;
		int indiceBandiera=0;
		Color coloreB=null;
		for(int i=0;i<nazioni.size();i++) {
			if(!eCarro.get(i)&&nazioni.get(i).equals(nazione)) {
				ancoraBandiere=true;
				indiceBandiera=i;
				coloreB=colori.get(i);
			}
		}
		if(ancoraBandiere) {
			nazioni.remove(indiceBandiera);
			colori.remove(indiceBandiera);
			listaPercx.remove(indiceBandiera);
			listaPercy.remove(indiceBandiera);
			int carri=10-rimaste;
			eCarro.remove(indiceBandiera);
			GloboGrafico gg=new GloboGraficoConcreto();
			NazioneGrafica ng=gg.prendiNazione(nazione);
			for(int i=0;i<carri;i++) {
				Rettangolo r=ng.prendiRettangoloACaso();
				double percx=r.getPercx1();
				double percy=r.getPercy1();
				disegnaArmata(percx,percy,coloreB,true,nazione);//ogni client le vedrà in modo diverso
			}			
		}
		else {
			for(int i = 0; i < nazioni.size();) {
				if(rimaste==0) {
					this.repaint();
					return;
				}
				if(eCarro.get(i) && nazioni.get(i).equals(nazione)) {
					nazioni.remove(i);
					colori.remove(i);
					listaPercx.remove(i);
					listaPercy.remove(i);
					eCarro.remove(i);
					rimaste--;
				}
				else i++;
			}
		}
		this.repaint();
	}





}

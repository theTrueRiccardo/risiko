package utilita;
import javax.swing.*;
import java.awt.*;
public class Immagine extends JComponent {
	
	private int base, altezza;
	
	private Image immagine;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(immagine,0,0,base,altezza,null);
	}
	
	public Immagine(String url, Dimension d) {
		super();
		immagine = new ImageIcon(url).getImage();
		base=d.width;
		altezza=d.height;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(base,altezza);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(base,altezza);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(base,altezza);
	}

}

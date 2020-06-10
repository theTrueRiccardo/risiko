package client.controller.gioco;

public class RettangoloConcreto implements Rettangolo {
	
	private double xi,yi,xf,yf;

	public RettangoloConcreto(double xi, double yi, double xf, double yf) {
		this.xi=xi; this.yi=yi; this.xf=xf; this.yf=yf;
	}
	
	
	@Override
	public boolean appartiene(double x, double y) {
		if(x > xi && y > yi && x < xf && y < yf) return true;
		return false;
	}
	
	
	public String toString() {
		return "Rettangolo: " + xi + " " + yi + " " + xf + " " + yf;
	}

}

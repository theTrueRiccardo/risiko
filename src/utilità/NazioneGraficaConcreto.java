package utilità;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class NazioneGraficaConcreto implements NazioneGrafica{
	
	private String nome;

	private ArrayList<Rettangolo> rettangoli = new ArrayList<Rettangolo>();
	
	public NazioneGraficaConcreto(String nome, ArrayList<Rettangolo> rettangoli) {
		this.rettangoli = new ArrayList<Rettangolo>(rettangoli);
		this.nome=nome;
	}
	
	
	public NazioneGraficaConcreto(String descrizione) {
		try {
			double xi=0,yi=0,xf=0,yf=0;
			int argomento = 0;
			StringTokenizer st = new StringTokenizer(descrizione, " ");
			nome = st.nextToken();
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				switch(argomento) {
				case 0 : {break;}
				case 1: {xi = Double.parseDouble(token); break;}
				case 2: {yi = Double.parseDouble(token); break;}
				case 3: {xf = Double.parseDouble(token); break;}
				case 4: {yf = Double.parseDouble(token); break;}
				case 5: {rettangoli.add(new RettangoloConcreto(xi,yi,xf,yf)); break;}
				}
				argomento = (argomento +1)%6;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Avvenuta eccezione " + e.toString());
			System.out.println("aru culu");
			System.exit(-1);
		}
	}

	@Override
	public boolean appartiene(double x, double y) {
		for(Rettangolo rettangolo: rettangoli) {
			if(rettangolo.appartiene(x, y)) return true;
		}
		return false;
	}

	@Override
	public String getNome() {
		return nome.toLowerCase();
	}
	
	
	public String toString() {
		String ris = "";
		for(Rettangolo r : rettangoli) {
			ris = ris +r.toString() + "\n";
		}
		return ris;
	}


	@Override
	public Rettangolo prendiRettangoloACaso() {
		Random r = new Random();
		int indice = r.nextInt(rettangoli.size());
		return rettangoli.get(indice);
	}

}

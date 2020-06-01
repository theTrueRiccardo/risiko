package utilità;
import java.util.*;
public class DadoSeiFacce implements Dado {
	
	private int faccia=6;

	public void lancia() {
		Random r = new Random();
		faccia = r.nextInt(6)+1;
	}
	
	public int faccia() {return faccia;}
}

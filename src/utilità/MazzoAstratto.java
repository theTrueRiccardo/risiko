package utilità;
import java.util.*;

import server.risiko.*;
public abstract class MazzoAstratto implements Mazzo {
	
	public boolean equals(Object o) {
		if(!(o instanceof Mazzo)) return false;
		if(o==this) return true;
		Mazzo mazzo = (Mazzo)o;
		if(grandezza()!=mazzo.grandezza()) return false;
		Iterator<Carta> i1 = iterator();
		Iterator<Carta> i2 = mazzo.iterator();
		while(i1.hasNext()) {
			Carta c1 = i1.next(), c2= i2.next();
			if(!c1.equals(c2)) return false;
		}
		return true;
	}
	
	public String toString() {
		int i = 1;
		String upper = "--------------------\n";
		String down = "\n";
		String ris="";
		for(Carta c : this) {
			ris+=upper+"#"+i + " "+c.toString()+down;
			i++;
		}
		ris+="--------------------";
		return ris;
	}
	
	
	public int hashCode() {
		final int MOLT=41;
		int h = 0;
		for(Carta c : this) h=h*MOLT+c.hashCode();
		return h;
	}
	

}

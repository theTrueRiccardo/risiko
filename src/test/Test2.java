package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<BitSet>a=new ArrayList<BitSet>();
		System.out.println(a.size());
		for(int i=0;i<3;i++)a.add(new BitSet(42));
		System.out.println(a.size());
		boolean[]b=new boolean[5];
		System.out.println(Arrays.toString(b));
	}

}

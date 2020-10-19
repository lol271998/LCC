import java.util.Scanner;
import java.io.*;
import java.util.*;

class Dna implements Comparable<Dna>{
	public char letra;
	public int occ;
	public int freq;

	Dna(char l, int o, int f){
		letra = l;
		occ = o;
		freq = f;
	}

	@Override
	public int compareTo(Dna d){
		if(occ<d.occ) return +1;
		if(occ>d.occ) return -1;
		else{
			if(freq<d.freq) return -1;
			if(freq>d.freq) return +1;
		}
		return 0;
	}
}

public class daa009{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		Dna d[] = new Dna [26];

		int n = line.length();
		char ch = 'A';
		for(int i = 0; i<26; i++){
			d[i] = new Dna(ch,0,-1);
			ch++;
		}

		for(int i = 0; i<n; i++){
			d[line.charAt(i)-'A'].occ++;
			//System.out.println(line.charAt(i)+": "+d[line.charAt(i)-'A'].occ);
			if(d[line.charAt(i)-'A'].freq == -1) d[line.charAt(i)-'A'].freq = i;
		}

		//System.out.println("");

		Arrays.sort(d);

		for(int i = 0; i<26; i++){
			if(d[i].occ>0) System.out.println(d[i].letra + " " + d[i].occ);
		}
	}
}
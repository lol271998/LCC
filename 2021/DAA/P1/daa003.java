import java.util.Scanner;
import java.lang.Math;

public class daa003{

	public static int matricula(String m){
		if((m.charAt(0)>='A' && m.charAt(0)<='Z') && (m.charAt(4)<='A' || m.charAt(4)>='Z')) return 1;
		if(m.charAt(4)>='A' && m.charAt(4)<='Z') return 2;
		if(m.charAt(2)>='A' && m.charAt(2)<='Z') return 3;
		else return 4;

	}

	//XXNNNN (1ª geração)(5290000)
	//NNNNXX (2ª geração)(5290000)
	//NNXXNN (3ª geração)(5290000)
	//XXNNXX (4ª geração)(27984100)

	public static int soma(String m, int g){
		int sum = 0;
		if(g == 1)
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		in.nextLine();
		for(int index = 0; index<t; index++){

			String s = in.nextLine();
			String m1 = "";
			String m2 = "";

			for(int i = 0; i<8; i++){
				if(s.charAt(i) != '-') m1 = m1 + s.charAt(i);
			}

			for(int i = 9; i<17; i++){
				if(s.charAt(i) != '-') m2 = m2 + s.charAt(i);
			}

			int g1 = matricula(m1);
			int g2 = matricula(m2);

			int sum1 = soma(m1,g1);
			int sum2 = soma(m2,g2);

			System.out.println(m1 + "->Geração: " + matricula(m1) + ", Soma: " + sum1);
			System.out.println(m2 + "->Geração: " + matricula(m2) + ", Soma: " + sum2);

			if(sum2-sum1>=0) System.out.println("Result: " + (sum2-sum1));
			if(sum2-sum1<0) System.out.println("Result: " + (sum1-sum2));

		}
	}
}
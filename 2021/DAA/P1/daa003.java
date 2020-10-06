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

		//1ª Geração
		if(g == 1){
			
			if(m.charAt(0)<'K') sum += (m.charAt(0) - 'A');
			else if(m.charAt(0)>'K' && m.charAt(0) < 'W') sum += (m.charAt(0) - 'A'-1);
			else if(m.charAt(0)>'W' && m.charAt(0) < 'Y') sum += (m.charAt(0) - 'A' - 2);			
			else sum += (m.charAt(0) - 'A' - 2);
			
			sum *= Math.pow(10,6);
			System.out.println("First Char sum: " + sum);

			if(m.charAt(1)<'K') sum *= (m.charAt(1) - 'A');
			else if(m.charAt(1)>'K' && m.charAt(1) < 'W') sum *= (m.charAt(1) - 'A'-1);
			else if(m.charAt(1)>'W' && m.charAt(1) < 'Y') sum *= (m.charAt(1) - 'A' - 2);
			else sum *= (m.charAt(0) - 'A' - 2);
			
			System.out.println(sum);
			
			for(int i = 2; i<6; i++){
				System.out.println(m.charAt(i));
				sum += ((m.charAt(i) - '0')*Math.pow(10,5-i));
			}
			
			System.out.println("SumWithNumbers: " + sum);;
		}

		//2ª Geração
		if(g == 2){

			sum = 5290000;

			if(m.charAt(4)<'K') sum += (m.charAt(4) - 'A');
			else if(m.charAt(4)>'K' && m.charAt(4) < 'W') sum += (m.charAt(4) - 'A' - 1);
			else if(m.charAt(4)>'W' && m.charAt(4) < 'Y') sum += (m.charAt(4) - 'A' - 2);
			else sum += (m.charAt(4) - 'A' - 3);
			
			System.out.println("sum: "+sum);

			if(m.charAt(4)<'K') sum += (m.charAt(4) - 'A' + 1);
			else if(m.charAt(4)>'K' && m.charAt(4) < 'W') sum += (m.charAt(4) - 'A' - 1);
			else if(m.charAt(4)>'W' && m.charAt(4) < 'Y') sum += (m.charAt(4) - 'A' - 2);
			else sum += (m.charAt(4) - 'A' - 3);

			sum *= Math.pow(10,4);
			System.out.println(sum);
			
			for(int i = 0; i<4; i++){
				System.out.println(m.charAt(i));
				sum += ((m.charAt(i) - '0')*Math.pow(10,4-i));
			}
			System.out.println("SumWithNumbers: " + sum);
		}

		//3ª Geração
		if(g == 3){

			sum = 5290000 + 5290000;

			if(m.charAt(2)<'K') sum += (m.charAt(2) - 'A');
			else if(m.charAt(2)>'K' && m.charAt(2) < 'W') sum += (m.charAt(2) - 'A' - 1);
			else if(m.charAt(2)>'W' && m.charAt(2) < 'Y') sum += (m.charAt(2) - 'A' - 2);
			else sum += (m.charAt(2) - 'A' - 3);
			
			System.out.println("sum: " + sum);

			if(m.charAt(3)<'K') sum += (m.charAt(3) - 'A');
			else if(m.charAt(3)>'K' && m.charAt(3) < 'W') sum += (m.charAt(3) - 'A' - 1);
			else if(m.charAt(3)>'W' && m.charAt(3) < 'Y') sum += (m.charAt(3) - 'A' - 2);
			else sum += (m.charAt(3) - 'A' - 3);

			sum *= Math.pow(10,4);
			System.out.println(sum);
			
			for(int i = 0; i<2; i++){
				System.out.println(m.charAt(i));
				sum += ((m.charAt(i) - '0')*Math.pow(10,3-i));
			}

			for(int i = 4; i<6; i++){
				System.out.println(m.charAt(i));
				sum += ((m.charAt(i) - '0')*Math.pow(10,5-i));
			}

			System.out.println("SumWithNumbers: " + sum);

		}
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
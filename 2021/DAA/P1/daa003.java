import java.util.Scanner;
import java.lang.Math;
import java.lang.Character;

public class daa003{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		in.nextLine();
		for(int i = 0; i<1; i++){

			String s = in.nextLine();

			/*

			int count = 6, flag = 0;
			int num1 = 0,num2 = 0;

			System.out.println("---------------Numero1----------------");

			for(int j = 0; j<8; j++){
				if(j == 2 || j == 5);
				else{
					//1ª Geração					
					if(j<2 && Character.isLetter(s.charAt(j))){
						if(s.charAt(j)>'K'){
							System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A'));
							num1 += (s.charAt(j) - 'A'- 1)*Math.pow(10,count);
						}
						else if(s.charAt(j)>'W'){
							System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' - 1));
							num1 += (s.charAt(j) - 'A'- 2)*Math.pow(10,count);	
						}
						else if(s.charAt(j)>'W'){
							System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' - 2));
							num1 += (s.charAt(j) - 'A'- 3)*Math.pow(10,count);
						}
						else{
							System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' + 1));
							num1 += (s.charAt(j) - 'A')*Math.pow(10,count);
						}
						flag++;
					}
					//2ª Geração
					else if((j>5 && j<7 && flag == 0) && Character.isLetter(s.charAt(j))){
						System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' + 46));
						num1 += (s.charAt(j) - 'A' + 46)*Math.pow(10,count);
						flag++;
					}
					//3ª Geração
					else if((j>2 && j<5) && Character.isLetter(s.charAt(j))){
						System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' + 93));
						num1 += (s.charAt(j) - 'A' + 93)*Math.pow(10,count);
						flag++;
					}
					//4ª Geração
					else if((j>5 && j<7) && Character.isLetter(s.charAt(j)) && flag == 1){
						System.out.println("Letra: " +s.charAt(j)+ " valor: "+(s.charAt(j) - 'A' + 103));
						num1 += (s.charAt(j) - 'A' + 103)*Math.pow(10,count);
					}
					//Numeros
					else{
						System.out.println("Numero: "+s.charAt(j) + " valor: "+((s.charAt(j)) - '0'));
						num1 += (((s.charAt(j)) - '0')*Math.pow(10,count));
					}
					count--;
					System.out.println("Numero1: "+num1);
				}
			}

			System.out.println("---------------Numero2----------------");
			count = 6;

			for(int k = 9; k<17; k++){
				if(k == 11 || k == 14);
				else{
					//1ª Geração					
					if(k<11 && Character.isLetter(s.charAt(k))){
						if(s.charAt(k)>'K'){
							System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' - 1));
							num1 += (s.charAt(k) - 'A'- 1)*Math.pow(10,count);
						}
						else if(s.charAt(k)>'W'){
							System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' - 2));
							num1 += (s.charAt(k) - 'A'- 2)*Math.pow(10,count);	
						}
						else if(s.charAt(k)>'W'){
							System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' - 3));
							num1 += (s.charAt(k) - 'A'- 3)*Math.pow(10,count);
						}
						else{
							System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' + 1));
							num1 += (s.charAt(k) - 'A')*Math.pow(10,count);
						}
						flag++;
					}
					//2ª Geração
					else if((k>11 && k<14) && Character.isLetter(s.charAt(k))){
						System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A'+ 46));
						num1 += (s.charAt(k) - 'A' + 46)*Math.pow(10,count);
						flag++;
					}
					//3ª Geração
					else if((k>14 && k<17) && Character.isLetter(s.charAt(k)) && flag == 0){
						System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' + 93));
						num1 += (s.charAt(k) - 'A' + 93)*Math.pow(10,count);
					}
					//4ª Geração
					else if((k>14 && k<17) && Character.isLetter(s.charAt(k)) && flag == 1){
						System.out.println("Letra: " +s.charAt(k)+ " valor: "+(s.charAt(k) - 'A' + 103));
						num1 += (s.charAt(k) - 'A' + 103)*Math.pow(10,count);
					}
					//Numeros
					else{
						System.out.println("Numero: "+s.charAt(k) + " valor: "+((s.charAt(k)) - '0'));
						num2 += (((s.charAt(k)) - '0')*Math.pow(10,count));
					}
					count--;
					System.out.println("Numero2: " + num2);
				}
			}

			System.out.println("Result: "+(num1-num2));
		
			*/
		}
	}
}
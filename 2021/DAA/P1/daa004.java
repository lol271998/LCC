import java.util.Scanner;

public class daa004{
	public static String add(String num){
		int incr = 0;
		String nnum1 = "";
		for(int i = num.length()-1; i>=0; i++){
			int c = num.charAt(i) - '0';
			if((c+1)==10){
				
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();
		System.out.println(n);

		for(int t = 0; t<n; t++){

			String line = in.nextLine();
			String numbers[] = line.split(" ",2);
			String num1 = numbers[0];
			int num2 = Integer.parseInt(numbers[1]);  
			int sum = 0;

			for(int i = 0; i< num1.length(); i++){
				sum+=num1.charAt(i)-'0';
			}

			String nnum1 = add(num1);
			
			while(sum<num2){
				add(num);
			}


			System.out.println(num1);
			System.out.println(num2);
			

		}
	}
}
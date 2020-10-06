import java.util.Scanner;

public class daa002{
	public static int sumf(int m){
		int n,sum = 0;
		while(m > 0){
        	n = m % 10;
        	sum = sum + n;
        	m = m / 10;
        }
        return sum;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int i = 0; i<t; i++){

			int n = in.nextInt();
			int numsum = in.nextInt();
			n++;
			while(sumf(n) != numsum){
				n++;
			}

			System.out.println(n);
		}
	}
}
import java.util.Scanner;

public class Teste{
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		System.out.println("Matrix m2");
		Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt(),5);
		m2.read(stdin);
		System.out.println(m2.transpose());	
	}
}
import java.util.Scanner;

public class TestMyStack{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		String linha;
		stdin.nextLine();
		for(int i = 0; i<n; i++){
			linha = stdin.nextLine();
			System.out.println(linha);
			System.out.println(ED195.balanced(linha));
		}
	}
}
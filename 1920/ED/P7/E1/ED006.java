import java.util.Scanner;

public class ED006{

	public static int conta(String str){
		int count = 0;
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) == ' ') count++;
		}
		return count+1;
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
	//Inicio do ciclo do jogo
		for(int i = 0; i<n; i++){

			String str = in.nextLine();
			int pal = conta(str);
	    //System.out.println(str+": "+pal);

			int nnome = in.nextInt();
			String[] nomes = in.nextLine().split(" ");

	    //Ciclo dos nomes
			CircularLinkedList<String> list = new CircularLinkedList<String>();
			for(int j = 1; j<=nnome;j++){
				list.addLast(nomes[j]);
			}
			while(list.size()!= 1){
				for(int j = 0; j<pal; j++){
					list.rotate();
				}
				list.removeLast();
			}
			
			if(list.getLast().equals("Carlos")){
				System.out.println("O Carlos nao se livrou");
			}
			else{
				System.out.println("O Carlos livrou-se (coitado do "+list.getLast()+"!)");
			}
		}
	}
}

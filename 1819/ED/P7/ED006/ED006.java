import java.util.Scanner;
public class ED006{
	public static int conta_frase(String linha){
		/*Contar quantas palavras há na frase*/
		String[] linhapalavras;
		int npalavras;
		linhapalavras = linha.split(" ");
		npalavras = linha.split(" ").length;
		//System.out.println("Frase: "+linha);
		return npalavras;

	}
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		stdin.nextLine();
		/*Casos a analisar*/
		for(int i = 0; i<n; i++){

			
			/*Cria a lista para os nomes*/
			CircularLinkedList<String> list = new CircularLinkedList<String>();
			String linha = stdin.nextLine();
			//System.out.println(linha);
			int npalavras = conta_frase(linha);
			
			
			/*Adicionar os nomes à lista criada*/
			String nomes = stdin.nextLine();
			String[] nArray;
			nArray = nomes.split(" ");
			int nnomes = Integer.parseInt(nArray[0]); //Quantos nomes há
			//System.out.println(nnomes);
			//System.out.println(nArray[0]);

			for(int j = 1; j<=nnomes; j++){
				list.addLast(nArray[j]);
				//System.out.println(nArray[j]);
			}
			//System.out.println(" ");
			
			
			/*Rodar a lista até se chegar às palavras*/
			while(list.size()>1){
				for(int j = 0; j<npalavras-1; j++){
					list.rotate();
					//System.out.println(list.getLast());
				}
				list.removeFirst();
			}

			
			/*Obter o ultimo nome e output*/
			String nome = list.getLast();
			//System.out.println(nome);
			if(nome.equals("Carlos")){
				System.out.println("O Carlos nao se livrou");
			}
			else{
				System.out.print("O Carlos livrou-se (coitado do " + nome);
				System.out.println("!)");
			}
			//System.out.println("");
		}
	}
}
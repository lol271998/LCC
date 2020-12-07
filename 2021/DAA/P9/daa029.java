import java.util.Scanner;
import java.util.LinkedList;

class daa029{

	static final int MAX = 27;
	//static int first,last;
	static int size = 0; // Numero de letras
	static boolean adj[][] = new boolean[MAX][MAX]; //Matrix de adjacências
	static boolean visited[] = new boolean[MAX]; //
	static LinkedList<Character> list = new LinkedList<Character>(); //Guardar os caracteres pela ordem desejada

	static void dfs(int v){
		visited[v] = true;
		int i;
		for(i = 0; i<MAX; i++){
			if(adj[v][i] && !visited[i]){
				visited[i] = true;
				dfs(i);

			}
		}
		list.addFirst((char)(v+64));
		size++;
		//System.out.println(size);
		//System.out.println((char)(v+64));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();
		String word[] = new String[n];
		
		word[0] = in.nextLine();

		for(int i = 1; i<n; i++){
			word[i] = in.nextLine();
			int l = Math.min(word[i-1].length(),word[i].length());
			for(int j = 0; j<l; j++){
				if(word[i-1].charAt(j) != word[i].charAt(j)){
					adj[(word[i-1]).charAt(j)-64][(word[i].charAt(j)-64)] = true;
					//System.out.println("adj["+((word[i-1]).charAt(j)-64)+"]["+(word[i].charAt(j)-64)+"]: "+adj[(word[i-1]).charAt(j)-64][(word[i].charAt(j)-64)]);
					break;
				}
			}	
		}

		for(int i = 1; i<MAX; i++){
			for(int j = 1; j<MAX; j++){
				if(adj[i][j] && !visited[i]){
					//System.out.println(i);
					dfs(i);
				}
			}
		}

		for(int i = 0; i<size; i++){
			System.out.print(list.removeFirst());
		}
		System.out.println();
	}
}	
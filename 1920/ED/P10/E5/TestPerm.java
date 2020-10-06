// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Geracao de permutacoes
// Ultima alteracao: 10/05/2019
// -----------------------------------------------------------

public class TestPerm {
    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
	boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
	int perm[] = new int[v.length];         // permutacao actual
	goPerm(0, v, used, perm); // chamar funcao recursiva
    }
    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
	if (cur == v.length) {  // Caso base: terminamos a permutacao
	    for (int i=0; i<v.length; i++) // Escrever a permutacao
		System.out.print(v[perm[i]] + " ");
	    System.out.println();
	} else { // Se nao terminamos, continuar a gerar
	    for (int i=0; i<v.length; i++) // Tentar todos os elementos
		if (!used[i]) { 
		    used[i] = true; perm[cur] = i;
		    goPerm(cur+1, v, used, perm);
		    used[i] = false;
		}
	}
    }   

   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      int[] v = new int[62];
      for(int i = 0; i<62; i++){
      	v[i] = i+1;
      }
      permutations(v);
   }
}

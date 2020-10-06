// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// 3 versoes para descobrir o maximo de um intervalo de um array:
// (uma iterativa e duas recursivas)
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

public class TestMax {

  	// Os 3 metodos seguintes recebem array v[] e duas posicoes start e end
   	// e devolvem o maior numero do array entre start e end (inclusive)

   	// --------------------------------------------------------

	// Versao iterativa   
    static int maxIt(int v[], int start, int end) {
        int maxSoFar = v[start];                // Maior ate agora
    	for (int i=start+1; i<=end; i++)        // Percorrer intervalo
    	   maxSoFar = Math.max(maxSoFar, v[i]); // Actualizar maximo
        return maxSoFar;
    }
   // --------------------------------------------------------

   // Versao recursiva 1: dividir em elemento inicial e resto da lista
    static int maxRec1(int v[], int start, int end) {
        if (start == end) return v[start];  // caso base (tamanho 1)
        int max = maxRec1(v, start+1, end); // chamada recursiva (resto da lista)
        return Math.max(v[start], max);     // combinar resultado
    }

   // --------------------------------------------------------

   // Versao recursiva 2: dividir em metade esquerda e metade direita
    static int maxRec2(int v[], int start, int end) {
        if (start == end) return v[start];    // caso base (tamanho 1)
        int middle = (start + end) / 2;       // ponto medio
        int max1 = maxRec2(v, start, middle); // recursao na metade esquerda
        int max2 = maxRec2(v, middle+1, end); // recursao na metade direita
        return Math.max(max1, max2);          // combinar resultado
    }

    static int sumRec1(int v[], int start, int end){
    	if(start == end) return v[start];
    	int sum = sumRec1(v,start+1,end);
    	return v[start]+sum;
    }

    static int sumRec2(int v[], int start, int end){
    	if(start == end) return v[start]; //Caso base (tamanho 1
    	int middle = (start + end) / 2; //ponto medio
    	int sum1 = sumRec2(v,start,middle);
    	int sum2 = sumRec2(v,middle+1,end);
    	return sum1+sum2;
    }

   	// --------------------------------------------------------

    public static void main(String[] args) {
		int v[] = {1,5,2,8,4,3,7,6}; // Inicializacao de array
		System.out.print("{"+v[0]);
		for(int i = 1; i<v.length-1; i++){
		    System.out.print(","+v[i]);
		}
		System.out.println(","+v[v.length-1]+"}");
		//Max iterativo
		System.out.println("maxIt: " + maxIt(v, 0, v.length-1));
		//Max dividir em elemento inicial e resto da lista
		System.out.println("maxRec1: " + maxRec1(v, 0, v.length-1));
		//Max dividir em metade esquerda e metade direita
		System.out.println("maxRec2: " + maxRec2(v, 0, v.length-1));
		//Sum dividir em elemento inicial e resto da lista
		System.out.println("SumRec1: "+ sumRec1(v,0,v.length-1));
		//Sum dividir em metade esquerda e metade direita
		System.out.println("SumRec1: "+ sumRec2(v,0,v.length-1));
	}
}

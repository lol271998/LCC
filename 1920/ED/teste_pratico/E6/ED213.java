

public class ED213{

	//Usar variaveis globais para guardar o melhor caminho e a melhor soma para comparar 
	static String best_path;
	static int best_sum;

	public static String maxSum(BTree<Integer> t){
		
		best_sum = -1;
		best_path = "";

		maxSum(t.getRoot(),"",0);
		return best_path;
	}
	private static void maxSum(BTNode<Integer> n, String path, int sum){
		//Caso seja nó nulo
		if(n == null) return;
		//Caso contrário fazer a soma do caminho
		sum += n.getValue();
		//Se for o final do caminho
		if(n.getLeft() == null && n.getRight() == null){
			if(sum>best_sum){
				best_path = path;
				sum = best_sum;
			}
		}
		else{
			maxSum(n.getLeft(),path + "E", sum);
			maxSum(n.getRight(),path + "D", sum);
		}

	}
}
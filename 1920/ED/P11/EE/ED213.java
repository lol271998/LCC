import java.util.Scanner;
import java.util.Arrays;

public class ED213{
	static int best;
	static String bestPath;

	public static String maxSum(BTree<Integer> t){
		best = 0;
		maxSum(t.getRoot(), 0, "");
		int[] a = new int[6];
		//System.out.println(bestPath);
		return bestPath;
	}

	private static void maxSum(BTNode<Integer> n, int sum, String str){
		if(n == null) return;
		sum += n.getValue();
		if(n.getLeft() == null && n.getRight() == null){
			//System.out.println(str+ " " +sum);
			if(best<=sum){		
				best = sum;
				bestPath = str;
			}
		}

		maxSum(n.getLeft(),sum,str+"E");
		maxSum(n.getRight(),sum,str+"D");
	}

	public static void main(String[] args) {
	 	Scanner in = new Scanner(System.in);

	 	int n = in.nextInt();
	 	for(int i = 0; i<n; i++){
	 		BTree<Integer> t = LibBTree.readIntTree(in);
	 		System.out.println(maxSum(t));
	 	}
	}
}
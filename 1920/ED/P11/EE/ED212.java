import java.util.Scanner;
import java.util.Arrays;

public class ED212{
	public static int[] sumLevels(BTree<Integer> t){
		int[] ans = new int[t.depth()+1];
		sumLevels(t.getRoot(),ans,0);
		return ans;
	}

	private static void sumLevels(BTNode<Integer> n,int[] ans, int d){
		if(n == null) return;
		ans[d] += n.getValue();
		sumLevels(n.getLeft(),ans,d+1);
		sumLevels(n.getRight(),ans,d+1);
	}

	public static void main(String[] args) {
	 	Scanner in = new Scanner(System.in);

	 	int n = in.nextInt();
	 	for(int i = 0; i<n; i++){
	 		BTree<Integer> t = LibBTree.readIntTree(in);
	 		System.out.println(Arrays.toString(sumLevels(t)));
	 	}
	}
}
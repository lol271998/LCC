public class ED212{

	public static int[] sumLevels(BTree<Integer> t){
		int[] sum = new int[t.depth()+1];
		int i;
		i = 0;
		while(i<t.depth()+1){
			sum[i] = sumLevels(t.getRoot(),0,i);
			i++;
		}
		return sum;
	}
	private static int sumLevels(BTNode<Integer> n, int nc, int k){
		if(n == null || nc>k) return 0;
		if(nc == k) return n.getValue();
		return sumLevels(n.getLeft(),nc+1,k) + sumLevels(n.getRight(),nc+1,k);
	}
}
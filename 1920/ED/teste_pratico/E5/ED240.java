public class ED240{
	public int min(BTree<Integer> t){
		return min(t.getRoot(),0);
	}
	private int min(BTNode<Integer> n,int min){
		if(n == null) return min;
		if(n.getValue()<=min) min = n.getValue();
		return min(n.getLeft()) + min(n.getRigth());
	}
}
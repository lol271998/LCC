public class ED211 {

	public static int countEven(BTree <Integer> t){
		return countEven(t.getRoot());
	}

	private static int countEven(BTNode <Integer> n){
		if (n == null) return 0;
		int count = 0;
		if(n.getValue() % 2 == 0) count++;
		return count + countEven(n.getLeft()) + countEven(n.getRight());
	}
}
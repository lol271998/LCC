public class ED194{
	public static void reverse(MyStack<Integer> s, int n){
		int temp[] = new int [s.size()];
		int i;
		//System.out.println("Primeiro FOR n:" + n);
		for(i = 0; i<=n-1; i++){
			temp[i] = (s.pop());
			/*System.out.println("temp[i]: ");
			System.out.println(temp[i]);
			System.out.println("s");
			System.out.println(s);*/
		}
		/*System.out.println("");
		System.out.println("Ultimo FOR temp[i] ");
		System.out.println(temp[i]);*/		for(int j = 0; j<i; j++){
			s.push(temp[j]);
			/*System.out.println("temp[j]: ");
			System.out.println("j: "+j);
			System.out.println(temp[j]);
			System.out.println("s: ");
			System.out.println(s);*/
		}
	}
}

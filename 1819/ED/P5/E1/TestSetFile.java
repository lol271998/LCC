import java.util.Scanner;

class TestSetFile{

	public static void main(String [] args){
		IntSet s = new MyIntSet();
		Scanner sc = new Scanner(System.in);
		int size = 0;

		while(sc.hasNextInt()){
			int n = sc.nextInt();
			System.out.println(s.add(n));
			size++;
			s.setSize(size);
			System.out.println(size);
		}
	}
}
import java.util.Scanner;

public class ED241{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int flag = in.nextInt();
		if(flag == 1){
			int n = in.nextInt();
			BSTree<String> movies = new BSTree<>();
			for(int i = 0; i<n; i++){
				String name = in.next();
				movies.insert(name);
				in.nextLine();
			}
			System.out.println(movies.numberNodes());
			return;
		}
		if(flag == 2 || flag == 3){
			BSTMap<String,Integer> map_count = new BSTMap<>();
			BSTMap<String,Integer> map_ratio = new BSTMap<>();
			int n = in.nextInt();
			int max = 0;
			String maxs = new String();
			for(int i = 0; i<n; i++){
				String name = in.next();
				String nameproblem = in.next();
				String result = in.next();
				//System.out.println("name: "+name);
				//System.out.println("nameproblem: "+nameproblem);
				//System.out.println("result: "+result);

				if(map_count.get(nameproblem) == null){
					map_count.put(nameproblem,1);
					if(result.equals("Accepted")){
						map_ratio.put(nameproblem,1);
					//System.out.println(nameproblem);
					}
				}
				else{
					int val = map_count.get(nameproblem);
					if(map_ratio.get(nameproblem) != null){
						int val2 = map_ratio.get(nameproblem);
						if(result.equals("Accepted")){
							map_ratio.put(nameproblem,val2++);
						}
					}
					if(val>max){
						max = val;
						maxs = nameproblem;
					}
					map_count.put(nameproblem,val++);
				}
			}
			if(flag == 2) System.out.println(maxs+" "+max);
			if (flag == 3){
				for (String k : map_ratio.keys()){
					if(map_ratio.get(k)/map_count.get(k)>=0.5)
						System.out.println(map_ratio.get(k));
					System.out.println(k);
				}
			}
		}
	}
}
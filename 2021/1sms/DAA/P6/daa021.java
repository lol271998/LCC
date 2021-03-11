import java.util.Scanner;
import java.util.TreeSet;
import java.util.TreeMap;

class daa021{
	public static void main(String[] args) {

		FastScanner in = new FastScanner(System.in);

		int a = in.nextInt();
		int r = in.nextInt();

		TreeMap<Integer,Integer> bak = new TreeMap<Integer,Integer>();
		TreeSet<Integer> s = new TreeSet<Integer>();

		for(int i = 0; i<a+r;i++){
			String line = in.nextLine();
			if(line.indexOf(' ')!=-1){
				String[] lA = line.split(" ",2);
				int e = Integer.parseInt(lA[1]);

				if(bak.get(e) == null){
					s.add(e);
					bak.put(e,0);
				}

				else{
					int k = bak.get(e);
					bak.put(e,++k);
				}

				//System.out.println("e: "+e+" k: "+bak.get(e));
			}

			else{
				if(line.equals("MIN")){

					System.out.println(s.first());
					
					if(bak.get(s.first()) == 0){
						bak.remove(s.first());
						s.remove(s.first());
					}
					else{
						int k = bak.get(s.first());
						bak.put(s.first(),--k);
					}
				}
				else{

					System.out.println(s.last());
					
					if(bak.get(s.last()) == 0){
						bak.remove(s.last());
						s.remove(s.last());

					}
					else{
						int k = bak.get(s.last());
						bak.put(s.last(),--k);
					}
				}
			}
		}
	}
}
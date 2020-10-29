import java.util.Scanner;

class daa011{

	public static int bsearch(int[] d,int low, int high, int max){
		while(low<high){

			int middle = low+(high-low)/2;
			/*
            System.out.println("low: "+low);
            System.out.println("middle: "+middle);
            System.out.println("high: "+high);
            System.out.println("--------------------------------");*/

			if(isPossible(d,middle,max)) high = middle;
			else low = middle + 1;
			/*
			System.out.println("low: "+low);
            System.out.println("middle: "+middle);
            System.out.println("high: "+high);
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");*/

		}
		if(!isPossible(d,low,max)) return -1;
		return low;
	}

	public static boolean isPossible(int[] d, int n, int max){
		int count = 0,sum = 0;
		//System.out.println(n);
		if(sum+d[0]>n) return false;
		sum += d[0];
		//System.out.print(d[0]);
		for(int i = 1; i<d.length; i++){

			if(d[i]+sum<=n){
				//System.out.print(d[i]);
				sum=sum+d[i];
			}
			else{
				//System.out.println();
				count++;
				sum = d[i];
				//System.out.print(d[i]);
			}
		}
		if(sum<=n) count++;
		/*
		System.out.println("");
		System.out.println("count: "+count);
		System.out.println("--------------------------------");*/
		if(count<=max) return true;
		else return false;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] d = new int[n];
		int sum = 0;

		for(int i = 0; i<n; i++){
			d[i] = in.nextInt();
			sum+=d[i];
		}


		int np = in.nextInt();

		for(int i = 0; i<np; i++){
			int m = in.nextInt();
			System.out.println(/*"RESULT: "+*/bsearch(d,0,sum,m));
			/*System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++");*/
		}
	}
}
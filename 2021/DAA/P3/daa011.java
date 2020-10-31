import java.util.Scanner;

class daa011{

	public static int bsearch(int[] d,int low, int high, int max){
		while(low<high){

			int middle = low+(high-low)/2;

			if(isPossible(d,middle,max)) high = middle;
			else low = middle + 1;
		}
		if(!isPossible(d,low,max)) return -1;
		return low;
	}

	public static boolean isPossible(int[] d, int n, int max){
		int count = 0,sum = 0;
		if(sum+d[0]>n) return false;
		sum += d[0];
		for(int i = 1; i<d.length; i++){

			//if(d[i]>n) return false;

			if(d[i]+sum<=n){
				sum=sum+d[i];
			}
			else{
				count++;
				sum = d[i];
			}
		}
		if(sum<=n) count++;
		if(count<=max) return true;
		else return false;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] d = new int[n];
		int sum = 0;
		int max = 0;

		for(int i = 0; i<n; i++){
			d[i] = in.nextInt();
			if(d[i]>=max) max = d[i];
			sum+=d[i];
		}


		int np = in.nextInt();

		for(int i = 0; i<np; i++){
			int m = in.nextInt();
			System.out.println(bsearch(d,max,sum,m));
		}
	}
}
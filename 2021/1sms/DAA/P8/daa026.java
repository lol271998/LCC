import java.util.Scanner;
import java.util.Arrays;

class daa026{

	static int rows,cols,c,max,ndirs = 8;
	static String m[];
	static boolean[][] visited;
	static int[] incx = {-1,1,0, 0,-1,-1, 1,1};
	static int[] incy = { 0,0,1,-1,-1, 1,-1,1};

	static int count(){
		int max = 0;

		for(int i = 0; i < rows; i++){
				for(int j = 0;j < cols; j++){
					if(m[i].charAt(j) == '#' && !visited[i][j]){
						dfs(i,j);
						//System.out.println("------------------------------");
					}
					max = Math.max(max,c);
					c = 0;
				}
			}

		return max;
	}

	static void dfs(int y,int x){
		if(y<0 || y>=rows || x<0 || x>=cols) return;
		if(visited[y][x] || m[y].charAt(x) != '#')	return;

		//System.out.println("dfs("+y+","+x+")");
		visited[y][x] = true;
		c++;
		//System.out.println(c);

		for(int i = 0; i<ndirs; i++){
			//System.out.println("y: "+(y+incy[i])+", x: "+(x+incx[i]));
			dfs(y+incy[i],x+incx[i]);
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int k = 0; k<n; k++){

			rows = in.nextInt();
			cols = in.nextInt();
			m = new String[rows];
			visited = new boolean[rows][cols];

			c = 0;
			max = 0;
			in.nextLine();

			for(int i = 0; i<rows; i++){
				m[i] = in.nextLine();
				//System.out.println(m[i]);
			}

			System.out.println(count());
		
		}
	}
}
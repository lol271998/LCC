import java.util.Scanner;

public class daa006{

	public static double cx = 0,cy = 0,cr = 0;

	public static double intersecao(double x1, double y1, double x2,double y2, double l){

		int cis = circleInsideSquare(x1,y1,x2,y2);

   		//Completamente fora uma da outra
   		if(cis == 0) return 0;
   		//Quadrado dentro do Circulo
   		if(cis == 1) return l*l;
   		//Circulo dentro do Circulo
   		if(cis == 2) return Math.PI * cr * cr;

   		double area = 0.0000;
   		if(l>=0.001){

   			//System.out.println("Recursion");

   			area = area + intersecao(x1,y1+(l/2),x1+(l/2),y2,(l/2));
			area = area + intersecao(x1+(l/2),y1+(l/2),x2,y2,(l/2));
			area = area + intersecao(x1,y1,x1+(l/2),y1+(l/2),(l/2));
			area = area + intersecao(x1+(l/2),y1,x2,y1+(l/2),(l/2));
		}

		return area;
	}

	public static int circleInsideSquare(double x1, double y1, double x2, double y2){
		//x2>x1; y2>y1;

		//Circle inside 
		System.out.println("(x1,y1): ("+x1+","+y1+")");
		System.out.println("(x2,y2): ("+x2+","+y2+")");
		System.out.println("(cx,cy): ("+cx+","+cy+") Raio -> "+cr);
		

		//Completamente fora
		if(cx-cr>x2 || cy-cr>y2 || cy+cr<y1 || cx+cr<x1){
			System.out.println("Completamente fora");
			return 0;
		} 
		//Quadrado dentro
		if(cx+cr >= x2 && cy+cr >= y2 && cx-cr<=x1 && cy-cr<=y1){
			System.out.println("Quadrado dentro");
			return 1;
		}
		//Ciruclo Dentro
		if(cx+cr <= x2 && cy+cr <= y2 && cx-cr>=x1 && cy-cr>=y1){
			System.out.println("Ciruclo Dentro");
			return 2;
		}

		else{
			//System.out.println("Else");
			return 3;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for(int i = 0; i<n; i++){

			//Coordenada canto inferior esquerdo ->(qx,qy)
			//Tamanho do lado -> ql
			//Centro da Circunferência -> (cx,cy)
			//Raio -> cr
			
			double qx = in.nextInt(); 
			double qy = in.nextInt(); 
			double ql = in.nextInt(); 
			cx = in.nextInt();
			cy = in.nextInt();
			cr = in.nextInt();

			double qx2 = qx+ql;
			double qy2 = qy+ql;

			System.out.println(intersecao(qx,qy,qx2,qy2,ql));



		}		
	}
}
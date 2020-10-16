import java.util.Scanner;

public class daa006{

	public static double cx = 0,cy = 0,cr = 0;

	public static double intersecao(double x1, double y1, double x2,double y2, double l){

		int cis = circleANDSquare(x1,y1,x2,y2);

   		//Completamente fora uma da outra
   		if(cis == 0){
   			//System.out.println("out");
   			return 0;
   		}
   		//Quadrado dentro do Circulo
   		if(cis == 1) return l*l;
   		//Circulo dentro do Circulo
   		if(cis == 2) return Math.PI * cr * cr;

   		double area = 0.0000;
   		if(l>=0.001){

   									//Quadrado inferior direito
   			area = area + intersecao(x1,y1+(l/2.0),x1+(l/2.0),y2,(l/2.0));
   									//Quadrado superior direito
			area = area + intersecao(x1+(l/2.0),y1+(l/2.0),x2,y2,(l/2.0));
									//Quadrado inferior esquerdo
			area = area + intersecao(x1,y1,x1+(l/2.0),y1+(l/2.0),(l/2.0));
									//Quadrado superior esquerdo
			area = area + intersecao(x1+(l/2.0),y1,x2,y1+(l/2.0),(l/2.0));
		}

		return area;
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}

	public static int circleANDSquare(double x1, double y1, double x2, double y2){
		//x2>x1; y2>y1;

		//Ciruclo Dentro
		if(cx+cr <= x2 && cy+cr <= y2 && cx-cr >= x1 && cy-cr >= y1){
			//System.out.println("Ciruclo Dentro");
			return 2;
		}

		//Quadrado está dentro do Circulo
		if (distance(x1,y1,cx,cy) <= cr &&
			distance(x1,y2,cx,cy) <= cr &&
			distance(x2,y1,cx,cy) <= cr &&
			distance(x2,y2,cx,cy) <= cr) return 1;
		
		//1º Quadrante
		if(x1>=cx && y1>=cy && x2>=cx && y2>=cy){
			//System.out.println("1ºQuadrante");
			if(distance(x1,y1,cx,cy)>cr) return 0;
			else return 3;
		}
		
		//2º Quadrante
		if(x2<=cx && y1>=cy && x1<=cx && y2>=cy){
			//System.out.println("2ºQuadrante");
			if(distance(x2,y1,cx,cy)>cr) return 0;
			else return 3;
		}

		//3º Quadrante
		if(x2<=cx && y2<=cy && x1<=cx && y1<=cy){
			//System.out.println("3ºQuadrante");
			if(distance(x2,y2,cx,cy)>cr) return 0;
			else return 3;
		}

		//4º Quadrante
		if(x1<=cx && y2>=cy && x2<=cx && y1>=cy){
			//System.out.println("4ºQuadrante");
			if(distance(x1,y2,cx,cy)>cr) return 0;
			else return 3;
		}
		return 3;
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
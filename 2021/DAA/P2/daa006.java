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

   		double area = 0.000;
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

	public static int circleANDSquare(double x1, double y1, double x2, double y2){
		//x2>x1; y2>y1;

		/*Circle inside 
		System.out.println("(x1,y1): ("+x1+","+y1+")");
		System.out.println("(x2,y2): ("+x2+","+y2+")");
		System.out.println("(cx,cy): ("+cx+","+cy+") Raio -> "+cr);
		*/

		//Quadrado dentro
		//Calcular qual o ponto mais longe do centro
		Double dx = Math.max(cx - x1, x2 - cx); 
		Double dy = Math.max(cy - y2, y1 - cx);

		if(cr*cr >= dx*dx + dy*dy){
			//System.out.println("Quadrado Dentro");
			return 1;
		}

		//Ciruclo Dentro
		if(){
			return 2;
		}

		//1º Quadrante
		if(x1>=cx && y1>=cy){
			double h2 = ((x1-cx)*(x1-cx)) + ((y1-cy)*(y1-cy));
			if(Math.sqrt(h2)>=cr) return 0;
		}

		//2º Quadrante
		if(x2<=cx && y1>=cy){
			double h2 = ((cx-x2)*(cx-x2)) + ((y1-cy)*(y1-cy));
			if(Math.sqrt(h2)>=cr) return 0;
		}

		//3º Quadrante
		if(x2<=cx && y2<=cy){
			double h2 = ((cx-x2)*(cx-x2)) + ((cy-y2)*(cy-y2));
			if(Math.sqrt(h2)>=cr) return 0;
		}

		//4º Quadrante
		if(x1<=cx && y2>=cy){
			double h2 = ((x1-cx)*(x1-cx)) + ((cy-y2)*(cy-y2));
			if(Math.sqrt(h2)>=cr) return 0;
		}

		//System.out.println("Not inside, Nor Outside.");
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
import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

public class DrawPolygon extends JPanel {
	
	private int height,width,n,sizeincrease;
	private LinkedList<Node> list;
	
	void set(int height,int width,int n,int sizeincrease,LinkedList<Node> list) {
		this.height = height;
		this.width = width;
		this.n = n;
		this.sizeincrease = sizeincrease;
		this.list = list;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		int xPoints[] = new int[n+1];
        int yPoints[] = new int[n+1];
        
		//Eixo do y
		g.drawLine(width/2,5,width/2,height-45);
		g.drawLine(width/2,5,(width/2)-5,10);
		g.drawLine(width/2,5,(width/2)+5,10);
		
		//Eixo do x
		g.drawLine(5,(height/2)-10,width-5,(height/2)-10);
		g.drawLine(width-5, (height/2)-10, width-10,(height/2)-15);
		g.drawLine(width-5, (height/2)-10, width-10,(height/2)-5);
		
		//Cada unidade
		for(int i = (width/2); i<width-10; i+=1*sizeincrease) {
			g.drawLine(i, (width/2)-15, i, (width/2)-5);
		}
		
		for(int i = (width/2); i>0; i-=1*sizeincrease) {
			g.drawLine(i, (width/2)-15, i, (width/2)-5);
		}
		
		for(int i = (height/2)-10; i>0; i-=1*sizeincrease) {
			g.drawLine((height/2)-5, i,(height/2)+5, i);
		}
		
		for(int i = (height/2)-10; i<height-10; i+=1*sizeincrease) {
			g.drawLine((height/2)-5, i,(height/2)+5, i);
		}
		
		//(0,0) = ((height/2),width/2-10)
		//g.drawLine(height/2,(width/2)-10, width-10, 0);
		for(int i = 0; i<list.size(); i++) {
			xPoints[i] = (list.get(i).x)*sizeincrease + (height/2);
			yPoints[i] = (list.get(i).y)*sizeincrease + ((width/2)-30);
        }	
		xPoints[n] = (list.getFirst().x)*sizeincrease + (height/2);
		yPoints[n] = (list.getFirst().y)*sizeincrease + ((width/2)-30);
		
		g.drawPolyline(xPoints,yPoints,n+1);
	}
}
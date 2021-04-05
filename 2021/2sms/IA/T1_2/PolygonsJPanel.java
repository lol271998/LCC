// Drawing polygons.
import java.util.*;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PolygonsJPanel extends JPanel {
// draw polygons and polylines
    private int n,m;
    private LinkedList<Node> l;
    public void set(int n, int m, LinkedList<Node> l) {
        this.n = n;
        this.m = m;
        this.l = l;
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); // call superclass's paintComponent
            
        int x1Points[] = new int[n+1];
        int y1Points[] = new int[n+1];
        int midx = m*10;
        int midy = m*10;  

        g.drawLine(midy, getHeight(), midy,0);
        g.drawLine(0, midx, getWidth(),midx);
        //Origem é midx,miy

        for(int i = 0; i<l.size(); i++) { 
            if(i == 0) {  
                x1Points[i] = midx+l.get(i).x;
                y1Points[i] = midy+l.get(i).y;
            }
            else {
                x1Points[i] = midx+l.get(i).x+m;
                y1Points[i] = midy+l.get(i).y+m;
            } 
        }
        x1Points[n] = midx+l.getFirst().x;
        y1Points[n] = midx+l.getFirst().y;
        g.drawPolyline( x1Points, y1Points, n+1 );
   } // end method paintComponent
} // end class PolygonsJPanel

    
// Drawing polygons.
import java.util.*;
import java.awt.Graphics;
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

        for(int i = 0; i<l.size(); i++) {
            x1Points[i] = (l.get(i).x) *100;
            y1Points[i] = (l.get(i).y) *100;
        }
        x1Points[n-1] = l.getFirst().x;
        y1Points[n-1] = l.getFirst().y;
        g.drawPolyline( x1Points, y1Points, n ); 

    } // end method paintComponent
} // end class PolygonsJPanel

    
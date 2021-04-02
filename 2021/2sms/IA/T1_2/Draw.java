// Drawing polygons.
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;
public class PolygonsJPanel extends JPanel {
// draw polygons and polylines
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); // call superclass's paintComponent
        
        for(int i = 0; i<n; i++) {
            x1Points[i] = poligono.get(i).x;
            y1Points[i] = poligono.get(i).y;
        }
        g.drawPolyline( xValues2, yValues2, 7 ); 

    } // end method paintComponent
} // end class PolygonsJPanel

    
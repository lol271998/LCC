import java.util.*;
import java.lang.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

public class Draw {

    static BufferedImage buffer = null;
    static int height = 10;
    static int width = 10;
    static Graphics2D g2;

    public Draw() {
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        g2 = buffer.createGraphics();
        g2.fillOval(2, 2, 2, 2);
        g2.dispose();
    }
    protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        g.drawImage(buffer, x, y, width, height, null);
    }

    public Graphics2D getGraphics(){
        return g2;
    }

    public static void printP(int n, LinkedList<Node> poligono) {
    
        Graphics2D g2 = getGraphics();
 
        int x1Points[] = new int[n];
        int y1Points[] = new int[n];
        
        for(int i = 0; i<n; i++) {
            x1Points[i] = poligono.get(i).x;
            y1Points[i] = poligono.get(i).y;
        }
        // draw GeneralPath (polygon)
        
        GeneralPath polygon = 
        new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                        x1Points.length);
        polygon.moveTo(x1Points[0], y1Points[0]);

        for (int index = 1; index < x1Points.length; index++) {
            polygon.lineTo(x1Points[index], y1Points[index]);
        };

        polygon.closePath();
        g2.draw(polygon);
    }
}

    
public class ScrollPanelFrame extends JFrame{

    public ScrollPanelFrame() {
        ArrayPanel panel = new ArrayPanel(20, 20);
        JScrollPane container = new JScrollPane(
                panel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        getContentPane().add(container);
    }

    class ArrayPanel extends JPanel {
        final int RECTANGLE_WIDTH = 100;
        final int RECTANGLE_HEIGHT = 100;

        int rectangleCountX;
        int rectangleCountY;

        public ArrayPanel(int rectangleCountX, int rectangleCountY) {
            this.rectangleCountX = rectangleCountX;
            this.rectangleCountY = rectangleCountY;
            this.setPreferredSize(new Dimension(RECTANGLE_WIDTH * rectangleCountX,
                                                RECTANGLE_HEIGHT * rectangleCountY));
        }

        @Override
        public void paintComponent(Graphics g) {
            for(int x = 0 ; x < rectangleCountX ; x++) {
                for(int y = 0 ; y < rectangleCountY ; y++) {
                    g.setColor(new Color(0, 0, (x+y)*64 % 256));
                    g.fillRect(x*RECTANGLE_WIDTH, y*RECTANGLE_HEIGHT,
                               RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                }
            }
        }
    }

    public static void main(String[] args) {
        ScrollPanelFrame frame = new ScrollPanelFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
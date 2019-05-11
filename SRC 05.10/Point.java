public class Point {
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(double _x, double _y) {
        x = (int) _x;
        y = (int) _y;
    }

    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }
}

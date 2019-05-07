public class Point {
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }
}

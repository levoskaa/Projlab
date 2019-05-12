/**
 * Osztaly a jatek koordinatainak implementalasara.
 */
public class Point {
    /**
     * Az x koordinatat tarolo int.
     */
    public int x;
    /**
     * Az y koordinatat tarolo int.
     */
    public int y;

    /**
     * Default Konstruktor.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Konstruktor.
     * @param _x Az x koordinata erteke.
     * @param _y Az y koordinata erteke.
     */
    public Point(double _x, double _y) {
        x = (int) _x;
        y = (int) _y;
    }

    /**
     * Hozzaadja a meglevo x es y koordinata ertekeihez a parameterben megadott pont megfelelo koordinatainak ertekeit, es visszaad egy uj Point objektumot.
     * @param p A bemeneti Point objektum.
     * @return Az uj Point objektum.
     */
    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }
}

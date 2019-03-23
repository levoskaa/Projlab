//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projlab
//  @ File Name : ExitPoint.java
//  @ Date : 2019.03.23
//  @ Author : Kalai
//
//

/**
 * Osztaly a kijarat viselkedesenek es tulajdonsagaiknak osszegyujtesere.
 * @author Kalai
 * @see EntryWardrobe
 */
public class ExitPoint extends EntryWardrobe {

    /**
     * Az ide lepo allatot a bejaratra teszi, levalasztja a pandakat, es
     * pontot oszt ertuk.
     *
     * @param a Az allat (orangutan) amely a kijaratra lepett.
     */
    public void receive(Animal a) {
        localAnimal.setTile(getStartingTile());
        int i = 0;
        for (Panda p: localAnimal.getCaughtPandas()) {
            p.die();
            ++i;
        }
        addPoints();
        return;
    }
}

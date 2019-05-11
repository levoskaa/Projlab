//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BreakableTile.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A torekeny csempe viselkedeset megvalosito osztaly.
 *
 * @author Konczos
 */


public class BreakableTile extends Tile {

    /**
     * A csempe elettartamat tarolo int.
     */
    private int health;

    /**
     * A csempe allapotat(torott/ep) jelzo boolean.
     */
    private boolean broken;

    public BreakableTile() {
        try {
            image = ImageIO.read(getClass().getResource( "images/breakabletile_notbroken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter fuggveny a health valtozohoz.
     *
     * @return A health valtozo, azaz a csempe elete.
     */
    public int getHealth() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::getHealth()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::getHealth()");
        }
        return health;
    }

    /**
     * Getter fuggveny a broken valtozohoz.
     *
     * @return A broken valtozo, azaz, hogy torott e a csempe.
     */
    public boolean isBroken() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::isBroken()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::isBroken()");
        }
        return broken;
    }

    /**
     * Setter fuggveny a health valtozohoz.
     *
     * @param newHealth Az health valtozo uj erteke.
     */
    @Override
    public void setHealth(int newHealth) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::setHealth(int newHealth)");
        }

        health = newHealth;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::setHealth(int newHealth)");
        }

    }

    /**
     * Setter fuggveny a broken valtozohoz.
     *
     * @param newBroken A broken valtozo uj erteke.
     */
    public void setBroken(boolean newBroken) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::setBroken(boolean newBroken)");
        }

        broken = newBroken;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::setBroken(boolean newBroken)");
        }
        return;

    }

    /**
     * A fuggveny eggyel csökkenti a törékeny csempe elettartamat.
     */
    @Override
    public void decreaseHealth() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::decreaseHealth()");
        }

        health--;
        if (health <= 0) {
            broken = true;
            localAnimal.die();

            try {
                image = ImageIO.read(getClass().getResource( "images/breakabletile_broken.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::decreaseHealth()");
        }
        return;
    }

    /**
     * Amennyiben az allat a csempere akar lepni, ez a fuggveny hivodik meg.
     *
     * @param a Az allat, amely a csempere akar lepni.
     */
    public void receive(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BreakableTile::receive (Animal a)");
        }

        if (!broken) {
            if (localAnimal == null) {
                a.getTile().remove();
                localAnimal = a;
                localAnimal.setTile(this);
                localAnimal.setCenter(center);
                decreaseHealth();
            } else {
                localAnimal.collideWith(a);
            }
        } else {
            a.getTile().remove();
            a.die();
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BreakableTile::receive (Animal a)");
        }
        return;
    }
}

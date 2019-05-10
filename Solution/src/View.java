//  @ Project : Projlab
//  @ File Name : View.java
//  @ Date : 2019.05.07.
//  @ Author : Laurinyecz

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

public class View {

    private GameWindow mainWindow;

    int maxWidth;
    int maxHeight;

    Map map;

    private Image automat;
    private Image breakabletile_broken;
    private Image breakabletile_notbroken;
    private Image couch;
    private Image exitpoint;
    private Image orangutan_ai;
    private Image orangutan_o;
    private Image panda;
    private Image slotmachine;
    private Image startingtile;
    private Image tile;
    private Image wardrobe;

    private GameLogic gl;

    //nalam ez pl "/images/", Levinel asszem "./src/images/"
    private String path = "./src/images/";

    //offset for images
    private int o = 32;

    public void init() {
        buildFrame();
    }

    public void drawAll() {
    }

    public class myPanel extends JPanel {
        public myPanel() {
            super.setPreferredSize(new Dimension(300, 300));
        }

        @Override
        public void paintComponent(Graphics g) {
            /*g.drawImage(tile, 45 - o, 45 - o, mainWindow);
            g.drawLine(45,45,130,130);
            g.drawImage(tile, 130 - o, 130 - o, mainWindow);
            g.drawLine(130,130,230,70);
            g.drawImage(tile, 230 - o, 70 - o, mainWindow);
            g.drawLine(230, 70,350,70);
            g.drawImage(tile, 350 - o, 70 - o, mainWindow);
            g.drawLine(350,70,470,125);
            g.drawImage(tile, 470 - o, 125 - o, mainWindow);
            g.drawLine(45,45,130,130);

            g.drawImage(tile, 600 - o, 70 - o, mainWindow);
            g.drawLine(45,45,130,130);
            g.drawImage(tile, 770 - o, 140 - o, mainWindow);
            g.drawLine(45,45,130,130);
            g.drawImage(tile, 890 - o, 50 - o, mainWindow);*/


            /*g.drawImage(startingtile, map.getTile("st").getCenter().x - o, map.getTile("st").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t1").getCenter().x - o, map.getTile("t1").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t2").getCenter().x - o, map.getTile("t2").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t3").getCenter().x - o, map.getTile("t3").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t4").getCenter().x - o, map.getTile("t4").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t5").getCenter().x - o, map.getTile("t5").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t6").getCenter().x - o, map.getTile("t6").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t7").getCenter().x - o, map.getTile("t7").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t8").getCenter().x - o, map.getTile("t8").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t9").getCenter().x - o, map.getTile("t9").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t10").getCenter().x - o, map.getTile("t10").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t11").getCenter().x - o, map.getTile("t11").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t12").getCenter().x - o, map.getTile("t12").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t13").getCenter().x - o, map.getTile("t13").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t14").getCenter().x - o, map.getTile("t14").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t15").getCenter().x - o, map.getTile("t15").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t16").getCenter().x - o, map.getTile("t16").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t17").getCenter().x - o, map.getTile("t17").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t18").getCenter().x - o, map.getTile("t18").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t19").getCenter().x - o, map.getTile("t19").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t20").getCenter().x - o, map.getTile("t20").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t21").getCenter().x - o, map.getTile("t21").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t22").getCenter().x - o, map.getTile("t22").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t23").getCenter().x - o, map.getTile("t23").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t24").getCenter().x - o, map.getTile("t24").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t25").getCenter().x - o, map.getTile("t25").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t26").getCenter().x - o, map.getTile("t26").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t27").getCenter().x - o, map.getTile("t27").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t28").getCenter().x - o, map.getTile("t28").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t29").getCenter().x - o, map.getTile("t29").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t30").getCenter().x - o, map.getTile("t30").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t31").getCenter().x - o, map.getTile("t31").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t32").getCenter().x - o, map.getTile("t32").getCenter().y - o, mainWindow);
            g.drawImage(tile, map.getTile("t33").getCenter().x - o, map.getTile("t33").getCenter().y - o, mainWindow);*/

            for (Object value : map.getTiles().values()) {
                //g.drawImage(tile, ((BaseTile) value).getCenter().x - o, ((BaseTile) value).getCenter().y - o, mainWindow);
                for (BaseTile bt : ((BaseTile) value).getNeighbours()) {
                    if (bt != null) {
                        int a = bt.getCenter().x;
                        int b = bt.getCenter().y;
                        int c = ((BaseTile) value).getCenter().x;
                        int d = ((BaseTile) value).getCenter().y;
                        g.drawLine(a, b, c, d);
                    }
                }
            }

            for (Object value : map.getTiles().values()) {
                g.drawImage(tile, ((BaseTile) value).getCenter().x - o, ((BaseTile) value).getCenter().y - o, mainWindow);
            }


            g.drawImage(startingtile, map.getTile("st").getCenter().x - o, map.getTile("st").getCenter().y - o, mainWindow);
            g.drawImage(exitpoint, map.getTile("e").getCenter().x - o, map.getTile("e").getCenter().y - o, mainWindow);
            g.drawImage(couch, map.getTile("c1").getCenter().x - o, map.getTile("c1").getCenter().y - o, mainWindow);
            g.drawImage(wardrobe, map.getTile("w1").getCenter().x - o, map.getTile("w1").getCenter().y - o, mainWindow);
            g.drawImage(wardrobe, map.getTile("w2").getCenter().x - o, map.getTile("w2").getCenter().y - o, mainWindow);
            g.drawImage(automat, map.getTile("a1").getCenter().x - o, map.getTile("a1").getCenter().y - o, mainWindow);
            g.drawImage(slotmachine, map.getTile("s1").getCenter().x - o, map.getTile("s1").getCenter().y - o, mainWindow);
            g.drawImage(breakabletile_notbroken, map.getTile("b1").getCenter().x - o, map.getTile("b1").getCenter().y - o, mainWindow);
            g.drawImage(breakabletile_notbroken, map.getTile("b3").getCenter().x - o, map.getTile("b3").getCenter().y - o, mainWindow);


            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    //System.out.println(me);
                    //System.out.println(me.getX() + " " + me.getY());
                    BaseTile bt = null;
                    for (Object value : map.getTiles().values()) {
                        if (Math.pow(me.getX() - ((BaseTile) value).getCenter().x, 2) + Math.pow(me.getY() - ((BaseTile) value).getCenter().y, 2) - 32 * 32 * map.s < 0){
                            bt = ((BaseTile) value);
                        }
                    }
                    if (bt != null){
                        //orangutan uj pozicio: bt csempe
                        System.out.println(bt.getCenter().x + " " + bt.getCenter().y);
                    }
                }
            });
        }

    }

    public void pandaRemoved() {

    }

    public void orangutanRemoved() {

    }

    public JFrame getFrame() {
        return mainWindow;
    }

    private JFrame buildFrame() {
        mainWindow = new GameWindow("Game");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //mainWindow.setSize(600, 600);

        /*GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        maxWidth = bounds.width;
        maxHeight = bounds.height;*/

        maxWidth = 1280;
        maxHeight = 720;

        mainWindow.setSize(new Dimension(maxWidth, maxHeight));

        //atmeretezheto ????
        mainWindow.setResizable(false);

        //mainWindow.setVisible(true);

        try {
            automat = ImageIO.read(getClass().getResource(path + "automat.png"));
            breakabletile_broken = ImageIO.read(getClass().getResource(path + "breakabletile(broken).png"));
            breakabletile_notbroken = ImageIO.read(getClass().getResource(path + "breakabletile(notbroken).png"));
            couch = ImageIO.read(getClass().getResource(path + "couch.png"));
            exitpoint = ImageIO.read(getClass().getResource(path + "exitpoint.png"));
            orangutan_ai = ImageIO.read(getClass().getResource(path + "orangutan(ai).png"));
            orangutan_o = ImageIO.read(getClass().getResource(path + "orangutan(o).png"));
            panda = ImageIO.read(getClass().getResource(path + "panda.png"));
            slotmachine = ImageIO.read(getClass().getResource(path + "slotmachine.png"));
            startingtile = ImageIO.read(getClass().getResource(path + "startingtile.png"));
            tile = ImageIO.read(getClass().getResource(path + "tile.png"));
            wardrobe = ImageIO.read(getClass().getResource(path + "wardrobe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gl = new GameLogic();
        map = new Map(gl, false, 1);

        myPanel pane = new myPanel();
        mainWindow.add(pane);
        mainWindow.setVisible(true);

        mainWindow.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                //szelesseg szerint skalaz
                //map = new Map(gl, false, mainWindow.getContentPane().getSize().getWidth() / 1280);

                //magassag szerint skalaz
                map = new Map(gl, false, mainWindow.getContentPane().getSize().getHeight() / 700);

                //mainWindow.setSize(new Dimension((int)(mainWindow.getContentPane().getSize().getWidth() / 1280), (int)(mainWindow.getContentPane().getSize().getWidth() / 1280 * 720)));
            }
        });


        return mainWindow;
    }
}

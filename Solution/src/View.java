//  @ Project : Projlab
//  @ File Name : View.java
//  @ Date : 2019.05.07.
//  @ Author : Laurinyecz

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class View {

    private GameWindow mainWindow;

    private int maxWidth;
    private int maxHeight;

    Map map;

    private GameLogic gl;

    private String path = "/images/";

    //offset for images
    private int o = 32;

    private Image startingTileImg;
    private Image orangutan_oImg;
    private Image orangutan_aiImg;

    public View(GameLogic gl) {
        try {
            startingTileImg = ImageIO.read(getClass().getResource( "images/startingtile.png"));
            orangutan_oImg = ImageIO.read(getClass().getResource( "images/orangutan_o.png"));
            orangutan_aiImg = ImageIO.read(getClass().getResource( "images/orangutan_ai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gl = gl;
    }

    public void init() {
        buildFrame();
        gl.start();
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

                for (BaseTile value : map.getTiles().values()) {
                    //g.drawImage(tile, ((BaseTile) value).getCenter().x - o, ((BaseTile) value).getCenter().y - o, mainWindow);
                    for (BaseTile bt : value.getNeighbours()) {
                        if (bt != null) {
                            int a = bt.getCenter().x;
                            int b = bt.getCenter().y;
                            int c = value.getCenter().x;
                            int d = value.getCenter().y;
                            g.drawLine(a, b, c, d);
                        }
                    }
                }

                for (BaseTile value : map.getTiles().values()) {
                    int x = value.getCenter().x - o;
                    int y = value.getCenter().y - o;

                    if (value.getName().compareTo("st") == 0) {
                        g.drawImage(startingTileImg, x, y, mainWindow);
                    } else {
                        g.drawImage(value.getImage(), x, y, mainWindow);
                    }

                    if (value.getItem() != null) {
                        g.drawImage(value.getItem().getImage(), x, y, mainWindow);
                    }
                }

                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent me) {
                        //System.out.println(me);
                        //System.out.println(me.getX() + " " + me.getY());
                        BaseTile bt = null;
                        for (Object value : map.getTiles().values()) {
                            if (Math.pow(me.getX() - ((BaseTile) value).getCenter().x, 2) + Math.pow(me.getY() - ((BaseTile) value).getCenter().y, 2) - 32 * 32 < 0) {
                                bt = ((BaseTile) value);
                            }
                        }
                        if (bt != null) {
                            //orangutan uj pozicio: bt csempe
                            boolean neighbour = false;
                            for (BaseTile bt1 : bt.getNeighbours()) {
                                //System.out.println(bt1.getName());
                                int a = bt1.getCenter().x;
                                int b = gl.getPlayerOrangutan().getCenter().x;
                                int c = bt1.getCenter().y;
                                int d = gl.getPlayerOrangutan().getCenter().y;
                                System.out.println(a + " " + b + " " + c + " " + d);
                                if (bt1.getCenter().x == gl.getPlayerOrangutan().getCenter().x && bt1.getCenter().y == gl.getPlayerOrangutan().getCenter().y){
                                    neighbour = true;
                                    break;
                                }
                            }
                            if (neighbour){
                                System.out.println(bt.getCenter().x + " " + bt.getCenter().y);
                                gl.getPlayerOrangutan().setDestination(bt);
                                //gl.getPlayerOrangutan().move(bt);
                                mainWindow.repaint();
                            } else {
                                gl.getPlayerOrangutan().setDestination(null);
                            }
                            System.out.println( gl.getPlayerOrangutan().getCenter().x + " " + gl.getPlayerOrangutan().getCenter().y );
                        }
                    }
                });

                addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        //super.keyReleased(e);
                        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                            if (gl.getPlayerOrangutan().getCaughtPandas().size() > 0) {
                                gl.getPlayerOrangutan().release(gl.getPlayerOrangutan().getCaughtPandas().get(0));
                            }
                        }
                    }
                });

                for (Animal a : map.getGameLogic().getPandasOnTheMap()) {
                    g.drawImage(a.getImage(), a.getCenter().x - o, a.getCenter().y - o, mainWindow);
                }

                g.drawImage(orangutan_oImg, map.getGameLogic().getPlayerOrangutan().getCenter().x - o, map.getGameLogic().getPlayerOrangutan().getCenter().y - o, mainWindow);
                g.drawImage(orangutan_aiImg, map.getGameLogic().getSecondOrangutan().getCenter().x - o, map.getGameLogic().getSecondOrangutan().getCenter().y - o, mainWindow);

                g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
                String text = "Score: " + gl.getPoints();
                int width = g.getFontMetrics().stringWidth(text);
                g.drawString(text, mainWindow.getWidth() - (width + 15), 32);
                text = "Time: " + gl.getTime();
                g.drawString(text, (mainWindow.getWidth() - width) / 2, 32);
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

        map = new Map(gl, false, 1);

        /*
        Panda p1 = new TiredPanda();
        p1.setCenter(map.getTile("t9").getCenter());

        gl.addPanda(p1);

        gl.getPlayerOrangutan().setCenter(map.getTile("t10").getCenter());
        gl.getSecondOrangutan().setCenter(map.getTile("t15").getCenter());

        ArrayList<Panda> follow = new ArrayList<>();
        follow.add(p1);
        gl.getPlayerOrangutan().setCaughtPandas(follow);
        */

        myPanel pane = new myPanel();
        mainWindow.add(pane);
        mainWindow.setVisible(true);

        /*mainWindow.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                //szelesseg szerint skalaz
                //map = new Map(gl, false, mainWindow.getContentPane().getSize().getWidth() / 1280);

                //magassag szerint skalaz
                //map = new Map(gl, false, mainWindow.getContentPane().getSize().getHeight() / 700);

                //mainWindow.setSize(new Dimension((int)(mainWindow.getContentPane().getSize().getWidth() / 1280), (int)(mainWindow.getContentPane().getSize().getWidth() / 1280 * 720)));
            }
        });*/

        return mainWindow;
    }

    public void repaint() {
        mainWindow.repaint();
    }
}

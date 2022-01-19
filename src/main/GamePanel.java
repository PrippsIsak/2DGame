package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    final int OgTileSize = 16;
    final int scale = 3;

    public final int tileSize = OgTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize *maxScreenCol;
    public final int screenHeight = tileSize *maxScreenRow;

    //world settings
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 48;
    public final int maxWorldWidth = tileSize * maxWorldRow;
    public final int maxWorldHeight = tileSize * maxWorldCol;


    final int fps = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyHandler);
    public CollisionDetect cd = new CollisionDetect(this);

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public  void  startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run()
    {
        double drawInterval = 1000000000/(double)fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) // runs aslong as gamethread is started
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1)
            {

                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                drawCount = 0;
                timer =0;
            }
        }
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        tileManager.draw(graphics2D);
        player.draw(graphics2D);
        graphics2D.dispose();
    }

}

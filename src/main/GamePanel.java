package main;

import entity.Player;
import object.superObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    public final int tileSize = 48;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize *maxScreenCol;
    public final int screenHeight = tileSize *maxScreenRow;

    //world settings
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 48;

    final int fps = 60;

//    SYSTEM
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionDetect cd = new CollisionDetect(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    Sound sound = new Sound();
//    ENTITYS AND OBJECTS
    public superObject[] object = new superObject[10];
    public Player player = new Player(this, keyHandler);


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public void setUpGame()
    {
        assetSetter.setObject();

        playMusic(0);
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
//        tiles
        tileManager.draw(graphics2D);
//        object
        for(int i = 0; i < object.length; i++)
        {
            if(object[i] != null)
                object[i].draw(graphics2D, this);
        }
//        player
        player.draw(graphics2D);
        graphics2D.dispose();
    }
    public void playMusic(int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic()
    {
        sound.stop();
    }
    public void playSoundEffect(int i)
    {
        sound.setFile(i);
        sound.play();
    }
}
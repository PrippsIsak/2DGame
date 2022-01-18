package entity;

import main.gamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    gamePanel gp;
    KeyHandler keyHandler;

    public  Player (gamePanel gp, KeyHandler keyHandler)
    {
        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "up";
    }

    public static String[] paths_to_feet_pics = {
            "/player/boy_down_1.png",
            "/player/boy_down_2.png",
            "/player/boy_down_1.png",
            "/player/boy_down_2.png",
            "/player/boy_left_1.png",
            "/player/boy_left_2.png",
            "/player/boy_right_1.png",
            "/player/boy_right_2.png"
    };
    public void getPlayerImage()
    {
        try
        {

            up1 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[0]));
            up2 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[1]));
            down1 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[2]));
            down2 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[3]));
            left1 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[4]));
            left2 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[5]));
            right1 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[6]));
            right2 = ImageIO.read(getClass().getResourceAsStream(paths_to_feet_pics[7]));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update()
    {
       if(keyHandler.anyPressed)
       {

           if(keyHandler.upPressed && keyHandler.rightPressed)
           {
               x += speed;
               y -= speed;
               direction = "right";
           }
           else if(keyHandler.upPressed && keyHandler.leftPressed)
           {
               x -= speed;
               y -= speed;
               direction = "left";
           }
           else if(keyHandler.downPressed && keyHandler.rightPressed)
           {
               y += speed;
               x += speed;
               direction = "right";
           }
           else if (keyHandler.downPressed && keyHandler.leftPressed)
           {
               y += speed;
               x -= speed;
               direction = "left";
           }
           else if(keyHandler.upPressed)
           {
               y -= speed;
               direction = "up";
           }
           else if(keyHandler.downPressed)
           {
               y += speed;
               direction = "down";
           }
           else if(keyHandler.rightPressed)
           {
               x += speed;
               direction = "right";
           }
           else if(keyHandler.leftPressed)
           {
               x -= speed;
               direction = "left";
           }
           spriteCounter++;
           if(spriteCounter == 10)
           {
               if(spriteNumber == 1)
                   spriteNumber = 2;
               else if (spriteNumber == 2) {
                   spriteNumber = 1;
               }
               spriteCounter = 0;
           }
       }
    }

    public  void draw(Graphics2D graphics2D)
    {
        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNumber == 1)
                    image = up1;
                if (spriteNumber == 2)
                    image = up2;
            }
            case "down" -> {
                if (spriteNumber == 1)
                    image = down1;
                if (spriteNumber == 2)
                    image = down2;
            }
            case "left" -> {
                if (spriteNumber == 1)
                    image = left1;
                if (spriteNumber == 2)
                    image = left2;
            }
            case "right" -> {
                if (spriteNumber == 1)
                    image = right1;
                if (spriteNumber == 2)
                    image = right2;
            }
        }
        graphics2D.drawImage(image,x,y,gp.tileSize,gp.tileSize, null);
    }
}
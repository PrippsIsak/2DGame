package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public  Player (GamePanel gp, KeyHandler keyHandler)
    {
        this.gp = gp;
        this.keyHandler = keyHandler;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidPart = new Rectangle(8,16,32,32);


        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        worldX = gp.tileSize * 22;
        worldY = gp.tileSize * 22;
        speed = 4;
        direction = "down";
    }

    public static String[] paths_to_feet_pics = {
            "/player/boy_up_1.png",
            "/player/boy_up_2.png",
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

           /*if(keyHandler.upPressed && keyHandler.rightPressed)
           {
               worldX += speed;
               worldY -= speed;
               direction = "right";
           }
           else if(keyHandler.upPressed && keyHandler.leftPressed)
           {
               worldX -= speed;
               worldY -= speed;
               direction = "left";
           }
           else if(keyHandler.downPressed && keyHandler.rightPressed)
           {
               worldY += speed;
               worldX += speed;
               direction = "right";
           }
           else if (keyHandler.downPressed && keyHandler.leftPressed)
           {
               worldY += speed;
               worldX -= speed;
               direction = "left";
           }*/
           if(keyHandler.upPressed)
               direction = "up";

           else if(keyHandler.downPressed)
               direction = "down";

           else if(keyHandler.rightPressed)
               direction = "right";

           else if(keyHandler.leftPressed)
               direction = "left";

           collisionOn = false;
           gp.cd.checkTile (this);
           if(!collisionOn)
               switch (direction)
               {
                   case "up" -> worldY -= speed;
                   case "down" -> worldY += speed;
                   case "left" -> worldX -= speed;
                   case "right" -> worldX += speed;
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
        graphics2D.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize, null);
    }
}
package entity;

import main.CollisionDetect;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public int keyAmount = 0;
    public boolean boots = false;
    public boolean RK = false;
    public boolean BK = false;
    public  Player (GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - gamePanel.tileSize/2;
        screenY = gamePanel.screenHeight/2 - gamePanel.tileSize/2;

        solidPart = new Rectangle(8,16,32,32);  //48*48
        solidAreaDefaultX = solidPart.x;
        solidAreaDefaultY = solidPart.y;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        worldX = gamePanel.tileSize * 22;
        worldY = gamePanel.tileSize * 22;
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
           if(keyHandler.upPressed)
               direction = "up";

           else if(keyHandler.downPressed)
               direction = "down";

           else if(keyHandler.rightPressed)
               direction = "right";

           else if(keyHandler.leftPressed)
               direction = "left";

           collisionOn = false;
           gamePanel.cd.checkTile (this);
           interreactObject(gamePanel.cd.checkObject(this,true));

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

    public void interreactObject(int i)
    {
        if(i != 999)
        {
            switch (gamePanel.object[i].name)
            {
            case "Key" ->
                {
                    keyAmount++;
                    gamePanel.object[i] = null;
                    gamePanel.playSoundEffect(1);
                }
            case "Door" ->
                {
                    if(keyAmount == 3)
                    {
                        gamePanel.object[i] = null;
                        gamePanel.playSoundEffect(2);
                    }
                }
            case "Lundgrens" ->
                {
                    gamePanel.object[i] = null;
                    gamePanel.playSoundEffect(4);

                }
            case "RedKey" ->
                {
                    RK = true;
                    gamePanel.object[i] = null;
                    gamePanel.playSoundEffect(1);
                }
            case "RedDoor"->
                {
                  if(RK)
                  {
                      gamePanel.object[i] = null;
                      gamePanel.playSoundEffect(2);
                  }
                }
            case "BlueDoor" ->
                {
                    if(BK)
                    {
                        gamePanel.object[i] = null;
                        gamePanel.playSoundEffect(2);
                    }
                }
            case "BlueKey" ->
                {
                    BK = true;
                    gamePanel.object[i] = null;
                    gamePanel.playSoundEffect(1);
                }
            case "Boots" ->
                {
                    speed += 4;
                    gamePanel.object[i] = null;
                    gamePanel.playSoundEffect(1);
                }
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
        graphics2D.drawImage(image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize, null);
    }
}
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
        speed = 100;
        direction = "right";
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1_.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2_.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1_.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2_.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1_.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right2_1_.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update()
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
    }

    public  void draw(Graphics2D graphics2D)
    {
        BufferedImage image = switch (direction) {
            case "up" -> up1;
            case "down" -> down1;
            case "left" -> left1;
            case "right" -> right1;
            default -> null;
        };

        graphics2D.drawImage(image,x,y,gp.tileSize,gp.tileSize, null);
    }
}

package main;

import object.ObjChest;
import object.ObjDoor;
import object.ObjKey;

public class AssetSetter
{
    GamePanel gamePanel;

    public  AssetSetter(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void  setObject()
    { // rad 17, col, 9
        gamePanel.object[0] = new ObjKey();
        gamePanel.object[0].worldX = 9 * gamePanel.tileSize;
        gamePanel.object[0].worldY = 17 * gamePanel.tileSize;

        gamePanel.object[1] = new ObjKey();
        gamePanel.object[1].worldX = 2 * gamePanel.tileSize;
        gamePanel.object[1].worldY = 2 * gamePanel.tileSize;

        gamePanel.object[2] = new ObjKey();
        gamePanel.object[2].worldX = 35 * gamePanel.tileSize;
        gamePanel.object[2].worldY = 23 * gamePanel.tileSize;

        gamePanel.object[3] = new ObjDoor();
        gamePanel.object[3].worldX = 7 * gamePanel.tileSize;
        gamePanel.object[3].worldY = 38 * gamePanel.tileSize;

        gamePanel.object[4] = new ObjChest();
        gamePanel.object[4].worldX = 7 * gamePanel.tileSize;
        gamePanel.object[4].worldY = 43 * gamePanel.tileSize;

    }
}

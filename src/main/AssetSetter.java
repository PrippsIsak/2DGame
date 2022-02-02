package main;

import object.*;

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
        gamePanel.object[2].worldX = 34 * gamePanel.tileSize;
        gamePanel.object[2].worldY = 22 * gamePanel.tileSize;

        gamePanel.object[3] = new ObjDoor();
        gamePanel.object[3].worldX = 7 * gamePanel.tileSize;
        gamePanel.object[3].worldY = 38 * gamePanel.tileSize;

        gamePanel.object[4] = new ObjBoots();
        gamePanel.object[4].worldX = 37 * gamePanel.tileSize;
        gamePanel.object[4].worldY = 5 * gamePanel.tileSize;

        gamePanel.object[5] = new ObjLundgrens();
        gamePanel.object[5].worldX = 20 * gamePanel.tileSize;
        gamePanel.object[5].worldY = 29 * gamePanel.tileSize;

        gamePanel.object[6] = new ObjBlueDoor();
        gamePanel.object[6].worldX = 20 * gamePanel.tileSize;
        gamePanel.object[6].worldY = 32 * gamePanel.tileSize;

        gamePanel.object[7] = new ObjRedDoor();
        gamePanel.object[7].worldX = 34 * gamePanel.tileSize;
        gamePanel.object[7].worldY = 24 * gamePanel.tileSize;

        gamePanel.object[8] = new ObjBlueKey();
        gamePanel.object[8].worldX = 18 * gamePanel.tileSize;
        gamePanel.object[8].worldY = 43 * gamePanel.tileSize;

        gamePanel.object[9] = new ObjRedKey();
        gamePanel.object[9].worldX = 7 * gamePanel.tileSize;
        gamePanel.object[9].worldY = 40 * gamePanel.tileSize;
    }
}

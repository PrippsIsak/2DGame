package main;
import entity.Entity;

public class CollisionDetect
{
    int leftX,rightX,topY,bottomY,leftCol,rightCol,topRow,bottomRow;

    GamePanel gamePanel;

    public CollisionDetect(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity)
    {
        //where in the world our solid part is
        leftX = entity.worldX + entity.solidPart.x;
        rightX = entity.worldX + entity.solidPart.x + entity.solidPart.width;
        topY = entity.worldY + entity.solidPart.y;
        bottomY = entity.worldY + entity.solidPart.y + entity.solidPart.height;

        leftCol = leftX/gamePanel.tileSize; //
        rightCol =  rightX/gamePanel.tileSize;
        topRow = topY/ gamePanel.tileSize;
        bottomRow = bottomY/ gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction)
        {
            case "up" -> {
                topRow = (topY-entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[topRow][leftCol];
                tileNum2 = gamePanel.tileManager.mapTileNum[topRow][rightCol];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                    entity.collisionOn = true;
            }
            case "down" -> {
                bottomRow = (bottomY+entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[bottomRow][leftCol];
                tileNum2 = gamePanel.tileManager.mapTileNum[bottomRow][rightCol];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                    entity.collisionOn = true;

            }
            case "right" -> {
                rightCol = (rightX + entity.speed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[topRow][rightCol];
                tileNum2 = gamePanel.tileManager.mapTileNum[bottomRow][rightCol];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                    entity.collisionOn = true;

            }
            case "left" -> {
                leftCol = (leftX - entity.speed)/ gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[topRow][leftCol];
                tileNum2 = gamePanel.tileManager.mapTileNum[bottomRow][leftCol];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                    entity.collisionOn = true;
            }
        }
    }
}
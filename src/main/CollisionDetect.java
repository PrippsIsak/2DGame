package main;

import entity.Entity;

public class CollisionDetect
{
    GamePanel gamePanel;
    public CollisionDetect(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity)
    {
        //where in the world our solid part is
        int leftX = entity.worldX + entity.solidPart.x;
        int rightX = entity.worldX + entity.solidPart.x + entity.solidPart.width;
        int topY = entity.worldY + entity.solidPart.y;
        int bottomY = entity.worldY + entity.solidPart.y + entity.solidPart.height;

        int leftCol = leftX/gamePanel.tileSize;
        int rightCol =  rightX/gamePanel.tileSize;
        int topRow = topY/ gamePanel.tileSize;
        int bottomRow = bottomY/ gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction)
        {
            case "up" -> {
                topRow = (topY - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[leftCol][topRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[rightCol][topRow];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                bottomRow = (bottomY + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[leftCol][bottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[rightCol][bottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                rightCol = (rightX + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[rightCol][topRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[rightCol][bottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }

            }
            case "left" -> {
                leftCol = (leftX - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[leftCol][topRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[leftCol][bottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision)
                {
                    entity.collisionOn = true;
                }
            }
        }
    }
}

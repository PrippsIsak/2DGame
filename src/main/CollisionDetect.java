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
    public int checkObject(Entity entity, boolean player)
    {
        int index = 999;

        for(int i = 0; i < gamePanel.object.length; i++)
        {
            if(gamePanel.object[i] != null)
            {
//                Entitys solid area pos
                entity.solidPart.x = entity.worldX + entity.solidPart.x;
                entity.solidPart.y = entity.worldY + entity.solidPart.y;
//                object solid area pos
                gamePanel.object[i].solidPart.x = gamePanel.object[i].worldX + gamePanel.object[i].solidPart.x;
                gamePanel.object[i].solidPart.y = gamePanel.object[i].worldY + gamePanel.object[i].solidPart.y;

                switch(entity.direction)
                {
                    case "up" ->
                            {
                                entity.solidPart.y -= entity.speed;
                                if(entity.solidPart.intersects(gamePanel.object[i].solidPart))
                                {
                                    if(gamePanel.object[i].collision)
                                        entity.collisionOn = true;
                                    if(player)
                                        index = i;
                                }
                            }
                    case "down" ->
                            {
                                entity.solidPart.y += entity.speed;
                                if(entity.solidPart.intersects(gamePanel.object[i].solidPart))
                                {
                                    if(gamePanel.object[i].collision)
                                        entity.collisionOn = true;
                                    if(player)
                                        index = i;
                                }
                            }
                    case "right" ->
                            {
                                entity.solidPart.x += entity.speed;
                                if(entity.solidPart.intersects(gamePanel.object[i].solidPart))
                                {
                                    if(gamePanel.object[i].collision)
                                        entity.collisionOn = true;
                                    if(player)
                                        index = i;
                                }
                            }
                    case "left" ->
                            {
                                entity.solidPart.x -= entity.speed;
                                if(entity.solidPart.intersects(gamePanel.object[i].solidPart))
                                {
                                    if(gamePanel.object[i].collision)
                                        entity.collisionOn = true;
                                    if(player)
                                        index = i;
                                }
                            }
                }
                entity.solidPart.x = entity.solidAreaDefaultX;
                entity.solidPart.y = entity.solidAreaDefaultY;
                gamePanel.object[i].solidPart.x = gamePanel.object[i].solidAreaDefaultX;
                gamePanel.object[i].solidPart.y = gamePanel.object[i].solidAreaDefaultY;

            }
        }
        return index;
    }
}
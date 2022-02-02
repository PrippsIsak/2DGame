package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;

    public  TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        tile = new Tile[48];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldMap01.txt");
    }
    public void loadMap(String pathToMap)
    {
        try{
            InputStream inputStream = getClass().getResourceAsStream(pathToMap);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol)
            {
                String line = bufferedReader.readLine();
                while (row < gamePanel.maxWorldRow)
                {
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[row]);
                    mapTileNum[col][row] = num;
                    row++;
                }
                col++;
                row = 0;
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] paths_to_tiles =
    {
        "/tiles/earth.png",
        "/tiles/tree.png",
        "/tiles/wall.png",
        "/tiles/water00.png",
        "/tiles/road00.png",
        "/tiles/grass00.png","/tiles/grass01.png",
        "/tiles/road01.png",
        "/tiles/road02.png","/tiles/road03.png","/tiles/road04.png","/tiles/road05.png",
        "/tiles/road06.png","/tiles/road07.png","/tiles/road08.png","/tiles/road09.png",
        "/tiles/road10.png","/tiles/road11.png","/tiles/road12.png",
        "/tiles/water01.png","/tiles/water02.png","/tiles/water03.png",
        "/tiles/water04.png","/tiles/water05.png","/tiles/water06.png","/tiles/water07.png",
        "/tiles/water08.png","/tiles/water09.png","/tiles/water10.png", "/tiles/water11.png",
        "/tiles/water12.png","/tiles/water13.png"



    };
    public void getTileImage()
    {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[0]));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[1]));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[2]));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[3]));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[4]));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[5]));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[6]));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[7]));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[8]));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[9]));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[10]));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[11]));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[12]));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[13]));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[14]));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[15]));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[16]));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[17]));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[18]));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[19]));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[20]));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[21]));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[22]));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[23]));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[24]));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[25]));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[26]));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[27]));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[28]));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[29]));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[30]));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[31]));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D)
    {
        int worldCol = 0;
        int worldRow = 0;

        while (worldRow < gamePanel.maxWorldRow)
        {
            int typeTile = mapTileNum[worldCol][worldRow];

            //setting the screen
            int worldX = worldRow * gamePanel.tileSize;
            int worldY = worldCol * gamePanel.tileSize;
            int screenX =worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            //boundaries to just draw tiles around the player
            if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) //->
                    graphics2D.drawImage(tile[typeTile].image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize,null);

            worldCol++;
            if(worldCol == gamePanel.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
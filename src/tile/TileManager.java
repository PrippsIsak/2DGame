package tile;

import main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    gamePanel gamePanel;
    Tile[] tile;
    int mapTileNum[][];

    public  TileManager(gamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap();
    }
    public void loadMap()
    {
        try{
            InputStream inputStream = getClass().getResourceAsStream("/maps/map1.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while (row < gamePanel.maxScreenRow  && col < gamePanel.maxScreenCol)
            {
                String line = bufferedReader.readLine();
                while (col < gamePanel.maxScreenCol)
                {
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gamePanel.maxScreenCol)
                {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] paths_to_tiles =
    {
        "/tiles/grass01.png",
        "/tiles/wall.png",
        "/tiles/water00.png"
    };
    public void getTileImage()
    {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[0]));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[1]));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream(paths_to_tiles[2]));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D)
    {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (row < gamePanel.maxScreenRow)
        {
            int typeTile = mapTileNum[col][row];

            graphics2D.drawImage(tile[typeTile].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
            col++;
            x += gamePanel.tileSize;

            if(col == gamePanel.maxScreenCol)
            {
                col = 0;
                x = 0;
                y += gamePanel.tileSize;
                row++;
            }
        }
    }
}

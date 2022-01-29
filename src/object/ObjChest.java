package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjChest extends superObject
{
    public ObjChest()
    {
        name = "Chest";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/chest.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

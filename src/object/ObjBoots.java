package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBoots extends superObject
{
    public ObjBoots()
    {
        name = "Boots";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/boots.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

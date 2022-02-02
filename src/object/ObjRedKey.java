package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjRedKey extends  superObject
{
    public ObjRedKey()
    {
        name = "RedKey";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/redkey.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

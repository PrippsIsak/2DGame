package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBlueKey extends superObject
{
    public ObjBlueKey()
    {
        name = "BlueKey";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/bluekey.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

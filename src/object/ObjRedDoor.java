package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjRedDoor extends superObject
{
    public ObjRedDoor()
    {
        name = "RedDoor";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/reddoor.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

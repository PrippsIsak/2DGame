package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBlueDoor extends superObject
{
    public ObjBlueDoor()
    {
        name = "BlueDoor";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/bluedoor.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjDoor extends  superObject
{
    public ObjDoor()
    {
        name = "Door";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/door.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

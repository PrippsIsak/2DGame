package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjLundgrens extends superObject
{

    public ObjLundgrens()
    {
        name = "Lundgrens";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/lundgrens.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}

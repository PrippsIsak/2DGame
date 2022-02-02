package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjKey extends superObject
{
     public ObjKey()
     {
         name = "Key";

         try
         {
          image = ImageIO.read(getClass().getResourceAsStream("/maps/objects/key.png"));
         }catch (IOException e)
         {
             e.printStackTrace();
         }
         collision = true;
    }
}

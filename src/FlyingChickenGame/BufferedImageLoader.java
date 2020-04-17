package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * ANCHOR BufferedImageLoader Class --------------------------------
 * TODO Class Usage.
 */
public class BufferedImageLoader {

    // Attributes. -------------
    private BufferedImage image;

    // SECTION loadImage() Method ---------------------------------
    public BufferedImage loadImage(String path) throws IOException{
        image = ImageIO.read(getClass().getResource(path));
        return image;
    }
}
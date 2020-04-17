package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.image.BufferedImage;

/**
 * ANCHOR SpriteSheet Class ---------------------------------------------------------------
 */
public class SpriteSheet {

    // Attribute. --------------
    private BufferedImage image;

    // SECTION SPRITESHEET COTR --------------------------------------------------
    public SpriteSheet(BufferedImage bufferedImage){ this.image = bufferedImage; }

    // SECTION METHOD --------------------------------------------------------------------
    public BufferedImage grabImage(int column, int row, int width, int height){
        BufferedImage img = image.getSubimage((column*32-32), (row*32-32), width, height);
        return img;
    }
}
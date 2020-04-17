package FlyingChickenGame;

/* Imports ---------------- */
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * ANCHOR Sprite Class ---------------------
 */
public class Sprite {

    // Attributes. ------------
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    // SECTION SPRITE COTR ------
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    /* SECTION METHODS ---------------------------------------------------------------------------- */
    protected void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    // Getters and Setters -------------------------------------------------------
    public Image getImage() { return image; }

    public int getX() { return x; }

    public int getY() { return y; }

    public boolean isVisible() { return visible; }

    public void setVisible(Boolean visible) { this.visible = visible; }

    public Rectangle getBounds() { return new Rectangle(x, y, width, height); }
}

package FlyingChickenGame;

/* Imports ------------- */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
// import java.awt.image.BufferedImage;

/**
 * ANCHOR EnemyCat Class First Type -------------------------------------------
 * EnemyCat: Game Object for Enemy / Cat.
 */
public class EnemyCat extends GameObject {

    // TODO Image Implementation. -------------------------------------------
    // private BufferedImage enemyCatImage;

    // SECTION ENEMYCAT COTR ------------------------------------------------
    public EnemyCat(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        // TODO SpriteSheet spriteSheet = new SpriteSheet(Game.spriteSheet);
        // enemyCatImage = spriteSheet.grabImage(2, 1, 30, 15);

        speedX = 1.5f; // Speed of EnemyCat --------------------------------
    } // -------------------------------------------------------------------

    /* SECTION METHODS -------------------------------------------------- */
    // Bounce() Method not Override.
    @Override
    public void tick() {
        xCoordinate += speedX;
        yCoordinate += speedY;

        bounce(); // Method that I wrote, To cat to go back and forth.

        // Clamping.
        xCoordinate = Game.clamp(xCoordinate, 0, Game.WIDTH - 36);
        yCoordinate = Game.clamp(yCoordinate, 0, Game.HEIGHT - 43);

    } // ------------------------------------------------------------------

    @Override
    public void render(Graphics graphics) {
        // graphics.drawImage(enemyCatImage, xCoordinate, yCoordinate, null);
        graphics.setColor(Color.RED); // Cat's rectangle.
        graphics.fillRect((int)xCoordinate, (int)yCoordinate, 30, 15); // Cat's Size.
    } // ----------------------------------------------------------------------------

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)xCoordinate, (int)yCoordinate, 30, 15);
    } // ----------------------------------------------------------------

    private void bounce() {
        if (xCoordinate <= 0 || xCoordinate >= Game.WIDTH - 36)
            speedX *= -1;
    } // ----------------------------------------------------------------
}
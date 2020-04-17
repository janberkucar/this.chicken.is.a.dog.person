package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * ANCHOR Basket Object Class --------------------------------
 */
public class Basket extends GameObject {

    // Other Classes Attributes.
    Handler handler;
    RandomEntity randomEntity = new RandomEntity();

    // SECTION BASKET COTR ----------------------------------
    public Basket(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    /* SECTION METHODS ---------------------------------------------------------------------------- */
    // Collsion() not Override.

    @Override
    public void tick() {
        // Prevents the PlayerChicken from going beyond the frame.
        xCoordinate = Game.clamp(xCoordinate, 0, Game.WIDTH - 37);
        yCoordinate = Game.clamp(yCoordinate, 0, Game.HEIGHT - 60);

        if(yCoordinate <= 200)
            yCoordinate = 200;

        collision();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect((int) xCoordinate, (int) yCoordinate, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) xCoordinate, (int) yCoordinate, 16, 16);
    }

    /** SECTION Collision Method that I wrote. -------------------------------
     * Needs a REVIEW
     */
    private void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {

            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Egg) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // STUB Collision code goes here. 
                    handler.removeObject(this);
                    randomEntity.CreateRandomEntity(handler, 1, ID.Target);
                    handler.killCount += 1;
                }
            }
        }
    } // End of Collision() Methodç -----------------------------------------

} // END OF BASKET CLASS ----------------------------------------------------------


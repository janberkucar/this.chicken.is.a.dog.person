package FlyingChickenGame;

/* Imports ------------- */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


/**
 *  ANCHOR PlayerChicken Class 
 */
public class PlayerChicken extends GameObject {

    // Other Classes Attributes.
    Handler handler;
    Random random = new Random();

    // SECTION PLAYERCHICKEN COTR --------------------------------------------------
    public PlayerChicken(int xCoordinate, int yCoordinate, ID id, Handler handler) {
        super(xCoordinate, yCoordinate, id);
        this.handler = handler;
    } // end of PlayerChicken constructor


    /* SECTION METHODS ---------------------------------------------------------------------------- */
    // Method that returns the bounds of the PlayerChicken. ---------------
    public Rectangle getBounds() {
        return new Rectangle((int) xCoordinate, (int) yCoordinate, 32, 32);
    }

    public void tick() {
        xCoordinate += speedX;
        yCoordinate += speedY;
        speedY += 0.5f;

        if (shoot) {
            handler.addObject(new GoldenEgg((int) xCoordinate + 48, (int) yCoordinate + 48, ID.Egg, handler));
            shoot = false;
        }

        // Prevents the PlayerChicken from going beyond the frame.
        xCoordinate = Game.clamp(xCoordinate, 0, Game.WIDTH - 37);
        yCoordinate = Game.clamp(yCoordinate, 0, Game.HEIGHT - 60);

        if (yCoordinate <= 120) { yCoordinate = 120; }

        collision();
        
    } // end of tick() method

    private void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {

            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Enemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code
                    HUD.HEALTH -= 1;
                }
            }

            if (tempObject.getId() == ID.Target) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code
                    HUD.HEALTH += 1;
                }
            }

        }
    }

    public void render(Graphics graphics) {
        // Draws the PlayerChicken.
        graphics.setColor(Color.white);
        graphics.fillRect((int) xCoordinate, (int) yCoordinate, 32, 32);
    } // end of render() method
} // end of PlayerChicken class

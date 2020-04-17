package FlyingChickenGame;

/* Imports ------------- */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * ANCHOR GoldenEgg Class -----------------------------------------------------
 * Weapon Type of player. 
 */
public class GoldenEgg extends GameObject {
 
  // Other Classes Attributes.
  private Handler handler;
  Random random = new Random();

  // SECTION GOLDENEGG CLASS --------------------------------------------------
  public GoldenEgg(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;
    
    speedX = (random.nextInt(8 - -8) + -8); // Random number between -5 and 5
  } //End of BasicEnemy constructor
  

  /* SECTION METHODS ---------------------------------------------------------------------------- */

  public Rectangle getBounds(){ return new Rectangle((int)xCoordinate, (int)yCoordinate, 16, 16); }
 
  public void tick() {
    //With every "tick", the object will move by calculation.
    if(speedX < 0)
        speedX = Game.clamp(speedX, -4, -8);
    if(speedX > 0)
        speedX = Game.clamp(speedX, 4, 8);
    if(speedX == 0)
        speedX = 4;
    
    xCoordinate += speedX;
    
    //Once the bullet hits the maximum size of the frame, it will be removed 
    if(yCoordinate >= Game.HEIGHT || yCoordinate < 0 || xCoordinate >= Game.HEIGHT || xCoordinate < 0)
      handler.removeObject(this);
    
  } //end of tick() method
 
  public void render(Graphics graphics) {
    graphics.setColor(Color.red);
    graphics.fillRect((int)xCoordinate, (int)yCoordinate, 16, 16);
  } //end of render() method
 
} //end of BasicEnemy class

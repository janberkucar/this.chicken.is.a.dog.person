package FlyingChickenGame;

/* Imports ------------ */
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * ANCHOR GameObject Class Object --------------------------------------------
 * GameObject: Abstract class for our Objects. All the game objects born here.
 */
public abstract class GameObject {

    // Attributes. --------------------------
    protected float xCoordinate, yCoordinate;
    protected ID idOfEntity;
    protected float speedX, speedY;
    protected boolean shoot;
    protected int killCount = 0;
    // --------------------------------------

    // SECTION GAMEOBJECT COTR ------------------
    // Base interface cotr for our objects.
    public GameObject(float x, float y, ID id) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.idOfEntity = id;
    } // ----------------------------------------


    /* SECTION METHODS -------------------------------------------------- */
    // Abstract Methods ------------------------------
    public abstract void tick();

    public abstract void render(Graphics graphics);

    public abstract Rectangle getBounds();
    // -----------------------------------------------

    // Getters and Setters ---------------------------------------
    public void setX(float x) { this.xCoordinate = x; }

    public void setY(float y) { this.yCoordinate = y; }

    public void setId(ID id) { this.idOfEntity = id; }

    public void setSpeedX(float speedx) { this.speedX = speedx; }

    public void setSpeedY(float speedy) { this.speedY = speedy; }

    public void setShoot(){ shoot = true; }

    public void setKill(){ killCount++; }

    public float getX() { return xCoordinate; }

    public float getY() { return yCoordinate; }

    public ID getId() { return idOfEntity; }

    public float getSpeedX() { return speedX; }

    public boolean getShoot(){ return shoot; }

    public int getKill(){ return killCount; }

    public float getSpeedY(){ return speedY; } 
    // ----------------------------------------------------------
}
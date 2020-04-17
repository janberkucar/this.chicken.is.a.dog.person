package FlyingChickenGame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * ANCHOR Handler Class Object ----------------------------------------------------------------------------------------
 */
public class Handler {

    // Attributes. ---------------------------------------------------
    public int killCount = 0;
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();


    /* SECTION METHODS ---------------------------------------------------------------------------- */

    public void tick() {
        // Loops through every single game object
        for (int i = 0; i < gameObjects.size(); i++) {
            // NOTE Object.get() is a function within the LinkedList.
            // It loops through.
            // And gets what is in the list.
            GameObject tempObject = gameObjects.get(i);// 
            tempObject.tick();
        } // end of for loop
    } // end of tick() method

    public void render(Graphics graphics) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(graphics);
        } // end of for loop
    } // end of render() method

    public void clearEnemy() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            // Clears all objects and places the player back where the player was at
            if (tempObject.getId() == ID.Player) {
                gameObjects.clear();
                if (Game.gameState != Game.STATE.End) {
                    addObject(new PlayerChicken((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
                    addObject(new Basket((int) tempObject.getX(), (int) tempObject.getY(), ID.Target, this));
                }
            }
        }
    }

    // Adds objects to the object LinkedList
    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    } // end of addObject() method
      // Removes objects from the object LinkedList

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    } // end of removeObject() method
} // end of Handler class

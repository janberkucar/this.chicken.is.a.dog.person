package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ANCHOR KeyInput Class -----------------------
 */


public class KeyInput extends KeyAdapter {

    // Attributes -----------------------------
    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    // SECTION KEYINPUT COTR ------------------
    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    } // end of KeyInput constructor


    /* SECTION METHODS ---------------------------------------------------------------------------- */
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        setKeyControlls1(key);
        setKeyControlls2(key);
    } // end of keyPressed() method

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for player 1
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    keyDown[0] = false;
                    // tempObject.setSpeedY(0);
                }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    keyDown[1] = false;
                    // tempObject.setSpeedY(0);
                }
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    keyDown[2] = false;
                    // tempObject.setSpeedX(0);
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    keyDown[3] = false;
                    // tempObject.setSpeedX(0);
                }
                /* Prevents the player's movements from zeroing out. */
                // vertical movement
                if (!keyDown[0] && !keyDown[1])
                    tempObject.setSpeedY(0);
                // horizontal movement
                if (!keyDown[2] && !keyDown[3])
                    tempObject.setSpeedX(0);
            } // end of if statement
        } // end of for loop
    } // end of keyReleased() method

    private void setKeyControlls1(int key) {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for player
                if (key == KeyEvent.VK_W) {
                    tempObject.setSpeedY(-8);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setSpeedY(8);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setSpeedX(8);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setSpeedX(-8);
                    keyDown[3] = true;
                }
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.setShoot();
                }
            } // end of if statement
        } // end of for loop
          // When the player presses the esc button, the program will terminate.
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    private void setKeyControlls2(int key) {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for player
                if (key == KeyEvent.VK_UP) {
                    tempObject.setSpeedY(-8);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setSpeedY(8);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setSpeedX(8);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setSpeedX(-8);
                    keyDown[3] = true;
                }
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.setShoot();
                }
            } // end of if statement
        } // end of for loop
          // When the player presses the esc button, the program will terminate.
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
    }
} // end of KeyInput class

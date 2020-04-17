package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import FlyingChickenGame.Game.STATE;

/**
 * ANCHOR Menu Class ----------------------------------
 */

public class Menu extends MouseAdapter {

    // Other Classes Attributes.
    private Handler handler;
    private HUD hud;
    private int space = 100;

    // SECTION MENU COTR -----------------------------
    public Menu(Game game, Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }


    /* SECTION METHODS ---------------------------------------------------------------------------- */
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.gameState == STATE.Menu) {
            // play button
            if (mouseOver(mx, my, Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30, 200, 60)) { // Check. REVIEW
                Game.gameState = STATE.Game;
                handler.addObject(new PlayerChicken(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemy();
                // TODO RANDOM.
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
            }

            // Quit button. --------------------------------------------------------------------
            if (mouseOver(mx, my, Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30 + space, 200, 60)){
                System.exit(1);
            }
        }

        // Back button for try again. ------------------------------------------------------------------------------
        if (Game.gameState == STATE.End) {
            if (mouseOver(mx, my, Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30 + space, 200, 60)) {
                Game.gameState = STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);
                handler.killCount = 0;
                handler.addObject(new PlayerChicken(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemy();
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
            }
        }

    }

    // NOTE : mx and my means mouse x, mouse y ---------------------------------------------
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        // If mouse x is > x and if mouse x is < x plus the width
        if (mx > x && mx < x + width) {
            // If mouse y is > y and if mouse y is < y plus the height
            if (my > y && my < y + height) {
                return true;
                /*
                 * By returning true, it means that the mouse click was within the x and y
                 * boundaries
                 */
            } else 
                return false;
        } else
            return false;
    }

    public void render(Graphics graphics) {
        if (Game.gameState == STATE.Menu) {
            drawMenu(graphics);
        } else if (Game.gameState == STATE.End) {
            drawGameEnd(graphics);
        }
    }

    private void drawMenu(Graphics graphics) {
        // Menu Background
        graphics.setColor(new Color(13, 34, 51));
        graphics.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        // TODO Logo.
        Font logoHolder = new Font("Arial", Font.BOLD, 100);
        graphics.setColor(Color.WHITE);
        graphics.setFont(logoHolder);
        graphics.drawString("LOGO", Game.WIDTH / 2 - 150, 150);

        // Font ---------------------------------------------------------
        Font font = new Font("TimesRoman", Font.ITALIC & Font.PLAIN, 30);
        graphics.setColor(Color.WHITE);
        graphics.setFont(font);
        
        // INSTRUCTIONS ----------------------------------------------------------------------------------
        Font instructions = new Font("Arial", Font.PLAIN, 15);
        graphics.setColor(Color.WHITE);
        graphics.setFont(instructions);
        graphics.drawString("Shoot Eggs to Cats: SPACE", Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 80);
        graphics.drawString("Movement: WASD or arrow keys", Game.WIDTH / 2 - 105, Game.HEIGHT / 2 - 60);

        // PLAY BUTTON --------------------------------------------------------
        graphics.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30, 200, 60);
        graphics.drawString("PLAY", Game.WIDTH / 2 - 40, Game.HEIGHT / 2 + 10);

        // EXIT BUTTON --------------------------------------------------------
        graphics.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30 + space, 200, 60);
        graphics.drawString("EXIT", Game.WIDTH / 2 - 35, Game.HEIGHT / 2 + 10 + space);
    } // ------------------------------------------------------------------------------------------------

    private void drawGameEnd(Graphics graphics) {
        Font fontMessage = new Font("arial", 1, 23);
        Font fontAgain = new Font("arial", Font.PLAIN, 30);
        Font fontScore = new Font("arial", Font.PLAIN, 20);

        graphics.setColor(Color.white);
        
        // Game Over Message -------------------------------------------------------------------------
        graphics.setFont(fontMessage);
        graphics.drawString("NO WINNER, CHICKEN DINNER", Game.WIDTH / 2 - 175, Game.HEIGHT / 2 - 100);

        // Score Message -----------------------------------------------------------------------------
        graphics.setFont(fontScore);
        graphics.drawString("You lost with a score of: " + hud.getScore(), Game.WIDTH / 2 - 130, 265);

        // Try Again Button  ----------------------------------------------------------------
        graphics.setFont(fontAgain);
        graphics.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30 + space, 200, 60);
        graphics.drawString("TRY AGAIN", Game.WIDTH / 2 - 80, Game.HEIGHT / 2 + 10 + space);
    }
}
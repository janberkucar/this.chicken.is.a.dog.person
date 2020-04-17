package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.Color;
import java.awt.Graphics;

/**
 * ANCHOR HUD Class Object ------------------------------------------------------
 */

public class HUD {

    // Attributes --------------------
    public static float HEALTH = 120;
    private float colorValue = 255;

    private int score = 0;
    private int scoreKeep = 0;
    private int level = 1;


    // SECTION GAME COTR ------------------------------------------------------------------------------
    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 120); // Caps the health between 0 and 100
        colorValue = Game.clamp(colorValue, 0, 255);
        colorValue = HEALTH * 2;

        if (scoreKeep >= 0) {
            scoreKeep = getScore();
            setLevel(scoreKeep/200 + 1 );
            scoreKeep = 0;
        }
    } // end of tick() method

    public void render(Graphics graphics) { // TODO On Graphics. ------------------------------
        graphics.setColor(Color.gray);
        graphics.drawString("Your Health: " + (int)HEALTH, Game.WIDTH/2-40, 25);
        graphics.fillRect(Game.WIDTH/2-120, 40, 240, 30);
        graphics.setColor(new Color(75, (int) colorValue, 0));
        graphics.fillRect(Game.WIDTH/2-120, 40, (int) HEALTH * 2, 30); // The health bar itself
        graphics.setColor(Color.white);
        graphics.drawRect(Game.WIDTH/2-120, 40, 240, 30); // White border around health bar

        graphics.drawString("Score: " + score, 15, 100);
        graphics.drawString("Level: " + level, Game.WIDTH-75, 100);

        /*
         * if(HEALTH == 0){ g.setColor(Color.BLACK); g.fillRect(0, 0, Game.WIDTH,
         * Game.HEIGHT); g.setColor(Color.white); g.drawString("GAME OVER", (Game.WIDTH
         * / 2) - 40, 150); level--; } //end of if
         * 
         * if(level > 40){ g.setColor(Color.BLACK); g.fillRect(0, 0, Game.WIDTH,
         * Game.HEIGHT); g.setColor(Color.white); g.drawString("YOU ARE A WINNER",
         * (Game.WIDTH / 2) - 40, 150); } // end of if
         */
    } // end of render() method

    // Getters and Setters --------------------------------
    public void setScore(int score) { this.score = score; }

    public int getScore() { return score; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }
} // end of HUD class
package FlyingChickenGame;

/* Imports ----------------------- */
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * ANCHOR Main Game Class ---------------------------------------------------------------------------------
 */

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    // STUB Game height and weight ----------------------------
    public static final int WIDTH = 750 / 2, HEIGHT = 1334 / 2;

    /** NOTE
     * How Entire game runs.
     * Single Threaded Game.
     */
    private Thread thread; 

    private boolean running = false;

    // Other Classes Attributes.
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    // State of the Window.
    public enum STATE { Menu, Game, End };

    // Booting in Menu State at first run.
    public static STATE gameState = STATE.Menu;

    // SECTION GAME COTR ------------------------------------------------------------------------------
    public Game() {

        // Creating essentials. -------------
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler, hud);

        // Adding Input Listeners ------------------
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        // STUB Window init. Title of the window goes here. -------------
        new Window(WIDTH, HEIGHT, "This Chicken Is A Dog Person!", this);

        // Spawning Handled here. --------------------------------------------------------------------
        spawner = new Spawn(handler, hud);
        if (gameState == STATE.Game) {
            handler.addObject(new PlayerChicken(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new EnemyCat(WIDTH / 2 - 32, HEIGHT / 2, ID.Enemy, handler));
            handler.addObject(new Basket(WIDTH/2 - 32, HEIGHT / 2 - 32, ID.Target, handler));
        }
    } // END COTR ------------------------------------------------------------------------------------

    /* SECTION METHODS ---------------------------------------------------------------------------- */
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start(); // Starts the thread.
        running = true;// The thread is running.
    } // End of start() method -----------------


    public synchronized void stop() {
        // If it can run, then run. If not, then print the exception error.
        try {
            thread.join();
            running = false; // Indicates the thread is not running.
        } catch (Exception e) {
            e.printStackTrace();
        } // End of try-catch
    } // End of stop() method ----------------------------------------------


    // SECTION RUN METHOD IN HERE --------------------------------------------------------------------------
    // Game Loop: A loop that keeps a game running over and over again.
    // I,e Until the user closes it
    public void run() {
        this.requestFocus(); // Allows key control input to happen automatically rather than having to click
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        // int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            } // End of while
            if (running)
                render();
            // frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                // frames = 0;
            } // End of if
        } // End of while
        stop();
    } // End of run() method ------------------------------------------------------------------------------


    // Updates the properties of the game itself.
    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
            spawner.tick();

            if (HUD.HEALTH <= 0) {
                // STUB Game End Logic.
                HUD.HEALTH = 120; // Default Healt State.
                gameState = STATE.End;
                handler.clearEnemy();
            }
            
        }
    } // End of tick() method

    // Displays the updates that were made from the tick method.
    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3); // How many buffers is created.
            return;
        } // End of if

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(new Color(15,15,15)); // TODO Background.
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(graphics); // Renders all of the game objects from handler class.

        if (gameState == STATE.Game) {
            hud.render(graphics); // Eenders hud class, the hud will be on top of the game objects.
        } else if (gameState == STATE.Menu || gameState == STATE.End) {
            menu.render(graphics);
        }

        graphics.dispose();
        bufferStrategy.show();
    } // End of renders() method. -----------------------------------------------------------------

    /** 
     * NOTE ----------------------------------------------------------------------
     * Say the var is the x value. If x is greater than the max (room width), then
     * return var as the room width. This will prevent the player from leaving the
     * width of the frame. The min would be the room height.
     */
    public static float clamp(float var, float min, float max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    } // End of clamp() method

    // SECTION Main method. -----------------
    public static void main(String args[]) {
        new Game();
    } // End of main method
} // End of Game class ----------------------------------------------------------------------------

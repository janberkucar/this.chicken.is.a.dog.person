package FlyingChickenGame;

/* Imports ------------ */
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

/** 
 * ANCHOR Window Class ---------------------------------------------------------------------
 * Window: This class' purpose is the create window for the FlyingChickenGame.
 */

public class Window extends Canvas {

    
    // Attribute: Creating SerialVersionUID randomlu.
    private static final long serialVersionUID = 8479484483451754512L;

    // SECTION WINDOW COTR ----------------------------------------
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title); // Frame of our Window.

        SetSizes(frame, width, height); // Setting Sizes.
        SetMyWindow(frame); // Setting Window.

        frame.add(game);
        game.start();
    }


    /* SECTION METHODS ---------------------------------------------------------------------------- */
    private void SetSizes(JFrame frame, int w, int h) {
        frame.setPreferredSize(new Dimension(w, h));
        frame.setMaximumSize(new Dimension(w, h));
        frame.setMinimumSize(new Dimension(w, h));
    } // ----------------------------------------------

    private void SetMyWindow(JFrame frame) {
        // Closing Operation.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } // ----------------------------------------------------
}

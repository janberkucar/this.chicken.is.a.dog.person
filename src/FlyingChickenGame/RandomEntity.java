package FlyingChickenGame;

/* Imports ----------- */
import java.util.Random;

/**
 * ANCHOR RandomEntity Class -----------------------------------------------------
 * RandomEntity: Class for creating random objects, when needed. I can change
 * the sections from here, making objects and making it cleaner.
 */
public class RandomEntity {

    // Random Value variable.
    private Random randomVal;

    public void CreateRandomEntity(Handler handler, int number, ID id) {
        randomVal = new Random(); // Init Random Variable

        // Bounds. ---------
        // int low = 1;
        // int high = 500;
        // -----------------

        switch (id) { // Switch Case for creating randomVariable ---------------------------------------------------
        case Player:
            System.out.println("You can't have more than one Player!");
            break;
        case Enemy:
            for (int i = 0; i < number; i++) {
                handler.addObject(new EnemyCat(randomVal.nextInt(30), Game.HEIGHT - 48, ID.Enemy, handler));
            }
            break;
        case Target:
            for (int i = 0; i < number; i++) {
                handler.addObject(new Basket(randomVal.nextInt(300), (randomVal.nextInt(480)), ID.Enemy, handler));            }
            break;
        case Egg:
            System.out.println("You don't need to have random eggs!");
            break;
        } // ------------------------------------------------------------------------------------------------------
    }
}
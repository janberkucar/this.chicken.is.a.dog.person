package FlyingChickenGame;

/**
 * ANCHOR Spawn Class --------------------------------------
 */

public class Spawn {

    // Other Classes Attributes.
    private Handler handler;
    private HUD hud;
    private RandomEntity randomEntity = new RandomEntity();

    private int killKeep = 0;
    private boolean[] ok = new boolean[8];

    // SECTION SPAWN COTR ------------------
    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        assignOk();
    }

    /* SECTION METHODS ---------------------------------------------------------------------------- */
    private void assignOk(){
        for (int i = 0; i < 8; i++) {
            ok[i] = true;
        }
    }

    public void tick() { // SECTION LEVEL LOGIC GOES HERE. -------------------------------------------
        if (killKeep >= 0) {
            System.out.println(killKeep + " " + handler.killCount);
            killKeep = handler.killCount;
            hud.setScore(killKeep * 100);
            killKeep = 0;

            if (hud.getLevel() == 2 && ok[0]) {
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[0] = false;
            } else if (hud.getLevel() == 3 && ok[1]) {
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                randomEntity.CreateRandomEntity(handler, 2, ID.Enemy);
             ok[1] = false;
            } else if (hud.getLevel() == 5 && ok[2]) {
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                randomEntity.CreateRandomEntity(handler, 2, ID.Enemy);
                ok[2] = false;
            } else if (hud.getLevel() == 6 && ok[3]) {
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[3] = false;
            } else if (hud.getLevel() == 7 && ok[4]) {
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[4] = false;
            } else if (hud.getLevel() == 13 && ok[5]) {
                handler.clearEnemy();
                randomEntity.CreateRandomEntity(handler, 3, ID.Enemy);
                handler.addObject(new EnemyCat3(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[5] = false;
            
            } else if (hud.getLevel() == 20 && ok[6]) {
                handler.clearEnemy();
                randomEntity.CreateRandomEntity(handler, 2, ID.Enemy);
                randomEntity.CreateRandomEntity(handler, 2, ID.Enemy);
                randomEntity.CreateRandomEntity(handler, 2, ID.Enemy);
                handler.addObject(new EnemyCat3(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[6] = false;
            } else if (hud.getLevel() == 30 && ok[7]) {
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat2(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat3(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat3(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                handler.addObject(new EnemyCat3(Game.WIDTH - 50, Game.HEIGHT / 2, ID.Enemy, handler));
                ok[7] = false;
            }
        }
    }
}
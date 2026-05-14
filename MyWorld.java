import greenfoot.*;

public class MyWorld extends World {


    static final int SMALL = 0;
    static final int MEDIUM = 1;
    static final int LARGE = 2;

    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    static int ASTEROID_SPAWN_RATE = 500;
    static int OUTER_SPAWN_RADIUS = 350; // how far from the center we can spawn asteroids
    int time = 0;

    public MyWorld() {
        super(WIDTH, HEIGHT, 1, false);
        super.setBackground("black_screen.jpeg");
        Ship ship = new Ship();
        addObject(ship, WIDTH / 2, HEIGHT / 2);
        ASTEROID_SPAWN_RATE = 500;
        time = 0;
    }

    public void act() {
        time++;
        if (time % ASTEROID_SPAWN_RATE == 0 || time == 1) {
            spawnAsteroid();
        }
        if(time % 6000 == 0)
        {
            ASTEROID_SPAWN_RATE -= 10;
        }
    }

    private void spawnAsteroid() {
        double direction = Greenfoot.getRandomNumber(360); // random direction in degrees

        int x = WIDTH/2 + (int)(OUTER_SPAWN_RADIUS * Math.cos(Math.toRadians(direction)));
        int y = HEIGHT/2  + (int)(OUTER_SPAWN_RADIUS * Math.sin(Math.toRadians(direction)));
        

        Asteroid asteroid = new Asteroid(x, y, direction-180, LARGE);
        addObject(asteroid, x, y);
    }
}

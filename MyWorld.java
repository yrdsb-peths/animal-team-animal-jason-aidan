import greenfoot.*;

public class MyWorld extends World {

    static int WIDTH = 600;
    static int HEIGHT = 600;
    static int ASTEROID_SPAWN_RATE = 500;
    static int OUTER_SPAWN_RADIUS = 350; // how far from the center we can spawn asteroids
    int time = 0;

    public MyWorld() {
        super(WIDTH, HEIGHT, 1, false);
        super.setBackground("black_screen.jpeg");
        Ship ship = new Ship();
        addObject(ship, WIDTH / 2, HEIGHT / 2);

    }

    public void act() {
        time++;
        if (time % ASTEROID_SPAWN_RATE == 0) {
            spawnAsteroid();
        }
    }

    private void spawnAsteroid() {
        double direction = Greenfoot.getRandomNumber(360); // random direction in degrees

        int x = WIDTH/2 + (int)(OUTER_SPAWN_RADIUS * Math.cos(Math.toRadians(direction)));
        int y = HEIGHT/2  + (int)(OUTER_SPAWN_RADIUS * Math.sin(Math.toRadians(direction)));
        

        Asteroid asteroid = new Asteroid(x, y, direction-180);
        addObject(asteroid, x, y);
    }
}

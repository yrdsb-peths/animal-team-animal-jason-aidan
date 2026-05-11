import greenfoot.*;

public class MyWorld extends World {

    static int ASTEROID_SPAWN_RATE = 10;
    static int invalidSpawnRadius = 150; // how close to the center we can spawn asteroids
    static int outerSpawnRadius = 200; // how far from the center we can spawn asteroids
    int time = 0;

    public MyWorld() {
        super(500, 600, 1, false);
        Ship ship = new Ship();
        addObject(ship, 250, 300);
    }

    public void act() {
        time++;
        if (time % ASTEROID_SPAWN_RATE == 0) {
            spawnAsteroid();
        }
    }

    private void spawnAsteroid() {
        int x = Greenfoot.getRandomNumber(getWidth() + 2 * outerSpawnRadius) - outerSpawnRadius;
        int y = Greenfoot.getRandomNumber(getHeight() + 2 * outerSpawnRadius) - outerSpawnRadius;
        while ((x-getWidth()/2)*(x-getWidth()/2) + (y-getHeight()/2)*(y-getHeight()/2) < invalidSpawnRadius * invalidSpawnRadius)
        {
            // don't spawn too close to the center where the ship is
            x = Greenfoot.getRandomNumber(getWidth() + 2 * outerSpawnRadius) - outerSpawnRadius;
            y = Greenfoot.getRandomNumber(getHeight() + 2 * outerSpawnRadius) - outerSpawnRadius;
        }
        Asteroid asteroid = new Asteroid(x, y);
        addObject(asteroid, x, y);
    }
}

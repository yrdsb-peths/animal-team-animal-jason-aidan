import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int speed = 2;
    int health = 10;
    double direction;
    static int WIDTH = MyWorld.WIDTH;
    static int HEIGHT = MyWorld.HEIGHT;
    
    public Asteroid(int x, int y, double direction)
    {
        GreenfootImage image = new GreenfootImage("asteroid_sprite.png");
        setImage(image);
        image.scale(100,100);
        this.direction = direction;
    }
    public void act()
    {
        // Add your action code here.
        move();
//        getX() * getX() + getY() * getY() > (MyWorld.WIDTH / 2.0 + MyWorld.OUTER_SPAWN_RADIUS) * (MyWorld.WIDTH / 2.0 + MyWorld.OUTER_SPAWN_RADIUS)
        if (health <= 0 || getX() < -100 || getX() > WIDTH+100 || getY() < -100 || getY() > HEIGHT+100)
        {
            getWorld().removeObject(this);
        }

        
    }
    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(speed * Math.cos(radians));
        int dy = (int)(speed * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);

    }

    public void collide()
    {
        if (isTouching(Projectile.class))
        {
            removeTouching(Projectile.class);
            health -= 1;

        }
    }
}

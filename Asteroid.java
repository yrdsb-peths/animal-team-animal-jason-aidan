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
    
    int speed = 3;
    double direction;
    
    static int ANGLE_VARIATION = 30; // how much it varies from center 
    
    public Asteroid(int x, int y, double direction)
    {
        GreenfootImage image = new GreenfootImage("button-green.png");
        setImage(image);
    
        this.direction = direction;
    }
    public void act()
    {
        // Add your action code here.
        move();
        if (getX() * getX() + getY() * getY() > (MyWorld.WIDTH / 2.0 + MyWorld.OUTER_SPAWN_RADIUS) * (MyWorld.WIDTH / 2.0 + MyWorld.OUTER_SPAWN_RADIUS))
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
}

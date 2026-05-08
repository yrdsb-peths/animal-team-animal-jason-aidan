import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    static int SPEED = 5;
    double direction; // in degrees

    public Projectile(double direction)
    {
        this.direction = direction;
        // GreenfootImage image = new GreenfootImage("button-red.png");
        // setImage(image);
        move();

        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }

    
    public void act()
    {
        // Add your action code here.

    }

    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(SPEED * Math.cos(radians));
        int dy = (int)(SPEED * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);

    }

}

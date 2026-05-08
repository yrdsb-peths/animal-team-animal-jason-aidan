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
    static int SPEED = 10;
    double direction = 0; // in radians

    public void act()
    {
        // Add your action code here.

        if (Greentfoot.isKeyDown("space"))
        {
            move();
        }

        if (Greenfoot.isKeyDown("left"))
        {
            direction -= 0.1; // rotate left
        }
        if (Greenfoot.isKeyDown("right"))
        {            
            direction += 0.1; // rotate right
        }
    }

    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(SPEED * Math.cos(radians));
        int dy = (int)(SPEED * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);
    }
}

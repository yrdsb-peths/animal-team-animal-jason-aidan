import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Ship()
    {
        GreenfootImage image = new GreenfootImage("pik.png");
        setImage(image);
    }

    double direction = 270; // in degrees
    double fireCooldown = 0; // time until we can fire again

    static int FIRE_RATE = 10; // cooldown time in act cycles
    static int SPEED = 3;
    static int ROTATION_SPEED = 3;

    public void act()
    {
        // Add your action code here.

        setRotation((int) direction + 90);

        fireCooldown = Math.max(0, fireCooldown - 1);

        if (Greenfoot.isKeyDown("w"))
        {
            if(getX() <= -20)
            {
                setLocation(510, getY());
            }
            if(getX() >= 520)
            {
                setLocation(-10, getY());
            }
            if(getY() <= -20)
            {
                setLocation(getX(), 610);
            }
            if(getY() >= 620)
            {
                setLocation(getX(), 10);
            }
            move();
        }

        if (Greenfoot.isKeyDown("a"))
        {
            direction -= ROTATION_SPEED; // rotate left
        }
        if (Greenfoot.isKeyDown("d"))
        {            
            direction += ROTATION_SPEED; // rotate right
        }

        if (Greenfoot.isKeyDown("space"))
        {
            fire();
        }
    }

    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(SPEED * Math.cos(radians));
        int dy = (int)(SPEED * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);

    }

    public void fire()
    {
        if (fireCooldown > 0)
        {
            return; 
        }
        Projectile projectile = new Projectile((int) direction);
        getWorld().addObject(projectile, getX(), getY());
        fireCooldown = FIRE_RATE; 
    }
}

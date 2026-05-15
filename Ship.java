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
        GreenfootImage image = new GreenfootImage("ship_image_bold.png");
        setImage(image);
    }

    double direction = 270; // in degrees
    double fireCooldown = 0; // time until we can fire again
    boolean practice = false;
    static int FIRE_RATE = 10; // cooldown time in act cycles
    static double SPEED = 0.0;
    static double MAXSPEED = 5.0;
    static int ROTATION_SPEED = 5;

    public void act()
    {
        // Add your action code here.

        setRotation((int) direction + 90);

        fireCooldown = Math.max(0, fireCooldown - 1);
        
        detectPosition();
        
        if (Greenfoot.isKeyDown("w"))
        {
            if(SPEED <= MAXSPEED)
            {
                SPEED += 0.2;
            }
            move();
        } else{
            if(SPEED > 0.0)
            {
                SPEED -= 0.1;
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

        if(Greenfoot.isKeyDown("p"))
        {
            practice = true;
        }
        
        if (isTouching(Asteroid.class) && practice == false)
        {
            MyWorld.loseGame();
        }
    }

    public void detectPosition()
    {
        if(getX() <= -20)
            {
                setLocation((MyWorld.WIDTH)+10, getY());
            }
        if(getX() >= MyWorld.WIDTH + 20)
        {
            setLocation(-10, getY());
        }
        if(getY() <= -20)
        {
            setLocation(getX(), MyWorld.HEIGHT+10);
        }
        if(getY() >= MyWorld.HEIGHT+20)
        {
            setLocation(getX(), -10);
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

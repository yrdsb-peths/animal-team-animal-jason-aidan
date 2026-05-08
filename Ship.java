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
<<<<<<< Updated upstream
    
    public Ship()
    {
        GreenfootImage image = new GreenfootImage("button-green.png");
        setImage(image);
    }
    public void act()
    {
        
=======
    static int SPEED = 10;
    double direction = 0; // angle in degrees

    public void act()
    {
        // Add your action code here.

        if (Greenfoot.isKeyDown("space"))
        {
            move();
        }

        if (Greenfoot.isKeyDown("a"))
        {
            direction -= 1; // rotate left
            System.out.println("Direction: " + direction);
        }
        if (Greenfoot.isKeyDown("d"))
        {            
            direction += 1; // rotate right
            System.out.println("Direction: " + direction);
        }
    }

    public void move()
    {
        double radians = Math.toRadians(direction);
        int dx = (int)(SPEED * Math.cos(radians));
        int dy = (int)(SPEED * Math.sin(radians));
        setLocation(getX() + dx, getY() + dy);
>>>>>>> Stashed changes
    }
}

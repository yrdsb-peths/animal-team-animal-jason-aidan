import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(500, 600, 1);
        Ship ship = new Ship();
        addObject(ship, 300, 200);
    }
}

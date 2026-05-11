import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(500, 600, 1, false);
        super.setBackground("black_screen.jpeg");
        Ship ship = new Ship();
        addObject(ship, 250, 300);
    }
}

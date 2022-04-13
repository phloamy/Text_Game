public class Chicken extends BasicEntity {

    public Chicken(Level.Room room, String name, String description) {
        super(room, name, description);
    }

    @Override
    public void move() {
        moveTo(getCurrentRoom().getRandomNeighbor());
    }

    @Override
    public void act() {
        move();
    }
}

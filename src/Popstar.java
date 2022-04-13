public class Popstar extends BasicEntity {

    public Popstar(Level.Room room, String name, String description) {
        super(room, name, description);
    }

    @Override
    public void move() {
        Level.Room neighboringPlayerRoom = getCurrentRoom().getNeighborThatHasPlayer();

        if (neighboringPlayerRoom != null) {
            moveTo(neighboringPlayerRoom);
        }
    }

    @Override
    public void act() {
        move();
    }
}

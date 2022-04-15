public class Wumpus extends BasicEntity {
    public Wumpus(Level.Room room, String name, String description) {
        super(room, name, description);
    }

    @Override
    public void move() {
        if (getCurrentRoom().neighborsPlayer()) {
            moveTo(getCurrentRoom().getNeighborWithoutPlayer());
        }
    }

    @Override
    public void act() {
        move();
    }
}

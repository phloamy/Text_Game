public class Popstar extends BasicEntity {

    public Popstar(Level.Room room, String name, String description) {
        super(room, name, description);
    }

    @Override
    public void move() {
        if (currentRoom.isNeighboring("Player"))
    }

    @Override
    public void act() {

    }
}

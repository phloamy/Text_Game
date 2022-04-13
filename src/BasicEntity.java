public abstract class BasicEntity implements Entity {
    protected Level.Room currentRoom;
    protected String name, description;

    public Container container;

    public BasicEntity(Level.Room room, String name, String description) {
        this.name = name;
        this.description = description;
        this.container = new Container();
        moveTo(room);
    }

    public boolean moveTo(String roomName) {
        Level.Room newRoom = currentRoom.getNeighbor(roomName);
        return moveTo(newRoom);
    }

    public boolean moveTo(Level.Room room) {
        if (room != null) {
            if (currentRoom != null) {
                currentRoom.removeEntity(this);
            }
            currentRoom = room;
            room.addEntity(this);
            return true;
        }

        return false;
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

public abstract class BasicEntity implements Entity {
    private Level.Room currentRoom;
    protected String name, description;

    public Container container;

    public BasicEntity(Level.Room room, String name, String description) {
        this.name = name;
        this.description = description;
        this.container = new Container();
        room.getLevel().addEntity(this);
        moveTo(room);
    }

    public boolean moveTo(String roomName) {
        Level.Room newRoom = currentRoom.getNeighbor(roomName);
        return moveTo(newRoom);
    }

    public boolean moveTo(Level.Room room) {
        if (room == null) return false;

        if (currentRoom != null) {
            currentRoom.removeEntity(this);
        }
        currentRoom = room;
        room.addEntity(this);
        return true;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

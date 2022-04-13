public abstract class BasicEntity extends Container implements Entity {
    Level.Room currentRoom;
    String name, description;

    public BasicEntity(Level.Room room, String name, String description) {
        this.name = name;
        this.description = description;
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

public abstract class BasicEntity extends Container implements Entity {
    Level.Room currentRoom;
    String name, description;

    public BasicEntity(Level.Room room, String name, String description) {
        this.currentRoom = room;
        this.name = name;
        this.description = description;
    }

    public boolean moveTo(String roomName) {
        Level.Room newRoom = currentRoom.getNeighbor(roomName);

        if (newRoom != null) {
            currentRoom = newRoom;
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
}

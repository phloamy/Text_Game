import java.util.ArrayList;
import java.util.List;

public class Player {
    private Level.Room currentRoom;
    private Container container;
    public Player(Level.Room room) {
        this.container = new Container();
        moveTo(room);
    }

    public boolean pickUp(String itemName) {
        Item picked = currentRoom.removeItem(itemName);

        if (picked != null) {
            container.items.add(picked);
            return true;
        }

        return false;
    }

    public boolean drop(String itemName) {
        Item item = container.removeItem(itemName);

        if (item != null) {
            currentRoom.addItem(item);
            return true;
        }

        return false;
    }

    private boolean moveTo(Level.Room room) {
        if (room != null) {
            if (currentRoom != null) {
                currentRoom.removePlayer();
            }
            currentRoom = room;
            room.addPlayer();
            return true;
        }

        return false;
    }

    public boolean moveTo(String roomName) {
        return moveTo(currentRoom.getNeighbor(roomName));
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Container getContainer() {
        return container;
    }
}

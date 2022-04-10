import java.util.ArrayList;
import java.util.List;

public class Player extends Container {
    private Level.Room currentRoom;

    public Player(Level.Room room) {
        currentRoom = room;
    }

    public boolean pickUp(String itemName) {
        Item picked = currentRoom.removeItem(itemName);

        if (picked != null) {
            items.add(picked);
            return true;
        }

        return false;
    }

    public boolean drop(String itemName) {
        Item item = removeItem(itemName);

        if (item != null) {
            currentRoom.addItem(item);
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

    public boolean moveTo(String roomName) {
        Level.Room newRoom = currentRoom.getNeighbor(roomName);

        if (newRoom != null) {
            currentRoom = newRoom;
            return true;
        }

        return false;
    }
}

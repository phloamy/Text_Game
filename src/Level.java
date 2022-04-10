import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Room> rooms;

    public Level() {
        rooms = new ArrayList<>();
    }

    public Room addRoom(String name) {
        Room room = new Room(name);
        rooms.add(room);
        return room;
    }

    public void addUndirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);

        if (n1 != null && n2 != null) {
            n1.addNeighbor(n2);
            n2.addNeighbor(n1);
        }
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);

        if (n1 != null && n2 != null) {
            n1.addNeighbor(n2);
        }
    }

    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) return room;
        }

        return null;
    }

    public class Room extends Container {
        private String name;
        private ArrayList<Room> neighbors;

        private Room(String name) {
            neighbors = new ArrayList<>();
            this.name = name;
        }

        private Room addTwoDirectionNeighbor(Room room) {
            addNeighbor(room);
            room.addNeighbor(this);
            return room;
        }

        private Room addNeighbor(Room room) {
            neighbors.add(room);
            return room;
        }

        public String getNeighborNames() {
            if (neighbors.size() == 0) return "";

            StringBuilder stringBuilder = new StringBuilder();

            for (Room neighbor : neighbors) {
                stringBuilder.append(neighbor.getName());
                stringBuilder.append(", ");
            }

            return stringBuilder.substring(0, stringBuilder.length() - 2);
        }

        public Room getNeighbor(String name) {
            for (Room neighbor : neighbors) {
                if (neighbor.getName().equals(name)) return neighbor;
            }
            return null;
        }

        public String getName() {
            return name;
        }
    }
}

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
        private List<Room> neighbors;
        private List<Entity> entities;
        private boolean hasPlayer;

        private Room(String name) {
            neighbors = new ArrayList<>();
            entities = new ArrayList<>();
            this.name = name;
            hasPlayer = false;
        }

        public void addPlayer() {
            player
        }

        public boolean neighborsPlayer() {
            for (Room room : neighbors) {
                if (room.containsPlayer()) return true;
            }
            return false;
        }

        public boolean containsPlayer() {
            return hasPlayer;
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

        public Room getRandomNeighbor() {
            int rand = (int) (Math.random() * neighbors.size());
            return neighbors.get(rand);
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

        public boolean isNeighboringEntity(String name) {
            for (Room room : neighbors) {
                if (room.hasEntity(name)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasPlayer() {
            return hasPlayer;
        }
    }
}

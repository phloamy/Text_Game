import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Room> rooms;
    private List<Entity> entities;

    public Level() {
        rooms = new ArrayList<>();
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        if (entity != null) {
            entities.add(entity);
        }
    }

    public Room addRoom(String name) {
        Room room = new Room(name);
        rooms.add(room);
        room.setLevel(this);
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

    public void updateEntities() {
        for (Entity entity : entities) {
            entity.act();
        }
    }

    public class Room extends Container {
        private Level level;
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

        public void setLevel(Level level) {
            this.level = level;
        }

        public void addPlayer() {
            hasPlayer = true;
        }

        public void removePlayer() {
            hasPlayer = false;
        }

        public void addEntity(Entity entity) {
            if (entity != null) {
                entities.add(entity);
            }
        }

        public boolean removeEntity(Entity entity) {
            if (entity != null && hasEntity(entity)) {
                return entities.remove(entity);
            }

            return false;
        }

        public boolean hasPlayer() {
            return hasPlayer;
        }

        public boolean hasEntity(Entity entity) {
            return entities.contains(entity);
        }

        public Room getNeighborThatHasPlayer() {
            for (Room room : neighbors) {
                if (room.hasPlayer()) {
                    return room;
                }
            }
            return null;
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

        public String getEntityNames() {
            if (entities.size() == 0) return "";

            StringBuilder stringBuilder = new StringBuilder();

            for (Entity entity : entities) {
                stringBuilder.append(entity.getName());
                stringBuilder.append(" - ");
                stringBuilder.append(entity.getDescription());
                stringBuilder.append(", ");
            }

            return stringBuilder.substring(0, stringBuilder.length() - 2);
        }

        public Level getLevel() {
            return level;
        }
    }
}

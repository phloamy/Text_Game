import java.util.ArrayList;
import java.util.List;

public class Container {
    protected List<Item> items;

    public Container() {
        items = new ArrayList<>();
    }

    public String getItemNames() {
        if (items.size() == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (Item item : items) {
            stringBuilder.append(item.getName());
            stringBuilder.append(" - ");
            stringBuilder.append(item.getDescription());
            stringBuilder.append(", ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    private Item removeItem(Item item) {
        items.remove(item);
        return item;
    }

    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return removeItem(item);
            }
        }

        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean has(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }
}

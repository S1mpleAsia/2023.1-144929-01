package utils.store;

import java.util.HashMap;

public class ApplicationContext {
    private final HashMap<String, Object> items;

    public ApplicationContext() {
        items = new HashMap<>();
    }

    public Object getItem(String key) {

        return items.get(key);
    }

    public void putItem(String key, Object item) {
        items.put(key, item);
    }

    public void removeItem(String key) {
        items.remove(key);
    }

    public void emptyState() {
        items.clear();
    }
}

package context;

import java.util.EnumMap;

public class ScenarioContext {
    private final EnumMap<ScenarioContextKey, Object> data = new EnumMap<ScenarioContextKey, Object>(ScenarioContextKey.class);

    public void set(ScenarioContextKey key, Object value) {

        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(ScenarioContextKey key) {
        return (T) data.get(key);
    }

    public boolean contains(ScenarioContextKey key) {
        return data.containsKey(key);
    }

    public void clear() {
        data.clear();
    }
}
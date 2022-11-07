package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Difference extends TreeMap<String, LineDiff> {
    public Difference(Map was, Map now) {
        Set<String> keysOfBoth = new TreeSet<>();
        keysOfBoth.addAll(was.keySet());
        keysOfBoth.addAll(now.keySet());

        for (String key : keysOfBoth) {
            put(key, new LineDiff(was.get(key), now.get(key), getLineState(was, now, key)));
        }
    }

    private LineDiffState getLineState(Map was, Map now, String key) {
        if (was.containsKey(key) && now.containsKey(key) && Objects.equals(was.get(key), now.get(key))) {
            return LineDiffState.UNCHANGED;
        } else if (!was.containsKey(key) && now.containsKey(key)) {
            return LineDiffState.ADDED;
        } else if (was.containsKey(key) && !now.containsKey(key)) {
            return LineDiffState.REMOVED;
        } else {
            return LineDiffState.CHANGED;
        }
    }
}

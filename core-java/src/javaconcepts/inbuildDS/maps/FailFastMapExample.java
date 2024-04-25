package javaconcepts.inbuildDS.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ": " + map.get(key));
            // Modify the map during iteration
            map.remove("B"); // ConcurrentModificationException
        }
    }
}


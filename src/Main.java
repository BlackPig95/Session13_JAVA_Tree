import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("A", "B");
        map.put("A", "C");
        map.put("C", "D");
        map.put(null, null);
        map.put(null, null);
        System.out.println(map);
        System.out.println(map.get("A"));
        System.out.println(map.get("B"));
        System.out.println(map.remove("B"));
        System.out.println(map.remove("A"));
        System.out.println(map.containsKey("C"));
        System.out.println(map.containsKey("A"));
        Set<String> newSet = map.keySet();
        Set<Map.Entry<String, String>> setEntry = map.entrySet();
        for (Map.Entry<String, String> entry : setEntry)
        {
            entry.getKey();
            entry.getValue();
        }

        TreeMap<String, String> treemap = new TreeMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        System.out.println(treemap);
        System.out.println(treemap.floorKey("12"));
        System.out.println(treemap.ceilingKey("12"));
    }
}
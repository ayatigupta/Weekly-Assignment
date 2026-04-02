import java.util.*;

 class MultiLevelCache {

    HashMap<String, String> L1 = new LinkedHashMap<>();
    HashMap<String, String> L2 = new HashMap<>();
    HashMap<String, String> DB = new HashMap<>();

    public String get(String key) {

        if (L1.containsKey(key)) {
            return "L1 HIT → " + L1.get(key);
        }

        if (L2.containsKey(key)) {
            L1.put(key, L2.get(key));
            return "L2 HIT → promoted to L1";
        }

        String val = DB.getOrDefault(key, "Not Found");
        L2.put(key, val);

        return "DB HIT → added to L2";
    }
}
// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        Integer timeKey = map.get(key).floorKey(timestamp);
        if(timeKey==null) return "";

        return map.get(key).get(timeKey);
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
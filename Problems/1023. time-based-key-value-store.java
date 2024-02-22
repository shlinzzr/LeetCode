// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {

    
    Map<String, TreeMap<Integer, String>> map; // <key, val> -> <key, TreeMap<time, val>>
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        TreeMap<Integer, String> treeMap;
        
        if(!map.containsKey(key))
            treeMap = new TreeMap<>();
        else
            treeMap = map.get(key);
        
        treeMap.put(timestamp, value);
        
        map.put(key, treeMap);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))   
            return "";
        
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer floorKey = treeMap.floorKey(timestamp);
        if(floorKey==null)
            return "";
        
        return treeMap.get(floorKey);
        // return treeMap.floorEntry(timestamp).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
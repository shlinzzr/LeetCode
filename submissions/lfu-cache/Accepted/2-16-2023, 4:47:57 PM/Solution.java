// https://leetcode.com/problems/lfu-cache

public class LFUCache {
    HashMap<Integer, Integer> vals; // key, val
    HashMap<Integer, Integer> counts; // key, freq
    HashMap<Integer, LinkedHashSet<Integer>> lists; // freq, listSet<key>
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1); // update key->freq
        
        
        lists.get(count).remove(key); // update freq List
        if(count==min && lists.get(count).size()==0)//freq (1:<2>)  /-> (2:<2>)
            min++;
        lists.putIfAbsent(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        // if(cap<=0)
        //     return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        
        
        if(vals.size() >= cap) { // remove
            for(int i:lists.get(min)){
                lists.get(min).remove(i);
                vals.remove(i);
                break;
            }
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);  
    }
}
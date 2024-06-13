// https://leetcode.com/problems/lfu-cache

class LFUCache {
    
    HashMap<Integer, Integer> vals = new HashMap<>(); // key, val
    HashMap<Integer, Integer> freq = new HashMap<>(); // key, freq
    HashMap<Integer, LinkedHashSet<Integer>> lists; // freq, listSet<key>
    int capacity=0; 
    int min = -1;
    
    
    
    

    public LFUCache(int capacity) {
        this.capacity = capacity;
        min=0;
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        
        if(!vals.containsKey(key)){
            return -1;
        }
        
        int cnt = freq.get(key);
        freq.put(key, cnt+1);
        
        lists.get(cnt).remove(key);
        if(cnt==min && lists.get(cnt).size()==0)
            min++;
        
        lists.putIfAbsent(cnt+1, new LinkedHashSet<>());
        lists.get(cnt+1).add(key);
        
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        
        if(vals.containsKey(key)){
            vals.put(key, value);
            get(key);
            return;
        }
        
        if(vals.size() >= capacity) { // remove
            for(int i:lists.get(min)){
                lists.get(min).remove(i);
                vals.remove(i);
                break;
            }
        }
        
        //new key insert
        vals.put(key, value);
        freq.put(key, 1);
        min = 1;
        lists.get(1).add(key);  
        
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
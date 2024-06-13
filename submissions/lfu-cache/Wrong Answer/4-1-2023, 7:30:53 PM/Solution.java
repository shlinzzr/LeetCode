// https://leetcode.com/problems/lfu-cache

class LFUCache {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Set<Integer>> map; // freq, list
    int capacity = 0;
    
    public LFUCache(int capacity) {
        freq = new HashMap<>();
        map=new HashMap<>();
        vals=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)){
            return -1;            
        }
        
        int fq = freq.get(key);
        map.get(fq).remove(key);
        map.putIfAbsent(fq+1, new HashSet<>());
        map.get(fq+1).add(key);
        
        
        return vals.get(key);
    }
    
    
    public void put(int key, int value) {
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
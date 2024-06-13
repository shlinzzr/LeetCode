// https://leetcode.com/problems/lfu-cache

class LFUCache {

    TreeMap<Integer, LinkedHashSet<Integer>> lvmap;
    int capacity;
    int min = 0;
    Map<Integer, Integer> vmap;
    Map<Integer, Integer> fmap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        fmap = new HashMap<>(); // key, freq
        lvmap = new TreeMap<>(); // freq, key
        vmap = new HashMap<>();// key, val
        
    }
    
    public int get(int key) {
        if(!fmap.containsKey(key)) return -1;
        int val = vmap.get(key);
        int freq = fmap.get(key);
        fmap.put(key, freq+1);

        if(freq==min && lvmap.get(min).size()==1)
            min++;

        lvmap.get(freq).remove(key);
        if(lvmap.get(freq).size()==0) lvmap.remove(freq);

        lvmap.putIfAbsent(freq+1, new LinkedHashSet<>());
        lvmap.get(freq+1).add(key);

        return val;
        
    }
    
    public void put(int key, int value) {

       


        if(!fmap.containsKey(key)){ // insert

            if(vmap.size()==capacity){ // delete first

                
                int del = 0;
                Set<Integer> set = lvmap.get(min);

                for(int k : set){
                    vmap.remove(k);
                    fmap.remove(k);
                    lvmap.get(min).remove(k);
                    if(lvmap.get(min).size()==0){
                        lvmap.remove(min);
                    }
                    break;
                }
            }


            vmap.put(key, value);
            fmap.put(key, 1);
            lvmap.putIfAbsent(1, new LinkedHashSet<>());
            lvmap.get(1).add(key);
            min = 1;

        }else{
            vmap.put(key, value);
            int freq = fmap.get(key);
            lvmap.putIfAbsent(freq+1, new LinkedHashSet<>());
            lvmap.get(freq+1).add(key);
            fmap.put(key, freq+1);
        }

        
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
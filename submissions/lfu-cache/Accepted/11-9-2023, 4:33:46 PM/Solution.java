// https://leetcode.com/problems/lfu-cache

class LFUCache {

    int capacity;
    HashMap<Integer, Integer> vmap; // key, val
    HashMap<Integer, LinkedHashSet<Integer>> smap; // freq, keySet
    HashMap<Integer, Integer> fmap; // key, freq
    int min;

    public LFUCache(int capacity) {
        vmap = new HashMap<>();
        smap = new HashMap<>();
        fmap = new HashMap<>();
        min=0;
        this.capacity = capacity;
        
    }
    
    public int get(int key) {

        if(!vmap.containsKey(key)){
            return -1;
        }

        int freq = fmap.get(key);
        fmap.put(key, freq+1);

        if(freq==min && smap.get(min).size()==1){
            min++;
        }

        smap.get(freq).remove(key);
        smap.putIfAbsent(freq+1, new LinkedHashSet<>());
        smap.get(freq+1).add(key);
        

        return vmap.get(key);
    }
    
    public void put(int key, int value) {

        if(vmap.containsKey(key)){
            vmap.put(key, value);
            get(key);
            return;
        }

        if(vmap.size()==capacity){
            for(int k : smap.get(min)){
                vmap.remove(k);
                fmap.remove(k);
                smap.get(min).remove(k);
                if(smap.get(min).isEmpty())
                    smap.remove(min);
                break;
            }
        }

        fmap.put(key, 1);
        smap.putIfAbsent(1, new LinkedHashSet<>());
        smap.get(1).add(key);
        min = 1;
        vmap.put(key, value);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
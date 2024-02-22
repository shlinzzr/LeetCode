// https://leetcode.com/problems/lfu-cache

class LFUCache {

    HashMap<Integer, Integer> valMap; // key, val
    HashMap<Integer, Integer> freqMap; // key, freq
    HashMap<Integer, LinkedHashSet<Integer>> keyList; // freq, LinkedHashSet<key1, key2 ...>
    int capacity; 
    int min;
    


    public LFUCache(int capacity) {
        valMap = new HashMap<>();
        freqMap = new HashMap<>();
        keyList = new HashMap<>();
        this.capacity = capacity;
        min= 0;
    }
    
    public int get(int key) {
        if(!valMap.containsKey(key))
            return -1;

        int freq = freqMap.get(key);
        freqMap.put(key, freq+1);

        if(freq==min && keyList.get(freq).size()==1){
            min++;
        }

        keyList.get(freq).remove(key);
        keyList.putIfAbsent(freq+1, new LinkedHashSet<>());
        keyList.get(freq+1).add(key);

        return valMap.get(key);
    }
    
    public void put(int key, int value) {

        if(valMap.containsKey(key)){
            valMap.put(key, value);
            get(key);
            return;
        }

        if(valMap.size()==capacity){
            for(int k : keyList.get(min)){
                valMap.remove(k);
                freqMap.remove(k);
                keyList.get(min).remove(k);
                if(keyList.get(min).isEmpty())
                    keyList.remove(min);
                break;
            }
        }

        valMap.put(key, value);
        freqMap.put(key, 1);
        min =1;
        keyList.putIfAbsent(1, new LinkedHashSet<>());
        keyList.get(1).add(key);

        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
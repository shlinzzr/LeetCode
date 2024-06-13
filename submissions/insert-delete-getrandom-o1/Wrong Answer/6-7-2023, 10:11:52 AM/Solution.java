// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    
    public RandomizedSet() {
        
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val)){
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int key = map.get(val);
        list.remove(key);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        
        int idx = (int) (Math.random() * list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
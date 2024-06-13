// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {
    
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        map.put(val, map.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        
        if(!map.containsKey(val))
            return false;
        
        int mval = list.get(list.size()-1);
        int rmIdx = map.get(val);
        list.set(rmIdx, mval);
        map.remove(val);
        map.put(mval, rmIdx);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        
        int idx = (int)(Math.random() * list.size());
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
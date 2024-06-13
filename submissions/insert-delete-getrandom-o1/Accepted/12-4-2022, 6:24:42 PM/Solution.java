// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        
        boolean contain = map.containsKey(val);
        
        if(!contain){
            map.put(val, list.size());
            list.add(val);
        }
        return !contain;
    }
    
    public boolean remove(int val) {
        
        boolean contain = map.containsKey(val);
        
        if(contain){
            int idx = map.get(val);
            list.set(idx, null);
            map.remove(val);    
        }
        
        return contain;
        
    }
    
    public int getRandom() {
        Integer res = null;
        while(map.size()>0 && res==null){
            int idx = (int)(Math.random() * list.size());
            res = list.get(idx);
        }
        
        return res;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
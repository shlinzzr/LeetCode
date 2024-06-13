// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed

class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map; // val, list<idx>
    List<Integer> list;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
       boolean res = map.containsKey(val) && map.get(val).size()>0;
        
       map.putIfAbsent(val, new HashSet<>());
        
        list.add(val);
        map.get(val).add(list.size()-1);
        
        return !res;
    }
    
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int rm_idx = map.get(val).iterator().next();
        map.get(val).remove(rm_idx);
        // if(map.get(val).isEmpty())
        //     map.remove(val);
        
        int last = list.get(list.size()-1);
        list.set(rm_idx, last);
        
        
        // map.putIfAbsent(last, new HashSet<>());
        map.get(last).add(rm_idx);
        map.get(last).remove(list.size()-1);
        
        list.remove(list.size()-1);
        return true;
        
    }
    
    
    public int getRandom() {
        int idx = (int) (Math.random() * list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
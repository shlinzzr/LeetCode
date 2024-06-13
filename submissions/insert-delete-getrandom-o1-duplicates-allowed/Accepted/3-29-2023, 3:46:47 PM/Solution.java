// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed

class RandomizedCollection {
    List<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
        
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
        if(map.get(val).size()==0)
            return false;
        
        int remove_idx = map.get(val).iterator().next();
        map.get(val).remove(remove_idx);
        int last = list.get(list.size() - 1);
        list.set(remove_idx, last);
        map.get(last).add(remove_idx);
        map.get(last).remove(list.size()-1);
        
        list.remove(list.size() - 1);
        
        // map.get(val).remove(map.get(val).size()-1);
        // if(map.get(val).size()==0)
        //     map.remove(val);
        
        
        return true;
        
    }
    
    public int getRandom() {
        // int key = (int)(Math.random() * len);
        // int val = list.get(key);
        // while(!map.containsKey(val) || map.get(val).size()==0){
        //     key = (int)(Math.random() * len);
        //     val = list.get(key);
        // }
        // return val;
          return list.get((int) (Math.random()*list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    // val, idx
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        
        if(!res){
            list.add(val);
            map.put(val, list.size()-1);    
        }
        
        return !res;
    }
    
    public boolean remove(int val) {
        
        boolean res = map.containsKey(val);
        
        if(res){
            int idx = map.get(val);
            list.set(idx, null);
            map.remove(val);
        }
        
        return res;
    }
    
    public int getRandom() {
        int idx = (int)(Math.random() * list.size());
        
        Integer res = list.get(idx);
        while(map.size()>0 && res==null){
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
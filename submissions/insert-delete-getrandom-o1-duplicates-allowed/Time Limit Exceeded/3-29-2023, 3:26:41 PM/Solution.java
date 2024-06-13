// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed

class RandomizedCollection {
    List<Integer> list = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int len;
    
    public RandomizedCollection() {
        len=0;
    }
    
    public boolean insert(int val) {
        
        boolean res = map.containsKey(val) && map.get(val).size()>0;
        
       map.putIfAbsent(val, new ArrayList<>());
        list.add(val);
        map.get(val).add(list.size()-1);
        len++;
        
        return !res;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        if(map.get(val).size()==0)
            return false;
        
        map.get(val).remove(map.get(val).size()-1);
        if(map.get(val).size()==0)
            map.remove(val);
        
        len--;
        
        return true;
        
    }
    
    public int getRandom() {
        int key = (int)(Math.random() * len);
        int val = list.get(key);
        while(!map.containsKey(val) || map.get(val).size()==0){
            key = (int)(Math.random() * len);
            val = list.get(key);
        }
        
        return val;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
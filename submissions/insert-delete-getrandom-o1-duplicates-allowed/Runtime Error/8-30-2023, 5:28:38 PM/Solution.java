// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed

class RandomizedCollection {

    HashMap<Integer, List<Integer>> map; // val, list<idx>
    List<Integer> list;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        map.putIfAbsent(val, new ArrayList<>());
        map.get(val).add(list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int idx = map.get(val).get(0);
        int last = list.get(list.size()-1);
        map.get(last).remove(map.get(last).size()-1);
        map.get(last).add(idx);
        
        list.remove(list.size()-1);
        if(map.get(val).size()==1){
            map.remove(val);
        }else{
            map.get(val).remove(0);
        }
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
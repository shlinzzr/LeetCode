// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    int len;
    
    
    public RandomizedSet() {
        list=new ArrayList<>();
        map = new HashMap<>();
        len=0;
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        len++;
        list.add(val);
        map.put(val, list.size()-1);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        map.remove(val);
        len--;
        return true;
    }
    
    public int getRandom() {
        
        Integer res = null;
        if(map.size()==0){
            return res;
        }
        
        int idx = (int)(Math.random() * list.size());
        int val = list.get(idx);
        
        while(!map.containsKey(val)){
            idx = (int)(Math.random() * list.size());
            val = list.get(idx);
        }
        
        return val;
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
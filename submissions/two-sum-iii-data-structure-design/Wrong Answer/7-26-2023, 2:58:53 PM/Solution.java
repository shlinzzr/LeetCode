// https://leetcode.com/problems/two-sum-iii-data-structure-design

class TwoSum {

    HashMap<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, -1);
    }
    
    public boolean find(int value) {
        for(int k : map.keySet()){
            if(map.containsKey(value-k))
                return true;
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
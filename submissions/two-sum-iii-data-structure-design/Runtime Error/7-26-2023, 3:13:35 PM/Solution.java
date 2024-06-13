// https://leetcode.com/problems/two-sum-iii-data-structure-design

class TwoSum {

    HashMap<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
    }
    
    
  
    
    public boolean find(int value) { // 0
        
          // System.out.println(map.keySet().toString() +  " " + map.values());
        for(int k : map.keySet()){ // 0, -1, 1
               // System.out.println("k=" + k  );           
            if(map.containsKey(value-k)){ // 1
                
                
                // System.out.println("value=" + value + " k=" + k  );                
                if(value-k==k){ //0--1 == -1?
                    if(map.get(value)-k<2)
                        continue;
                }
                return true;    
            }
                
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
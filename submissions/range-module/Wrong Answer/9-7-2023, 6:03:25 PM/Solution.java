// https://leetcode.com/problems/range-module

class RangeModule {

    TreeMap<Integer, Integer> map;
    
    public RangeModule() {
        map = new TreeMap<>();
        
    }
    
    public void addRange(int left, int right) {
        map.put(left, right);
        
    }
    
    public boolean queryRange(int left, int right) {
        
        Integer floorKey = map.floorKey(left);
        Integer ceilingKey = map.ceilingKey(left);
        
        while(floorKey!=null){
            
            if(map.get(floorKey)>=right || (ceilingKey!=null && map.get(floorKey)>=ceilingKey)){
                return true;
            }
            
            floorKey = map.lowerKey(floorKey);
        }
        
        
        System.out.println(left + " " + right + " " + floorKey + " " + ceilingKey);
        
        while(ceilingKey!=null && ceilingKey<right){
            
            if(ceilingKey<right)
                return true;
            
            ceilingKey = map.higherKey(ceilingKey);
        }
        
        
        
        return false;
    }
    
    public void removeRange(int left, int right) {
        
        Integer floorKey = map.floorKey(left);
        Integer ceilingKey = map.ceilingKey(left);
            
        // System.out.println("revmove " + left + " " + right + " " + floorKey + " " + ceilingKey);
       
        
        while(floorKey!=null){
            
            int val = map.get(floorKey);
            
            if(val<left)
                continue;
            
            map.put(floorKey, left);
            if(val>right)
                map.put(right, val);
            
            floorKey = map.lowerKey(floorKey);
        }
        
        
        while(ceilingKey!=null && ceilingKey<right){
            int val = map.get(ceilingKey);
            if(val<right){
                map.remove(ceilingKey);
                continue;
            }
                
            map.put(right, val);
            ceilingKey = map.higherKey(ceilingKey);
        }
        
        
        // for(Map.Entry<Integer, Integer> en : map.entrySet()){
        //     System.out.println(en.getKey() + " " + en.getValue());
        // }
        
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
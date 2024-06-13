// https://leetcode.com/problems/online-majority-element-in-subarray

class MajorityChecker {

    
    
    int[] arr;
    
    List<Map<Integer, Integer>> list = new ArrayList<>();
    
    
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
            list.add(new HashMap<>(map));
        }
        
        // System.out.println(list.get(0).get(2));
    
        
    }
    
    public int query(int left, int right, int threshold) {
        Map<Integer, Integer> lmap = left==0 ? new HashMap<>() : list.get(left-1);
        Map<Integer, Integer> rmap = list.get(right);
        
        // System.out.println(left + " " + right + " " + threshold);
        
        
        int maj = -1;
        int max = 0;
        
        for(int k : rmap.keySet()){
            
            int val = rmap.get(k);
            
            if(lmap.containsKey(k)){
                val -= lmap.get(k);
            }
            
            // System.out.println("k=" + k + " val="+val); 
            
            if(val>max){
                maj = k;
                max = val;
            }
        }
        
        
        return max>=threshold ? maj : -1;
        
        
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
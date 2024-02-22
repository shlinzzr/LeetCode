// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        
        int len = nums.length;
        if(len%k!=0)
            return false;
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        while(!map.isEmpty()){
            
            int key = map.firstKey();    
            for(int i=0; i<k;i++){
                
                 int t = key+i;
                
                 if(!map.containsKey(t)){
                     return false;
                 }else{
                    map.put(t, map.get(t)-1);
                    if(map.get(t)==0)
                        map.remove(t);
                 }
            }
        }
        
        return true;
        
    }
}
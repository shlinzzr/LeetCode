// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] res = new long[len];
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
             map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        
        
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len; j++){
                
                if(map.get(nums[i])==1)
                    break;
                
                if(nums[i]==nums[j]){
                    
                    int abs = Math.abs(i-j);
                    
                    res[i] += abs;
                    res[j] += abs;
                }
            }
        }
        
        return res;
    }
}

// https://leetcode.com/problems/subarray-sums-divisible-by-k

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        
        int cur=0, res= 0 ;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i=0; i<len; i++){
            
            cur = (cur+nums[i])%k;
            if(cur<0) cur+=k;
            
            
            if(map.containsKey(cur)){
                res += map.get(cur);
            }
            
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
        
        
//         for(int i=0; i<len; i++){
//             sum = (sum + nums[i]) % k;
//             if(sum < 0) 
//                 sum += k; 
            
//             res+=map.getOrDefault(sum, 0);
            
//             map.put(sum, map.getOrDefault(sum, 0)+1);
//          }
        
        return res;
        
    }
}
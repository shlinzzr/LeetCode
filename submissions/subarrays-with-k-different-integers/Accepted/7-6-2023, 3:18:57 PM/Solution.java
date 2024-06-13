// https://leetcode.com/problems/subarrays-with-k-different-integers

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      
        int a = leetcode340(nums, k) ;
        int b = leetcode340(nums, k-1);
        
        return a-b;
        
    }
    
    // leetcode 340 => find the longest length of substring
    // 992 request to find the "number" of the subarray: ref line 40
     public int leetcode340(int[] nums, int k) {
        int len = nums.length;
        
        int st= 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res =0 ;
        
        for(int ed=0; ed<len; ed++){
            
            int n = nums[ed];
            
            map.put(n, map.getOrDefault(n, 0)+1);
            
            while(map.size()>k){
                
                int nn = nums[st];
                map.put(nn, map.get(nn)-1);
                if(map.get(nn)==0)
                    map.remove(nn);
                
                st++;
            }
            
            // the key is below : 
            // res = Math.max(res, ed-st+1);   // find longest;
            res+=(ed-st+1);                    // find total number of subarray
        }
        return res;
    }
}
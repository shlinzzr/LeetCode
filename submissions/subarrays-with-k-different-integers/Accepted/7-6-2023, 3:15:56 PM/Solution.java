// https://leetcode.com/problems/subarrays-with-k-different-integers

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      
        int a = leetcode340(nums, k) ;
        int b = leetcode340(nums, k-1);
        
        // System.out.println(a + " " + b);
        
        return a-b;
        
    }
    
    // leetcode 340 atMostK
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
            
            res+=(ed-st+1);
        }
        return res;
    }
}
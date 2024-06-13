// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        
        
        
        int a = atMostK(nums, k);
        int b = atMostK(nums, k-1);
        
        
        
        return a-b;
    }
    
    private int atMostK(int[] nums, int k){
        
        int len = nums.length;
        
        int res = 0;
        
        int odd = 0;
        
        int st=0;
        for(int ed=0; ed<len ;ed++){
            
            if(nums[ed]%2==1)
                odd++;
            
            while(odd>k){
                if(nums[st]%2==1){
                    odd--;
                }
                st++;
            }
            
            res += (ed-st+1);
            
        }
        
        return res;
        
        
        
    }
    
}
// https://leetcode.com/problems/max-consecutive-ones-ii

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int len = nums.length;
        
        int z=0;
        
        int max= 0 ;
        
        int st=0;
        for(int ed=0; ed<len;ed++){
            if(nums[ed] ==0){
                z++;
            }
            
            while(st<ed && z>1){
                if(nums[st++]==0){
                    z--;
                }
            }
            max = Math.max(max, ed-st+1);
        }
        
        return max;
        
    }
}
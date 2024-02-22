// https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations

class Solution {
    public long maxArrayValue(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;
        
        if(len==1)
            return nums[0];
        
        long curr = nums[len-1];
        long max = curr ;
        for(int i=len-1; i>0; i--){
            
            if(curr>=nums[i-1]){
                curr += nums[i-1];
               
            }else{
                curr = nums[i-1];
            }
            
            max= Math.max(max, curr);
            
        }
        
        
        return max;
      
        
    }
}
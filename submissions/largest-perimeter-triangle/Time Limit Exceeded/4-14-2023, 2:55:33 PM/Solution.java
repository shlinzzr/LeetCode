// https://leetcode.com/problems/largest-perimeter-triangle

class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        int max = 0;
        for(int i=len-1; i>1; i--){
            
            for(int j=i-1; j>0; j--){
                
                for(int k=j-1; k>=0; k--){
                    
                    if(nums[j] + nums[k]>nums[i])
                        return nums[j] + nums[k] + nums[i];
                }
            }
        }
        
        return 0;
        
    }
}
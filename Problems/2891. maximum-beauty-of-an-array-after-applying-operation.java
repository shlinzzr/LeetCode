// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int max = 0;
        
        int j=0;
        for(int i=0; i<nums.length; i++){
            
            if(nums[i]-nums[j]>2*k){
                j++;
            }
            
            max = Math.max(max, i-j+1);
            
            
            
        }
        
        
        return max;
        
        
    }
}
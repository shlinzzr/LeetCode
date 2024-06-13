// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            
            // 我的數值是: nums[i]
            // 目的是  把nums[i] 換到 nums[i]-1的位置上
            // 限制: nums[i]-1 要在範圍內
            // 終止條件: 直到目前的nums[i]=i+1, 做下一輪
            
            while(nums[i]-1!=i && nums[i]-1>=0 && nums[i]-1<len && nums[i]!=nums[nums[i]-1] ){
                swap(i, nums[i]-1, nums);
            }
            
        }        
        
        for(int i=0; i<len;i++){
            if(nums[i]-1!=i)
                return i+1;
        }
        
        return len;
            
    }
    
    
    private void swap(int a, int b, int[] nums){
        
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
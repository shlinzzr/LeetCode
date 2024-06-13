// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        // index sorting;
        
        int len = nums.length;
        
        
        // nums[2]==2
        
        // [3,4,-1,1]
        
        // swap nums[0] (3) to nums[2]; && check nums[2]!=3
        
        // => check 
        
        

        // let nums[i] = i+1; => idx = nums[i]-1;
        for(int i=0; i<len; i++){
            

            int idx = nums[i]-1;
            while(nums[i]!=i+1 && idx>=0 && nums[i]-1<len && nums[nums[i]-1]!=nums[i]){
                swap(nums, i, nums[i]-1);
            }
        }
        
        for(int i=0; i<len; i++){
            
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return len+1;
        
        
    }
    
    private void swap(int[] nums, int a, int b){
        
        int tmp=nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
        
    }
}
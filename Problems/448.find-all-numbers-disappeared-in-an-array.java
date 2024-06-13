// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int len = nums.length;
        
        
        // 
        
        for(int i=0; i<len; i++){
            
            int val = nums[i]; 
            // val should be at the nums[val-1]
            // i.e. nums[i] should be i+1
            
            
            
            while(nums[i]-1>=0 && nums[i]-1<len && nums[nums[i]-1] != nums[i] ){
                swap(nums, i , nums[i]-1);
            }
            
//             if(nums[i]!=i+1){
//                 res.add(i+1);
//             }
             
            
        }
        
        for(int i=0; i<len; i++){
            if(nums[i]!=i+1)
                res.add(i+1);
        }
        
        
        return res;
        
        
    }
    
    // 4,3,2,7,8,2,3,1
    // 7 3 2 4 8 2 3 1
    // 3 3 2 4 8 2 7 1
    // 2 3 3 4 8 2 7 1
    // 3 2 3 4 8 2 7 1
        
    
    
    
    private void swap (int[] nums ,int a, int b){
        
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
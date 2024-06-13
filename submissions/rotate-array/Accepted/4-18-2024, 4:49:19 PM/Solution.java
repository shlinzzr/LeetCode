// https://leetcode.com/problems/rotate-array

class Solution {
    
    /*
    
    Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
                len-1
    1,2,3,4,5,6,7
    4 3 2 1 7 6 5 
    5 6 7 1 2 3 4 
    
    
    
    */
    
    
    public void rotate(int[] nums, int k) {
        
        
        int len = nums.length;
        
        if(len==1) return;
        k%=len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
        
        
        
    }
    
    private void reverse(int[] nums, int st, int ed){
        while(st<ed){
            int tmp = nums[st];
            nums[st]= nums[ed];
            nums[ed] = tmp;
            st++;
            ed--;
        }
    }
}
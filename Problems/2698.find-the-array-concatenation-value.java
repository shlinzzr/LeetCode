// https://leetcode.com/problems/find-the-array-concatenation-value

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int len = nums.length;
        int i=0;
        int j =len-1;
        
        long res = 0;
        
        while(i<=j){
            
            int val = 0;
            if(i!=j){
                val = Integer.valueOf( String.valueOf(nums[i])+String.valueOf(nums[j]));
                
            }else{
                val = Integer.valueOf( String.valueOf(nums[i]));
            }
            
            res+=val;
            i++;
            j--;
        }
        
        return res;
    }
}
// https://leetcode.com/problems/sort-array-by-parity

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int st=0, ed= nums.length-1;
        
        
        while(st<ed){
            
//             for(int n: nums)
//                 System.out.print(n);
//             System.out.println("");
            
            
            
            
            if(nums[st]%2==1 && nums[ed]%2==0){
               int t = nums[st];
               nums[st]=nums[ed];
               nums[ed] = t;
            }
            
            
             if(nums[st]%2==0)
                st++;
            if(nums[ed]%2==1)
                ed--;
            
         
            
            
            
        }
        
        return nums;
    }
}
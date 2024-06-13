// https://leetcode.com/problems/maximum-subarray

class Solution {
//     public int maxSubArray(int[] nums) {
     
        
//         int max = Integer.MIN_VALUE;
        
//         for(int i=0; i<nums.length; i++){
//             int sum = 0;
//             for(int j=i; j< nums.length; j++){
                
//                 sum = sum + nums[j];
//                 if(sum>max)
//                     max=sum;
            
//             }
//         }
//         return max;
//     }
    
       public int maxSubArray(int[] nums) {
     
        // sum(0,i) = a[i] + (sum(0,i-1) < 0 ? 0 : sum(0,i-1))
                
           
        int max = Integer.MIN_VALUE;
        int sum=0;
           
        for(int i=0; i<nums.length; i++){
            
            if(sum<0)
                sum = nums[i];
            else 
                sum = sum + nums[i];
            
            max = Math.max(max, sum);
        }
        return max;
    }
}
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

class Solution {
    public int maxProduct(int[] nums) {
        
        // O(n^2)
        // int max = 0;
        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<nums.length; j++){
        //         if(i!=j)
        //             max = Math.max(max, (nums[i]-1)*(nums[j]-1));
        //     }
        // }
        // return max;
        
        
        
        // O(n)
        
        int max1=0, max2=0;
        for(int n:nums){
            
            if(n>max1){
                max2=max1;
                max1 = n;
                
            }else if(n>max2){
                max2 = n;
            }
        }
        
        return (max1-1) * (max2-1);
        
        
    }
    
}
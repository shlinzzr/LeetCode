// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii

class Solution {
    public int minimumSum(int[] nums) {
        int len = nums.length;
        
        
        int sum = Integer.MAX_VALUE;
        
        int[] leftmin = new int[len];
        leftmin[0] = nums[0];
        for(int i=1; i<len; i++){
            leftmin[i] = Math.min(leftmin[i-1], nums[i]);   
            // System.out.print(leftmin[i]+",");
        }
         // System.out.println();
        
        int[] rightmin = new int[len];
        rightmin[len-1] = nums[len-1];
        for(int i=len-2; i>=0; i--){
            rightmin[i] = Math.min(rightmin[i+1], nums[i]);  
            // System.out.print(rightmin[i]+",");
        }
        
         // System.out.println();
        
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<len-1; i++){
            if(leftmin[i-1]<nums[i] && nums[i]>rightmin[i+1]){
                min = Math.min(min, leftmin[i-1]+nums[i]+rightmin[i+1]);
            }
        }
        
        return min==Integer.MAX_VALUE ? -1: min;
        
    }
               
}
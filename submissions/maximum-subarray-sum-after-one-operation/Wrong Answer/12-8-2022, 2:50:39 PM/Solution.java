// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
        
        int s = 0;
        for(int n : nums){
            
            if(sum<0){
                
                if(s!=0){
                    sum += s>0 ? Math.abs(s)*(Math.abs(s)-1) : Math.abs(s)*(Math.abs(s)+1);
                }
                max = Math.max(max, sum);
                sum=0;
                s=0;
            }
            
            s = Math.abs(n)>Math.abs(s) ? n : s;
                
            sum += n;
            
            max = Math.max(max, sum);
            
        }
        return max;
        
    }
}
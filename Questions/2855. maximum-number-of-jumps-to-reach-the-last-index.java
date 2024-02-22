// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1]=0;
        
        long cur = (long) nums[0];
        
        boolean last = false;
        
        int cnt =0;
        for(int i=2; i<=len; i++){ //i=2
            
            
            for(int j=1; j<i; j++){ 
                
                // System.out.println(i + " " + j +  " nums[i-1]="+nums[i-1] + " nums[j-1]="+nums[j-1]);
                
                
                
                if(dp[j]!=Integer.MIN_VALUE && Math.abs(nums[i-1]-nums[j-1])<=target){
                    // System.out.println("bf  dp[i]="+ dp[i]);
                     dp[i] = Math.max(dp[i], dp[j]+1);
                     // System.out.println("af  dp[i]="+ dp[i]);
                }
                // i=5, j=4, 
            }
            
        }
        
        // for(int d : dp){
        //      System.out.println(d);
        // }
        
        return dp[len]==Integer.MIN_VALUE? -1 : dp[len];
        
        /*-2147483648
0
1
-2147483648
2
3
4
            
            */
    }
}
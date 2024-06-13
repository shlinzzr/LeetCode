// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
//          solution1 : O(n^2)
//         int len = nums.length;
        
//         int[] dp = new int[len];
//         Arrays.fill(dp, 1);
        
//         for(int ed= 0; ed<len; ed++){
//             for(int st=0; st<ed; st++){
//                 if(nums[ed]>nums[st])
//                     dp[ed] = Math.max(dp[ed], dp[st]+1);
//             }
//         }
//         int longest = 0;
//         for (int c: dp) {
//             longest = Math.max(longest, c);
//         }
//         return longest;
        
        
        // solution 2 O(n^2) with Intelligently subseq
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    j += 1;
                }
                
                sub.set(j, num);
            }
        }
        
        return sub.size();
        
        
    }
}
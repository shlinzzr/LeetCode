// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // https://leetcode.com/problems/longest-increasing-subsequence/discuss/2395527/3-Approaches%3A-Backtrack-DP-Binary-Search
        
        // https://www.youtube.com/watch?v=l2rCz7skAlk
        // bottom-up dp O(n^2)
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=0;
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<i; j++){
                
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);    
                }
            }
            
            max = Math.max(max, dp[i]);
            
        }
        
        return max;
        
    }
}


// // binarySearch O(nlogn)

// class Solution {
//     public int lengthOfLIS(int[] nums) {
        
//         int[] tail = new int[nums.length];
//         tail[0] = nums[0];
//         int maxLen = 1;
        
//          for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > tail[maxLen - 1]) { // if(cur>tail) append @ tail
//                 tail[maxLen] = nums[i];
//                 maxLen++;
                
                
//             } else {  // find the current number in tail array , replace by nums[i]
//                 int left = 0;
//                 int right = maxLen - 1;
//                 while (left < right) {
//                     int mid = left + (right - left) / 2;
//                     if (tail[mid] < nums[i]) {
//                         left = mid + 1;
//                     } else {
//                         right = mid;
//                     }
//                 }

//                 tail[left] = nums[i];
//             }
//         }
        
//         return maxLen;
        
//     }
    
   
    
}
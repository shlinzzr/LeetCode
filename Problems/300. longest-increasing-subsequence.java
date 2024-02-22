// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
//          solution1 : O(n^2) : 70ms
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
        
        /*
        // solution 2 O(n^2) with Intelligently subseq : 7ms
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
        */
        
        // solution 3:   same with sol2 .... but : O(nlgn) improve with binary search 6ms
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int target) {
        int st = 0;
        int ed = sub.size() - 1;
        
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (sub.get(mid) == target) {
                return mid;

            }else if (target > sub.get(mid) ) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        
        return st;
        
    }
}
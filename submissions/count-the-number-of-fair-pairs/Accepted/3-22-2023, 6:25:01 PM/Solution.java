// https://leetcode.com/problems/count-the-number-of-fair-pairs

class Solution {
    
    // ref :https://leetcode.com/problems/count-the-number-of-fair-pairs/discuss/3178075/java-approach-tracing-simple-tc-o-n-log-n-sc-o-1
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairsLessThanVal(nums, upper) - countPairsLessThanVal(nums, lower - 1);
    }
    
    private long countPairsLessThanVal(int[] nums, int val) {
        long output = 0;
        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            if (nums[i] + nums[j] > val) {
                -- j;
            } else {
                output += j - i;
                ++ i;
            }
        }
        
        return output;
    }
}
// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        int M = (int) 1e9+7;

        int len = nums.length;

        int[]  diff = new int[len+1];
        for(int[] r : requests){
            diff[r[0]]++;
            diff[r[1]+1]--;
        }

        int cur = 0;
        int[] freq = new int[len];
        for(int i=0; i<len; i++){
            cur += diff[i];
            freq[i] = cur; 
        }

        Arrays.sort(nums);
        Arrays.sort(freq);

        long sum = 0 ;
        for(int i=0; i<len; i++){
            sum = sum + (nums[i] * freq[i])%M;
            sum %= M;
        }

        return (int) sum;


        
    }
}
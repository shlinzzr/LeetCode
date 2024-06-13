// https://leetcode.com/problems/subarray-sums-divisible-by-k

class Solution {
    public int subarraysDivByK(int[] nums, int k) {


        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0 ;
        int res = 0;
        for(int i=0; i<len; i++){
            sum += nums[i];
            sum %= k;
            if(sum<0) sum+=k;

            res += map.getOrDefault(sum ,0);

            map.put(sum, map.getOrDefault(sum, 0)+1);


        }

        return res;
        
    }
}
// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int len =  nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);


        int res= 0 ;
        int cur = 0 ;
        for(int i=0; i<len; i++){

            int n = nums[i];
            cur+=n;
            if(map.containsKey(cur-goal)){
                res += map.get(cur-goal);
            }
            map.put(cur, map.getOrDefault(cur,0)+1);
        }

        return res;
        
    }
}
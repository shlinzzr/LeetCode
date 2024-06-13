// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;

        int sum = 0;
        // 0 1 2 3
        // 0 1 0 1
        int res= 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<len; i++){
            sum += nums[i]==1 ? 1 : -1;

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                res = Math.max(res, i-map.get(sum));
            }

        }

        return res;


        
    }
}
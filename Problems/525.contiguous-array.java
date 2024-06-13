// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {

        int len = nums.length;

        int sum = 0;

        // 0 1 0
        // -1 0

        Map<Integer, Integer> map = new HashMap<>(); // sum , idx
        map.put(0, -1);
        int max= 0 ;
        for(int i=0; i<len; i++){
            int n = nums[i]==1 ? 1 : -1;
            sum += n;

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                max = Math.max(max, i-map.get(sum));
            }

        }

        return max;
        
    }
}
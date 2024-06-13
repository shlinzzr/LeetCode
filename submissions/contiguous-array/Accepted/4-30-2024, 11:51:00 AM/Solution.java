// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int cur = 0;
        int max= 0 ;

        int len = nums.length;
        for(int i=0; i<len; i++){
            int n = nums[i];

            cur += (n==1)? 1 : -1;

            if(map.containsKey(cur)){
                max = Math.max(max, i-map.get(cur));
            }else{
                map.put(cur, i);
            }
        }
        

        return max;
    }
}
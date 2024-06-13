// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {

        int max = 1;
        int cur = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i<nums.length; i++){
            if(nums[i]==1) 
                cur++;
            else 
                cur--;

            if(map.containsKey(cur)){
                max = Math.max(max, i-map.get(cur));
            }else{
                map.put(cur, i);
            }

        }
        return max;
    }
}
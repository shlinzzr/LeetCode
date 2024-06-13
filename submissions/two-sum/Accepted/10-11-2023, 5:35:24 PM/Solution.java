// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(map.containsKey(target-n)){
                return new int[]{i, map.get(target-n)};
            }

            map.put(n, i);
        }
        return null;
    }
}
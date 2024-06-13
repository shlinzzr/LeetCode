// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int cur = 0;
        for(int i=0; i<len; i++){
            int num = nums[i];
            if(num==1){
                cur++;
            }else 
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

// [0,-1] [-1, 0] [
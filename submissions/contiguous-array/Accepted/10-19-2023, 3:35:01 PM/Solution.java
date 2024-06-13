// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;

        int cur = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0;i<len; i++){
            int n = nums[i];

            if(n==1) 
                cur++;
            else 
                cur--;

            if(!map.containsKey(cur)){
                map.put(cur, i);
            }else{
                max = Math.max(max, i-map.get(cur));
            }
        }

        return max;
    }
}
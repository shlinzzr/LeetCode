// https://leetcode.com/problems/count-the-number-of-good-partitions

class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
        }
        
        int m=0;
        int right =0;
        for(int i=0; i<len; i++){
            
            if(map.get(nums[i])==right){
                m++;
                right++;
            }
            
            right = Math.max(right, map.get(nums[i]));
        }
        
        return (int)Math.pow(2, m-1);
        
    }
}
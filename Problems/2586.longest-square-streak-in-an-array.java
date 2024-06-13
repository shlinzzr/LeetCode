// https://leetcode.com/problems/longest-square-streak-in-an-array

class Solution {
    public int longestSquareStreak(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max =-1;
        
        for(int i=len-1; i>=0; i--){
            
            int n = nums[i];
            
            if(map.containsKey(n*n)){
                map.put(n, map.get(n*n)+1);
                max= Math.max(max, map.get(n));
            }else{
                map.put(n, 1);
            }
        }
        
        return max;
        
        
    }
}
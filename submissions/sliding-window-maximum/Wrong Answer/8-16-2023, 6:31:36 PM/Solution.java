// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        TreeSet<Integer> set = new TreeSet<>(); // nums[i]
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        int windowSize=0;
        for(int i=0; i<len ;i++){
            
            set.add(nums[i]);
            windowSize++;
            
            if(windowSize>k){
                set.remove(i-k);
                windowSize--;
            }
            
            if(i+1-k>=0){
                res[i+1-k] = set.last();
            }
        }
        
        return res;
        
    }
}
// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        for(int i=0; i<len ;i++){
            int cur = nums[i];
            map.put(cur, map.getOrDefault(cur, 0)+1);
            
            while(map.size()>k){
                map.put(nums[i-k], map.get(nums[i-k])-1);
                if(map.get(nums[i-k])==0)
                    map.remove(nums[i-k]);
            }
            
            if(i+1-k>=0){
                res[i+1-k] = map.lastKey();
            }
        }
        
        return res;
        
        
        
    }
}
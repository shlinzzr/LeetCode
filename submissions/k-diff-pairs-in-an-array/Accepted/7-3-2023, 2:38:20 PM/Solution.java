// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        
        // Arrays.sort(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();        
        
        int res=0;
        for(int i=0; i<len; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for (Map.Entry <Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && map.containsKey(key + k)) {
                res++;
            } else if (k == 0 && val > 1) {
                res++;
            }
        }
        
        return res;
        
    }
}
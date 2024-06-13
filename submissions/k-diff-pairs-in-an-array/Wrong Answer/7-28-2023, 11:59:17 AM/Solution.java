// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        
        Set<String> set = new HashSet<>();
        
        
        int cnt = 0;
        
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len; j++){
                
                if(Math.abs(nums[i]-nums[j])==k && !set.contains(nums[i]+"_"+nums[j])){
                    cnt++;
                    set.add(nums[i]+"_" + nums[j]);
                }
            }
            
        }
        
        return cnt;
        
        
        
    }
}
// https://leetcode.com/problems/find-subarrays-with-equal-sum

class Solution {
    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<len-1; i++){
            
            int sum = nums[i] + nums[i+1];
            
            if(set.add(sum)==false)
                return true;
        }
            
        return false;
    }
}
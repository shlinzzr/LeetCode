// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        
        
        HashSet<Integer> set = new HashSet<>();
        
        int sum=0;
        int max = 0;
        Integer prev = null;
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            
            if(set.contains(nums[ed])){
                set = new HashSet<>();
                sum=0;
                st=ed;
            }
            
            
            set.add(nums[ed]);
            sum += nums[ed];
            if(ed-st+1<k){
                continue;
            }
            
            max = Math.max(max, sum);
            
            set.remove(nums[st]);
            sum-=nums[st++];
        }
        
        return max;
        
    }
}
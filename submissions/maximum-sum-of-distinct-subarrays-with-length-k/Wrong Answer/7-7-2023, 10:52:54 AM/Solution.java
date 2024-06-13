// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        long max = 0;
        
        int sum=0;
        
        int st =0;
        for(int ed=0; ed<len; ed++){
            
            sum += nums[ed];
            
            while(st<=ed-k || (st<ed && set.contains(nums[ed]))){
                int nst = nums[st];
                set.remove(nst);
                sum -= nst;
                st++;
            }
            
            set.add(nums[ed]);
            
            if(ed-st+1==k)
                max = Math.max(max, sum);
            
                        
            
            
        }
        
        return max;
    }
}
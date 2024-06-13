// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        
        int st=0, ed=len-1;
        
        while(st<ed){
            int mid = ed-(ed-st)/2;    
            
            if(count(nums, mid)>=k)
                st=mid;
            else
                ed=mid-1;
        }
        
        return st;
    }
    
    private int count(int[] nums, int idx){
        
        int cnt=0;
        for(int n : nums){
            if(nums[idx]>n)
                cnt++;
        }
        
        return cnt;
    }
}
// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        
        int st=Integer.MIN_VALUE/2, ed= Integer.MAX_VALUE/2;
        
        while(st<ed){
            
           int mid =ed-(ed-st)/2;    
            
            if(check(nums, mid, k)){
                st =mid;
            }else
                ed=mid-1;
        }
        
        return st;
        
    
    }
                
                
 private boolean check(int[] nums, int idx, int k){
        
        int cnt=0;
        for(int n : nums){
            if(n>=idx)
                cnt++;
        }
        
        return cnt>=k;
    }
}
                
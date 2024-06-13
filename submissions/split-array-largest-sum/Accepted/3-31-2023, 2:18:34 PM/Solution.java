// https://leetcode.com/problems/split-array-largest-sum

class Solution {
    public int splitArray(int[] nums, int k) {
        
        
        int left = 0;
        int right = 0;
        for(int n: nums){
            left= Math.max(left, n);
            right+=n;
        }
        
        while(left<right){
            
            int mid = left+(right-left)/2;
            
            if( check(nums, k, mid) ){
                right=mid;
            }else
                left=mid+1;
        }
        
        return left;
        
        
    }
    
 
    private boolean check(int[] nums, int k, int capacity){
        
        
        int sum=0, day=1;
        for(int i=0; i<nums.length; i++){
            
            if(sum+nums[i]>capacity){
                sum=nums[i];
                day++;
            }else{
                sum+=nums[i];
            }
            
            if(day>k)
                return false;
        }
        
        return true;
        
        
        
        
        
        
    }
}
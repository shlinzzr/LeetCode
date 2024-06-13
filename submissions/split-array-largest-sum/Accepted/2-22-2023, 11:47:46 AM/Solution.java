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
            
            if(valid(nums, k, mid)){
                right=mid;
            }else
                left=mid+1;
        }
        
        return left;
        
        
    }
    
    public boolean valid( int[] nums, int m, long target) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(int[] nums, int k, int capacity){
        
        
        int sum=0, day=1;
        for(int i=0; i<nums.length; i++){
            
            if(sum+nums[i]>capacity){
                sum=0;
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
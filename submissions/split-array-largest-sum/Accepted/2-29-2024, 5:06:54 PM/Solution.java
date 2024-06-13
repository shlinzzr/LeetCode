// https://leetcode.com/problems/split-array-largest-sum

class Solution {
    public int splitArray(int[] nums, int k) {
        
        int len = nums.length;
        
        
        int st = 0;
        int ed = 0;
        for(int n: nums){
            st= Math.max(st, n);
            ed+=n;
        }
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            if(check(nums, k, mid)){
                ed = mid;
                
            }else{
                st = mid+1;
            }
            
        }
        
        return st;
        
    }
    
    
    private boolean check(int[] nums, int k, int capacity){
        
        
        int sum=0, cnt=1;
        for(int i=0; i<nums.length; i++){
            
            if(sum+nums[i]>capacity){
                sum=nums[i];
                cnt++;// before i
            }else{
                sum+=nums[i];
            }
            
            if(cnt>k)
                return false;
        }
        
        return true;
        
        
        
        
        
        
    }
}
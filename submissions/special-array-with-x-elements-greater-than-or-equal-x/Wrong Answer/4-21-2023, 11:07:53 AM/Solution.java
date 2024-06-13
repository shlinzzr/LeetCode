// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x

class Solution {
    public int specialArray(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int st =0, ed=nums[len-1];
        
        int cnt = 0;
        while(st<ed){
            
            int mid= st+(ed-st)/2;
            
            for(int n : nums){
                if(n>mid){
                    cnt+=1;
                }
            }
            
            if(cnt==mid)
                return mid;
            
            else if(cnt>mid){
                ed = mid;
            }else{
                st= mid+1;
            }
            
        }
        
        if(cnt==nums[st])
            return cnt;
        
        
        return -1;
        
        
    }
}
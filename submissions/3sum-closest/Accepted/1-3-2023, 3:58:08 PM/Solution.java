// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        
        int abs = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        
        for(int i=0; i<len-2; i++){
            
            int st =i+1;
            int ed =len-1;
            
            while(st<ed){
                
                int sum = nums[i] + nums[st] + nums[ed];
                
                
                if(Math.abs(sum-target)<abs){
                    abs = Math.abs(sum-target);
                    res = sum;
                }
                
                if(sum==target)
                    return target;
                else if(sum > target){
                    ed--;
                }else{
                    st++;
                }
            }
            
        }
        
        return res;
    }
}
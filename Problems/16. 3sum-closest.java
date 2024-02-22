// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int res = -1;
        
        for(int i=0; i<len; i++){
            
            int j=i+1, k=len-1;
            
            while(j<k){
                
                int curr = nums[i] + nums[j] + nums[k];
            
                if(Math.abs(curr-target) < diff){
                    diff = Math.abs(curr-target);
                    res = curr;
                }
                
                if(curr==target)
                    return target;
                
                else if(curr<target){
                    j++;
                    
                }else 
                    k--;
            }
       }
        
        return res;
        
    }
}
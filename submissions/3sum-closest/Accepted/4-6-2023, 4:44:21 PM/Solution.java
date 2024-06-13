// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int res =0;
        for(int i=0; i<len-2; i++){
            
            int j=i+1, k=len-1;
            
            while(j<k){
                
                int sum = nums[i]+nums[j]+nums[k];
                
                int abs = Math.abs(sum-target);
                if(abs<min){
                    res = sum;
                    min = abs;
                }
                
                if(sum==target)
                    return target;
                
                else if(sum<target)
                    j++;
                else 
                    k--;
            }
        }
        
        return res;
    }
}
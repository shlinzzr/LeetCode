// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int min = Integer.MAX_VALUE;  
        int res = 0;                     
        
        /*
        -4 -1 1 2
        i. j. st ed
              mid
        
        */
        
        
        for(int i=0; i<len-2; i++){
            
            int j=i+1, k=len-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
            
                int abs = Math.abs(sum-target);
                if(abs<min){
                    min = abs;
                    res = sum;
                }

                if(sum==target)
                    return target;

                else if(sum > target)
                    k--;
                else 
                    j++;
            }
        }  
        
        return res;
    }
}
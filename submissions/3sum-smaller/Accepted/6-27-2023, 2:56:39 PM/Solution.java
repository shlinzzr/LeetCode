// https://leetcode.com/problems/3sum-smaller

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        
        int len = nums.length;
        
        if(len<3)
            return 0;
        
        
        Arrays.sort(nums);
        
        
        for(int i=0; i<len; i++){
            
            int j=i+1, k= len-1;
            
            while(j<k){
                
                int val = nums[i] + nums[j] + nums[k];
                
                if(val< target){
                    res+=(k-j);
                    j++;
                }else
                    k--;
                
            }
            
            
        }
        
        return res;
    }
}
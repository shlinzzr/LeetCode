// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int clo = Integer.MAX_VALUE;
        int clo_abs = Integer.MAX_VALUE;
        
        
        for(int i=0; i<len; i++){
            
            int j=i+1;
            int k=len-1;
            
            while(j<k){
                
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum-target)< clo_abs){
                    clo_abs = Math.abs(sum-target);
                    clo = sum;
                }
                
                
                if(target-sum>0){
                    j++;
                    
                }else{
                    k--;
                }
            }
        }
        return clo;
    }
}
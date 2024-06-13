// https://leetcode.com/problems/3sum-smaller

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        int len = nums.length;
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int res =0;
        for(int i=0; i<len-2; i++){

            int j=i+1, k=len-1;
            
            while(j<k){
                
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum < target){
                    res+= k-j;
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return res;
    }
}
        

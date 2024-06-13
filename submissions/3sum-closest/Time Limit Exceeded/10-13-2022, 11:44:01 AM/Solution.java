// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int sum = -3000;
        int dis = Integer.MAX_VALUE;
        
        for(int i=0; i<len; i++){
            
            int j=i+1;
            int k=len-1;
            
            while(j<k){

                int curr = nums[i]+nums[j]+nums[k];
                int currDis = Math.abs(target-curr);
                    
                if(currDis<dis || currDis==0){
                    dis = currDis;
                    sum=curr;
                    
                }else if(target-curr>0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return sum;
        
    }
}
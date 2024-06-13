// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int len = nums.length;

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int res =0 ;
        for(int i=0; i<len; i++){
            int j=i+1;
            int k = len-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(sum-target);
                if(diff<min){
                    min = diff;
                    res = sum;
                }

                if(sum-target==0) return sum;
                else if(sum-target>0){
                    k--;
                }else 
                    j++;
            }
        }
        return res;
        
    }
}
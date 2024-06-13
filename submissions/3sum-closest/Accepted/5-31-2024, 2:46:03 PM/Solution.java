// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        Arrays.sort(nums);

        int res = -1;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<len-2; i++){

            int j=i+1, k=len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(sum-target)<diff){
                        diff = Math.abs(sum-target);
                        res = sum;
                }

                if(sum==target) return target;
                else if(sum>target){
                    k--;
                }else{
                    j++;
                }

            }
        }

        return res;

        

        
    }
}
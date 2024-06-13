// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int res = 0;

        for(int i=0; i<3; i++){
            res += nums[i];   
        }

        int len = nums.length;
        int st=0, ed=len-1;

        for(int i=0; i<len-2; i++){
            int j=i+1, k=len-1;

            int sum = nums[i]+ nums[j] + nums[k];

            if(Math.abs(sum-target)<Math.abs(res-target)){
                res = sum;
            }

            if(sum == target){
                return target;
            }else if(sum>target){
                k--;
            }else {
                j++;
            }
        }
        return res;
        
    }
}
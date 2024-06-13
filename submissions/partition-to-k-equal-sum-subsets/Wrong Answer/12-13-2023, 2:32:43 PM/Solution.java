// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;
        for(int n: nums){
            sum+=n;
        }

        if(sum%k!=0) return false;
        int target = sum/4;

        int[] arr = new int[k];

        Arrays.sort(nums);

        return match(nums, len-1, arr, target);
    }

    private boolean match(int[] nums, int idx, int[] arr, int target){
        boolean rt = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=target)
                rt = false;
        }

        if(rt) return true;

        rt = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>target)
                rt = false;
        }

        if(rt==false) return false;

        int v = nums[idx];
        for(int i=0; i<arr.length; i++){
            arr[i] += v;
            if(match(nums, idx-1, arr, target)){
                return true;
            }
            arr[i]-=v;
        }

        return false;


    }



}
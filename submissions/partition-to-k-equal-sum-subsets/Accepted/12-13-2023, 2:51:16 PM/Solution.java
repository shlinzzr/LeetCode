// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;
        for(int n: nums){
            sum+=n;
        }

        if(sum%k!=0 || len<k) return false;
        int target = sum/k;

        int[] arr = new int[k];

        Arrays.sort(nums);

        return match(nums, len-1, arr, target);
    }

    private boolean match(int[] nums, int idx, int[] arr, int target){

        if(idx==-1)
            return true;

        // boolean allMatch = true;
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i]!=target)
        //         allMatch = false;
        // }

        // if(allMatch) return true;

        // boolean overTarget = false;
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i]>target)
        //         overTarget = true;
        // }
        // if(overTarget) return false;

        int val= nums[idx];
        for(int i=0; i<arr.length; i++){

            if(arr[i]+val<=target){
                arr[i] += val;
                if(match(nums, idx-1, arr, target)){
                    return true;
                }
                arr[i] -= val;
            }


            //如果前一個 arr[i] 被backtrack==0 表示已經不是答案
            if(arr[i]==0)  
                break;
            
        }

        return false;


    }



}
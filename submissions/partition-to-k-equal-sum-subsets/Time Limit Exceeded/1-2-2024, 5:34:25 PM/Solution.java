// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    int cnt =0 ;
    List<Integer> list = new ArrayList<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        int sum = 0 ;
        for(int n : nums){
            sum+=n;
        }

        if(sum%k!=0) return false;
        int target = sum/k;
        return dfs(nums, 0L, 0, target, k);

    }

    private boolean dfs(int[] nums, long state, int cur , int target, int k){
        if(cur>target) return false;
        if(cur==target){
          
            k--;
            if(k==0)
                return true;
            cur=0;
            
        }

        for(int i=0; i<nums.length; i++){
            if( (state & (1<<i))==0){
                list.add(i);
                boolean rt = dfs(nums, state|(1<<i), cur+ nums[i], target, k);
                list.remove(list.size()-1);
                if(rt) return true;
            }
        }
        return false;
    }
}
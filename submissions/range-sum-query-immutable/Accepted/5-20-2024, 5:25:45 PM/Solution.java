// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    int[] presum;
    public NumArray(int[] nums) {
        int len = nums.length;
        presum = new int[len+1];
        for(int i=0; i<len;i++){
            presum[i+1] = nums[i] + presum[i];
        }
        //.  0 1 2 3
        //   1 2 3 4
        // 0 1 3 6 10
    }
    
    public int sumRange(int left, int right) {
        return presum[right+1]-presum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
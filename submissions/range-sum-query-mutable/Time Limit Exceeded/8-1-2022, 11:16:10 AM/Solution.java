// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {

    private int arr[];
    
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    public void update(int index, int val) {
        arr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int s = 0;
        
        for(int i=left; i<=right; i++){
            s+=arr[i];
        }
        return s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {

    private int[] arr;
    private int[] b;
    int len;
    
    public NumArray(int[] nums) {
        arr = nums;
        
        double d = Math.sqrt(nums.length);
        len = (int)Math.ceil(nums.length/1);
        b = new int[len];
        
        for(int i=0; i<nums.length; i++){
            b[i/len]+=nums[i];
        }
        
        
    }
    
//     public void update(int index, int val) {
//         arr[index] = val;
        
//     }
    
//     public int sumRange(int left, int right) {
//         int s = 0;
        
//         for(int i=left; i<=right; i++){
//             s+=arr[i];
//         }
//         return s;
//     }
    
    
    
public int sumRange(int i, int j) {
    int sum = 0;
    int startBlock = i / len;
    int endBlock = j / len;
    if (startBlock == endBlock) {
        for (int k = i; k <= j; k++)
            sum += arr[k];
    } else {
        for (int k = i; k <= (startBlock + 1) * len - 1; k++)
            sum += arr[k];
        for (int k = startBlock + 1; k <= endBlock - 1; k++)
            sum += b[k];
        for (int k = endBlock * len; k <= j; k++)
            sum += arr[k];
    }
    return sum;
}

public void update(int i, int val) {
    int b_l = i / len;
    b[b_l] = b[b_l] - arr[i] + val;
    arr[i] = val;
}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    int[] arr ;
    
    public NumArray(int[] nums) {
        int len = nums.length;
        
        arr = new int[len];
        for(int i=0; i<len; i++){
            
            if(i==0)
                arr[i]=nums[i];
            else{
                arr[i] = arr[i-1]+nums[i];
            }
        }
        
//         for(int a: arr){
//             System.out.print(a +",");
            
//         }System.out.println();
        
    }
    
    public int sumRange(int left, int right) {
        // System.out.println(arr[right]);
        // System.out.println(arr[left]);
        return left==0? arr[right] : arr[right]-arr[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k

class Solution {
  public long minOperationsToMakeMedianK(int[] nums, int k) {
    final int n = nums.length;
    long operation = 0;

    Arrays.sort(nums);
    // index of median
    final int m = n / 2;
    operation += Math.abs(nums[m] - k);


    System.out.println("m="+m);
    
         System.out.println("operation="+operation);
    for (int j = m - 1; j >= 0 && k < nums[j]; j--) {
      operation += nums[j] - k;

         System.out.println("operation="+operation);
    }

    for (int j = m + 1; j < n && k > nums[j]; j++) {
      operation += k - nums[j];
      
         System.out.println("operation="+operation);
    }

    return operation;
  }
}
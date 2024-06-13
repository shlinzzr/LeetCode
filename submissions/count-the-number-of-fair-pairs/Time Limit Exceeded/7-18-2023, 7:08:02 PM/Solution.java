// https://leetcode.com/problems/count-the-number-of-fair-pairs

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            
            long b = ceiling(nums, i, upper-nums[i]);
            
                       System.out.println(i); 
            long a = floor(nums, i, lower-nums[i]);
            System.out.println(i + " " + a + "->" + b + " add:" + ((b)-a) ); 
            if(a==b && a<nums.length && (nums[i]+nums[(int)a]>upper || nums[i]+nums[(int)a]<lower))
               continue;
            result += (b)-a;
        }
        return result;
    }
    public long ceiling(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            
            
            System.out.println(mid);
            if (nums[mid] <= (target)) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
     public long floor(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < (target)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
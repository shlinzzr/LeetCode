// https://leetcode.com/problems/maximum-product-difference-between-two-pairs

class Solution {
    
//            // Big-O(NlgN)
//     public int maxProductDifference(int[] nums) {
 
//         Arrays.sort(nums);
        
//         return Math.abs(nums[0]* nums[1] - nums[nums.length-1]*nums[nums.length-2]);
        
//     }
    
    
    // O(N)
    public int maxProductDifference(int[] nums) {
	int largest = 0, secondLargest = 0, smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
	for(int i=0;i<nums.length;i++) {
		if(nums[i]>=largest) {
			secondLargest = largest;
			largest = nums[i];
		} else if(nums[i]>secondLargest) secondLargest = nums[i];
		if(nums[i]<=smallest) {
			secondSmallest = smallest;
			smallest = nums[i];
		} else if(nums[i]<secondSmallest) secondSmallest = nums[i];
	}
	return largest * secondLargest - smallest * secondSmallest;
}
    
}
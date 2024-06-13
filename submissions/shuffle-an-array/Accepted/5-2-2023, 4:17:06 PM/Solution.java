// https://leetcode.com/problems/shuffle-an-array

class Solution {
	int[] nums;
	public Solution(int[] nums) {
		this.nums = nums;
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] res = new int[nums.length];
		res = nums.clone();
		
		for(int i = 0; i < nums.length; i++){
			int rand = (int)(Math.random()*(nums.length - i)) + i;
			swap(res, i, rand);
		}
		return res;
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
// https://leetcode.com/problems/shuffle-an-array

class Solution {
    
    //https://www.youtube.com/watch?v=VO0mf19dBWU
    
	int[] nums;
    Random rand;
    
	public Solution(int[] nums) {
		this.nums = nums;
        rand = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] res = new int[nums.length];
		res = nums.clone();
		
		for(int end = nums.length-1; end>=0 ; end--){
			int idx = rand.nextInt(end+1);
			swap(res, idx, end);
		}
		return res;
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
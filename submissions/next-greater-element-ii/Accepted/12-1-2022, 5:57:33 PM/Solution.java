// https://leetcode.com/problems/next-greater-element-ii

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        
        // int[] nn = new int[len*2];
        // System.arraycopy(nums, 0, nn, 0, len);
        // System.arraycopy(nums, 0, nn, len, len);
        
        int[] res = new int[len];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len])
                res[stack.pop()] = nums[i % len];
            stack.push(i % len);
        }
        return res;
        
        
    }
}
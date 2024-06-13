// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        
        
        int[] leftMin= new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min , nums[i]);
            leftMin[i] = min;
        }
        
        
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            
            int second=Integer.MIN_VALUE;
            if(!st.isEmpty() && st.peek()<nums[i]){
                second = st.pop();
            }
            
            if(leftMin[i]<second){
                return true;
            }
            st.push(nums[i]);
            
        }
        
        
        
        return false;
    }
}
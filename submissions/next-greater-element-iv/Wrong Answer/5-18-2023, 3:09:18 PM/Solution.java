// https://leetcode.com/problems/next-greater-element-iv

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        int len = nums.length;
        boolean[] bool = new boolean[len];
        
         int[] res = new int[len];
        Arrays.fill(res, -1);
        
        // st = 2 4 0 9
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            
            while(!st2.isEmpty() && nums[st2.peek()]<n){
                res[st2.pop()]= nums[i];
            }
            
            while(!st.isEmpty() && nums[st.peek()]<n){
                
                st2.push(st.pop());
            }
            st.push(i);
        }
        
       
        return res;
        
        
    }
}
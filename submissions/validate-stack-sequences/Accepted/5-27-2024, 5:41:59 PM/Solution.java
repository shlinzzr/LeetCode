// https://leetcode.com/problems/validate-stack-sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        

        Stack<Integer> st = new Stack<>();
        
        int j = 0;
        for(int i=0; i<pushed.length; i++){

            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }

        while(j<popped.length){
            if(st.isEmpty() || st.peek()!=popped[j]) return false;
            j++;
            st.pop();
        }

        return st.isEmpty();
        
    }
}
// https://leetcode.com/problems/validate-stack-sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx1=0, idx2=0;
        int len1 = pushed.length, len2=popped.length;

        Stack<Integer> st = new Stack<>();
        st.push(pushed[0]);
        idx1++;

        while( idx2<len2){

            while(!st.isEmpty() && st.peek()==popped[idx2]){
                st.pop();
                idx2++;
            }

            if(idx1==len1)
                if(st.isEmpty())
                    return true;
                else 
                    return false;
                
            
            st.push(pushed[idx1++]);
        }

        return true;
    }
}
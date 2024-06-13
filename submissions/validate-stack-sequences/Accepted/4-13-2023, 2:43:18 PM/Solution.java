// https://leetcode.com/problems/validate-stack-sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx1=0; int idx2=0;
        
        int len=pushed.length;
        
        Stack<Integer> st = new Stack<>();
        
        while(idx1<len && idx2<len){
            
            while(idx1<len && pushed[idx1]!=popped[idx2]){
                st.push(idx1); // 0 1 2
                idx1++;
            }
            
            idx1++;
            idx2++;
            
            while(!st.isEmpty() && idx2<len && pushed[st.peek()]==popped[idx2]){
                idx2++;
                st.pop();
            }
            
        }
        
        
        if(!st.isEmpty())
            return false;
        
        return true;
    }
}
// https://leetcode.com/problems/max-chunks-to-make-sorted

class Solution {
    public int maxChunksToSorted(int[] arr) {
         int len = arr.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, arr[i]);
            if(st.isEmpty()){
                max = Math.max(max, arr[i]);
                st.push(max);
                continue;
            }else{

                
                while(!st.isEmpty() && arr[i]<st.peek()){
                    st.pop();
                }
                st.push(max);

            }
        }

        return st.size();
    
    }
}
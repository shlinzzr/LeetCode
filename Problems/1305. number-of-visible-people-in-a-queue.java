// https://leetcode.com/problems/number-of-visible-people-in-a-queue

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int len = heights.length;

        int[] ans = new int[len];

        int[] prevGreater = new int[len];
        Arrays.fill(prevGreater, -1);

        Stack<Integer> st = new Stack<>();
        for(int i =len-1; i>=0; i--){

            while(!st.isEmpty() && heights[i]>heights[st.peek()]){
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, len);
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && heights[st.peek()]<heights[i]){
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }


        for(int i=0; i<len; i++){
            if(prevGreater[i]!=-1){
                ans[prevGreater[i]]++;
            }

           if(nextGreater[i]!=len){
                ans[i]++;
            }
        }

        return ans;


    }
}


/*
[3,0,1,0,0,0]



*/

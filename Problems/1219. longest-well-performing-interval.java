// https://leetcode.com/problems/longest-well-performing-interval

class Solution {
    public int longestWPI(int[] hours) {
        int len = hours.length;


/*
[9,9,6,0,6,6,9] => [1,1,-1,-1,-1,-1,1]
presum =>   [1,2,1,0,-1,-2,-1] 
offset => [0,1,2,1,0,-1,-2,-1]

 find maxLen Of [i, j] s.t. presum[j] - presum[i]>0  ==> presum[i]>presum[j]

 ref : leetcode 962

*/

        int[] presum = new int[len+1]; // offset
        int sum = 0 ;
        for(int i=0; i<len; i++){
            sum += hours[i]>8 ? 1 : -1;
            presum[i+1] = sum;
        }


        // find caddidate i, make stack desc
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len+1; i++){
            if(st.isEmpty() || presum[st.peek()]>presum[i]){
                st.push(i);
            }
        }

        //find j to match from back, if match : calculate max
        int max = 0;
        for(int j=len; j>=0; j--){
            while(!st.isEmpty() && presum[st.peek()]<presum[j]){
                max = Math.max(max, j-st.pop());
            }
        }


        return max;
    }
}


// https://leetcode.com/problems/longest-well-performing-interval

class Solution {
    public int longestWPI(int[] hours) {
        int len = hours.length;


/*
[9,9,6,0,6,6,9] => [1,1,-1,-1,-1,-1,1]
presum =>   [1,2,1,0,-1,-2,-1] 
presum => [0,1,2,1,0,-1,-2,-1]

 find maxLen Of [i, j] s.t. presum[j] - presum[i]>0  ==> presum[j]>presum[i]

 ref : leetcode 962

*/

        int[] presum = new int[len+1]; 
        int sum = 0 ;
        for(int i=0; i<len; i++){
            sum += hours[i]>8 ? 1 : -1;
            presum[i+1] = sum;
        }


        // 對於i來說 若前一個presum[st.peek()] 比presum[i]還小 
        // 就不用push stack了 因為更可能成立presum[j]>presum[i]而且位置還更遠
        // else : push stack


        Stack<Integer> st = new Stack<>();
        // find caddidate i, make stack desc
        // 後面雖然直比較小 也比較近 至少公式會成立
        for(int i=0; i<len+1; i++){
            if(st.isEmpty() || presum[st.peek()]>presum[i]){
                st.push(i);
            }
        }

        //對於j從後面來說 要找的是stack中最遠的i s.t. presum[j]> presum[st.peek()] 
        // 然後算 max = Math.max(max, j-st.pop)

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


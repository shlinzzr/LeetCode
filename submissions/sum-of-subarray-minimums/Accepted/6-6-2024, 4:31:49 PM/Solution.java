// https://leetcode.com/problems/sum-of-subarray-minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int len = arr.length;

     

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty()&& arr[st.peek()]>arr[i]){
                nextSmaller[st.pop()]=i;
            }
            st.push(i);
        }

        st.clear();
        int[] prevSmallerOrEqual = new int[len];
        Arrays.fill(prevSmallerOrEqual, -1);
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                prevSmallerOrEqual[st.pop()] = i;
            }
            st.push(i);
        }


        // 0 1 2
        //     i

        int M = (int)1e9+7;
        long res =0L ;
        for(int i=0; i<len; i++){
            // for i
            int left = prevSmallerOrEqual[i]+1;
            int right = nextSmaller[i]-1;

            long cnt = (i-left+1) * (right-i+1) %M;
            res = (res+ cnt*arr[i])%M;

            
            // res += (right-left+1)*(long)arr[i]%M;

            //  System.out.println(left + " " + arr[i] + " " + right + " res="+res);
        }

        return (int)res;



        // find all subarray
        // b-f
        // for(int i=0; i<len; i++){
        //     for(int j=i; j<len; j++){
        //         // iter all to find min of [i, j] ...
        //     }
        // }


        
    }
}
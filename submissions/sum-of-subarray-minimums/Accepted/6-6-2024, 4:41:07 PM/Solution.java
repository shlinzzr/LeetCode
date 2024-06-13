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

        //關鍵-> prevSmaller 改 prevSmallerOrEqual; 
        //why ? consider below case :
        // 2 [8 5 6 5 6 ]2  第一個5 會算到這個array
        //      ^

        // 2 [8 5 6 5 6 ]2  第二個5 也會算到這個array=>重複算了
        //          ^                              

        //=> 要馬 prevSmaller 改 prevSmallerOrEqual 
        // 不然就 nextSmaller 改 nextSmallerOrEqual 才不會重複算

        // 修改後 
        // 2 8 5 [6 5 6 ]2  第二個5 只算後面的部分
        //          ^      

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
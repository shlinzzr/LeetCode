// https://leetcode.com/problems/xor-queries-of-a-subarray

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int len = arr.length;
        int[] prexor = new int[len];

        int[] sufxor = new int[len];

        for(int i=0; i<len; i++){
            prexor[i] = i==0? arr[i] : arr[i] ^ prexor[i-1];

            int idx = len-i-1;
            sufxor[idx] = idx==len-1 ? arr[idx] : arr[idx]^ sufxor[idx+1];
        }

        int[] res = new int[len];
        for(int i=0; i<queries.length; i++){

            int left = queries[i][0];
            int right = queries[i][1];

            res[i] = prexor[len-1];
            if(left-1>=0) res[i] ^= prexor[left-1];
            if(right+1<len) res[i] ^= sufxor[right+1];
        }
        return res;


        
        // a^b^c^d^e
        // q = c, d

        // all = presum[len-1] ^ sufsum[right+1] ^ presum[left-1];



        
    }
}
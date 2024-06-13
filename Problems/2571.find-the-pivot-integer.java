// https://leetcode.com/problems/find-the-pivot-integer

class Solution {
    public int pivotInteger(int n) {
        

        int[] presum = new int[n];
        int[] sufsum = new int[n];

        for(int i=0; i<n ;i++){
            presum[i] = i==0 ? 1 : presum[i-1]+i+1;
        }

        for(int i=n-1; i>=0; i--){
            sufsum[i] = i==n-1 ? n : sufsum[i+1] + i+1;
        }

        for(int i=0; i<n; i++){
            if(presum[i]==sufsum[i])
                return i+1;
        }

        return -1;
    }
}
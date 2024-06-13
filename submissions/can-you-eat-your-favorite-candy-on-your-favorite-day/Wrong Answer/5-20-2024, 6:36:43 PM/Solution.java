// https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day

class Solution {
    // T = O(n) S=O(n)
    public boolean[] canEat(int[] cc, int[][] queries) {
        // calculate prefix sum
        long[] presum = new long[cc.length+1];
        boolean[] res = new boolean[queries.length];
        
        for(int i=0; i< cc.length; i++)
            presum[i+1] = presum[i]+cc[i];
        
        for(int i=0; i< res.length; i++) {
            int type = queries[i][0];
            int day  = queries[i][1];
            int cap  = queries[i][2];
            
            // max and min day required to eat
            // if we eat one candy per day including type candy (prefix[type+1]). we decrement by 1 since we need atleast one candy of type
            long maxDay = presum[type+1]; 
            // if we eat upto capacity each day upto previous candy
            long minDay = presum[type]/cap; 
        
            // check if query day is within the limits (minDay and maxDay inclusive)
            res[i] = (minDay <= day && day <= maxDay);            
        }
        
        return res;
    }
}
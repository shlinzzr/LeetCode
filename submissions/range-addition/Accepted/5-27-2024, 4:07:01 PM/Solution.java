// https://leetcode.com/problems/range-addition

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {

        int[] diff = new int[length+1];
        for(int[] u : updates){
            diff[u[0]]+= u[2];
            diff[u[1]+1]-=u[2];
        }


        int[]res = new int[length];
        int cur= 0;
        for(int i=0; i<length; i++){
            cur += diff[i];
            res[i] = cur;
        }

        return res;
        
    }
}
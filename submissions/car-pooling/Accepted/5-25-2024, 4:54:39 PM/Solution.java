// https://leetcode.com/problems/car-pooling

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] arr = new int[1001];

        for(int[] t : trips){
            arr[t[1]]+= t[0];
            arr[t[2]]-= t[0];
        }

        int cur = 0;
        for(int i=0; i<=1000; i++){
            cur+= arr[i];
            if(cur>capacity) return false;
        }

        return true;
        
    }
}
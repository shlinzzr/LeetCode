// https://leetcode.com/problems/maximum-population-year

class Solution {
    public int maximumPopulation(int[][] logs) {

        int len = logs.length;
        int[] arr = new int[2100];
        for(int[] log : logs){
            arr[log[0]]++;
            arr[log[1]+1]--;
        }
        int max = 0;
        int res = 0;
        int cur = 0;
        for(int i=1950;i<arr.length; i++){
            cur += arr[i];
            if(cur>max){
                res = i ;
                max = cur;
            }
        }

        return res;
        
    }
}
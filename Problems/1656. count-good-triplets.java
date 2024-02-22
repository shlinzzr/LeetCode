// https://leetcode.com/problems/count-good-triplets

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length, cnt=0;
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    
                    if( Math.abs(arr[i]-arr[j])<=a
                     && Math.abs(arr[k]-arr[j])<=b
                     && Math.abs(arr[i]-arr[k])<=c )
                        cnt++;
                    
                }
            }
        }
        return cnt;
    }
}
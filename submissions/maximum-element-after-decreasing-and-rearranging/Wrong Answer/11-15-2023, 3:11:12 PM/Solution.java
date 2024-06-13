// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;

        Arrays.sort(arr);

        for(int i=1; i<len; i++){
            while(arr[i]-arr[i-1]>1){
                arr[i]--;
            }
        }

        return arr[len-1];
    }
}
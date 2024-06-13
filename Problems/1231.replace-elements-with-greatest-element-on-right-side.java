// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        
        int len = arr.length;
        
        int max = -1;
        
        for(int i=len-1; i>=0 ;i--){
            int val = arr[i];
            arr[i] = max;
            max = Math.max(val, max);
        }        
        
        return arr;
    }
}
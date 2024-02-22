// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        
        int len = arr.length;

        int max= -1;
        for(int i=len-1; i>=0; i--){
            int ins = max;
            max=Math.max(max, arr[i]);
            arr[i] = ins;
        }
        
        
        
        return arr;
    }
}
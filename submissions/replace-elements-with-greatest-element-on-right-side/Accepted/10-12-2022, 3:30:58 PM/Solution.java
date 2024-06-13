// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        
        int len = arr.length;

        
        for(int i=0; i<len; i++){
            int max = -1;
            for(int j=i+1; j<len; j++){
                max= Math.max(max, arr[j]);
            }
            arr[i] = max;
        }
        
        arr[len-1]=-1;
        
        
        return arr;
    }
}
// https://leetcode.com/problems/shuffle-string

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        
        for(int i=0; i<indices.length; i++){
            
            int idx = indices[i];
            char c = s.charAt(i);
            
            arr[idx] = c;
        }
        
        return String.valueOf(arr);
        
        
    }
}
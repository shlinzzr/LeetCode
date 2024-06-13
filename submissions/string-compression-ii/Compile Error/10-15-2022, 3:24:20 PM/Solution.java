// https://leetcode.com/problems/string-compression-ii

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[] arr = new int[26];
        int len = s.length();
        for(int i=0; i<len;i++){
             char c = s.charAt(i);
             arr[c-'a']++;

        }
        
        while(k>0){
            int idx = findMin(arr);
            arr[idx]--;
            
        }
        
    }


private int findMin(int[] arr){
    int min = Integer MAX_VALUE;
    int idx =0;
    for (int i=0; i<26; i++){
         if(n<min){
             min=n;
             idx=i;
         }

    }
    
    return idx;
}
}
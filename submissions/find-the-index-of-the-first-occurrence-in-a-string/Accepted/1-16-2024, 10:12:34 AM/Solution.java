// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {

        // KMP algo : O(MN) -> O(M)
        
        
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        int[] next = new int[n];
        next[0] = -1;


        //write next array to store previous where we have same pattern
        //starting from the second item to mth item
        for (int i = 1, j = -1; i < n; i++){
            while(j > -1 && needle.charAt(i) != needle.charAt(j + 1) ){
                j = next[j];
            }

            if (needle.charAt(i) == needle.charAt(j + 1)){
                j++;
            }

            next[i] = j;
        }

        // go throught haystack
        for (int i = 0, j = -1; i < m; i++){
            while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)){
                j++;
            }

            if (j == n  - 1){
                return i - n +1;
            }
        }

        return -1;
    }
}
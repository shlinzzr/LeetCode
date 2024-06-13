// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {

        // KMP algo : O(MN) -> O(M)
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;

        // init

        // needle
        // <--- n --->
        // x x x x x x
        // j i

        // create prefix(next) array
        // 1. while not match
        // 2. match
        // 3.
        
        // a a b a a f 
        // 0 1 0 1 2 0
        //   j i

        int[] next = getNext(needle);

        for(int a : next){
            System.out.print(a + " ,");
        }

        // go throught haystack
        for (int i = 0, j = 0; i < m; i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }

            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }

            if (j == n ){
                return i - n +1;
            }
        }

        return -1;
    }


    private int[] getNext(String needle){
        int n = needle.length();
        int[] next = new int[n];
        for(int j=0, i=1; i<n; i++){

            while(j>0 && needle.charAt(j)!=needle.charAt(i)){
                j = next[j-1];
            }

            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
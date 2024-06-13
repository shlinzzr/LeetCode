// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        if(null == s || s.trim().length() == 0){
            return false;
        }

        int[] next = getNext(s);

        int left = s.length()-next[next.length-1];

        if(left==s.length()) return false;

        if(s.length()%left!=0) return false;


        // abcabcabcabc
        // 000123456789

        return true;
        
    }
    

    public  List<Integer> KMP(String haystack, String needle) {
        List<Integer> list = new ArrayList<>();
       
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return list;

        int[] next = getNext(needle);

        for (int j=0, i=0; i < m; i++){
            while (j > 0 && j<n && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1]; // fallback
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if ( j==n ){
                list.add(i-n+1);
                j=next[j-1];
            }
        }
       
        return list;
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
        
        for(int nn: next){
            System.out.print(nn + ",");
        }
        System.out.println();
        return next;
    }
}
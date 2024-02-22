// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int[] next = getNext(s);

        int left = s.length()-next[next.length-1];

        if(left==s.length()) return false;

        if(s.length()%left!=0) return false;


        // abcabcabcabc
        // 000123456789

        return true;
        
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
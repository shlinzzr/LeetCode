// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i1=0, i2=0;
        int len1 = str1.length();
        int len2 = str2.length();
        
        
        while(i1<len1 && i2<len2){
            
            char ch1 = str1.charAt(i1);
            char ch2 = str2.charAt(i2);
            
            while( i1<len1 && ch1 !=ch2 && (ch1+1-'a')%26+'a'!=ch2){
                i1++;
                if(i1<len1)
                    ch1 = str1.charAt(i1);
            }
                
            
            if(ch1==ch2 || (ch1+1-'a')%26+'a'==ch2)
            i2++;
        }
        
        return i2==len2;
    }
}
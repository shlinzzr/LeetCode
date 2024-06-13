// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        String res = s.charAt(0)+"";
        
        for(int i=0; i<len; i++){

            String odd = expand(s, i, i);
            if(odd.length()>res.length()){
                res = odd;
            }

            if(i+1<len){
                String even = expand(s, i, i+1);
                if(even.length()>res.length()){
                    res = even;   
                }
            }
        }

        return res;

    }
    private String expand(String s , int i, int j){
        
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--; 
            j++;
        }

        i++;
        j--;

        return s.substring(i, j+1);
    }


 // public String longestPalindrome(String s) {
        // String res = s.charAt(0)+"";

        // for(int i=0; i<len; i++){

        //     for(int j=i+2; j<=len; j++){
        //         String sub = s.substring(i, j);
        //         if(sub.length()<res.length()) continue;
        //         if(isPal(sub)){
        //             res = sub;
        //         }
        //     }
            
        // }

        // return res;
    // }

    private boolean isPal(String s){
        int len = s.length();

        for(int i=0; i<len/2; i++){

            int j = len-i-1;

            if(s.charAt(i)!=s.charAt(j))
                return false;
        }   

        return true;
    }
}
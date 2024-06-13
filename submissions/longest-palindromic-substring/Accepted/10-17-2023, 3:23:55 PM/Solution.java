// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {

        String res = "";
        for(int st=0; st<s.length(); st++){

            for(int ed=st+1+res.length(); ed<=s.length(); ed++){
                String sub = s.substring(st, ed);
                if(isPal(sub))
                    res = sub;

            }

        }

        return res;
        
    }

    private boolean isPal(String s){

        int st=0, ed=s.length()-1;

        while(st<ed){
            if(s.charAt(st++)!=s.charAt(ed--))
                return false;
        }

        return true;

    }
}
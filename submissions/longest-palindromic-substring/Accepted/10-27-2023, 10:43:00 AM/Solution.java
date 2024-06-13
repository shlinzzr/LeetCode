// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {

        String res = "";

        for(int mid = 0; mid<s.length(); mid++){

            String odd = helper(s, mid, mid);
            if(odd.length()>res.length()){
                res = odd;
            }


            String even = helper(s, mid, mid+1);
            if(even.length()>res.length()){
                res = even;
            }
        }

        return res;
        
    }

    private String helper(String s, int st, int ed){

       
        while(st>=0 && ed<s.length() && s.charAt(st)==s.charAt(ed)){
            st--;
            ed++;
        }

        st++;
        ed--;


        String res= s.substring(st, ed+1);

        return res;


    }
}

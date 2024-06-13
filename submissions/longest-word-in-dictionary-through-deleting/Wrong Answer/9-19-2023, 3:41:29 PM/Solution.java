// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";

        for(String d : dictionary){

            int idx=0;
            for(int i=0;i<s.length() && idx<d.length();i++){
                if(s.charAt(i)==d.charAt(idx)){
                    idx++;
                }
            }

            if(idx==d.length()){
                if(d.length()>res.length())
                    res=d;
            }



        }

        return res;
    }
}
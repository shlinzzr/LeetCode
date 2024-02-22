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
                // System.out.println(d+" "+res+ ", "+(d.compareTo(res)));

                if(d.length()>res.length())
                    res=d;
                else if(d.length()==res.length() && d.compareTo(res)<0)
                    res =d;
            }



        }

        return res;
    }
}
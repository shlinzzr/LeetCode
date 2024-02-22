// https://leetcode.com/problems/bold-words-in-string

class Solution {
    public String boldWords(String[] words, String s) {
        int len = s.length();
        boolean[] bold = new boolean[len];


        for(String w: words){

            int st = s.indexOf(w);

            while(st>=0){

                for(int i=st; i<st+w.length(); i++){
                    bold[i]=true;
                }

                st = s.indexOf(w, st+1);
            }
        }

        String open = "<b>";
        String close = "</b>";

        StringBuilder sb = new StringBuilder();

        boolean isBold = false;

        for(int i=0; i<len; i++){

            if(bold[i] && (i==0 || !bold[i-1])){
                sb.append(open);
                isBold = true;
            }

            sb.append(s.charAt(i));
   
            if (bold[i] && (i == len - 1 || !bold[i + 1])) { // i是bold, i+1是!bold的時候 + closetag
                sb.append(close);
            }
                
        }

        return sb.toString();

    }
}
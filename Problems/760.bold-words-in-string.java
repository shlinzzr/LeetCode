// https://leetcode.com/problems/bold-words-in-string

class Solution {
    public String boldWords(String[] words, String s) {

        int len = s.length();

        boolean[] b = new boolean[len];

        Set<String> set = new HashSet<>(Arrays.asList(words));

       
        for(String w: words){

            int st = s.indexOf(w);

            while(st>=0){

                for(int i=st; i<st+w.length(); i++){
                    b[i]=true;
                }

                st = s.indexOf(w, st+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){

            if((i==0 && b[i]) || (i>0 && b[i-1]==false && b[i])){
                sb.append("<b>");
            }

            sb.append(s.charAt(i));

            if((i==len-1 && b[i]) || (i<len-1 && b[i]&& b[i+1]==false))
                sb.append("</b>");
        }

        return sb.toString();


        
    }
}
// https://leetcode.com/problems/bold-words-in-string

class Solution {
    public String boldWords(String[] words, String s) {

        int len = words.length;

        boolean[] b = new boolean[len];

        Set<String> set = new HashSet<>(Arrays.asList(words));

        for(int i=0; i<len; i++){

            for(String w : words){
                int idx = s.indexOf(w, i);
                if(idx>=0){
                    b[i] = true;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){

            if((i==0 && b[i]) || (b[i-1]==false && b[i])){
                sb.append("<b>");
            }

            sb.append(s.charAt(i));

            if((i==len-1 && b[i]) || (b[i]&& b[i+1]==false))
                sb.append("</b>");
        }


        
    }
}
// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
    public String robotWithString(String s) {

        StringBuilder t = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();

        while(sb.length()>0){

            char s_head = sb.charAt(0);

            if(t.length()>0 && t.charAt(t.length()-1)<s_head){
                char t_tail = t.charAt(t.length()-1);
                t.deleteCharAt(t.length()-1);
                res.append(t_tail);
            }else{
                sb.deleteCharAt(0);
                t.append(s_head);
            }
        }

        while(t.length()>0){
            char t_tail = t.charAt(t.length()-1);
            t.deleteCharAt(t.length()-1);
            res.append(t_tail);
        }

        return res.toString();

        
    }
}
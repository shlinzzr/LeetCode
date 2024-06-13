// https://leetcode.com/problems/decoded-string-at-index

class Solution {
    public String decodeAtIndex(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        int rp = 0;
        for(int i=0; i<len && sb.length()<=k ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                rp = ch-'0';
                // while(i+1<len && Character.isDigit(s.charAt(i+1))){
                //     rp = rp*10 + (s.charAt(i+1)-'0');
                //     i++;
                // }

                StringBuilder t = new StringBuilder();
                for(int j=0; j<rp ; j++){
                    t.append(sb);
                }
                sb = t;
                // System.out.println(sb.toString());

            }else{
                sb.append(ch);
            }
        }

        return sb.toString().charAt(k-1)+"";
    }
}
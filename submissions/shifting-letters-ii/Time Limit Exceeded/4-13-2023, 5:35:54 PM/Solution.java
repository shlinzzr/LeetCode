// https://leetcode.com/problems/shifting-letters-ii

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        for(int[] sh : shifts){
            
            int st= sh[0];
            int ed = sh[1];
            int dir= sh[2];

            String sub = "";
            for(int i=st; i<=ed; i++){
                
                int val = s.charAt(i);
                
                if(dir==1){
                     val = s.charAt(i)-'a'+1;
                }else{
                     val = s.charAt(i)-'a'-1;
                }
                
                
               
                 if(val>=26) val-=26;
                if(val<0) val+=26;
                
                char ch = (char)('a'+val);
                sub+=ch;
            }
            
            s = s.substring(0, st) + sub + s.substring(ed+1);
        }
        return s;
    }
}
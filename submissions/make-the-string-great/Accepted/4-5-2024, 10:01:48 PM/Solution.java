// https://leetcode.com/problems/make-the-string-great

class Solution {
    public String makeGood(String s) {
        
       
        boolean redo = true;        
        
        
        while(redo==true){
            int len = s.length();
            boolean hit = false;
            
            for(int i=0; i<len-1; i++){
                if((s.charAt(i)-'a'== s.charAt(i+1)-'A')
                || (s.charAt(i)-'A'== s.charAt(i+1)-'a')){


                    if(i+2<len)
                        s = s.substring(0, i) + s.substring(i+2, len);
                    else{
                        s = s.substring(0, i) ;
                    }
                    len-=2;
                    hit=true;
                }
            }
            
            redo = hit;
        }
        
        return s;
        
        
        
    }
}
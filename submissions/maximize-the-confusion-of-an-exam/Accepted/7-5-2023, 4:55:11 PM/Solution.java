// https://leetcode.com/problems/maximize-the-confusion-of-an-exam

class Solution {
    public int maxConsecutiveAnswers(String ans, int k) {
        
        int len = ans.length();
        
        int res = 0 ;
        
        
        int f=0;
        
        int st =0 ;
        for(int ed=0; ed<len;ed++){
            
            char ch  = ans.charAt(ed);
            if(ch=='F'){
                f++;
            }
            
            
            while(f>k){
                char chh = ans.charAt(st);
                if(chh=='F')
                    f--;
                st++;
            }
            
            res = Math.max(res, ed-st+1);
        }
        
        int t=0;
        st=0;
        for(int ed=0; ed<len; ed++){
            
            char ch = ans.charAt(ed);
            if(ch=='T')
                t++;
            
            while(t>k){
                char chh = ans.charAt(st);
                if(chh=='T')
                    t--;
                st++;
            }
            res = Math.max(res, ed-st+1);
        }
        
        return res;
        
        
    }
}
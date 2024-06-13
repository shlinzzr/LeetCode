// https://leetcode.com/problems/distribute-money-to-maximum-children

class Solution {
    public int distMoney(int m, int ch) {
        
        if(m<ch)
            return -1;
        
        int res = 0;
        
        m-=ch;
        
        while(m>0 && ch>0){
            if(m-7!=3){
                m-=7;
                res++;
                ch--;
            }else{
                break;
            }
                
        }
        
        
        return res;
        
    }
}
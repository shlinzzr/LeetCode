// https://leetcode.com/problems/distribute-money-to-maximum-children

class Solution {
    public int distMoney(int m, int ch) {
        
        if(m<ch)
            return -1;
        
        int res = 0;
        
        m-=ch;
        
        while(m>0){
            if(m-ch!=4){
                m-=8;
                res++;
            }else{
                break;
            }
                
        }
        
        
        return res;
        
    }
}
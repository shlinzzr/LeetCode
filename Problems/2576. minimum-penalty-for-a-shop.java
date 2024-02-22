// https://leetcode.com/problems/minimum-penalty-for-a-shop

class Solution {
    public int bestClosingTime(String cust) {
        int ycnt = 0;
        int ncnt = 0;
        for(char ch : cust.toCharArray()){
            if(ch=='Y')
                ycnt++;
            else 
                ncnt++;
        }
        
        int len = cust.length();
        int idx =-1;
        int min = len;
        
        int openPenalty=0;
        
        for(int i=0; i<len; i++){
            
            int closedPenalty = ycnt;
            
            int p = openPenalty + closedPenalty;
            
            if(p<min){
                min = p;
                idx = i;
            }
            
            if(cust.charAt(i)=='Y'){
                ycnt--;
            }else{
                ncnt--;
                openPenalty++;
            }
        }
        
        if(openPenalty<min){
            min = openPenalty;
            idx = len;
        }
        return idx;
        
    }
}
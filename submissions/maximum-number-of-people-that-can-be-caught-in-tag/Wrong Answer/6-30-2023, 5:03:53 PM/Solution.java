// https://leetcode.com/problems/maximum-number-of-people-that-can-be-caught-in-tag

class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        
        int len = team.length;
        
        int cnt =0;
        int max = 0;
        int ed=0, st=0;
        
        for(int m=0; m<len;m++){
            
            int ted = m+dist;
            if(ted>len-1)
                ted=len-1;
            
            while(ed<=ted){
                cnt+= team[ed++];
            }
            
            int tst = m-dist;
            if(tst<0)
                tst=0;
            
            while(st<=tst){
                cnt-=team[st++];
            }
            
            if(team[m]==1){
                max = Math.max(max, cnt);
            }
            
            
            
        }
        
        return max;
        
            
        
    }
}
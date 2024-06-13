// https://leetcode.com/problems/find-the-winner-of-the-circular-game

class Solution {
    public int findTheWinner(int n, int k) {
        
        boolean[] bool = new boolean[n];
        
        int cnt=n;
        int idx=0;
        int m = k-1;
        while(cnt>1){
            
            if(bool[idx%n]==false ){
                
                if(m==0){
                    // System.out.println(idx%n);
                    
                    bool[idx%n]=true;
                    cnt--;                    
                    m=k;
                }
                
                m--;

            }
            
            idx++;
        }
        
        for(int i=0; i<n; i++){
            boolean b = bool[i];
            if(b==false)
                return i+1;
                
        }
        
        
        return -1;
        
        
        
    }
}
// https://leetcode.com/problems/find-the-winner-of-the-circular-game

class Solution {
    public int findTheWinner(int n, int k) {
        k = k % n;
        int siz = n;
        int idx = 0;
        int step = k-1;
        
        boolean[] bool = new boolean[n];
        while(siz>1){
            
            if(bool[idx%n]==false){
                
                
                if(step==0){
                    bool[idx%n]=true;
                    siz--;
                    step=k;
                }
                step--;
            }
            
            idx++;
            
            
        }
        
        for(int j=0; j<n; j++){
            if(bool[j]==false)
                return j+1;
        }
        
        return -1;
    }
    
}
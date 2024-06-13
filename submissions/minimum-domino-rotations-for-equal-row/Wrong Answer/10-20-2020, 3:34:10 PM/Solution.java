// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int mainA = A[0];
        int AcntA = 0;
        int AcntB = 0;
        
        int resA = 0;
        for(int i=0;i<A.length;i++){
            if(mainA!=A[i] && mainA!=B[i]){
                resA=-1;
                break;
            }else{
                
                if(mainA!=A[i] ) AcntA++;
                if(mainA!=B[i] ) AcntB++;
            }
        }
        
        if(resA!=-1) resA = Math.min(AcntA, AcntB);
        
        
        int mainB = B[0];
        int BcntA = 0;
        int BcntB = 0;
        
        int resB = 0;
        for(int i=0;i<B.length;i++){
            if(mainB!=A[i] && mainB!=B[i]){
                resB=-1;
                break;
            }else{
                
                if(mainA!=A[i] ) BcntA++;
                if(mainA!=B[i] ) BcntB++;
            }
        }
        
        if(resB!=-1) resB = Math.min(BcntA, BcntB);
        
        return Math.max(resA, resB);
           
    }
}
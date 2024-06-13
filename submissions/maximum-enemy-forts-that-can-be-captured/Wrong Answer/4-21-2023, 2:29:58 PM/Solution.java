// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured

class Solution {
    public int captureForts(int[] forts) {
     // req : 1 to -1, get max of 0's cnt
        
//         TreeSet<Integer> set= new TreeSet();
//         int max =0 ;
//         for(int i=0; i<forts.length; i++){
            
//             if(forts[i]==-1){
//                 set.add(i);
//             }
//             if()
//         }
        int max = 0;
        for(int i=0; i<forts.length; i++){
            
            if(forts[i]==0)
                continue;
            
            for(int j=i+1; j<forts.length; j++){
                
                if(forts[j]==0)                
                    continue;
                
                if(forts[i] * forts[j]==-1){
                    max = Math.max(max, j-i-1);    
                    break;
                }
            }
        }
        
        
        return max;
        
        
        
    }
}
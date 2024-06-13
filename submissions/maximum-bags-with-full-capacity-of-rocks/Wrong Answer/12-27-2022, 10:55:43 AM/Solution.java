// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length;
        int[] need = new int[len];
        
        for(int i=0;i<len; i++){
            need[i] = capacity[i]-rocks[i];
        }
        
        Arrays.sort(need);
        
        
        int res=0;
        for(int i=0; i<len && additionalRocks>0; i++){
            
            if(need[i]==0){
                res++;
                continue;
            }
                
            
            else if(need[i]>0){
                additionalRocks-=need[i];
                res++;
            }
        }
        
        return res;
            
        
    }
}
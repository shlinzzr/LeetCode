// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        
        Arrays.sort(potions);
        
        int[] res = new int[n];
        
        for(int i=0; i<n; i++){
            
            int idx  = findlowBound(potions, spells[i], success);
            res[i]=m-idx;
        }
        
        return res;
    }
    
    
    private int findlowBound(int[] potions, int spell, long success){
        
        int len = potions.length;
        
        int st =0, ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            if(Long.valueOf(potions[mid])*spell<success){
                st=mid+1;
            }else
                ed = mid;
        }
        
          if(st==len-1 && Long.valueOf(potions[st])*spell<success)
                st++;
        
        return st;
        
        
        
        
        
    }
}
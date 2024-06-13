// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        
        Arrays.sort(potions);
        
        
        int[] res = new int[n];
        
        for(int i=0; i<n; i++){
            
            int sum =0;
            
            
            
            
            
            // int j=0;
            
            int idx  = findlowBound(potions, spells[i], success);
            
            if(idx==m-1 && Long.valueOf(potions[idx])*spells[i]<success)
                idx++;
            
            // System.out.println(i + " " + idx);
            // while(j<m&&Long.valueOf(spells[i])*potions[j]<success){
            //     j++;
            // }
            sum += m-idx;
                
            res[i]=sum;
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
        
        return st;
        
        
        
        
        
    }
}
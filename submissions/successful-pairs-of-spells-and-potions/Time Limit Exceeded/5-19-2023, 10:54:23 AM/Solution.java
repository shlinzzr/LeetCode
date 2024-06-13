// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        
        Arrays.sort(potions);
        
        
        int[] res = new int[n];
        
        for(int i=0; i<n; i++){
            
            int sum =0;
            int j=0;
            while(j<m&&Long.valueOf(spells[i])*potions[j]<success){
                j++;
            }
            sum += m-j;
                
            res[i]=sum;
        }
        
        return res;
        
        
    }
}
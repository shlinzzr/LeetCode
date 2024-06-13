// https://leetcode.com/problems/reduce-array-size-to-the-half

class Solution {
    public int minSetSize(int[] arr) {
        int[] occ = new int[10];
        
        for(int i : arr){
             occ[i]++;
        }
        
        Arrays.sort(occ);
        
        int cnt=0, total=0;
        for(int i=occ.length-1; i>=0; i--){
            
            total+=occ[i];
            cnt++;
            
            if(total>=arr.length/2)
                return cnt;
        }
        
        return -1;
    }
}
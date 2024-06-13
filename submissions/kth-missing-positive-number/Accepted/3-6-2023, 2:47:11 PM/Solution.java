// https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            set.add(a);
        }
         
        int i=1;
        while(k>0){
            
            if(set.contains(i)){
                i++;
                continue;
            }
            k--;
            i++;
            
            
            
            
        }
       
        return i-1;
        
        
    }
}
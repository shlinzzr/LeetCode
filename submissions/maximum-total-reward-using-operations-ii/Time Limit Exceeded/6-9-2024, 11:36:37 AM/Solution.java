// https://leetcode.com/problems/maximum-total-reward-using-operations-ii

class Solution {
    public int maxTotalReward(int[] rv) {
        
        int len = rv.length;
        
        Arrays.sort(rv);
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        
        int max= 0 ;
        for(int i=0; i<len; i++){
            int c= rv[i];
            
            Set<Integer> set2 = new HashSet<>(set);
            for(int a: set){
                if(a<c){
                    set2.add(a+c);
                    max = Math.max(max, a+c);
                }
            }
            
            set = set2;
        }
        
        return max;
        
        
        
        
        
        
    }
}
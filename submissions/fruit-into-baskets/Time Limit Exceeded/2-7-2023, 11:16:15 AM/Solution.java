// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        
        int max =0, start=0;
        for(int st =0; st<len; st++){
            Set<Integer> set= new HashSet<>();  
            for(int ed=st; ed<len; ed++){
                int val = fruits[ed];
                if(set.contains(val) || set.size()<2){
                    set.add(val);
                    max=Math.max(max, ed-st+1);
                    
                }else{
                    break;
                } 
            }
            
            
        }
        
        return max;
    }
}
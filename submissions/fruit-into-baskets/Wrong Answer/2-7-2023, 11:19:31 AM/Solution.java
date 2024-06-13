// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        
        int max =0, start=0;
       
        Set<Integer> set= new HashSet<>();
        
        
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            int val = fruits[ed];
            if(set.contains(val)){
                max = Math.max(max, ed-st+1);
            }else{
                set.add(val);
            }
            
            while(set.size()>2){
                set.remove(fruits[st]);
                st++;
            }
            
        }
        
        
        
        
        return max;
    }
}
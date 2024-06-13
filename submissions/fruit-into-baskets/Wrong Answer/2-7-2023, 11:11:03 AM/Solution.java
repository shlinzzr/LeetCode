// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        
        Set<Integer> set= new HashSet<>();
        
        int max =0, start=0;
        for(int st =0; st<len; st++){
            int val = fruits[st];
            if(set.contains(val) || set.size()<2){
                set.add(val);
                max=Math.max(max, st-start+1);
            }else{
                set = new HashSet<>();
                start=st;
                set.add(val);
            }
        }
        
        return max;
    }
}
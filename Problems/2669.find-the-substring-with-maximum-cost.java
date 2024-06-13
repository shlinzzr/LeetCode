// https://leetcode.com/problems/find-the-substring-with-maximum-cost

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int cost = 0;
        
        int max = 0;
        
        for(char ch : s.toCharArray()){
            
            if(cost<0)
                cost=0;
            
            if(chars.contains(ch+""))
                cost+= vals[chars.indexOf(ch)];
            else{
                cost+=(ch-'a'+1);
            }
            
            max =Math.max(max, cost);
        }
        
        return max;
    }
}
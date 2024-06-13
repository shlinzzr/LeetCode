// https://leetcode.com/problems/bag-of-tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int st = 0, ed= tokens.length-1;
        Arrays.sort(tokens);
        
        int max = 0;
        
        while(st<=ed){
            
            if(power>=tokens[st]){
                score++;
                power-=tokens[st];
                st++;
            }else{ // power<t
                
                
                power+=tokens[ed];
                score--;
                ed--;
                if(score<0)
                    return max;
            }
            
            max = Math.max(max, score);
                
        }
        
        return max;
        
    }
}
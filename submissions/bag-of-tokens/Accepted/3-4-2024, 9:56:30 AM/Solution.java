// https://leetcode.com/problems/bag-of-tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int score = 0, max= 0;
        int len = tokens.length;

        int st =0, ed= len-1;

        while(st<=ed){

            if(power>=tokens[st]){
                score++;
                power-=tokens[st];
                st++;
            }else if(score>0) {

                power += tokens[ed];
                score--;
                ed--;
            }else{
                return max;
            }

            max= Math.max(max, score);
        }

        return max;

    }
}
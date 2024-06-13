// https://leetcode.com/problems/maximum-score-after-splitting-a-string

class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int[] prefix = new int[len];

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='0'){
                prefix[i] = i==0 ? 1 : prefix[i-1]+1;
            }else{
                if(i>0) prefix[i]= prefix[i-1];
            }
        }

        int max = 0;

        int[] postfix = new int[len];
        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i)=='1'){
                postfix[i] = (i==s.length()-1) ? 1 :  postfix[i+1]+1;
            }else{
                postfix[i] = postfix[i+1];
            }

            // System.out.println(i + " " + postfix[i]);

            max = Math.max(prefix[i]+postfix[i], max);
        }

        return max;


    }
}
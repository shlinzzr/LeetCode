// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor

class Solution {
    public int numberOfWays(String corridor) {
        int len = corridor.length();
        int M = (int) 1e9+7;

        int s = 0;
        int p = 0;

        int st=0, ed=0;
        long res = 1;
        for(int i=0; i<len; i++){
            char ch = corridor.charAt(i);
            if(ch=='S') s++;
            if(ch=='P') p++;

            if(ch=='S' && s%2==0){
                // i=1 , st = 1
                st = i;

            }else if(ch=='S' && s%2==1 && s>2){
                // i=4, ed=4
                ed=i;
                res = (res * (ed-st)%M)%M;
            }
        }

        if(s%2!=0 || s==0) return 0;

        return (int)res;


    }
}
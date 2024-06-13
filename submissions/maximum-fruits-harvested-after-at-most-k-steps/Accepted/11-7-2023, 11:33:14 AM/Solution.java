// https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int len = fruits.length;

        int st=0, sum=0, max=0;

        while(st<len && fruits[st][0]<startPos-k){
            st++;
        }


       // 2*(pos-st) + (ed-pos) >k
       // => pos - 2*st + ed
        //              st       startPos        ed
        // |------------|----------^-------------|-------|
        //               <---------
        //.              ----------------------->          


        // 2*(ed-pos) + pos -st
        // =>  2*ed -st - pos
        //              st       startPos        ed
        // |------------|----------^-------------|-------|
        //                          ------------>
        //.              <-----------------------          


        for(int ed=st; ed<len && fruits[ed][0]<=startPos+k; ed++){
            sum += fruits[ed][1];
            while(Math.min(startPos - 2*fruits[st][0] + fruits[ed][0], 2*fruits[ed][0]-fruits[st][0] - startPos) > k){
                sum -= fruits[st++][1];
            }
            max = Math.max(max, sum);
        }

        return max;
        
        
        
    }
}
// https://leetcode.com/problems/time-needed-to-buy-tickets

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;

        int idx= 0 ;
        int time =0;
        while(tickets[k]>0){

            tickets[idx]--;
            idx++;

            int r=0;
            
            while(r<len && tickets[idx%len]==0){
                idx++;
                r++;
            }

            idx%=len;
            time++;

            // for(int t : tickets){
            //     System.out.println(t+",");
            // }
            // System.out.println();
        }
        return time;
    }
}
// https://leetcode.com/problems/longest-well-performing-interval

class Solution {
    public int longestWPI(int[] hours) {

        int len = hours.length;
        int sum=0; 
        int max = 0;

        //.    9,9,6,0,6,6,9]
        //sum. 1 2 1
        int prev = -1;

        for(int i=0; i<len; i++){
            sum+= hours[i]>8 ? 1 : -1;

            if(sum<0){
                sum = 0;
                prev = i;
            
            }else if(sum>0){
                max = Math.max(max, i-prev);
            }
        }


        sum=0;
        prev= len;
        for(int i=len-1; i>=0; i--){
            sum+= hours[i]>8 ? 1 : -1;
            if(sum<0){
                sum = 0;
                prev = i;
            }else if(sum>0){
                max = Math.max(max, prev-i);
                // System.out.println(i + " " + prev);
            }
        }

        return max;
        
    }
}
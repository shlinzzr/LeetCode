// https://leetcode.com/problems/count-the-number-of-square-free-subsets

class Solution {

    int M = (int) 1e9+7;
    public int squareFreeSubsets(int[] nums) {
        int len = nums.length;

        boolean[] isSquFree = new boolean[len];
        int cnt=0;
        for(int i=0; i<len; i++){
            int n = nums[i];
            int sq =(int)Math.sqrt(n);
            boolean isSqu =  n==1 ? false : sq*sq==n;
            boolean notSqu = !isSqu;
            isSquFree[i] = notSqu;

            //  System.out.println( (sq*sq==n) + " " + notSqu);

            if(notSqu) cnt++;
        }
        int res = 0;
        int prod =1 ;
        for(int i=0; i<cnt; i++){
            prod *= 2 %M;
        }
        return cnt>0 ? prod -1: res;
        // System.out.println(cnt);

        // return (int)Math.pow(2,cnt)-1;

    }
}
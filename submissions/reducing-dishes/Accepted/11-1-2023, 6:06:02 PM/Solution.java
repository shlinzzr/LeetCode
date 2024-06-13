// https://leetcode.com/problems/reducing-dishes

class Solution {
    public int maxSatisfaction(int[] sat) {
        int len = sat.length;

        Arrays.sort(sat);

        int presum= 0, sum =0;
        for(int i=len-1; i>=0; i--){
            presum += sat[i];
            if(presum<0)
                break;
            sum += presum;
        }

        return sum;
    }
}
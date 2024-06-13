// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] od = new int[n+1];
        for(int [] t : trust){
            od[t[0]]++;
        }
        
        for(int i=1; i<n+1; i++){
            int o = od[i];
            if(o==0)
                return i;
        }
        
        return -1;
    }
}
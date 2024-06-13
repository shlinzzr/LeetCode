// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n+1];
        int[] trustOthers = new int[n+1];

        int len = trust.length;
        for(int i=0; i<len; i++){
            
            int a = trust[i][0];
            int b = trust[i][1];
            trustOthers[a]++;
            trusted[b]++;
        }

        for(int i=1; i<=n; i++){
            if(trusted[i]==n-1 && trustOthers[i]==0){
                return i;
            }
        }

        return -1;
    }
}
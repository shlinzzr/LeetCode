// https://leetcode.com/problems/eliminate-maximum-number-of-monsters

class Solution {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int len  = dist.length;
        double[] time = new double[len];
        for(int i=0;i<len;i++)
            time[i] = (double)(dist[i]) / speed[i];

        Arrays.sort(time);
        int count = 0;
        double currTime = 0.0;
        
        for(int i=0;i<len;i++)
        {
            if(time[i] > currTime)
                ++count;
            else 
                return count;
            currTime = currTime + 1.0;
        }
        return count;
    }
}
// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int cnt= 0;
        for(int i=0; i<len; i++){
            if(endTime[i]>=queryTime && startTime[i]<=queryTime)
                cnt++;
            
        }
        
        return cnt;
    }
}
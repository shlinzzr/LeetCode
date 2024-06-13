// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int len = tasks.length;
        
        /*
        
        2 -> 1
        3 -> 1
        4 -> 2
        5 -> 2
        6 -> 2
        7 -> 3
        8 -> 3
        9 -> 3
        10 ->4
        */
        
        int res = 0;
        int idx=0;
        while(idx<len){
            
            int t = tasks[idx];
            if(idx>=len && tasks[idx+1]!=t){
                return -1;
            }
            
            int cnt=1;
            
            while(idx+1<len && tasks[idx+1]==t){
                idx++;
                cnt++; 
            }
            
            res+=cnt/3;
            // 4 -> 1
            // 5 -> 1
            // 6 -> 2
            
            
            if(cnt%3!=0)
                res+=1;
            idx++;
        }
        
        return res;
    }
}
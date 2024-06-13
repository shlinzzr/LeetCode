// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {

        
        int[] arr = new int[26];
        int max = 0;
        int maxCnt = 0;

        for(int i=0; i<tasks.length; i++){
            char ch = tasks[i];
            arr[ch-'A']++;
            if(arr[ch-'A']>max){
                max = arr[ch-'A'];
                maxCnt=1;
            }else if(arr[ch-'A']==max){
                maxCnt++;
            }
        }


        // A B cool A B cool  A
        // \               /
        //     max*(n+1)+maxCnt

        int res = (max-1)*(n+1)+maxCnt;

        if(tasks.length>res) return tasks.length;

        return res;
        
    }
}
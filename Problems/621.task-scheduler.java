// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int len = tasks.length;

        int max=0, maxCnt=0;
        int[] arr = new int[26];

        for(char t :tasks){
            arr[t-'A']++;

            if(arr[t-'A']>max){
                max = arr[t-'A'];
                maxCnt = 1;
            }

            else if(arr[t-'A']==max){
                maxCnt++;
            }
        }

        // [A B x] [A B x] A B
        // |   (max-1)(n+1)    | + maxCnt



        int res = (max-1)*(n+1) + maxCnt;

        if(res<len) return len;

        return res;




        
    }
}
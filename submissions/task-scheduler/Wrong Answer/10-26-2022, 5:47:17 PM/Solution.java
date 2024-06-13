// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int k = 0;
        for(char t : tasks){
            arr[t-'A']++;
            k = Math.max(k, arr[t-'A']);
        }
        
        int p=0;
        int d=0;
        for(int a : arr){
            if(a==k)
                p++;
            if(a>0)
                d++;
        }
        
        
        return (k-1)*(d+1)+ p;
        
    }
        // ans = (k-1)*(d+1)+ p;
        // k:最高次數
        // d:不同的字母數
        // p:出現最高次數的字母數
}
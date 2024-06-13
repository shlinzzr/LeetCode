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
        for(int a : arr){
            if(a==k)
                p++;
        }
        
        int ans = (k-1)*(n+1)+ p;
        
        // edge case: 最高次數都跑完了 還有多餘的task沒做 => no idle
        if(tasks.length>=ans)
            return tasks.length;
        
        return ans;
        
    }
        // ans = (k-1)*(n+1)+ p;
        // k:最高次數
        // p:出現最高次數的字母數
    
    /*
    Input
    ["A","A","A","B","B","B"]
    k=3, d=2, p=2;
    (3-1)*(3)+2=8
    */
    
    
}
// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();

        int max= 0 ;
        int maxCnt = 0;
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.get(ch)>max){
                max = map.get(ch);
                maxCnt=1;
            }else if(map.get(ch)==max){
                maxCnt++;
            }
        }


        //先問 總共執行幾次: max次
        //會有幾個cooldown period : max-1
        //每個cooldown period多長 : n + 1個max task 執行時間
        // => (max-1)*(n+1) + maxCnt;

        int res = (max-1)*(n+1) + maxCnt;
        // 要執行完max次task 共需要max-1個idle, 所以max-1; 
        // n個 cooldown period加上1個task執行時間 所以要n+1; 
        // A ... -> A ... -> A B C 共有max-1個 (1 + n ) (1 + n ) + maxCnt 


        // 還有一個edge case: 最高次數都跑完了 還有多餘的task沒做 => no idle
        if(tasks.length>=res)
            return tasks.length;
        

        return res;

    }
}
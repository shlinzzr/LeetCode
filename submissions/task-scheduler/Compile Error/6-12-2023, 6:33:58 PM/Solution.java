// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        int max = 0;
        int maxCnt=0;
        
        
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
            
            max= Math.max(max, map.get(c));
        }
        
        for(char k : map.keySet()){
            if(map.get(k)==max)
                maxCnt++;
        }
        int ans = (max-1) * (n+1) +maxCnt; // 要執行完max個task 共需要max-1個idle, 所以max-1; n個 cooldown idle加上1個task執行時間 所以要n+1; 
        /* A ... -> A ... -> A B C 
共有max-1個 (1 + n ) (1 + n ) + maxCnt
        
        
                                   //最後加上最後一次的最高次數task : maxCnt
        
         // edge case: 最高次數都跑完了 還有多餘的task沒做 => no idle
        if(tasks.length>=ans)
            return tasks.length;
        
        
        return ans;
        
        
        
    }
}
// https://leetcode.com/problems/task-scheduler

class Solution {
     public int leastInterval(char[] tasks, int n) {
         
         
         // https://www.youtube.com/watch?v=YCD_iYxyXoo 
         // k groups = most freq count;
         // s : same # as most freq counts
         //ans = (k-1)*(n+1) + s
         
         int[] counter = new int[26];
         int max = 0;
         int maxCount = 0;
         for(char task : tasks) {
             counter[task - 'A']++;
             if(max == counter[task - 'A']) {
                 maxCount++;
             }
             else if(max < counter[task - 'A']) {
                 max = counter[task - 'A'];
                 maxCount = 1;
             }
         }
         
         // int ans = (maxCount-1)*(n+1)
         // 分成k組 考慮最大出現頻率(max)有多個字母的狀況(maxCount>1的狀況)
         
         // partCount = count(A) - 1  // ex: 4A3B A為最大頻率分成4-1組
         // emptySlots = partCount * n;  // 剩下空格數給其他字母填滿
         // emptySlots = partCount * (n - (maxCount - 1)) // 只需額外考慮最大頻率字母可能一個以上 
         // availableTasks = tasks.length - count(A)
         // idles = max(0, emptySlots - availableTasks); // 可能為負 需要max一下
          
          
         int partCount = max - 1; 
         int partLength = n - (maxCount - 1);
         int emptySlots = partCount * partLength;
         int availableTasks = tasks.length - max * maxCount;
         int idles = Math.max(0, emptySlots - availableTasks);
            
         
         return tasks.length + idles;
         
         
         
     }
}
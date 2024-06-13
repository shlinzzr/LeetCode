// https://leetcode.com/problems/course-schedule-iii

class Solution {
    public int scheduleCourse(int[][] courses) {
        int len = courses.length;

        int max = 0 ;
        /*
        又称摸鱼policy，如果sprint的story怎么也干不完，老板又只看完成的个数而不是具体难度，那就难的活就往后拖咯...
        */

        Arrays.sort(courses, (a,b)-> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]); //sort by deadline asc
        PriorityQueue<Integer> pq = new PriorityQueue<>( // sort pq by longest duration time
            (a,b) -> b-a
        );

        int cur = 0;

        for(int i=0; i<len; i++){

            int[] c = courses[i];
            int duration = c[0];
            int lastDay = c[1];

            cur += duration; // 當作做完了
            pq.offer(duration); // 丟到待放棄的清單

            if(cur>lastDay){ // 如果超過deadline了
                cur-=pq.poll(); // 把難做的放棄
            }
        }

        return pq.size();
        
    }
}
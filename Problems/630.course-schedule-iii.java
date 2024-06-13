// https://leetcode.com/problems/course-schedule-iii

class Solution {
    public int scheduleCourse(int[][] courses) {
        int len = courses.length;

        int max = 0 ;

        Arrays.sort(courses, (a,b)-> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>( // sort pq by longest duration time
            (a,b) -> b-a
        );

        int cur = 0;

        for(int i=0; i<len; i++){

            int[] c = courses[i];
            int duration = c[0];
            int lastDay = c[1];

            cur += duration;
            pq.offer(duration);

            if(cur>lastDay){
                cur-=pq.poll();
            }
        }

        return pq.size();
        
    }
}
// https://leetcode.com/problems/course-schedule-iii

class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a,b)-> a[1]-b[1]); // sort asc by deadline

        PriorityQueue<int[]> pq = new PriorityQueue<>( // sort pq by longest duration time
            (a,b) -> b[0]-a[0]
        );

        int cur = 0;
        int cnt = 0;

        for(int[] c : courses){
            int duration = c[0];
            int lastDay = c[1];

            cur += duration;
            cnt++;
            pq.offer(c);

            if(cur>lastDay){
                cur -= pq.poll()[0];
            }
        }

        return pq.size();

        
    }
}
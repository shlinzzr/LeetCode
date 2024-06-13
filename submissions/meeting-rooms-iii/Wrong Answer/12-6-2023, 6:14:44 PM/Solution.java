// https://leetcode.com/problems/meeting-rooms-iii

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] room = new int[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int len = meetings.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.offer(i);
        }

        PriorityQueue<long[]> holding = new PriorityQueue<>( // idx, st , endTime
            (a,b)->(int)a[2]-(int)b[2]
        );


        for(int i=0; i<len; i++){
            int[] m = meetings[i];
            int st = m[0];
            int ed = m[1];

            while(!holding.isEmpty() && holding.peek()[2]<=st){
                pq.offer( (int)holding.poll()[0] );
            }

            if(pq.isEmpty()){
                long[] r = holding.poll();
                room[(int)r[0]]++;
                int offset = (int)r[2]-st;
                st += offset;
                ed += offset;
                holding.offer(new long[]{r[0], st, ed});

            }else{
                int r = pq.poll();
                room[r]++;
                holding.offer(new long[]{r, st, ed});
            }
        }

        int max = 0;
        int res = 0;
        for(int i=n-1; i>=0; i--){
            if(room[i]>=max){
                max = room[i];
                res = i;
            }
        }

        return res;

    }
}
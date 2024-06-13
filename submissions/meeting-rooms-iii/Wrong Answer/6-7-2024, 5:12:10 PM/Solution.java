// https://leetcode.com/problems/meeting-rooms-iii

class Solution {

    class Room{
        int free=0;
        int cnt= 0 ;
        int idx;

        public Room(int idx){
            this.idx=idx;
        }
    }
    public int mostBooked(int n, int[][] meetings) {

        int[] mcnt = new int[n];

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        int len = meetings.length;

        for(int i=0; i<len; i++){
            int st = meetings[i][0];
            int ed = meetings[i][1];
            int duration = ed-st;
            meetings[i][1]=duration;
        }

        PriorityQueue<Room> rq = new PriorityQueue<>(
            (a,b) -> a.free!=b.free ? a.free - b.free : a.idx-b.idx
        );

        PriorityQueue<Room> hold = new PriorityQueue<>(
            (a,b) -> a.free - b.free 
        );

        for(int i=0; i<n; i++){
            Room room = new Room(i);
            rq.offer(room);
        }

        for(int i=0; i<len; i++){

            int[] mt = meetings[i];
            int cur = mt[0];

            while(!hold.isEmpty() && hold.peek().free<=cur){
                rq.offer(hold.poll());
            }

            if(!rq.isEmpty()){
                Room room = rq.poll();
                room.cnt++;
                room.free += cur + mt[1];
                hold.offer(room);
                
            }else{
                
                Room room = hold.poll();
                cur = room.free;
                room.free += mt[1];
                room.cnt++;
                hold.offer(room);
            }
        }

        int res = len;
        int max = 0;
        while(!rq.isEmpty()){
            Room room = rq.poll();
            if(room.cnt>max || (room.cnt==max && room.idx<res)){
                max = room.cnt;
                res = room.idx;
            }
        }
        while(!hold.isEmpty()){
            Room room = hold.poll();
            if(room.cnt>max || (room.cnt==max && room.idx<res)){
                max = room.cnt;
                res = room.idx;
            }
        }

        return res;
    }
}
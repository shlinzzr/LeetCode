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

        Arrays.sort(meetings, (a,b)->a[0]-b[0]); // sort by stTime asc

        System.out.println(Arrays.deepToString(meetings)); //[[2, 13], [3, 12], [7, 10], [17, 19], [18, 19]]

        int len = meetings.length;

        for(int i=0; i<len; i++){
            int st = meetings[i][0];
            int ed = meetings[i][1];
            int duration = ed-st;
            meetings[i][1]=duration;
        }

         System.out.println(Arrays.deepToString(meetings)); 
     

        PriorityQueue<Room> rq = new PriorityQueue<>(
            (a,b) ->  a.idx-b.idx
        );

        PriorityQueue<Room> hold = new PriorityQueue<>(
            (a,b) ->  a.free!=b.free ? a.free - b.free : a.idx-b.idx
        );

        for(int i=0; i<n; i++){
            Room room = new Room(i);
            rq.offer(room);
        }

        for(int i=0; i<len; i++){
             //[[2, 11], [3, 9], [7, 3], [17, 2], [18, 1]]

            int[] mt = meetings[i];
            int cur = mt[0]; // 2, 3, 7, 17

            while(!hold.isEmpty() && hold.peek().free<=cur || rq.isEmpty()){
                cur = Math.max(cur, hold.peek().free); // 17
                rq.offer(hold.poll()); // r0 / r1 / r2
            }



            // if(!rq.isEmpty()){
                Room room = rq.poll(); 
                room.cnt++; //r0.cnt=1, r1.cnt1, r2.cnt=1
                room.free = cur + mt[1]; //r0.free = 13, r1.free=12,  r2.free=10
                hold.offer(room); 
                //hold : r0.cnt=1.free=13, r1.cnt=1.free=12, r2.cnt=1.free=10

            
            
            // }else{
                
            //     Room room = hold.poll();
            //     cur = room.free;
            //     room.free += mt[1];
            //     room.cnt++;
            //     hold.offer(room);
            // }
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
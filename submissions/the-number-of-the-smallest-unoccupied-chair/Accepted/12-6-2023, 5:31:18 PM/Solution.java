// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair

class Solution {

    class Friend{
        int arrival;
        int leaving;
        int idx;

        public Friend(int arrival, int leaving, int idx){
            this.arrival=arrival;
            this.leaving = leaving;
            this.idx=idx;
        }

    }


    public int smallestChair(int[][] times, int targetFriend) {
        
        int len = times.length;

        List<Friend> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            int[] t = times[i];
            Friend f = new Friend(t[0], t[1], i);
            list.add(f);
        }

        Collections.sort(list, (a,b)-> a.arrival-b.arrival);

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        PriorityQueue<int[]> sitted = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        ); // arr ,leav, chair id
        

        for(int i=0; i<len; i++){
            Friend f = list.get(i);

            while(!sitted.isEmpty() && sitted.peek()[1]<= f.arrival){
                pq.offer(sitted.poll()[2]);
            }

            if(pq.isEmpty()){

                if(targetFriend==f.idx){
                    return max;
                }
                sitted.offer(new int[]{f.arrival, f.leaving, max});
                max+=1;

            }else{
                if(f.idx==targetFriend){
                    return pq.poll();
                }

                sitted.offer(new int[]{f.arrival, f.leaving, pq.poll()});
            }

        }

        return -1;
    }
}
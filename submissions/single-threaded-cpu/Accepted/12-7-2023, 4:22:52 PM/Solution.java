// https://leetcode.com/problems/single-threaded-cpu

class Solution {

    class Task{

        int eq;
        int pt;
        int idx;
        public Task(int eq, int pt, int idx){
            this.eq=eq;
            this.pt=pt;
            this.idx=idx;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        List<Task> list = new ArrayList<>(); 
        PriorityQueue<Task> pq = new PriorityQueue<>( // enq, processTime, idx
            (a,b)-> a.pt==b.pt? a.idx-b.idx : a.pt-b.pt
        );

        for(int i=0; i<len; i++){
            list.add(new Task(tasks[i][0], tasks[i][1], i));
        }

        Collections.sort(list, (a,b)-> a.eq-b.eq);

        pq.offer(list.get(0));
        int cur = list.get(0).eq;
        int idx= 1;
        int cnt = 0;

        int[] ans = new int[len];

        while(cnt<len){

            while(idx<list.size() && list.get(idx).eq<=cur){
                pq.offer(list.get(idx));
                idx++;
            }

            if(pq.isEmpty() ){
                pq.offer(list.get(idx));
                cur = list.get(idx).eq;
                idx++;
            }else{
                Task t = pq.poll();
                cur += t.pt;
                ans[cnt]=t.idx;
                cnt++;
            }
        }

        return ans;



    }
}
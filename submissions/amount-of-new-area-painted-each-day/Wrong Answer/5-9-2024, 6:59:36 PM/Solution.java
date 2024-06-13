// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        Arrays.sort(paint, (a,b)-> a[0]-b[0]);
        int len = paint.length;
        Map<Integer, List<int[]>> map =new HashMap<>();

        for(int i=0; i<len; i++){
            int[] p = new int[3]; // add idx info to p 
            p[0]=paint[i][0];
            p[1]=paint[i][1];
            p[2]=i;

            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add(p);
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p);
        }

        System.out.println(map);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[0]-b[0]
        );

        int[] res = new int[len];

        Integer prev_x = null;
        for(int x : map.keySet()){

           
            List<int[]> list = map.get(x);
            for(int[] p : list){
                // System.out.println(x + " " + Arrays.toString(p));
                if(p[0]==x){
                    pq.offer(p);
                }else if(p[1]<x){
                    pq.remove(p);
                }
            }

            if(pq.isEmpty()|| prev_x==null) {
                prev_x = x;
                continue;
            }
            // System.out.println("x="+x + " " +pq.peek()[0] + " " + pq.peek()[1]+ " " + pq.peek()[2]);
            int idx = pq.peek()[2];
            res[idx]+= (x-prev_x);
            prev_x=x;


            while(!pq.isEmpty() && pq.peek()[1]==x) pq.poll();
        }   

        return res;

        
    }
}
// https://leetcode.com/problems/number-of-flowers-in-full-bloom

class Solution {

    class Tuple{
        int idx;
        int val;
        public Tuple(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, (a,b)-> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[1]-b[1]
        );

        Tuple[] arr = new Tuple[people.length];
        for(int i=0; i<people.length; i++){
            arr[i] = new Tuple(i, people[i]);
        }

        Arrays.sort(arr, (a,b)-> a.val-b.val);



        int[] res = new int[people.length];

        int idx = 0;

        for(int i=0; i<arr.length; i++){

            Tuple t = arr[i];
            int p = t.val;

            while(!pq.isEmpty() && pq.peek()[1]<p){
                int[] po = pq.poll();
                System.out.println("poll: "  + po[0]+" "+po[1]);
            }


            while(idx<flowers.length && flowers[idx][0]<=p){
                pq.offer(flowers[idx]);
                  System.out.println("offer: " + idx + " "   + flowers[idx][0]+" "+flowers[idx][1]);
                  idx++;
            }

            res[t.idx] = pq.size();

        }

        return res;



    }
}
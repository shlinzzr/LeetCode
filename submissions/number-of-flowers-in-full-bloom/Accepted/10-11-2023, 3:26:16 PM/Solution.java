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
        // for(int[] f : flowers){
        //     System.out.print("[" +f[0]+ "," + f[1] + "], ");
        // }
        // System.out.println();

        




        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[1]-b[1]
        );

        Tuple[] arr = new Tuple[people.length];
        for(int i=0; i<people.length; i++){
            arr[i] = new Tuple(i, people[i]);
        }

        Arrays.sort(arr, (a,b)-> a.val-b.val);

        // for(Tuple t: arr){
        //     System.out.print(t.val + ", ");
        // }
        // System.out.println();


        int[] res = new int[people.length];

        int idx = 0;

        for(int i=0; i<arr.length; i++){

            Tuple t = arr[i];
            int p = t.val;
//  System.out.println("p=:" + p); 

            while(idx<flowers.length && flowers[idx][0]<=p){
                pq.offer(flowers[idx]);
                //   System.out.println("offer: " + idx + " "   + flowers[idx][0]+" "+flowers[idx][1]);
                  idx++;
            }


            while(!pq.isEmpty() && pq.peek()[1]<p){
                int[] po = pq.poll();
                // System.out.println("poll: "  + po[0]+" "+po[1]);
            }


          
            //  System.out.println("res : " + t.idx + "=" + pq.size());
            res[t.idx] = pq.size();

        }

        return res;



    }
}
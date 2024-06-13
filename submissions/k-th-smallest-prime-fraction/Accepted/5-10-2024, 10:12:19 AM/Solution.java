// https://leetcode.com/problems/k-th-smallest-prime-fraction

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> cal(a,b)
        );


        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                pq.offer(new int[]{arr[i], arr[j]});

                if(pq.size()>k) pq.poll();
            }
        }

        return pq.poll();
        
    }

    private int cal(int[] a, int[] b){
        // a/b


        Double aa = Double.valueOf(a[0]) / Double.valueOf(a[1]);
        
        Double bb = Double.valueOf(b[0]) / Double.valueOf(b[1]);




        if(aa==bb) return 0;
         if(bb>aa) return 1;
         return -1;


    }
}
// https://leetcode.com/problems/maximum-number-of-eaten-apples

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // select the apple whose rotten day is closer

        int len = apples.length;
        for(int i = 0; i < 40001; i++){
            if (i < len)
                pq.add(new int[]{i + days[i]-1, apples[i]}); // rot day, cnt
            // poll rot apple
            while (!pq.isEmpty()){
                int[] cur = pq.peek();
                if(cur[0] < i){
                    pq.poll(); 
                }else{
                    break;
                }
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[1]--;
                res += 1;
                if(cur[1] > 0){
                    pq.add(cur);
                }
            }
        }
        return res;
    }
}
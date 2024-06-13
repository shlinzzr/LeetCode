// https://leetcode.com/problems/the-skyline-problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for(int[] b : buildings) {
            int x1 = b[0];
            int x2 = b[1];
            int y = b[2];
            list.add(new int[]{x1, -y});
            list.add(new int[]{x2, y});
        }

        Collections.sort(list, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        // Collections.sort(height, (a, b) -> {
        //         if(a[0] != b[0]) 
        //             return a[0] - b[0];
        //         return a[1] - b[1];
        // });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); //y
        pq.offer(0);
        int prev = 0;
        for(int[] p: list) {
            if(p[1] < 0) {
                pq.offer(-p[1]);
            } else {
                pq.remove(p[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                List<Integer> sub = new ArrayList<>();
                sub.add(p[0]);
                sub.add(cur);
                result.add(sub);
                prev = cur;
            }
        }
        return result;
    }
}
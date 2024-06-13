// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;

        Arrays.sort(points, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0] );

        PriorityQueue<int[]> pq = new PriorityQueue<>( // idx, pts
            (a,b)->b[1]!=a[1] ? b[1]-a[1] : a[0]-b[0]
        );

        HashMap<Integer, Set<Integer>> pts = new HashMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            int[] p = points[i];
            map.put(p[0], map.getOrDefault(p[0], 0)+1);
            map.put(p[1], map.getOrDefault(p[1], 0)-1);

            pts.putIfAbsent(p[0], new HashSet<>());
            pts.putIfAbsent(p[1], new HashSet<>());
            pts.get(p[0]).add(i);
            pts.get(p[1]).add(i);
        }

        for(int k : )
        


    }
}
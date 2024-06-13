// https://leetcode.com/problems/the-skyline-problem


class Solution {

    //https://www.youtube.com/watch?v=tQiXaCT0ndE

    /*
    几个想法：1. 其实这里的treemap只是用来对起始结束events排序的，应该可以直接用数组排序，省去treemap的overhead。2. 这里还是要对heap进行删除操作，Java的PriorityQueue实现的remove是O(n)的。我们可以改用treemap代替PriorityQueue或者不进行remove，标记一下就可以了，poll()的时候特殊处理一下。
    */

    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // Map<x, List<building>
        for (int[] b : buildings) {
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }

        //max heap sort by height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        List<List<Integer>> res = new ArrayList<>();
        
        for (int x : map.keySet()) { // x-axis from left to right
            List<int[]> list = map.get(x);
            for (int[] b : list) {
                if (b[0] == x) { // left
                    pq.offer(b);

                } else { //right
                    pq.remove(b); // remove point when meet right
                }
            }

            // if just meet right and remove, heap maybe empty, add additional bottom line which height is 0
            int maxHeight = pq.isEmpty() ? 0 : pq.peek()[2];  // curr maxheight
            
            // prev point of height is not equal maxHeight means the maxHeight is change , need add res
            // if "First" or  "maxheight change"
            if (res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
                res.add(Arrays.asList(x, maxHeight));
            }
        }
        
        return res;
    }
}

         
// class Solution {
//     public List<List<Integer>> getSkyline(int[][] buildings) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<int[]> height = new ArrayList<>();  // List<x, height> sort by x
//         for(int[] b:buildings) { 
//             height.add(new int[]{b[0], -b[2]}); // left, -height
//             height.add(new int[]{b[1], b[2]});  // right, height
//         }
//         Collections.sort(height, (a, b) -> {
//                 if(a[0] != b[0]) 
//                     return a[0] - b[0];
//                 return a[1] - b[1];
//         });
//         Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//         pq.offer(0);
//         int prev = 0;
//         for(int[] h:height) {
//             if(h[1] < 0) {
//                 pq.offer(-h[1]);
//             } else {
//                 pq.remove(h[1]);
//             }
//             int cur = pq.peek();
//             if(prev != cur) {
//                 List<Integer> list = new ArrayList<>();
//                 list.add(h[0]);
//                 list.add(cur);
//                 result.add(list);
//                 prev = cur;
//             }
//         }
//         return result;
//     }
// }
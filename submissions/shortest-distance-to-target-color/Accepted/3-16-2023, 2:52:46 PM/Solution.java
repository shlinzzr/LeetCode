// https://leetcode.com/problems/shortest-distance-to-target-color

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            int c = colors[i];
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int index = query[0];
            int c = query[1];
            if (!map.containsKey(c)) {
                ans.add(-1);
            } else {
                ans.add(binarySearch(index, map.get(c)));
            }
        }
        return ans;
    }
    
    public int binarySearch(int index, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left +1< right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < index) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        int leftDis = Math.abs(list.get(left) - index);
        int rightDis = Math.abs(list.get(right) - index);
        return leftDis <= rightDis ? leftDis : rightDis;
    }
}
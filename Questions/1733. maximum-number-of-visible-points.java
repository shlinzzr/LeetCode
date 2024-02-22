// https://leetcode.com/problems/maximum-number-of-visible-points

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            } 
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int ed = 0, st = 0; ed < tmp.size(); ed++) {
            while (tmp.get(ed) - tmp.get(st) > angle) {
                st++;
            }
            res = Math.max(res, count + ed - st + 1);
        }
        return res;
    }
}
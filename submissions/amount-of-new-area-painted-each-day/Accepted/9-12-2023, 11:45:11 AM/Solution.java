// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        int len = paint.length;

        int[] worklog = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(paint[0][0], paint[0][1]); //st, ed

        worklog[0] = paint[0][1]-paint[0][0];

        for (int i = 1; i<len; i++){

            int[] p = paint[i];
            int st = p[0];
            int ed = p[1];
            int cnt = ed-st;
            
            Map.Entry<Integer, Integer> prevWork = map.lowerEntry(ed);
            
            while (prevWork != null) {
                int prevStart = prevWork.getKey();
                int prevEnd = prevWork.getValue();

                if (prevEnd <= st)
                    break;

                cnt -= Math.min(ed, prevEnd) - Math.max(st, prevStart);
                st = Math.min(st, prevStart);
                ed = Math.max(ed, prevEnd);
                map.remove(prevStart);

                prevWork = map.lowerEntry(ed);
            }
            map.put(st, ed);
            worklog[i] = cnt;
        }
        return worklog;
    }
}
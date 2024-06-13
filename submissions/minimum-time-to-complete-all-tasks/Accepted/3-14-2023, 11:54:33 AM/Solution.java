// https://leetcode.com/problems/minimum-time-to-complete-all-tasks

class Solution {
    public int findMinimumTime(int[][] tasks) {
        if (tasks == null || tasks.length == 0) return 0;
        Arrays.sort(tasks, (a,b) -> (a[1] - b[1])); // sort by end time increasing to complete early task first
        boolean[] slots = new boolean[2001];
        for (int[] task : tasks) {
            int s = task[0];
            int e = task[1];
            int dur = task[2];
            int i = s;
            for (; i <= e && dur > 0; i++) {
                if (slots[i]) {
                    dur--;
                }
            }
            i = e;
            while (dur > 0 && i >= s) {
                if (!slots[i]) {
                    slots[i] = true;
                    dur--;
                }
                i--;
            }
        }
        int res = 0;
        for (boolean slot : slots) {
            if (slot) res++;
        }
        return res;
    }
}
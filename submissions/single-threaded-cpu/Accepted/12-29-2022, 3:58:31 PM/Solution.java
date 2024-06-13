// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];//待求的任务处理顺序
        PriorityQueue<int[]> toDo = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1])//注意Integer比较用equals和compareTo
                    return a[1] - b[1];
                return a[2] - b[2];
            }
        });
        int[][] newTasks = new int[n][3];//添加任务序号信息
        for (int i = 0; i < n; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        Arrays.sort(newTasks, (t1, t2) -> t1[0] - t2[0]);//将任务按时间排序
        
        int t = 0, index = 0, i = 0;//当前时间，已执行任务数，已入队任务数
        while (index < n) {
            if (toDo.isEmpty())//若队列为空且当前时间小于下一任务起始时间，直接跳到该起始时间
                t = Math.max(t, newTasks[i][0]);
            while (i < n && newTasks[i][0] <= t)//将起始时间不超过当前时间的任务都入队
                toDo.offer(newTasks[i++]);
            int[] task = toDo.poll();//选取优先执行的任务
            ans[index++] = task[2];
            t += task[1];
        }
        return ans;
    }
}

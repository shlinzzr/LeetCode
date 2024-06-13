// https://leetcode.com/problems/process-tasks-using-servers

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = servers.length;
        int n = tasks.length;

        int[] ans = new int[n];

        PriorityQueue<int[]> freeServer = new PriorityQueue<>( //idx, weight[idx]
            (a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]
        );

        PriorityQueue<int[]> running = new PriorityQueue<>( //idx, weight[idx], finishTime
              (a,b)-> a[2]==b[2] ? a[0]-b[0] : a[2]-b[2]
        );

        for(int i=0; i<m; i++){
            freeServer.offer(new int[]{i, servers[i]});
        }

        Queue<Integer> q= new LinkedList<>();
        for(int j=0; j<n; j++){

            while(!running.isEmpty() && running.peek()[2]==j){
                int[] s = running.poll();
                freeServer.offer(new int[]{s[0], s[1]});
            }

            int t= tasks[j];
            q.offer(t);

            while(!q.isEmpty() && !freeServer.isEmpty()){
                t = q.poll();
                int[] s = freeServer.poll();

                ans[j] = s[0];
                running.offer(new int[]{s[0], s[1], j+t});
            }
        }
        

        return ans;

        

    }
}
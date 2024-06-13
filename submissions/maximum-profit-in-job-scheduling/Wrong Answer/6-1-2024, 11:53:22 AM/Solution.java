// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {

    class Task{
        int st;
        int ed;
        int p;
        public Task(int st, int ed, int p){
            this.st = st;
            this.ed = ed;
            this.p = p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;

        List<Task> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            Task task = new Task(startTime[i], endTime[i], profit[i]);
            list.add(task);
        }

        Collections.sort(list, (a,b)-> a.st!=b.st ? a.st-b.st : a.ed-b.ed);



        Task prev = list.get(0);
        int sum = 0;
        for(int i=1; i<len; i++){
            Task curr = list.get(i);

            if(prev.ed <= curr.st){
                sum += prev.p;
                prev = curr;
                continue;
            }

            if(curr.p<=prev.p){
                continue;
            }else{
                prev.p = curr.p;
                prev.ed = curr.ed;
            }
        }

        sum += prev.p;


        return sum;


        
    }
}
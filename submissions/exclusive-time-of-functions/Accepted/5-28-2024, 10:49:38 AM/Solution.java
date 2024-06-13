// https://leetcode.com/problems/exclusive-time-of-functions

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {


        int[] res = new int[n];
        Stack<Log> st = new Stack<>();
        for(String s : logs){
            Log log = new Log(s); // id:end:5

            if(log.isStart){
                st.push(log);
            }else{
                Log top = st.pop(); //id:start//2
                res[top.id] += log.timestamp - top.timestamp +1;
                if(!st.isEmpty()){
                    res[st.peek().id] -= (log.timestamp - top.timestamp +1);
                }
            }
        }

        return res;
        
    }


    class Log {

        int id;
        boolean isStart;
        int timestamp;

        public Log(String s){
            String[] arr = s.split(":");
            this.id = Integer.valueOf(arr[0]);
            this.isStart = "start".equals(arr[1]);
            this.timestamp = Integer.valueOf(arr[2]);
        }
    }
}
// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {
    Queue<Integer> myQueue;
    public RecentCounter() {
        myQueue = new LinkedList<>();
    }
    
    public int ping(int t) {
        while(!myQueue.isEmpty() && myQueue.peek()<t-3000){
            myQueue.poll();
        }
        myQueue.offer(t);
        return myQueue.size();
    }
}
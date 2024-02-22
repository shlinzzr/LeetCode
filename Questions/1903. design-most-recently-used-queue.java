// https://leetcode.com/problems/design-most-recently-used-queue

class MRUQueue {

    List<Integer> list ;

    public MRUQueue(int n) {
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
    }
    
    public int fetch(int k) {
        list.add(list.remove(k-1));
        return list.get(list.size()-1);
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
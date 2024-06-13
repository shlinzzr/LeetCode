// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    
    TreeMap<Integer, List<Integer>> f2list = new TreeMap<>(); // freq, list of val
    Map<Integer, Integer> v2f = new HashMap<>(); //val, freq
    public FreqStack() {
        f2list = new TreeMap<>();
        v2f = new HashMap<>();
    }
    
    public void push(int val) {
        
        if(!v2f.containsKey(val)){
            List<Integer> list = f2list.getOrDefault(1 , new ArrayList<>());
            list.add(val);
            f2list.put(1, list);

            v2f.put(val, 1);
            return;
        }

        int newFreq = v2f.get(val)+1;
        List<Integer> list = f2list.getOrDefault(newFreq, new ArrayList<>());
        list.add(val);
        f2list.put(newFreq, list);
        v2f.put(val, newFreq);
    }

    

     public int pop() {

        int maxFreq = f2list.lastKey();
        List<Integer> list = f2list.get(maxFreq);
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        if(list.size()==0)
            f2list.remove(maxFreq);
        
        v2f.put(res, v2f.get(res)-1);
        return res;
        
        
    }
}


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
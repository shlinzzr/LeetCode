// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    HashMap<Integer, List<Integer>> fmap; // freq, list<val>
    HashMap<Integer, Integer> vmap; // val, freq
    int max =0;
    
    public FreqStack() {
        fmap = new HashMap<>();
        vmap = new HashMap<>();
        
        
    }
    
    public void push(int val) {
        
        int freq = vmap.getOrDefault(val, 0)+1;
        vmap.put(val, freq);
        
        fmap.putIfAbsent(freq, new ArrayList<>());
        fmap.get(freq).add(val);
        max = Math.max(max, freq);
    }
    
    public int pop() {
        List<Integer> list = fmap.get(max);
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        if(list.size()==0)
            max-=1;
        
        vmap.put(res, vmap.get(res)-1);
        return res;
        
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
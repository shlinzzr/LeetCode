// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {

    HashMap<Integer, List<Integer>> cmap; // cnt, list<val>
    HashMap<Integer, Integer> fmap; // val, freq
    int max =0;
    int idx=0;
    
    
    public FreqStack() {
        cmap = new HashMap<>();
        fmap = new HashMap<>();
        
    }
    
    public void push(int val) {
        fmap.put(val, fmap.getOrDefault(val, 0)+1);
        int f = fmap.get(val);
        
        // if(f==max){
        //     cmap.put(f+1, new ArrayList<>());
        //     max = f+1;
        // }
            
        List<Integer> list = cmap.getOrDefault(f, new ArrayList<Integer>());
        list.add(val);
        cmap.put(f, list);
        max = Math.max(f, max);
    }
    
    public int pop() {
        
        
        
        
        
        
        List<Integer> list = cmap.get(max);
        
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        if(list.size()==0)
            max-=1;
        
        // if(max>0){
        //     cmap.get(max-1).add(res);
        // }
        
        fmap.put(res, fmap.get(res)-1);
        
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// https://leetcode.com/problems/design-a-stack-with-increment-operation

class CustomStack {

    Stack<Integer> st;
    int capacity ;
    int[] inc ;
    public CustomStack(int maxSize) {
        capacity = maxSize;
        inc = new int[maxSize];
        st = new Stack<>();
    }
    
    public void push(int x) {

        if(st.size()<capacity){
            st.push(x);
        }
            
        
    }
    
    public int pop() {
        if(st.isEmpty()) return -1;
        
        int idx = st.size()-1;
        int res = inc[idx] + st.pop();
        if(idx>0)
            inc[idx-1] += inc[idx];

        inc[idx] = 0;

        return res;
        
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, st.size())-1;
        if(k>=0)
            inc[k] += val;
        // for(int i=0; i<k && i<st.size(); i++){
            // arr[i] += val;
        // }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
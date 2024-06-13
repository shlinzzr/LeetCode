// https://leetcode.com/problems/design-a-stack-with-increment-operation

class CustomStack {

    Stack<Integer> st;
    int capacity ;
    int[] arr ;
    int idx;
    public CustomStack(int maxSize) {
        capacity = maxSize;
        arr = new int[maxSize];
        idx = 0;
        st = new Stack<>();
    }
    
    public void push(int x) {

        if(st.size()<capacity){
            st.push(x);
        }
            
        
    }
    
    public int pop() {
        if(st.isEmpty()) return -1;
        
        int sz = st.size()-1;
        int res = arr[sz] + st.pop();
        arr[sz] = 0;

        return res;
        
    }
    
    public void increment(int k, int val) {
        
        for(int i=0; i<k && i<st.size(); i++){
            arr[i] += val;
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
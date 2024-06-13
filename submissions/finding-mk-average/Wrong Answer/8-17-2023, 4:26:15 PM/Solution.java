// https://leetcode.com/problems/finding-mk-average

class MKAverage {

    // m=3, k=1
    
    //
    int m;
    int k;
    TreeMap<Integer, Integer> left;
    TreeMap<Integer, Integer> mid;
    TreeMap<Integer, Integer> right;
    Queue<Integer> q;
    long sum = 0;
    
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        left = new TreeMap<>();
        mid = new TreeMap<>();
        right = new TreeMap<>();
        q = new LinkedList<>();
        
        
    }
    
    public void addElement(int num) {
        
        if (q.size() < m)
        {                        
            q.offer(num);
            mid.put(num, mid.getOrDefault(num,0)+1);
            sum += num;

            if (q.size()==m)
            {
                while (left.size()<k)
                {
                    sum -= mid.firstKey();
                    shiftLeft(left, mid);
                }                    
                while (right.size()<k)
                {
                    sum -= mid.lastKey();
                    shiftRight(mid, right);
                }                    
            }
        }            
        else if (q.size() == m)
        {
            // add the new element
            q.offer(num);
            if (!left.isEmpty() && num <= left.lastKey())
                left.put(num, left.getOrDefault(num,0)+1);
            else if (!right.isEmpty() && num >= right.firstKey()){
                right.put(num, right.getOrDefault(num,0)+1);
                
            } else
            {
                mid.put(num, mid.getOrDefault(num,0)+1);
                
                sum += num;
            }

            if (left.size() > k)
            {   
                sum += left.lastKey();
                shiftRight(left, mid);
            }            
            if (right.size() > k)
            {
                sum += right.firstKey();
                shiftLeft(mid, right);
            }
            
            // delete the old element
            int x = q.poll();
            if (left.containsKey(x)){
                left.put(x, left.get(x)-1);
                if(left.get(x)==0)
                    left.remove(x);
                
            }else if (right.containsKey(x)){
                right.put(x, right.get(x)+1);
                if(right.get(x)==0)
                    right.remove(x);
                
            }else
            {
                sum -= x;
                mid.put(x, mid.get(x)-1);
                if(mid.get(x)==0)
                    mid.remove(x);
            }                
                        
            if (left.size() < k)
            {
                sum -= mid.firstKey();
                shiftLeft(left, mid);                
            }            
            if (right.size() < k)
            {
                sum -= mid.lastKey();
                shiftRight(mid, right);
            }                        
        }
        
        
    }
    
    private void shiftLeft(TreeMap<Integer, Integer> A, TreeMap<Integer, Integer> B){
       
        A.put(B.firstKey(), A.getOrDefault(B.firstKey(),0)+1);
        B.put(B.firstKey(), B.get(B.firstKey())-1);
        if(B.get(B.firstKey())==0)
            B.remove(B.firstKey());
    }
    
    private void shiftRight(TreeMap<Integer, Integer> A, TreeMap<Integer, Integer> B){
    
        B.put(A.lastKey(), B.getOrDefault(A.lastKey(),0)+1);
        A.put(A.lastKey(), A.get(A.lastKey())-1);
        if(A.get(A.lastKey())==0)
            A.remove(A.lastKey());
    }
    
    
    public int calculateMKAverage() {
        if (q.size() < m)
            return -1;
        else
            return (int) ( sum / (m-2*k) );
        
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
// https://leetcode.com/problems/finding-mk-average

class MKAverage {

    int m;
    int k;
    TreeMap<Integer, Integer> left;
    TreeMap<Integer, Integer> mid;
    TreeMap<Integer, Integer> right;
    Queue<Integer> q;
    long sum = 0;
    int leftCnt=0, rightCnt=0, midCnt=0;
    
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
            midCnt++;
            sum += num;

            if (q.size()==m)
            {
                while (leftCnt<k)
                {
                    sum -= mid.firstKey();
                    shiftLeft(left, mid);
                    midCnt--;
                    leftCnt++;
                }                    
                while (rightCnt<k)
                {
                    sum -= mid.lastKey();
                    shiftRight(mid, right);
                    midCnt--;
                    rightCnt++;
                }                    
            }
        }            
        else if (q.size() == m)
        {
            // add the new element
            q.offer(num);
            if (!left.isEmpty() && num <= left.lastKey()){
                left.put(num, left.getOrDefault(num,0)+1);
                leftCnt++;
                
            }else if (!right.isEmpty() && num >= right.firstKey()){
                right.put(num, right.getOrDefault(num,0)+1);
                rightCnt++;
                
            } else  { // mid
                mid.put(num, mid.getOrDefault(num,0)+1);
                midCnt++;
                sum += num;
            }

            if (leftCnt > k)
            {   
                sum += left.lastKey();
                shiftRight(left, mid);
                leftCnt--;
                midCnt++;
            }            
            if (rightCnt > k)
            {
                sum += right.firstKey();
                shiftLeft(mid, right);
                rightCnt--;
                midCnt++;
            }
            
            // delete the old element
            int x = q.poll();
            if (left.containsKey(x)){
                leftCnt--;
                left.put(x, left.get(x)-1);
                if(left.get(x)==0)
                    left.remove(x);
                
            }else if (right.containsKey(x)){
                rightCnt--;
                right.put(x, right.get(x)-1);
                if(right.get(x)==0)
                    right.remove(x);
                
            }else { // mid
                sum -= x;
                midCnt--;
                mid.put(x, mid.get(x)-1);
                if(mid.get(x)==0)
                    mid.remove(x);
            }                
                        
            if (leftCnt < k)
            {
                sum -= mid.firstKey();
                shiftLeft(left, mid);                
                midCnt--;
                leftCnt++;
            }
            if (rightCnt < k)
            {
                sum -= mid.lastKey();
                shiftRight(mid, right);
                midCnt--;
                rightCnt++;
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
            return (int) ( sum / (long)(m-2*k) );
        
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
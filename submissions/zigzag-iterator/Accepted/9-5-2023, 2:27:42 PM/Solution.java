// https://leetcode.com/problems/zigzag-iterator

public class ZigzagIterator {
    
    List<Integer> v1;
    List<Integer> v2;
    boolean flag;
    
    int idx1, idx2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        idx1=0;
        idx2=0;
        flag=true;
    }

    public int next() {
        
        if(!hasNext())
            return -1;
        
        int res = -1;
        if(flag){
            
            if(idx1<v1.size()){
                res = v1.get(idx1++);
            }else{
                res = v2.get(idx2++);
            }
        }else{
            if(idx2<v2.size()){
                res = v2.get(idx2++);
            }else{
                res = v1.get(idx1++);
            }
        }
        flag = !flag;
        
        return res;
        
    }

    public boolean hasNext() {
        return idx1<v1.size() || idx2<v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
// https://leetcode.com/problems/zigzag-iterator

public class ZigzagIterator {
    
    List<Integer> v1;
    List<Integer> v2;
    boolean flag = true;
    int total=0;
    int idx1=0, idx2=0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        total = v1.size()+v2.size();
    }

    public int next() {
        // System.out.println("next");
        int res = 0;
        if(hasNext()){
            if(flag){
                if(idx1<v1.size()){
                    res =  v1.get(idx1);
                    idx1++;
                    
                }else{
                    res = v2.get(idx2);
                    idx2++;
                }
                flag=!flag;
            }else{
                
                if(idx2<v2.size()){
                    res =  v2.get(idx2);
                    idx2++;
                    
                }else{
                    res = v1.get(idx1);
                    idx1++;
                }
                flag=!flag;
                
                
            }
        }else{
            return -1;
        }
        
        return res;
    }

    public boolean hasNext() {
        // System.out.println(idx1 +" "+idx2);
        return idx2+idx2<=total;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
// https://leetcode.com/problems/rle-iterator

class RLEIterator {
    int idx = 0;
    List<Integer> list =new ArrayList<>();
    public RLEIterator(int[] encoding) {
        int len = encoding.length;
        
        
        for(int i=0; i<len; i+=2){
            
            int time = encoding[i];
            int num = encoding[i+1];
            for(int j=0; j<time; j++){
                list.add(num);
            }
        }
        
        
    }
    
    public int next(int n) {
        int last = -1;
        
        
        int cnt =0 ;
        for(int i=idx; i<idx+n; i++){
            
            if(i>= list.size()){
                idx = list.size();
                return -1;
            }
            
            last = list.get(i);
            cnt++;
        }
        idx += cnt;
        
        
        
        return last;
        
        
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
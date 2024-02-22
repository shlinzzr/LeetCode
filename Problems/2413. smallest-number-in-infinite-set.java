// https://leetcode.com/problems/smallest-number-in-infinite-set

class SmallestInfiniteSet {

    int curr;
    TreeSet<Integer> set;
    
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        curr=1;
    }
    
    public int popSmallest() {
        
        boolean rmset = false;
        
        int res = 0;
        for(int n : set){
            res = n;
            
            if(curr==res){
                res = curr;
                curr++;
                rmset = true;
            }
            
            
            else if(curr<res){
                res = curr;
                curr++;
            }else
                rmset = true;
            
            break;
        }
        
        
        if(set.isEmpty()){
            res= curr;
            curr++;
        }
        
        
        if(rmset)
            set.remove(res);
        
        return res;
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
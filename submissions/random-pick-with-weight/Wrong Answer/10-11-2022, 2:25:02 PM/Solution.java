// https://leetcode.com/problems/random-pick-with-weight

class Solution {

    int[] w;
    int sum = 0;
     Random rand;
    
    public Solution(int[] w) {
        for(int i=1; i<w.length; i++){
            w[i] += w[i-1];
        }
        
        this.w = w;
        this.rand = new Random();
    }
    
    public int pickIndex() {
        int len = w.length;
        int idx = rand.nextInt(w[len-1]);
        int left=0, right=len-1;
        
        System.out.println(idx);
        
        while(left<right){
            
            int mid = left+ (right-left)/2;
            if(w[mid]==idx)
                return mid;
            
            else if(w[mid]<idx){
                left = mid+1;
                
            }else 
                right = mid;
        }
        
        
        
        return left;
        
        
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
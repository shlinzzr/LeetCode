// https://leetcode.com/problems/maximum-total-reward-using-operations-ii

class Solution {
    public int maxTotalReward(int[] rv) {
        
        int len = rv.length;
        
        Arrays.sort(rv);
        
        // lis
        
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
            
        // [1,2,3,4,6]
        // [0, 1 2]
        
        int max= 0 ;
        for(int i=0; i<len; i++){
            int c= rv[i];
            
            if(list.get(list.size()-1)<c){
                list.add(list.get(list.size()-1)+c);
            }else{
                
                int idx = findFirstSmaller(list, c);
                if(idx!=-1){
                    int val = list.get(idx)+c;
                    list.add(findInsertPos(list, val), val);
                    
                }
            }
            
        }
        
        return list.get(list.size()-1);
        
        
        
        
        
        
    }
    
    private int findInsertPos(List<Integer> list, int val){
        int st = 0, ed=list.size()-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(list.get(mid)>=val){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        return st;
           
    }
    
    private int findFirstSmaller(List<Integer> list, int c){
        
        int st = 0, ed=list.size()-1;
        
        while(st<ed){
            int mid = ed-(ed-st)/2;
            if(list.get(mid)>=c){
                ed= mid-1;
            }else{
                st=mid;
            }
        }
        if(list.get(st)<c) return st;
        return -1;
        
    }
}
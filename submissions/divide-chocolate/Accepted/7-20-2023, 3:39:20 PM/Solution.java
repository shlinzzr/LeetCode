// https://leetcode.com/problems/divide-chocolate

class Solution {
    public int maximizeSweetness(int[] sw, int k) {
        int len = sw.length;
        
        
        int total = 0;
        for(int w : sw){
            total += w;
        }
        
        int st =0, ed=total;
        
        while(st<ed){
            
            int mid = st + (ed-st+1)/2;
            
            if(isOk(sw, mid, k+1)){
                st = mid;
                
            }else{
                ed = mid-1;
            }
        }
        
        if(isOk(sw, st, k+1)){
            return st;
        }
        
        return st-1;
    }
    
    
    private boolean isOk(int[] sw, int mid, int k){
        
        List<Integer> list= new ArrayList<>();
        
        int sum = 0;
        for(int i=0; i<sw.length; i++){
            
            sum += sw[i];
            if(sum>=mid){
                list.add(sum);
                sum=0;
            }
        }
        
        // System.out.println("isOk " + mid + " list="+list.toString() + " res="+(list.size()>=k));
        
        return list.size()>=k;
        
        
    }
}
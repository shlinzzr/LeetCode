// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] ci) {
        
        //研究者有n 篇论文每篇 至少被引用了 n 次, find max n
        
        Arrays.sort(ci);
        
        int len = ci.length; //總共有len篇論文 被引用次數從小排到大
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int mid = st + (ed-st+1)/2;
            
            // System.out.println(st + " " + ed + " mid=" + mid  + " ci[mid]="+ci[mid] + " len="+(len-mid) );
            
            
            if(ci[mid]==len-mid){
                return len-mid;
                
            }else if(ci[mid]<(len-mid)){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
        // 1, 1, 3
        
    }
}
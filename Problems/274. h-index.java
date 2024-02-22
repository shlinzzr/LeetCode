// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] ci) {
        
        //研究者有n 篇论文每篇 至少被引用了 n 次, find max n
        
        Arrays.sort(ci);
        
         int len = ci.length; //總共有len篇論文 被引用次數從小排到大
          
        if(ci[len-1]==0) // 若最後一篇都無引用次數 那全部都是0;
            return 0;
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            // System.out.println(st + " " + ed + " mid=" + mid  + " ci[mid]="+ci[mid] + " len="+(len-mid) );
            
            if(ci[mid]==len-mid){ // 從後面數到mid 至少有(len-mid)篇論文 被引用 ci[mid]次
                return len-mid;
                
            }else if(ci[mid]<(len-mid)){ // 當引用次數 比篇數少 => 往後面找引用次數多的
                st = mid+1;
            }else{
                ed = mid;  //當引用次數 比篇數多 => 可以往前找更多篇 是有達到最低引用次數的要求
            }
        }
      
        
        return len-st;
        
        // 1, 1, 3
        
    }
}
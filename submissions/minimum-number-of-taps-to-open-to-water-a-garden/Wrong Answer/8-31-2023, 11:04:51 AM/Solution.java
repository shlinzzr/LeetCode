// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden

class Solution {
    public int minTaps(int n, int[] ranges) {
        List<int[]> list =new ArrayList<>();
        
        int len = ranges.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1]-a[1]
        );
        
        for(int i=0; i<len; i++){
            int[] ele = new int[]{i-ranges[i], i+ranges[i]};
            if(i-ranges[i]<0)
                pq.offer(ele);
            else{
                list.add(ele);
            }
        }
        
        int covered = -1;
        int cnt =0 ;
        while(covered<n){
            
            if(pq.isEmpty())
                return -1;
            
            int[] p = pq.poll();
            covered = p[1];
            
            List<int[]> tmp = new ArrayList<>();
            for(int[] ele : list){
                if(ele[1]<= covered)
                    continue;
                else if(ele[0]<=covered && ele[0]>covered){
                    pq.offer(ele);
                }else if(ele[0] > covered){
                    tmp.add(ele);
                }
            }
            list = tmp;
            
            cnt++;
        }
        
        return cnt;
    }
}
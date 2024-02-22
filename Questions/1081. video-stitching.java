// https://leetcode.com/problems/video-stitching

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int len = clips.length;
        
        Arrays.sort(clips, (a,b)-> a[0]-b[0]); 
        
        
        int cnt = 0;
             
        int covered = 0;
        
        for(int i=0; i<len; i++){
            int max = covered;
            
            int[] a = clips[i];
            
            while(a[0]<=covered){
                max = Math.max(max, a[1]);
                i++;
                if(i>=len)
                    break;
                a=clips[i];
                
                if(a[0]>covered)
                    i--;
            }
            
            
            cnt++;
            covered=max;
            
            if(covered>=time)
                break;
        }
        
        return covered < time? -1 : cnt;
        
    }
}
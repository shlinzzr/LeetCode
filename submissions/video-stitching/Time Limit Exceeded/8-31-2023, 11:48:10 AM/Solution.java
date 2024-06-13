// https://leetcode.com/problems/video-stitching

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int len = clips.length;
        
        Arrays.sort(clips, (a,b)-> a[0]-b[0]); 
        
        // for(int[] c: clips){
        //     System.out.print( "[" +c[0] +"," + c[1] + "], ");
        // }
        // System.out.println();
        
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
            }
            i--;
            
            cnt++;
            covered=max;
            
        }
        
        return covered < time? -1 : cnt;
        
    }
}
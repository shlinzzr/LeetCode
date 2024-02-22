// https://leetcode.com/problems/finding-the-number-of-visible-mountains

class Solution {
    public int visibleMountains(int [][] peaks){


        // making peaks into left, right => peaks[0] =left, peaks[1]=right
        for(int i = 0; i < peaks.length; i ++){
            int temp = peaks[i][0];
            peaks[i][0] -= peaks[i][1];
            peaks[i][1] += temp;
        }
        
        Arrays.sort(peaks, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        int res = 0;
        int i = 0;
        while(i < peaks.length){
            res ++;
            if(i + 1 == peaks.length){
                return res;
            } 
            int currEnd = peaks[i][1]; // right
            if(peaks[i][0] == peaks[i + 1][0]){ //  if(left== next.left) no matter how h is, res will decrease
                res --;
            }
            while(i + 1 != peaks.length && currEnd >= peaks[i + 1][1]){  // while (curr.right >= next.right)
                i++;
            }
            i++;
        }
        return res;
    }
    
}
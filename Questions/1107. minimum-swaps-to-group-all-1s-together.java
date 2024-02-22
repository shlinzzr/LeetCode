// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together

class Solution {
    public int minSwaps(int[] data) {
        
        
         //https://www.youtube.com/watch?v=p7HnMir7XI4
        
        int len =data.length;
        
        int windowSize = 0;
        for(int d : data){
            if(d==1)
                windowSize++;
        }

        int currOnes=0;
        int maxOnes=0;
        
        
        int st=0;
        for(int ed=0; ed<len; ed++){
            if(ed-st+1>windowSize){
                if(data[st]==1)
                    currOnes-=1;
                st++;
            }
            
            if(data[ed]==1){
                currOnes+=1;
                maxOnes = Math.max(maxOnes, currOnes);
            }
            
        }
        
        return windowSize - maxOnes; //最多個1 表示最少個0需要交換
        
    }
}
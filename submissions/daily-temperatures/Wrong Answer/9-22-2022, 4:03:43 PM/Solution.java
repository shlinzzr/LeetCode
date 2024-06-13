// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] res = new int[len];
        
        for(int i=len-2; i>=0; i--){
            
            if(temp[i]<temp[i+1]){
                res[i] = 1;
            }else{
                
                if(res[i+1]==0)
                    res[i]=0;
                else{
                    
                    int k=2;
                    while(i+k<len){
                        
                         // System.out.println("i="+i+" k="+k + " res[i]=" + res[i] + " res[i+k]=" + res[i+k] );
                        
                        if(temp[i+k]>temp[i])
                            break;
                        k++;
                    }
                    
                    res[i] = k;
                }
            }
            
            System.out.println(res[i]);
            
        }
        
        return res;
    }
}
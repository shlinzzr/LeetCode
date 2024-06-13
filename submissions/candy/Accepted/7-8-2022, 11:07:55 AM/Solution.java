// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        
        if(ratings.length==1)
            return 1;
        
        int[] curr = new int[ratings.length];
        
        int cnt = 1;
        for(int i=0; i<ratings.length-1; i++){
            
            if(ratings[i]<ratings[i+1]){
                
                if(cnt==1)
                    curr[i]=cnt;

                cnt++;
                curr[i+1] = cnt;
                
                
            }else{
                if(curr[i]==0)
                    curr[i]=1;
                
                
                cnt=1;
            }
        }
        
        cnt=1;
        for(int i=ratings.length-1; i>0; i--){
            
            if(ratings[i]<ratings[i-1]){
                
                if(cnt==1 && cnt > curr[i])
                    curr[i] = cnt;
                
                cnt++;
                if(cnt > curr[i-1])
                    curr[i-1] = cnt;
                
                
            }else{
                 if(curr[i]==0)
                    curr[i]=1;
                cnt=1;
            }
        }
        
        
        int totalCnt=0;
        for(int c : curr){
            totalCnt+=c;
            // System.out.println(c);
        }
        
        return totalCnt;
        
        
    }
}
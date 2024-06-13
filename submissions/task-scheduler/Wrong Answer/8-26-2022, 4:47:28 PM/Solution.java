// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int cnt=0, res=0;
        for(char t : tasks){
            freq[t-'A']++;
            cnt++;
        }
        
        int[] stall= new int[26];
        
        
        // char prev = null;
        while(cnt>0){
            
            
            boolean done=false;
            
            for(int i=0; i<26; i++){
                
                char ch = (char) (i + 'A');
                int f = freq[i];
                
                if(stall[i]>0)
                    stall[i]--;
                
                if(f==0 || /*(ch==prev) ||*/ stall[i]>0)
                    continue;
                
                if(done==false){
                    freq[i]--;
                    cnt--;
                    // prev = ch;
                    stall[i]=n+1;
                    done=true;
                }
                
                
            }
                   
            res++;
            
        }
        return res;
    }
}
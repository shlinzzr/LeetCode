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
        int prev=0;
        
        // char prev = null;
        while(cnt>0){
            
            
            boolean done=false;
            
            for(int i=0; i<26; i++){
                int idx = (i+prev)%26;
                
                char ch = (char) (idx + 'A');
                int f = freq[idx];
                
                if(stall[idx]>0)
                    stall[idx]--;
                
                if(f==0 ||  stall[idx]>0)
                    continue;
                
                if(done==false){
                    
                    System.out.print(ch + ", ");
                    
                    
                    
                    freq[idx]--;
                    cnt--;
                    stall[idx]=n+1;
                    done=true;
                    prev=getMax(freq);
                }
                
            }
            
            if(done==false)
                System.out.print(  "IDLE, ");
            
            // System.out.println();
            res++;
                   
            
        }
        return res;
    }
    
    
    private int getMax(int[] freq){
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=0; i<freq.length; i++){
            
            int f = freq[i];
            if(f>max){
                idx=i;
                max=f;
            }
                
        }
        
        return idx;
    }
}
// https://leetcode.com/problems/push-dominoes

class Solution {
    public String pushDominoes(String dominoes) {
        //.L.R...LR..L.."
        //LL.RR.LLRRLL.."
        
        int len = dominoes.length();
        
        
        int lastCharIdx = 0;
        char lastChar = '.';
        
        char[] arr = dominoes.toCharArray();
        for(int i=0; i<len; i++){
            char c = arr[i];
            if(c=='.'){
                if(lastChar=='R')
                    arr[i] = 'R';
                
            }else if(c=='L'){
                
                if(lastChar=='R'){
                    int mid = (i-lastCharIdx)/2+lastCharIdx;
                    if((i-lastCharIdx)%2==0){
                        arr[mid]='.';
                    }
                    
                    mid+=1;
                        
                    while(mid<i){
                        arr[mid]='L';
                        mid++;
                    }
                }else if(lastChar=='.'){
                    int st = lastCharIdx;
                    while(st<i){
                        arr[st]='L';
                        st++;
                    }
                }
                lastCharIdx = i;
                lastChar = 'L';
                
            }else if(c=='R'){
                lastCharIdx = i;
                lastChar = 'R';
                
            }
        }
        
        return String.valueOf(arr);
        
    }
}
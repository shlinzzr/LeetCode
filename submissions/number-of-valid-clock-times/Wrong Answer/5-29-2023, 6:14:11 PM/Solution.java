// https://leetcode.com/problems/number-of-valid-clock-times

class Solution {
    public int countTime(String time) {
        String[]  arr =  time.split(":");
        
        int prev=1, next=1;
        
        String f = arr[0];
        
        if(f.charAt(0)=='?' || f.charAt(1)=='?'){
            if(f.charAt(0)=='?' && f.charAt(1)=='?'){
                prev = 24;
                
            }else if(f.charAt(0)=='?'){
                if(f.charAt(1)-'0'<5){
                    prev = 3;
                }
                    
                else
                    prev = 2;
                
            }else if(f.charAt(1)=='?'){
                if(f.charAt(1)=='1')
                    prev = 10;
                else  if(f.charAt(1)=='2')
                    prev = 5;
                else 
                    prev = 10;
            }
        }
        
        String s = arr[1];
        if(s.charAt(0)=='?'){
            next*=6;
        }
        if(s.charAt(1)=='?'){
            next*=10;
        }
        
        // System.out.println(prev + " " + next);
        return prev*next;
        
    }
}
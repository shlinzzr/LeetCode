// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        int i=0; 
        int len = chars.length;
        
        int res = 0;
        
        while(i<len){
            
            char ch = chars[i];
            int num=0;
            while(i<len && chars[i]==ch){
                num++;
                i++;
            }

            
            chars[res++]=ch;
            if(num==1){
                continue;
            }
            
            Stack<Integer> st = new Stack<>();
            while(num>0){
                st.push(num%10);
                num/=10;
            }
            
            while(!st.isEmpty()){
                chars[res++] = (char)(st.pop()+'0');
            }
            
            
        }
        
        return res;
    }
}
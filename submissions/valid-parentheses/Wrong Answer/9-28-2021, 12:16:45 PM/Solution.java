// https://leetcode.com/problems/valid-parentheses


		class Solution {
		    public boolean isValid(String s) {
		        Stack<Character> st  = new Stack<Character>();
		        
		        for(char c : s.toCharArray() ){
		            if( '('==c ||  '['==c || '{'==c)
		                st.push(c);
		            else{
		                
		                
		                
		                char r = st.pop();
		                if( '('==r && ')'!=c
		                 || '['==r && ']'!=c
		                 || '{'==r && '}'!=c)
		                    return false;
		                
		                
		                
		            }
		        }
		        
		        return true;
		    }
		}
		
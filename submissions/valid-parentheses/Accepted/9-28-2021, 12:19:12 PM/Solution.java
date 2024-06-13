// https://leetcode.com/problems/valid-parentheses


		class Solution {
		    public boolean isValid(String s) {
                
                if(s==null)
                    return true;
                
		        Stack<Character> st  = new Stack<Character>();
		        
		        for(char c : s.toCharArray() ){
		            if( '('==c ||  '['==c || '{'==c)
		                st.push(c);
		            else{
		                
		                if(st.isEmpty())
		                return false;
                        
		                char r = st.pop();
		                if( '('==r && ')'!=c
		                 || '['==r && ']'!=c
		                 || '{'==r && '}'!=c)
		                    return false;
		                
		                
		                
		            }
		        }
		        
                       if(st.size()>0)
		        	return false;
                
                
		        return true;
		    }
		}
		